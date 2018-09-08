<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<%@include file="header.jsp" %>


	<div class="right">
        <img class="wColck" src="statics/images/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>${sessionScope.loginUser.username }</h2>
            <p>欢迎来到超市订单管理系统!</p>
        </div>
    </div>
</section>

<%@include file="foot.jsp" %>