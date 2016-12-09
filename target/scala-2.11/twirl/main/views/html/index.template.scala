
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String, redirectUrl: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.40*/("""

"""),_display_(/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
    """),format.raw/*4.5*/("""<h2>Not Yet Authenticated</h2>
    <a href=""""),_display_(/*5.15*/redirectUrl),format.raw/*5.26*/(""""><em><b>Log in with GITHUB!</b></em></a>
""")))}),format.raw/*6.2*/("""
"""))
      }
    }
  }

  def render(message:String,redirectUrl:String): play.twirl.api.HtmlFormat.Appendable = apply(message,redirectUrl)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (message,redirectUrl) => apply(message,redirectUrl)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Thu Nov 17 21:58:12 GMT 2016
                  SOURCE: /Users/stephenjacob/workspace/portsCrossing2/app/views/index.scala.html
                  HASH: 59f858ca5f7a35fc40a8e30f0d8f26d5e1927fc3
                  MATRIX: 534->1|667->39|695->42|726->65|765->67|796->72|867->117|898->128|970->171
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|29->5|29->5|30->6
                  -- GENERATED --
              */
          