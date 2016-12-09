package controllers

import javax.inject.Inject

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json.Json
import play.api.mvc.{ Action, BodyParsers, Call, Controller, Result }

import reactivemongo.bson.{ BSONObjectID, BSONDocument }
import reactivemongo.core.actors.Exceptions.PrimaryUnavailableException
import reactivemongo.api.commands.WriteResult

import play.modules.reactivemongo.{
  MongoController, ReactiveMongoApi, ReactiveMongoComponents
}

import play.modules.reactivemongo.json.ImplicitBSONHandlers._

class Images @Inject() (val reactiveMongoApi: ReactiveMongoApi)
    extends Controller with MongoController with ReactiveMongoComponents {
        
  import controllers.ImageFields._

  def imageRepo = new backend.ImageMongoRepo(reactiveMongoApi)

  def list = Action.async {implicit request =>
  print("*********Images called*********")
  print("*********Images called*********")
  imageRepo.find()
    .map(images => Ok(Json.toJson(images.reverse)))
    .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  }
  
  def findById(id: String) = Action.async { implicit request =>
  print("*********Images by ID called*********")
    imageRepo.findById(id)
    .map(images => Ok(Json.toJson(images.take(1))))
    .recover { case PrimaryUnavailableException => InternalServerError("Please install MongoDB") }
  }
}

object ImageFields {
    val Id = "_id"
    val Filename = "filename"
    val UploadDate = "uploadDate"
    val Length = "length"
    val Md5 = "md5"
}