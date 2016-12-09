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

class Songs @Inject() (val reactiveMongoApi: ReactiveMongoApi)
    extends Controller with MongoController with ReactiveMongoComponents {
        
  import controllers.SongFields._
  
  def songRepo = new backend.SongMongoRepo(reactiveMongoApi)
  
  def list = Action.async {implicit request =>
    songRepo.find()
    .map(posts => Ok(Json.toJson(posts.reverse)))
    .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  }
  
//   def like(id: String) = Action.async(BodyParsers.parse.json) { implicit request =>
//     val value = (request.body \ Favorite).as[Boolean]
//     postRepo.update(BSONDocument(Id -> BSONObjectID(id)), BSONDocument("$set" -> BSONDocument(Favorite -> value)))
//       .map(le => Ok(Json.obj("success" -> le.ok)))
//   }

//   def update(id: String) = Action.async(BodyParsers.parse.json) { implicit request =>
//     val value = (request.body \ Text).as[String]
//     postRepo.update(BSONDocument(Id -> BSONObjectID(id)), BSONDocument("$set" -> BSONDocument(Text -> value)))
//       .map(le => Ok(Json.obj("success" -> le.ok)))
  }
  
 object SongFields {
      val Id = "_id"
      val Title = "title"
      val Duration = "duration"
      val Writer = "writer"
      val Image = "img_id"
  }