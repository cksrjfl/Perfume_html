<%@ page contentType="text/html" pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="util.*" %>
<%@ page import="dao.*" %>
<%
	out.print((new FeedDAO()).p_getList());
%>