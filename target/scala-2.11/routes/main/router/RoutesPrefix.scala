
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/stephenjacob/workspace/TempTest/com.purpledecks.portcrossing.scala/conf/routes
// @DATE:Tue Dec 13 10:43:10 GMT 2016


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
