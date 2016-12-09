package util

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.Application
import play.api.Play
import play.api.http.{ MimeTypes, HeaderNames }
import play.api.mvc.{ Results, Action, Controller }
import play.api.libs.ws.WS


import scala.concurrent.Future
// import scala.concurrent.ExecutionContext.Implicits.global
import controllers.Posts
import javax.inject.Inject

object OAuth2 {
  def application = Play.current ;
  lazy val githubAuthId = application.configuration.getString("github.client.id").get
  lazy val githubAuthSecret = application.configuration.getString("github.client.secret").get

  def getAuthorizationUrl(redirectUri: String, scope: String, state: String): String = {
    val baseUrl = application.configuration.getString("github.redirect.url").get
    baseUrl.format(githubAuthId, redirectUri, scope, state)
}
  
  def getToken(code: String): Future[String] = {
    val tokenResponse = WS.url("https://github.com/login/oauth/access_token")(application).
      withQueryString("client_id" -> githubAuthId,
        "client_secret" -> githubAuthSecret,
        "code" -> code).
        withHeaders(HeaderNames.ACCEPT -> MimeTypes.JSON).
        post(Results.EmptyContent())

    tokenResponse.flatMap { response =>
      (response.json \ "access_token").asOpt[String].fold(Future.failed[String](new IllegalStateException("Sooo Long!"))) { accessToken =>
        Future.successful(accessToken)
      }
    }
  }
}
