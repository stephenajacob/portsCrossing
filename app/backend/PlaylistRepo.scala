package backend

import play.api.libs.json.{JsObject, Json}
import play.modules.reactivemongo.ReactiveMongoApi
import play.modules.reactivemongo.json._
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.api.ReadPreference
import reactivemongo.api.commands.WriteResult
import reactivemongo.bson.{BSONObjectID, BSONDocument}

import scala.concurrent.{ExecutionContext, Future}

trait PlaylistRepo {
  def find()(implicit ec: ExecutionContext): Future[List[JsObject]]

  //def update(selector: BSONDocument, update: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult]

  //def remove(document: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult]

  //def save(document: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult]
}

class PlaylistMongoRepo(reactiveMongoApi: ReactiveMongoApi) extends PlaylistRepo {
    
    protected def collection = reactiveMongoApi.db.collection[JSONCollection]("playlists")
    
    def find()(implicit ec: ExecutionContext): Future[List[JsObject]] =
    collection.find(Json.obj()).cursor[JsObject](ReadPreference.Primary).collect[List]()
    
//   def get(id:int)(implicit ec: ExecutionContext): Future[JsObject] =
//     collecton.

 // def findByName(name: String)(implicit ec: ExecutionContext): Future[List[JsObject]] =
  //   collection.find(Json.obj()).cursor[JsObject](ReadPreference.Primary).collect[List]()
    
    
  //def update(selector: BSONDocument, update: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult] = collection.update(selector, update)

  //def remove(document: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult] = collection.remove(document)

  //def save(document: BSONDocument)(implicit ec: ExecutionContext): Future[WriteResult] =
    //collection.update(BSONDocument("_id" -> document.get("_id").getOrElse(BSONObjectID.generate)), document, upsert = true)
}