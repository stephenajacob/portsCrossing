package controllers

import java.util.UUID

import play.api.mvc.Action
import play.api.mvc.Controller
import util.OAuth2
import javax.inject.Inject

class ApplicationController @Inject() extends Controller {
  
  def index = Action { implicit request =>
    
    val callbackUrl = controllers.routes.OAuth2Controller.callback(None, None).absoluteURL()
    val scope = "repo"   // github scope - request repo access
    val state = UUID.randomUUID().toString  // random confirmation string
    val redirectUrl = OAuth2.getAuthorizationUrl(callbackUrl, scope, state)
    Ok(views.html.index("Your new application is ready.", redirectUrl)).
      withSession("oauth-state" -> state)
  }
}