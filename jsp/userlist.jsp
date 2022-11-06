<%@ page contentType="text/html" pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="util.*" %>
<%@ page import="dao.*" %>
	<%
	out.print((new UserDAO()).getList());
	/*
	String str = "<table align=center> " ;
	str += "<tr><th colspan=3>가입자 리스트</th></td>";
	while(rs.next()) {
		str += "<tr><th colspan=3><hr></th></td>";
		str += "<tr>";
		str += "<td>" + rs.getString("id")   + "</td>" ;
		str += "<td>" + rs.getString("name") + "</td>";
		str += "<td>&nbsp<small>" + rs.getString("ts")   + "</td>";
		str += "</tr>";
	}
	str += "</table>";
	out.print(str);
	*/
%>