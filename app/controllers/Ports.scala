package controllers

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import javax.inject.Inject
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json.Json
import play.api.mvc.Action
import play.api.Play
import play.api.mvc.BodyParsers
import play.api.mvc.Call
import play.api.mvc.Controller
import scala.concurrent.Future
import play.api.mvc.Result
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.ReactiveMongoApi
import play.modules.reactivemongo.ReactiveMongoComponents
import play.modules.reactivemongo.json.ImplicitBSONHandlers.JsObjectDocumentWriter
import reactivemongo.api.commands.WriteResult
import reactivemongo.bson.BSONDocument
import reactivemongo.bson.BSONObjectID
import reactivemongo.bson.Producer.nameValue2Producer
import reactivemongo.core.actors.Exceptions.PrimaryUnavailableException
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiImplicitParam
import play.api.libs.ws.WS
import play.mvc.Http.HeaderNames

@Api(value = "/api/ports", description = "Run operations with Ports on localhost:9000") //@Security.Authenticated(Secured.class) public class TodoController extends Controller {
class Ports @Inject() (val reactiveMongoApi: ReactiveMongoApi)
    extends Controller with MongoController with ReactiveMongoComponents {

  import controllers.PortFields._

  def portRepo = new backend.PortMongoRepo(reactiveMongoApi)

  @ApiOperation(value = "Get All Ports",
    notes = "Returns a List of all Ports in MongoDB",
    httpMethod = "GET")
  def list = Action.async { implicit request =>
    print("**********port list called************")
    portRepo.find()
      .map(ports => Ok(Json.toJson(ports.reverse)))
      .recover { case PrimaryUnavailableException => InternalServerError("Please install MongoDB") }
  }

  @ApiOperation(value = "Get All Ports by Port Name",
    notes = "Returns a List of all Ports by a single Port Name",
    httpMethod = "GET")
  def findByName(name: String) = Action.async { implicit request =>
    print("**********find ports by name**********")
    portRepo.findByName(name)
      .map(ports => Ok(Json.toJson(ports.reverse)))
      .recover { case PrimaryUnavailableException => InternalServerError("Please install MongoDB") }
  }

  @ApiOperation(value = "Get One Port by Port Name",
    notes = "Returns first Port from the List of Ports by Port Name",
    httpMethod = "GET")
  def findOneByName(name: String) = Action.async { implicit request =>
    print("************find one port by name************")
    portRepo.findOneByName(name)
      .map(ports => Ok(Json.toJson(ports.take(1))))
      .recover { case PrimaryUnavailableException => InternalServerError("Please install MongoDB") }
  }

  @ApiOperation(value = "Get Ports by Port ID",
    notes = "Returns a List of all Ports by a Single Port ID",
    httpMethod = "GET")
  def findById(id: String) = Action.async { implicit request =>
    print("************find ports by id************")
    portRepo.findById(id)
      .map(ports => Ok(Json.toJson(ports.take(1))))
      .recover { case PrimaryUnavailableException => InternalServerError("Please install MongoDB") }
  }

  //   def get = Action.async {implicit request =>
  //     portRepo.get(id)
  //     .map(ports => Ok(Json.toJson(ports.reverse)))
  //     .recover {case PrimaryUnavailableException => InternalServerError("Please install MongoDB")}
  //   }

  //   def like(id: String) = Action.async(BodyParsers.parse.json) { implicit request =>
  //       val value = (request.body \ Portname).as[String]
  //       portRepo.update(BSONDocument(Id -> BSONObjectID(id)), BSONDocument("$set" -> BSONDocument(Portname -> value)))
  //       .map(le => Ok(Json.obj("success" -> le.ok)))
  //   }

  //   def update(id: String) = Action.async(BodyParsers.parse.json) { implicit request =>
  //     val value = (request.body \ Text).as[String]
  //     postRepo.update(BSONDocument(Id -> BSONObjectID(id)), BSONDocument("$set" -> BSONDocument(Text -> value)))
  //       .map(le => Ok(Json.obj("success" -> le.ok)))
  //   }

  @ApiOperation(value = "Delete a Port",
    notes = "Remove a Port from MongoDB",
    httpMethod = "DELETE")
  def delete(id: String) = Action.async {
    portRepo.remove(BSONDocument(Id -> BSONObjectID(id)))
      .map(le => RedirectAfterPost(le, routes.Posts.list()))
  }

  private def RedirectAfterPost(result: WriteResult, call: Call): Result =
    if (result.inError) InternalServerError(result.toString)
    else Redirect(call)

  @ApiOperation(value = "Insert a Port",
    notes = "Add a new Port into MongoDB",
    httpMethod = "POST")
  @ApiImplicitParams(Array(
    new ApiImplicitParam(value = "Port to be Inserted", required = true, dataType = "string", paramType = "body")))
  def add = Action.async(BodyParsers.parse.json) { implicit request =>
    val portName = (request.body \ PortName).as[String]
    val latitude = (request.body \ Latitude).as[String]
    val longitude = (request.body \ Longitude).as[String]
    portRepo.save(BSONDocument(
      PortName -> portName,
      Latitude -> latitude,
      Longitude -> longitude)).map(le => Redirect(routes.Ports.list()))
  }

  // first send request to github for user info.
  // save this with the port data
  // post json with postman
  // see the oauth2Controller.getUserInfo
  
  
  @ApiOperation(value = "Insert a Port with Authenticate Identifier",
    notes = "Add a new Authenticated Port with ID into MongoDB",
    httpMethod = "POST")
  @ApiImplicitParams(Array(
    new ApiImplicitParam(value = "Authenticated Port to be Inserted", required = true, dataType = "string", paramType = "body")))
  def addAuthenticated = Action.async(BodyParsers.parse.json) { implicit request =>
    implicit val app = Play.current
    request.session.get("oauth-token").fold(Future.successful(Unauthorized("You are not authorized to do."))) { authToken =>
      WS.url("https://api.github.com/user").
      withHeaders(HeaderNames.AUTHORIZATION -> s"token $authToken").
        get().map { response =>
          val userName = (response.json \ "login").as[String]
          val id = (response.json \ "id").as[Int]
          val portName = (request.body \ PortName).as[String]
          val latitude = (request.body \ Latitude).as[String]
          val longitude = (request.body \ Longitude).as[String]
          portRepo.save(BSONDocument(
            "userName" -> userName,
            "id" -> id,
            PortName -> portName,
            Latitude -> latitude,
            Longitude -> longitude))
          Ok(response.json)
        }
    }
  }
}

object PortFields {
  val Id = "_id"
  val PortName = "portName"
  val Latitude = "latitude"
  val Longitude = "longitude"
}
