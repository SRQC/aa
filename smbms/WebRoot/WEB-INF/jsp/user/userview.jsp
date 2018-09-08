<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../header.jsp" %>

	<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${requestScope.u.usercode }</span></p>
            <p><strong>用户名称：</strong><span>${requestScope.u.username }</span></p>
            <p><strong>用户性别：</strong>
            	<span>
 					<c:if test="${requestScope.u.gender==1}">男</c:if>
 					<c:if test="${requestScope.u.gender==2}">女</c:if>
				</span>
			</p>
            <p><strong>出生日期：</strong><span><fm:formatDate value="${requestScope.u.birthday}" pattern="yyyy-MM-dd"/></span></p>
            <p><strong>用户电话：</strong><span>${requestScope.u.phone }</span></p>
            <p><strong>用户地址：</strong><span>${requestScope.u.address }</span></p>
            <p><strong>用户角色：</strong><span>${requestScope.u.role.rolename }</span></p>            
            <p><strong>个人证件照：</strong><span>
           		
                   			<c:choose>
	                   			<c:when test="${requestScope.u.cardphoto!=null}">
	                   				<img src="${pageContext.request.contextPath }/${requestScope.u.cardphoto}" width="200px" height="200px" style="margin-left: 200px"/>
	                   			</c:when>
	                   			<c:otherwise>
	                   				暂无证件照
	                   			</c:otherwise>
                   			</c:choose>
            </span></p>            
            <p><strong>工作证照片：</strong><span>
          
                   			<c:choose>
	                   			<c:when test="${requestScope.u.workphoto!=null}">
	                   				<img src="${pageContext.request.contextPath }/${requestScope.u.workphoto}" width="200px" height="200px" style="margin-left: 200px"/>
	                   			</c:when>
	                   			<c:otherwise>
	                   				暂无工作照
	                   			</c:otherwise>
                   			</c:choose>
            </span></p>
			<div class="providerAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>

<%@include file="../foot.jsp" %>