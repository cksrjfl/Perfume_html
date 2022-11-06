<%@ page contentType="text/html" pageEncoding="utf-8" %>
<%
	session.invalidate();
	out.print("로그아웃 하셨습니다.");
%>