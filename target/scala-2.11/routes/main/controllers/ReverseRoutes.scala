
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/stephenjacob/workspace/TempTest/com.purpledecks.portcrossing.scala/conf/routes
// @DATE:Tue Dec 13 10:43:10 GMT 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:9
package controllers {

  // @LINE:43
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def at(file:String): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:38
  class ReverseOAuth2Controller(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def hello(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/hello")
    }
  
    // @LINE:40
    def getUserInfo(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "_oauth-getInfo")
    }
  
    // @LINE:38
    def callback(code:Option[String], state:Option[String]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "_oauth-callback" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("code", code)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("state", state)))))
    }
  
    // @LINE:39
    def success(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "_oauth-success")
    }
  
  }

  // @LINE:30
  class ReversePlaylists(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def list(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/playlists")
    }
  
  }

  // @LINE:29
  class ReverseSongs(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def list(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/songs")
    }
  
  }

  // @LINE:9
  class ReverseApplicationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
  }

  // @LINE:14
  class ReversePosts(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def like(id:String): Call = {
      import ReverseRouteContext.empty
      Call("PATCH", _prefix + { _defaultPrefix } + "api/post/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/like")
    }
  
    // @LINE:17
    def add(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/post")
    }
  
    // @LINE:14
    def list(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/posts")
    }
  
    // @LINE:18
    def delete(id:String): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "api/post/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
    // @LINE:16
    def update(id:String): Call = {
      import ReverseRouteContext.empty
      Call("PATCH", _prefix + { _defaultPrefix } + "api/post/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
  }

  // @LINE:34
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def register(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "users/register")
    }
  
  }

  // @LINE:20
  class ReversePorts(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def findById(id:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/ports/id/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
    // @LINE:25
    def addAuthenticated(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/port/oauth")
    }
  
    // @LINE:22
    def findOneByName(portName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/ports/1/" + implicitly[PathBindable[String]].unbind("portName", dynamicString(portName)))
    }
  
    // @LINE:21
    def findByName(portName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/ports/" + implicitly[PathBindable[String]].unbind("portName", dynamicString(portName)))
    }
  
    // @LINE:24
    def add(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/port")
    }
  
    // @LINE:20
    def list(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/ports")
    }
  
    // @LINE:26
    def delete(id:String): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "api/ports/remove/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
  }

  // @LINE:11
  class ReverseApiHelpController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getResources(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api-docs.json")
    }
  
    // @LINE:12
    def getResource(): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/api/ports")))
      Call("GET", _prefix + { _defaultPrefix } + "api-docs/api/ports")
    }
  
  }

  // @LINE:36
  class ReverseFileController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def sayHello(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/file")
    }
  
  }

  // @LINE:31
  class ReverseImages(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def list(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/images")
    }
  
    // @LINE:32
    def findById(id:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/images/id/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
  }


}