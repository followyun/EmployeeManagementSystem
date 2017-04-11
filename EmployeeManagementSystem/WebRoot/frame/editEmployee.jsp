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
<script type="text/javascript" src="<%=path %>/js/Calendar3.js"></script>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工修改</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('addForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="Employee_updateEmployee" method="post" namespace="/employeeManager" id='addForm'>
<s:hidden name="eid" value="%{model.eid}"/>
<table border='0' cellpadding="0"  cellspacing="10">
<tr>

<td>姓名：</td>
<td><s:textfield name="ename" value="%{model.ename}"/></td>
<td>性别：</td>
<td><s:radio name="gender" list="{'男','女'}" value="%{model.gender}"/></td>
</tr>
<tr>
<td>出生日期：</td>
<td><input type="text" name="birthday" size="20" maxlength="10" onclick="new Calendar().show(this);" readonly="readonly"/></td>
<td>入职时间：</td>
<td><input type="text" name="joinDate" size="20" maxlength="10" onclick="new Calendar().show(this);" readonly="readonly"/></td>
</tr>

<tr>
<td>所属部门：</td>
<td><s:select name="department.did" list="list" listKey="did" listValue="dname" headerKey="%{model.department.did}" headerValue="%{model.department.dname}"></s:select>
</td>

<td>编号：</td>
<td><s:textfield name="enumber" value="%{model.enumber}"/></td>

</tr>
<tr>
<td>用户名：</td>
<td><input type="text" name="username" value="<s:property value="%{model.username}"/>"/></td>
<tr/>
<tr>
<td>密码：</td>
<td><input type="password" name="password" value="<s:property value="%{model.password}"/>"/></td>
</tr>
</table>
</s:form>
<!-- 打印执行添加action后的信息 -->
<br><s:actionmessage/><br><s:actionerror/>
</body>
</html>

