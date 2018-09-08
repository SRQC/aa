<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../header.jsp"%>
<script type="text/javascript">
	$(function(){
		$("#back").click(function() {
			window.history.go(-1)
		})
	})
</script>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>供应商管理页面 >> 信息查看</span>
	</div>
	<div class="providerView">
		<p>
			<strong>供应商编码：</strong><span>${provider.procode}</span>
		</p>
		<p>
			<strong>供应商名称：</strong><span>${provider.proname}</span>
		</p>
		<p>
			<strong>联系人：</strong><span>${provider.procontact}</span>
		</p>
		<p>
			<strong>联系电话：</strong><span>${provider.prophone}</span>
		</p>
		<p>
			<strong>传真：</strong><span>${provider.profax}</span>
		</p>
		<p>
			<strong>描述：</strong><span>${provider.prodesc}</span>
		</p>
		<p>
			<strong>企业营业执照：</strong><span>
			
			<c:choose>
	       		<c:when test="${requestScope.provider.cardphoto!=null}">
			    	<img src="${pageContext.request.contextPath }/${requestScope.provider.cardphoto}" width="200px" height="200px" style="margin-left: 200px"/>
	           	</c:when>
	            <c:otherwise>
	                   	暂无企业营业执照
	           </c:otherwise>
           </c:choose>
			</span>
		</p>

		<p>
			<strong>组织机构代码证：</strong><span>
			<c:choose>
	        	<c:when test="${requestScope.provider.workphoto!=null}">
	                 <img src="${pageContext.request.contextPath }/${requestScope.provider.workphoto}" width="200px" height="200px" style="margin-left: 200px"/>
	           	</c:when>
	            <c:otherwise>
	                   	暂无组织机构代码证照
	            </c:otherwise>
            </c:choose>
			</span>
		</p>

		<div class="providerAddBtn">
			<input type="button" id="back" name="back" value="返回">
		</div>
	</div>
</div>
</section>
<%@include file="../foot.jsp"%>