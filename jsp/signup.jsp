<%@ page contentType="text/html" pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="util.*" %>
<%@ page import="dao.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String uid = request.getParameter("id");
	String upass = request.getParameter("ps");
	String uname = request.getParameter("name");

	UserDAO dao = new UserDAO();
	
	if(dao.exists(uid))
	{
		out.print("EX");
		return;
	}
	else if (dao.insert(uid,upass,uname) == true) {
	out.print("OK");
	}
	else {
	out.print("ER");
	}
	
%>