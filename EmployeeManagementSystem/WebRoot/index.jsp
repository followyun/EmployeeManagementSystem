<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 引入struts2的标签库 -->
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="utf-8">
<title>登陆</title>
<link type="text/css" rel="stylesheet" href="<%=path %>/style/reset.css">
<link type="text/css" rel="stylesheet" href="<%=path %>/style/main.css">
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript" src="js/ie6Fixpng.js"></script>
<![endif]-->
</head>

<body>
<div class="headerBar">
    <div class="logoBar login_logo">
        <div class="comWidth">
            <!--  
            <div class="logo fl">
                <a href="#"><img src="<%=path %>/images/logo.jpg" alt="慕课网"></a>
            </div>
            -->
            <h3 class="welcome_title" align="center">欢迎登陆</h3>
        </div>
    </div>
</div>

<s:form action="Employee_login" method="post" namespace="/employeeManager">
<div class="loginBox">
    <div class="login_cont">
        <ul class="login">
            <li class="l_tit" >用户名</li>
            <li class="mb_10"><input type="text" class="login_input user_icon" name="username"></li>
            <li class="l_tit">密码</li>
            <li class="mb_10"><input type="password" class="login_input user_icon" name="password"></li>
            
            <li><input type="submit" value="" class="login_btn"></li>
        </ul>
        <!-- 打印Action执行后返回的错误信息 -->
        <s:actionerror/>
        
    </div>
    
</div>
</s:form>

<div class="hr_25"></div>
<div class="footer">
    <p>Copyright &copy; 版权所有&nbsp;&nbsp;&nbsp;</p>
    <p class="web"><a href="#"><img src="<%=path %>/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="<%=path %>/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="<%=path %>/images/webLogo.jpg" alt="logo"></a><a href="#"><img src="<%=path %>/images/webLogo.jpg" alt="logo"></a></p>
</div>
</body>
</html>
