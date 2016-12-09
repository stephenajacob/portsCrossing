
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/stephenjacob/workspace/portsCrossing3/conf/routes
// @DATE:Fri Nov 25 20:15:45 GMT 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
