
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/stephenjacob/workspace/portsCrossing3/conf/routes
// @DATE:Fri Nov 25 20:15:45 GMT 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:9
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:43
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:38
  class ReverseOAuth2Controller(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def hello: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OAuth2Controller.hello",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/hello"})
        }
      """
    )
  
    // @LINE:40
    def getUserInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OAuth2Controller.getUserInfo",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "_oauth-getInfo"})
        }
      """
    )
  
    // @LINE:38
    def callback: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OAuth2Controller.callback",
      """
        function(code,state) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "_oauth-callback" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("code", code), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("state", state)])})
        }
      """
    )
  
    // @LINE:39
    def success: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OAuth2Controller.success",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "_oauth-success"})
        }
      """
    )
  
  }

  // @LINE:30
  class ReversePlaylists(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Playlists.list",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/playlists"})
        }
      """
    )
  
  }

  // @LINE:29
  class ReverseSongs(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Songs.list",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/songs"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseApplicationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApplicationController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReversePosts(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def like: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Posts.like",
      """
        function(id) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "api/post/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/like"})
        }
      """
    )
  
    // @LINE:17
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Posts.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/post"})
        }
      """
    )
  
    // @LINE:14
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Posts.list",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/posts"})
        }
      """
    )
  
    // @LINE:18
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Posts.delete",
      """
        function(id) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/post/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
    // @LINE:16
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Posts.update",
      """
        function(id) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "api/post/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
  }

  // @LINE:34
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def register: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.register",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/register"})
        }
      """
    )
  
  }

  // @LINE:20
  class ReversePorts(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def findById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Ports.findById",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ports/id/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
    // @LINE:25
    def addAuthenticated: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Ports.addAuthenticated",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/port/oauth"})
        }
      """
    )
  
    // @LINE:22
    def findOneByName: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Ports.findOneByName",
      """
        function(portName) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ports/1/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("portName", encodeURIComponent(portName))})
        }
      """
    )
  
    // @LINE:21
    def findByName: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Ports.findByName",
      """
        function(portName) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ports/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("portName", encodeURIComponent(portName))})
        }
      """
    )
  
    // @LINE:24
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Ports.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/port"})
        }
      """
    )
  
    // @LINE:20
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Ports.list",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ports"})
        }
      """
    )
  
    // @LINE:26
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Ports.delete",
      """
        function(id) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/ports/remove/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseApiHelpController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getResources: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiHelpController.getResources",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api-docs.json"})
        }
      """
    )
  
    // @LINE:12
    def getResource: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiHelpController.getResource",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api-docs/api/ports"})
        }
      """
    )
  
  }

  // @LINE:36
  class ReverseFileController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def sayHello: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FileController.sayHello",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/file"})
        }
      """
    )
  
  }

  // @LINE:31
  class ReverseImages(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Images.list",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/images"})
        }
      """
    )
  
    // @LINE:32
    def findById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Images.findById",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/images/id/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
  }


}