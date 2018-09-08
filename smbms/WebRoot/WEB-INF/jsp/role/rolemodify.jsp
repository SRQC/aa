<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<script>
	$(function(){
		$("#save").click(function(){
			document.forms[0].submit()
		})
		$("#back").click(function(){
			window.history.go(-1)
		})
	})
</script>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>角色管理页面 >> 角色修改页面</span>
	</div>
	<div class="providerAdd">
		<form id="roleForm" name="roleForm" method="post" action="roleModify.do">
			<input type="hidden" name="id" value="${r.id}"/>
			<div>
				<label for="roleCode">
					用户编码：
				</label>
				<input type="text" name="rolecode" value="${r.rolecode}" readonly="readonly">
			</div>
			<div>
				<label for="roleName">
					用户名称：
				</label>
				<input type="text" name="rolename" id="roleName" value="${r.rolename}">
				<font color="red"></font>
			</div>

			<div class="providerAddBtn">
				<input type="button" name="save" id="save" value="保存" />
				<input type="button" id="back" name="back" value="返回" />
			</div>
		</form>
	</div>
</div>
</section>
<%@include file="../foot.jsp"%>