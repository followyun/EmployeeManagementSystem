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
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 部门修改</td>
</tr>
<tr>
<td align="right" > 
<a href="<%=path %>/employeeManager/Department_getDepartments?currentPage=1">退回 </a>
</td>
</tr>
</table>

<br/>
 <br>
 <s:form action="Department_updateDepartment" method="post" namespace="/employeeManager">
<table style="font-size::16px">
<tr>
  <td>部门ID：</td>
  <td><input type="text" name="did" value="<s:property value="#session.editDepartment.did"/>" readonly="readonly"/></td>
</tr>
<tr>
  <td>部门名称：</td>
  <td><input type="text" name="dname" value="<s:property value="#session.editDepartment.dname"/>"/></td>
</tr>
<tr>
  <td>部门介绍：</td>
  <td></td>
</tr>
<tr>
  <td width="10%"></td>
  <td>
     <textarea cols="50" rows="5" name="ddesc"><s:property value="#session.editDepartment.ddesc"/></textarea>
  </td>
</tr>
<tr>
    <td colspan="2"><input type="submit" value="保存"></td>
</tr>
</table>
</s:form>
<!-- 打印执行添加action后的信息 -->
<br><s:actionmessage/><br><s:actionerror/>
</body>
</html> 

