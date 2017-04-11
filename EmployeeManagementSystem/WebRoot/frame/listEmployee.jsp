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
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工管理</td>
</tr>
<tr>
<td align="right" > <a href="<%=path %>/employeeManager/Employee_addUI">添加</a></td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">编号</td>
<td align="center">员工姓名</td>
<td align="center">性别</td>
<td align="center">出生日期</td>
<td align="center">入职时间</td>
<td align="center">所属部门</td>
<td align="center">编辑</td>
<td align="center">删除</td>
</tr>
</thead>
<tbody>
<s:iterator value="list" var="employee">
<tr>
<td align="center"><s:property value="#employee.enumber"/></td>
<td align="center"><s:property value="#employee.ename"/></td>
<td align="center"><s:property value="#employee.gender"/></td>
<td align="center"><s:date name="#employee.birthday" format="yyyy-mm-dd"/></td>
<td align="center"><s:date name="#employee.joinDate" format="yyyy-mm-dd"/></td>
<td align="center"><s:property value="#employee.department.dname"/></td>
<td align="center"><a href="<%=path %>/employeeManager/Employee_editEmployee?eid=<s:property value="#employee.eid"/>"><img alt="编辑" src="<%=path %>/images/bianji.png"> </a></td>
<td align="center"><a href="<%=path %>/employeeManager/Employee_deleteEmployee?eid=<s:property value="#employee.eid"/>" onclick="javascript: return confirm('真的要删除吗？');"><img alt="删除" src="<%=path %>/images/delete.png"> </a></td>
</tr>
</s:iterator>
</tbody>
</table>
<br/>

<table table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currentPage"/>/<s:property value="totalPage"/>页</span>
   <span>
   <s:if test="currentPage != 1">
       <a href="<%=path %>/employeeManager/Employee_getEmployees?currentPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="<%=path %>/employeeManager/Employee_getEmployees?currentPage=<s:property value="currentPage - 1"/>">[上一页]</a>&nbsp;&nbsp;
      </s:if>
      <s:if test="currentPage != totalPage">
       <a href="<%=path %>/employeeManager/Employee_getEmployees?currentPage=<s:property value="currentPage + 1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="<%=path %>/employeeManager/Employee_getEmployees?currentPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
       </s:if>
   </span>
   <span>总记录数: <s:property value="totalCount"/></span>
</td>
</tr>
</table>
</body>
</html>