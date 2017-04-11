<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="/struts-tags" prefix="s"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="txt/html; charset=utf-8"/>
<title>员工管理系统</title>
</head>
<html>
<frameset rows="80,*">
   <frame name="top" src="<%=path %>/frame/top.jsp">
   <frameset cols="150,*" id="main">

      <frame src="<%=path %>/frame/left.jsp"> 
     <frame name="right" src="<%=path %>/frame/right.jsp">
   </frameset>
</frameset>
</html>