<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!doctype html>
    <!-- 引入struts2的标签库 -->
    <%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<link href="<%=path %>/frame/dtree.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path %>/frame/dtree.js"></script>
<meta http-equiv="Content-Type" content="txt/html; charset=utf-8"/>
</head>

<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center">
<div class="dtree">
  <script type="text/javascript">
    d=new dTree('d');

    d.add('01','-1','员工管理系统');
    d.add('0101','01','人力资源部');
    d.add('010101','0101','部门管理','<%=path %>/employeeManager/Department_getDepartments?currentPage=1','','right');

    d.add('010102','0101','员工管理','<%=path %>/employeeManager/Employee_getEmployees?currentPage=1','','right');
    document.write(d);
  </script>
</div>
</table>

</body>
</html>
