package controllers

import scala.concurrent.Future
import play.api.mvc.{ Action, Controller }
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json._

import reactivemongo.api.gridfs.{ 
  DefaultFileToSave,
  FileToSave,
  GridFS,
  ReadFile
}
import play.modules.reactivemongo.{ MongoController, ReactiveMongoComponents }
//import reactivemongo.play.json._
import play.modules.reactivemongo.json.JSONSerializationPack
import play.modules.reactivemongo.ReactiveMongoApi
import javax.inject.Inject

class FileController @Inject() (val reactiveMongoApi: ReactiveMongoApi)
    extends Controller with MongoController with ReactiveMongoComponents {

  // gridFSBodyParser from `MongoController`
  import MongoController.readFileReads

  val fsParser = gridFSBodyParser(reactiveMongoApi.gridFS)
  
  private val gridFS = reactiveMongoApi.gridFS

  def upload = Action.async(fsParser) { request =>
    // here is the future file!
    val futureFile: Future[ReadFile[JSONSerializationPack.type, JsValue]] =
      request.body.files.head.ref

    futureFile.map { file =>
      // do something
      //gridFS.files.update()
      Ok
    }.recover {
      case e: Throwable => InternalServerError(e.getMessage)
    }
    
//    val futureUpdate = for {
//        file <- { println("_0"); futureFile }
//        // here, the file is completely uploaded, so it is time to update the article
//        updateResult <- {
//          println("_1")
//          gridFS.files.update(
//            Json.obj("_id" -> file.id),
//            Json.obj("$set" -> Json.obj("article" -> id)))
//        }
//      } yield updateResult
      
  }

  def sayHello = Action { request =>
    print("hello")
    Ok("Got request HEREEE [" + request + "]")
  }
}