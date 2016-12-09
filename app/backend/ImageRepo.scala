package backend

import play.api.libs.json.{JsObject, Json}
import play.modules.reactivemongo.ReactiveMongoApi
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.api.ReadPreference
import reactivemongo.api.commands.WriteResult
import reactivemongo.bson.{BSONObjectID, BSONDocument}
import reactivemongo.api.Cursor

import scala.concurrent.{ExecutionContext, Future}

trait ImageRepo {
    def find()(implicit ec: ExecutionContext): Future[List[JsObject]]

    def update(selector: BSONDocument, update: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult]
    
    def findById(id: String)(implicit ec: ExecutionContext): Future[List[JsObject]]
}

class ImageMongoRepo(reactiveMongoApi: ReactiveMongoApi) extends ImageRepo {
    // BSON-JSON conversions
    import play.modules.reactivemongo.json._
    
    protected def collection =
    reactiveMongoApi.db.collection[JSONCollection]("fs.files")
    
    def find()(implicit ec: ExecutionContext): Future[List[JsObject]] =
    collection.find(Json.obj()).cursor[JsObject](ReadPreference.Primary).collect[List]()
    
    def update(selector: BSONDocument, update: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult] = collection.update(selector, update)
    
    def findById(id: String)(implicit ec: ExecutionContext): Future[List[JsObject]] = {
        
        val oid : String = "ObjectId(\"" + id + "\")"
        println(oid)
        
        val cursor: Cursor[JsObject] = collection.    
        find( BSONDocument("_id" -> BSONObjectID(id))).
        cursor[JsObject](ReadPreference.Primary)

    cursor.collect[List]()
  }
}