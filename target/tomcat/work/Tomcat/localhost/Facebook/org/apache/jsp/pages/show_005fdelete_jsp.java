/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-11-01 09:03:49 UTC
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

public final class show_005fdelete_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>");
      if (_jspx_meth_spring_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("</title>\n");
      out.write("    <style>\n");
      out.write("    \ttable{\n");
      out.write("    \t\tborder-collapse: collapse;\n");
      out.write("    \t\twidth:75%;\n");
      out.write("    \t}\n");
      out.write("    \tth, td{\n");
      out.write("    \t\ttext-align:left;\n");
      out.write("    \t\tpadding:10px;\n");
      out.write("    \t}\n");
      out.write("    \ttr:nth-child(even){\n");
      out.write("    \t\tbackground-color:#f2f2f2;\n");
      out.write("    \t}\n");
      out.write("    \tth{\n");
      out.write("    \t\tbackground-color:#3498db;\n");
      out.write("    \t\tcolor:white;\n");
      out.write("    \t}\n");
      out.write("    \t.button {\n");
      out.write("\t\t\t  background-color: green;\n");
      out.write("\t\t\t  border: none;\n");
      out.write("\t\t\t  color: white;\n");
      out.write("\t\t\t  padding: 10px 15px;\n");
      out.write("\t\t\t  margin-top: 10\tpx;\n");
      out.write("\t\t\t  text-align: center;\n");
      out.write("\t\t\t  text-decoration: none;\n");
      out.write("\t\t\t  display: inline-block;\n");
      out.write("\t\t\t  font-size: 15px;\n");
      out.write("\t\t\t  margin: 15px 8px;\n");
      out.write("\t\t\t  cursor: pointer;\n");
      out.write("\t\t}\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <h2>Group Table: </h2>\n");
      out.write("   \t<h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${STATUS_MESSAGE}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h3>\n");
      out.write("\t   <table border=\"2\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<th>User ID</th>\n");
      out.write("\t\t\t<th>Group ID</th>\n");
      out.write("\t\t\t<th>Password</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t   ");
 	
	   	Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/user?useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username="root";
		String password="root";
		String query="select * from userinfo";
		Connection conn=DriverManager.getConnection(url, username, password);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
		
      out.write("\n");
      out.write("\t\t\t<tr><td>");
      out.print(rs.getString("userid") );
      out.write("</td>\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString("groupid") );
      out.write("</td>\n");
      out.write("\t\t\t\t<td>");
      out.print(rs.getString("password") );
      out.write("</td>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t");

		}
		
      out.write("\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t<h2>Delete User</h2>\n");
      out.write("\t\t\t<form onsubmit = \"return confirmDelete()\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/delete.html\" method=\"post\">\n");
      out.write("\t\t\t\t<label for=\"userid\">User ID:</label>\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"userid\" name=\"userid\"/><br/>\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Delete\" class=\"button\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t");

			rs.close();
			stmt.close();
			conn.close();
		
      out.write("\n");
      out.write("</body>\n");
      out.write("<script>\n");
      out.write("\tfunction confirmDelete(){\n");
      out.write("\t\tif(confirm(\"Are you sure?\")) {\n");
      out.write("\t\t\treturn true;\n");
      out.write("\t\t}\n");
      out.write("\t\t\treturn false;\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("<script defer src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/js/main.js\"></script>\n");
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
    // /pages/show_delete.jsp(15,11) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
