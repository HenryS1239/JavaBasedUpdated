/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-10-18 07:50:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public final class push_005fnot_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>");
      if (_jspx_meth_spring_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("    <style>\r\n");
      out.write("    \t.button {\r\n");
      out.write("\t\t\t  background-color: green;\r\n");
      out.write("\t\t\t  border: none;\r\n");
      out.write("\t\t\t  color: white;\r\n");
      out.write("\t\t\t  padding: 10px 15px;\r\n");
      out.write("\t\t\t  margin-top: 10\tpx;\r\n");
      out.write("\t\t\t  text-align: center;\r\n");
      out.write("\t\t\t  text-decoration: none;\r\n");
      out.write("\t\t\t  display: inline-block;\r\n");
      out.write("\t\t\t  font-size: 15px;\r\n");
      out.write("\t\t\t  margin: 15px 8px;\r\n");
      out.write("\t\t\t  cursor: pointer;\r\n");
      out.write("\t\t}\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <h1>Get Notified </h1>\r\n");
      out.write("\r\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/notify.html\" method=\"post\" class=\"notify\">\r\n");
      out.write("    \r\n");
      out.write("        <div class=\"box\">\r\n");
      out.write("            <label for=\"userid\">User ID: </label><br/>\r\n");
      out.write("            <input type=\"text\" id=\"userid\" name=\"userid\" class=\"userid\" /><br/> \r\n");
      out.write("            <label for=\"userid\">Group ID: </label><br/>\r\n");
      out.write("            <input type=\"text\" id=\"groupid\" name=\"groupid\" class=\"userid\" /><br/>\r\n");
      out.write("        \r\n");
      out.write("            <label for=\"sentinel\">Transaction type: </label><br/>\r\n");
      out.write("            <input type=\"text\" id=\"clientT\" placeholder=\"{Account Number}\"><br/>\r\n");
      out.write("            <label for=\"sentinel\">Value: </label><br/>\r\n");
      out.write("            <input type=\"text\" id=\"value\" placeholder=\"Value:RMXX.XX; Time:XXXX\"><br/>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"userid\">Custom Message:</label><br/>\r\n");
      out.write("            <textarea rows=\"4\" cols=\"50\" id=\"customMsg\"></textarea><br/>\r\n");
      out.write("\r\n");
      out.write("            <div><input type=\"submit\" class=\"button\" value=\"Notify Me\" /></div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<!-- The core Firebase JS SDK is always required and must be listed first -->\r\n");
      out.write("<script src=\"https://www.gstatic.com/firebasejs/7.2.1/firebase-app.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- TODO: Add SDKs for Firebase products that you want to use\r\n");
      out.write("     https://firebase.google.com/docs/web/setup#available-libraries -->\r\n");
      out.write("<script src=\"https://www.gstatic.com/firebasejs/7.2.1/firebase-messaging.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("  // Your web app's Firebase configuration\r\n");
      out.write("  var firebaseConfig = {\r\n");
      out.write("    apiKey: \"AIzaSyBITHGVy77Drl-DjkJNvKNuzt-jX2-9pIA\",\r\n");
      out.write("    authDomain: \"pushnotification-ff078.firebaseapp.com\",\r\n");
      out.write("    databaseURL: \"https://pushnotification-ff078.firebaseio.com\",\r\n");
      out.write("    projectId: \"pushnotification-ff078\",\r\n");
      out.write("    storageBucket: \"pushnotification-ff078.appspot.com\",\r\n");
      out.write("    messagingSenderId: \"708440050320\",\r\n");
      out.write("    appId: \"1:708440050320:web:0bc2bbf55655c5079a2615\"\r\n");
      out.write("  };\r\n");
      out.write("  // Initialize Firebase\r\n");
      out.write("  firebase.initializeApp(firebaseConfig);\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script defer src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("const dataToSend = JSON.stringify({\"email\": \"hey@mail.com\", \"password\": \"101010\"});\r\n");
      out.write("let dataRecieved=\"\"; \r\n");
      out.write("fetch(\"\",{credentials:'same-origin',mode:'same-origin',method:\"post\",body:dataToSend})\r\n");
      out.write("              .then(resp => {\r\n");
      out.write("                if(resp.status==200){\r\n");
      out.write("                   return resp.json()\r\n");
      out.write("                }else{\r\n");
      out.write("                    console.log(\"Status: \"+resp.status);\r\n");
      out.write("                    return Promise.reject(\"server\")\r\n");
      out.write("                }\r\n");
      out.write("              })\r\n");
      out.write("           .then(dataJson =>{\r\n");
      out.write("                 dataToRecieved = JSON.parse(dataJson);\r\n");
      out.write("             })\r\n");
      out.write("              .catch(err =>{\r\n");
      out.write("                if(err==\"server\")return\r\n");
      out.write("                console.log(err);\r\n");
      out.write("            })\r\n");
      out.write("            \r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_spring_005fmessage_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_005fmessage_005f0 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_spring_005fmessage_005f0.setParent(null);
    // /pages/push_not.jsp(14,11) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_spring_005fmessage_005f0.setCode("login_success_title");
    int[] _jspx_push_body_count_spring_005fmessage_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_005fmessage_005f0 = _jspx_th_spring_005fmessage_005f0.doStartTag();
      if (_jspx_th_spring_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_005fmessage_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_005fmessage_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_005fmessage_005f0.doFinally();
      _005fjspx_005ftagPool_005fspring_005fmessage_0026_005fcode_005fnobody.reuse(_jspx_th_spring_005fmessage_005f0);
    }
    return false;
  }
}
