<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head lang="en">
  
    <title>超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/public.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
    	function getNow(){
    		var d=  new Date();
    		var text = d.getFullYear()+"年"+(d.getMonth()+1)+"月"+d.getDate()+"日"
    		text += " "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
    		
    		switch (d.getDay()) {
			case 0:
				text += " 星期日"
				break;
			case 1:
				text += " 星期一";
				break;
			case 2:
				text += " 星期二";
				break;
			case 3:
				text += " 星期三";
				break;
			case 4:
				text += " 星期四";
				break;
			case 5:
				text += " 星期五";
				break;
			case 6:
				text += " 星期六";
				break;
			default:
				break;
			}
    		
    		$("#time").html(text);
    	}
    	
    	var d = setInterval("getNow()",1000);
    	
    
    </script>
    
    
</head>

<body>
	<header class="publicHeader">
        <h1>超市订单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.loginUser.username }</span> , 欢迎你！</p>
            <a href="loginOut.do">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
 <!--主体内容-->
 <section class="publicMian ">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
                  <li><a href="toBillList.do">订单管理</a></li>
				  <li><a href="toprovider.do">供应商管理</a></li>
				  <li><a href="toUserList.do">用户管理</a></li>
				  <li><a href="toRoleList.do">角色管理</a></li>
				  <li><a href="toPwd.do">密码修改</a></li>
				  <li><a href="loginOut.do">退出系统</a></li>
             </ul>
         </nav>
     </div>


