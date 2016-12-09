package controllers

import scala.concurrent.Future

import javax.inject.Inject
import play.api.Application
import play.api.Play
import play.api.http.HeaderNames
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.ws.WS
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.mvc.Results
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.bson.{BSONObjectID, BSONDocument}
import play.modules.reactivemongo.ReactiveMongoComponents

class OAuth2Controller @Inject() (val reactiveMongoApi: ReactiveMongoApi)
    extends Controller with MongoController with ReactiveMongoComponents {
  def application = Play.current;
  lazy val githubAuthId = application.configuration.getString("github.client.id").get
  lazy val githubAuthSecret = application.configuration.getString("github.client.secret").get

  def userRepo = new backend.UserMongoRepo(reactiveMongoApi)

  def callback(codeOpt: Option[String] = None, stateOpt: Option[String] = None) = Action.async { implicit request =>
    (for {
      code <- codeOpt
      state <- stateOpt
      oauthState <- request.session.get("oauth-state")
    } yield {
      if (state == oauthState) {
        util.OAuth2.getToken(code).map { accessToken =>
          Redirect(controllers.routes.OAuth2Controller.success()).withSession("oauth-token" -> accessToken)
        }.recover {
          case ex: IllegalStateException => Unauthorized(ex.getMessage)
        }
        //Future.successful(BadRequest("Invalid github login"))
      } else {
        Future.successful(BadRequest("Invalid github login"))
      }
    }).getOrElse(Future.successful(BadRequest("No parameters supplied")))
  }

  //  def callback(codeOpt: Option[String] = None, stateOpt: Option[String] = None) = Action.async { implicit request =>
  //    Future(Ok("Hello")) 
  //  }

  def hello = Action.async { implicit request =>
    Future(Ok("Hello"))
  }

  //WS.url("https://api.github.com/user/repos").
  
  def success() = Action.async { request =>
    implicit val app = Play.current
    request.session.get("oauth-token").fold(Future.successful(Unauthorized("No way, Jose"))) { authToken =>
      WS.url("https://api.github.com/user/repos").
        withHeaders(HeaderNames.AUTHORIZATION -> s"token $authToken").
        get().map { response =>
//          val userName = (response.json \ "login").as[String]
//          val id = (response.json \ "id").as[Int]
//          userRepo.save(BSONDocument(
//            "userName" -> userName,
//            "id" -> id))
          Ok(response.json)
        }
    }
  }

  // gets the oauth token from the session object
  // requests user information from github
  // and stores user object in database
  def getUserInfo() = Action.async { request =>
    implicit val app = Play.current
    request.session.get("oauth-token").fold(Future.successful(Unauthorized("You are not authorized to do so."))) { authToken =>
      WS.url("https://api.github.com/user").
        withHeaders(HeaderNames.AUTHORIZATION -> s"token $authToken").
        get().map { response =>
          val userName = (response.json \ "login").as[String]
          val id = (response.json \ "id").as[Int]
          userRepo.save(BSONDocument(
            "userName" -> userName,
            "id" -> id))
          Ok(response.json)
        }
    }
  }
}