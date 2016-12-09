package backend

import play.api.libs.json.{JsObject, Json}
import play.modules.reactivemongo.ReactiveMongoApi
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.api.ReadPreference
import reactivemongo.api.commands.WriteResult
import reactivemongo.bson.{BSONObjectID, BSONDocument}
import reactivemongo.api.Cursor


import scala.concurrent.{ExecutionContext, Future}

trait PortRepo {
  def find()(implicit ec: ExecutionContext): Future[List[JsObject]]
  
  //def get(id: String)(implicit ec: ExecutionContext): Future[JsObject]

  def update(selector: BSONDocument, update: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult]

  def findByName(name: String)(implicit ec: ExecutionContext): Future[List[JsObject]]
  
  def findOneByName(name: String)(implicit ec: ExecutionContext): Future[List[JsObject]]
  
  def findById(id: String)(implicit ec: ExecutionContext): Future[List[JsObject]]
  
  def remove(document: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult]

  def save(document: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult]
}

class PortMongoRepo(reactiveMongoApi: ReactiveMongoApi) extends PortRepo {
  // BSON-JSON conversions
  import play.modules.reactivemongo.json._

  protected def collection =
    reactiveMongoApi.db.collection[JSONCollection]("ports")

  def find()(implicit ec: ExecutionContext): Future[List[JsObject]] =
    collection.find(Json.obj()).cursor[JsObject](ReadPreference.Primary).collect[List]()
    
  //def get(id: Int)(implicit ec: ExecutionContext): Future[JsObject] =
  //   collection.find(Json.obj()).cursor[JsObject](ReadPreference.Primary)

  def findByName(name: String)(implicit ec: ExecutionContext): Future[List[JsObject]] = {
      
      val cursor: Cursor[JsObject] = collection.
      // find all people with name portName
      // sort them by creation date
      // perform the query and get a cursor of JsObject
      find(Json.obj("portName" -> name)).
      sort(Json.obj("created" -> -1)).
      cursor[JsObject](ReadPreference.Primary)

    cursor.collect[List]()
  }
  
    def findOneByName(name: String)(implicit ec: ExecutionContext): Future[List[JsObject]] = {
        
        val cursor: Cursor[JsObject] = collection.
        
        find(Json.obj("portName" -> name)).
        sort(Json.obj("created" -> -1)).
        cursor[JsObject](ReadPreference.Primary)

    cursor.collect[List]()
  }


    def findById(id: String)(implicit ec: ExecutionContext): Future[List[JsObject]] = {

    val oid : String = "ObjectId(\"" + id + "\")"
    println(oid)
    
    val cursor: Cursor[JsObject] = collection.    
      find( BSONDocument("_id" -> BSONObjectID(id))).
      cursor[JsObject](ReadPreference.Primary)

    cursor.collect[List]()
  }

    
    
  def update(selector: BSONDocument, update: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult] = collection.update(selector, update)

  def remove(document: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult] = collection.remove(document)

  def save(document: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult] = collection.update(BSONDocument("_id" -> document.get("_id").getOrElse(BSONObjectID.generate)), document, upsert = true)
}