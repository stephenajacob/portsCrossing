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

class Playlists @Inject() (val reactiveMongoApi: ReactiveMongoApi)
    extends Controller with MongoController with ReactiveMongoComponents {
        
  import controllers.PlaylistFields._
  
  def playlistRepo = new backend.PlaylistMongoRepo(reactiveMongoApi)

  def list = Action.async {implicit request =>
    print("*********************playlist list called*****************************************************************")
    playlistRepo.find()
    .map(playlists => Ok(Json.toJson(playlists.reverse)))
    .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  }
}  

object PlaylistFields {
      val Id = "_id"
      val Title = "title"
      val Label = "label"
      val Songs = "songs"
}