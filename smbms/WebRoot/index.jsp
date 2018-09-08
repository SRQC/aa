<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">

    <title>系统登录 - 超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="statics/css/style.css" />
  
</head>
<body>
	<c:if test="${requestScope.loginflag!=null}">
		<script>
			alert("用户名或密码不正确")
		</script>
	</c:if>


	<section class="loginBox">
        <header class="loginHeader">
            <h1>超市订单管理系统</h1>
        </header>
        <section class="loginCont">
	        <form class="loginForm" action="login.do"  method="post" >
				<div class="info"></div>
				<div class="inputbox">
                    <label for="user">用户名：</label>
					<input type="text" class="input-text" name="username"  placeholder="请输入用户名" required/>
				</div>	
				<div class="inputbox">
                    <label for="mima">密码：</label>
                    <input type="password" placeholder="请输入密码" name="userpassword" required/>
                </div>	
				<div class="subBtn">
                    <input type="submit" value="登录"/>
                    <input type="reset" value="重置"/>
                </div>	
			</form>
        </section>
    </section>
</body>
</html>
