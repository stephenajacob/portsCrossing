
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/stephenjacob/workspace/TempTest/com.purpledecks.portcrossing.scala/conf/routes
// @DATE:Tue Dec 13 10:43:10 GMT 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:9
  ApplicationController_5: controllers.ApplicationController,
  // @LINE:11
  ApiHelpController_6: controllers.ApiHelpController,
  // @LINE:14
  Posts_8: controllers.Posts,
  // @LINE:20
  Ports_2: controllers.Ports,
  // @LINE:29
  Songs_0: controllers.Songs,
  // @LINE:30
  Playlists_10: controllers.Playlists,
  // @LINE:31
  Images_9: controllers.Images,
  // @LINE:34
  UserController_1: controllers.UserController,
  // @LINE:36
  FileController_7: controllers.FileController,
  // @LINE:38
  OAuth2Controller_4: controllers.OAuth2Controller,
  // @LINE:43
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:9
    ApplicationController_5: controllers.ApplicationController,
    // @LINE:11
    ApiHelpController_6: controllers.ApiHelpController,
    // @LINE:14
    Posts_8: controllers.Posts,
    // @LINE:20
    Ports_2: controllers.Ports,
    // @LINE:29
    Songs_0: controllers.Songs,
    // @LINE:30
    Playlists_10: controllers.Playlists,
    // @LINE:31
    Images_9: controllers.Images,
    // @LINE:34
    UserController_1: controllers.UserController,
    // @LINE:36
    FileController_7: controllers.FileController,
    // @LINE:38
    OAuth2Controller_4: controllers.OAuth2Controller,
    // @LINE:43
    Assets_3: controllers.Assets
  ) = this(errorHandler, ApplicationController_5, ApiHelpController_6, Posts_8, Ports_2, Songs_0, Playlists_10, Images_9, UserController_1, FileController_7, OAuth2Controller_4, Assets_3, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ApplicationController_5, ApiHelpController_6, Posts_8, Ports_2, Songs_0, Playlists_10, Images_9, UserController_1, FileController_7, OAuth2Controller_4, Assets_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.ApplicationController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api-docs.json""", """controllers.ApiHelpController.getResources"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api-docs/api/ports""", """controllers.ApiHelpController.getResource(path:String = "/api/ports")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/posts""", """controllers.Posts.list"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/post/$id<[^/]+>/like""", """controllers.Posts.like(id:String)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/post/$id<[^/]+>""", """controllers.Posts.update(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/post""", """controllers.Posts.add"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/post/$id<[^/]+>""", """controllers.Posts.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/ports""", """controllers.Ports.list"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/ports/$portName<[^/]+>""", """controllers.Ports.findByName(portName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/ports/1/$portName<[^/]+>""", """controllers.Ports.findOneByName(portName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/ports/id/$id<[^/]+>""", """controllers.Ports.findById(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/port""", """controllers.Ports.add"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/port/oauth""", """controllers.Ports.addAuthenticated"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/ports/remove/$id<[^/]+>""", """controllers.Ports.delete(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/songs""", """controllers.Songs.list"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/playlists""", """controllers.Playlists.list"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/images""", """controllers.Images.list"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/images/id/$id<[^/]+>""", """controllers.Images.findById(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/register""", """controllers.UserController.register"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/file""", """controllers.FileController.sayHello"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """_oauth-callback""", """controllers.OAuth2Controller.callback(code:Option[String], state:Option[String])"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """_oauth-success""", """controllers.OAuth2Controller.success"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """_oauth-getInfo""", """controllers.OAuth2Controller.getUserInfo()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/hello""", """controllers.OAuth2Controller.hello"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """$file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:9
  private[this] lazy val controllers_ApplicationController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_ApplicationController_index0_invoker = createInvoker(
    ApplicationController_5.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_ApiHelpController_getResources1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api-docs.json")))
  )
  private[this] lazy val controllers_ApiHelpController_getResources1_invoker = createInvoker(
    ApiHelpController_6.getResources,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiHelpController",
      "getResources",
      Nil,
      "GET",
      """""",
      this.prefix + """api-docs.json"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_ApiHelpController_getResource2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api-docs/api/ports")))
  )
  private[this] lazy val controllers_ApiHelpController_getResource2_invoker = createInvoker(
    ApiHelpController_6.getResource(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiHelpController",
      "getResource",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api-docs/api/ports"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Posts_list3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/posts")))
  )
  private[this] lazy val controllers_Posts_list3_invoker = createInvoker(
    Posts_8.list,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Posts",
      "list",
      Nil,
      "GET",
      """""",
      this.prefix + """api/posts"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Posts_like4_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/post/"), DynamicPart("id", """[^/]+""",true), StaticPart("/like")))
  )
  private[this] lazy val controllers_Posts_like4_invoker = createInvoker(
    Posts_8.like(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Posts",
      "like",
      Seq(classOf[String]),
      "PATCH",
      """""",
      this.prefix + """api/post/$id<[^/]+>/like"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Posts_update5_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/post/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Posts_update5_invoker = createInvoker(
    Posts_8.update(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Posts",
      "update",
      Seq(classOf[String]),
      "PATCH",
      """""",
      this.prefix + """api/post/$id<[^/]+>"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Posts_add6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/post")))
  )
  private[this] lazy val controllers_Posts_add6_invoker = createInvoker(
    Posts_8.add,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Posts",
      "add",
      Nil,
      "POST",
      """""",
      this.prefix + """api/post"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Posts_delete7_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/post/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Posts_delete7_invoker = createInvoker(
    Posts_8.delete(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Posts",
      "delete",
      Seq(classOf[String]),
      "DELETE",
      """""",
      this.prefix + """api/post/$id<[^/]+>"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Ports_list8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/ports")))
  )
  private[this] lazy val controllers_Ports_list8_invoker = createInvoker(
    Ports_2.list,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Ports",
      "list",
      Nil,
      "GET",
      """""",
      this.prefix + """api/ports"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Ports_findByName9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/ports/"), DynamicPart("portName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Ports_findByName9_invoker = createInvoker(
    Ports_2.findByName(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Ports",
      "findByName",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/ports/$portName<[^/]+>"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Ports_findOneByName10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/ports/1/"), DynamicPart("portName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Ports_findOneByName10_invoker = createInvoker(
    Ports_2.findOneByName(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Ports",
      "findOneByName",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/ports/1/$portName<[^/]+>"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Ports_findById11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/ports/id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Ports_findById11_invoker = createInvoker(
    Ports_2.findById(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Ports",
      "findById",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/ports/id/$id<[^/]+>"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Ports_add12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/port")))
  )
  private[this] lazy val controllers_Ports_add12_invoker = createInvoker(
    Ports_2.add,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Ports",
      "add",
      Nil,
      "POST",
      """""",
      this.prefix + """api/port"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_Ports_addAuthenticated13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/port/oauth")))
  )
  private[this] lazy val controllers_Ports_addAuthenticated13_invoker = createInvoker(
    Ports_2.addAuthenticated,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Ports",
      "addAuthenticated",
      Nil,
      "POST",
      """""",
      this.prefix + """api/port/oauth"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_Ports_delete14_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/ports/remove/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Ports_delete14_invoker = createInvoker(
    Ports_2.delete(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Ports",
      "delete",
      Seq(classOf[String]),
      "DELETE",
      """""",
      this.prefix + """api/ports/remove/$id<[^/]+>"""
    )
  )

  // @LINE:29
  private[this] lazy val controllers_Songs_list15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/songs")))
  )
  private[this] lazy val controllers_Songs_list15_invoker = createInvoker(
    Songs_0.list,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Songs",
      "list",
      Nil,
      "GET",
      """""",
      this.prefix + """api/songs"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_Playlists_list16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/playlists")))
  )
  private[this] lazy val controllers_Playlists_list16_invoker = createInvoker(
    Playlists_10.list,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Playlists",
      "list",
      Nil,
      "GET",
      """""",
      this.prefix + """api/playlists"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_Images_list17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/images")))
  )
  private[this] lazy val controllers_Images_list17_invoker = createInvoker(
    Images_9.list,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Images",
      "list",
      Nil,
      "GET",
      """""",
      this.prefix + """api/images"""
    )
  )

  // @LINE:32
  private[this] lazy val controllers_Images_findById18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/images/id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Images_findById18_invoker = createInvoker(
    Images_9.findById(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Images",
      "findById",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/images/id/$id<[^/]+>"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_UserController_register19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/register")))
  )
  private[this] lazy val controllers_UserController_register19_invoker = createInvoker(
    UserController_1.register,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "register",
      Nil,
      "POST",
      """""",
      this.prefix + """users/register"""
    )
  )

  // @LINE:36
  private[this] lazy val controllers_FileController_sayHello20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/file")))
  )
  private[this] lazy val controllers_FileController_sayHello20_invoker = createInvoker(
    FileController_7.sayHello,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FileController",
      "sayHello",
      Nil,
      "POST",
      """""",
      this.prefix + """api/file"""
    )
  )

  // @LINE:38
  private[this] lazy val controllers_OAuth2Controller_callback21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("_oauth-callback")))
  )
  private[this] lazy val controllers_OAuth2Controller_callback21_invoker = createInvoker(
    OAuth2Controller_4.callback(fakeValue[Option[String]], fakeValue[Option[String]]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OAuth2Controller",
      "callback",
      Seq(classOf[Option[String]], classOf[Option[String]]),
      "GET",
      """""",
      this.prefix + """_oauth-callback"""
    )
  )

  // @LINE:39
  private[this] lazy val controllers_OAuth2Controller_success22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("_oauth-success")))
  )
  private[this] lazy val controllers_OAuth2Controller_success22_invoker = createInvoker(
    OAuth2Controller_4.success,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OAuth2Controller",
      "success",
      Nil,
      "GET",
      """""",
      this.prefix + """_oauth-success"""
    )
  )

  // @LINE:40
  private[this] lazy val controllers_OAuth2Controller_getUserInfo23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("_oauth-getInfo")))
  )
  private[this] lazy val controllers_OAuth2Controller_getUserInfo23_invoker = createInvoker(
    OAuth2Controller_4.getUserInfo(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OAuth2Controller",
      "getUserInfo",
      Nil,
      "GET",
      """""",
      this.prefix + """_oauth-getInfo"""
    )
  )

  // @LINE:41
  private[this] lazy val controllers_OAuth2Controller_hello24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/hello")))
  )
  private[this] lazy val controllers_OAuth2Controller_hello24_invoker = createInvoker(
    OAuth2Controller_4.hello,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OAuth2Controller",
      "hello",
      Nil,
      "GET",
      """""",
      this.prefix + """api/hello"""
    )
  )

  // @LINE:43
  private[this] lazy val controllers_Assets_at25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at25_invoker = createInvoker(
    Assets_3.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:9
    case controllers_ApplicationController_index0_route(params) =>
      call { 
        controllers_ApplicationController_index0_invoker.call(ApplicationController_5.index)
      }
  
    // @LINE:11
    case controllers_ApiHelpController_getResources1_route(params) =>
      call { 
        controllers_ApiHelpController_getResources1_invoker.call(ApiHelpController_6.getResources)
      }
  
    // @LINE:12
    case controllers_ApiHelpController_getResource2_route(params) =>
      call(Param[String]("path", Right("/api/ports"))) { (path) =>
        controllers_ApiHelpController_getResource2_invoker.call(ApiHelpController_6.getResource(path))
      }
  
    // @LINE:14
    case controllers_Posts_list3_route(params) =>
      call { 
        controllers_Posts_list3_invoker.call(Posts_8.list)
      }
  
    // @LINE:15
    case controllers_Posts_like4_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Posts_like4_invoker.call(Posts_8.like(id))
      }
  
    // @LINE:16
    case controllers_Posts_update5_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Posts_update5_invoker.call(Posts_8.update(id))
      }
  
    // @LINE:17
    case controllers_Posts_add6_route(params) =>
      call { 
        controllers_Posts_add6_invoker.call(Posts_8.add)
      }
  
    // @LINE:18
    case controllers_Posts_delete7_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Posts_delete7_invoker.call(Posts_8.delete(id))
      }
  
    // @LINE:20
    case controllers_Ports_list8_route(params) =>
      call { 
        controllers_Ports_list8_invoker.call(Ports_2.list)
      }
  
    // @LINE:21
    case controllers_Ports_findByName9_route(params) =>
      call(params.fromPath[String]("portName", None)) { (portName) =>
        controllers_Ports_findByName9_invoker.call(Ports_2.findByName(portName))
      }
  
    // @LINE:22
    case controllers_Ports_findOneByName10_route(params) =>
      call(params.fromPath[String]("portName", None)) { (portName) =>
        controllers_Ports_findOneByName10_invoker.call(Ports_2.findOneByName(portName))
      }
  
    // @LINE:23
    case controllers_Ports_findById11_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Ports_findById11_invoker.call(Ports_2.findById(id))
      }
  
    // @LINE:24
    case controllers_Ports_add12_route(params) =>
      call { 
        controllers_Ports_add12_invoker.call(Ports_2.add)
      }
  
    // @LINE:25
    case controllers_Ports_addAuthenticated13_route(params) =>
      call { 
        controllers_Ports_addAuthenticated13_invoker.call(Ports_2.addAuthenticated)
      }
  
    // @LINE:26
    case controllers_Ports_delete14_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Ports_delete14_invoker.call(Ports_2.delete(id))
      }
  
    // @LINE:29
    case controllers_Songs_list15_route(params) =>
      call { 
        controllers_Songs_list15_invoker.call(Songs_0.list)
      }
  
    // @LINE:30
    case controllers_Playlists_list16_route(params) =>
      call { 
        controllers_Playlists_list16_invoker.call(Playlists_10.list)
      }
  
    // @LINE:31
    case controllers_Images_list17_route(params) =>
      call { 
        controllers_Images_list17_invoker.call(Images_9.list)
      }
  
    // @LINE:32
    case controllers_Images_findById18_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Images_findById18_invoker.call(Images_9.findById(id))
      }
  
    // @LINE:34
    case controllers_UserController_register19_route(params) =>
      call { 
        controllers_UserController_register19_invoker.call(UserController_1.register)
      }
  
    // @LINE:36
    case controllers_FileController_sayHello20_route(params) =>
      call { 
        controllers_FileController_sayHello20_invoker.call(FileController_7.sayHello)
      }
  
    // @LINE:38
    case controllers_OAuth2Controller_callback21_route(params) =>
      call(params.fromQuery[Option[String]]("code", None), params.fromQuery[Option[String]]("state", None)) { (code, state) =>
        controllers_OAuth2Controller_callback21_invoker.call(OAuth2Controller_4.callback(code, state))
      }
  
    // @LINE:39
    case controllers_OAuth2Controller_success22_route(params) =>
      call { 
        controllers_OAuth2Controller_success22_invoker.call(OAuth2Controller_4.success)
      }
  
    // @LINE:40
    case controllers_OAuth2Controller_getUserInfo23_route(params) =>
      call { 
        controllers_OAuth2Controller_getUserInfo23_invoker.call(OAuth2Controller_4.getUserInfo())
      }
  
    // @LINE:41
    case controllers_OAuth2Controller_hello24_route(params) =>
      call { 
        controllers_OAuth2Controller_hello24_invoker.call(OAuth2Controller_4.hello)
      }
  
    // @LINE:43
    case controllers_Assets_at25_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at25_invoker.call(Assets_3.at(path, file))
      }
  }
}