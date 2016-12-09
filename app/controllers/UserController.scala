package controllers

import javax.inject.Inject
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.Action
import play.api.mvc.BodyParsers
import play.api.mvc.Call
import play.api.mvc.Controller
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.ReactiveMongoApi
import play.modules.reactivemongo.ReactiveMongoComponents
import reactivemongo.api.commands.WriteResult
import reactivemongo.bson.Producer.nameValue2Producer
import reactivemongo.bson.BSONDocument

class UserController @ Inject() (val reactiveMongoApi: ReactiveMongoApi)
    extends Controller with MongoController with ReactiveMongoComponents{
    
    def userRepo = new backend.UserMongoRepo(reactiveMongoApi)
    
    def register = Action.async(parse.urlFormEncoded) { implicit request =>
       val username = request.body("username").head
       val password = request.body("password").head
    
    print("Hello " + username + ", you're trying to login with the password: " + password)

    userRepo.save(BSONDocument(
      "username" -> username,
      "password" -> password)).map(le => Redirect(routes.Ports.list()))
  }
}