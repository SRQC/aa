<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
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
	function checkCode(obj){
		var code = $(obj).val();
		$.ajax({
			url:"roleCheckCode.do",
			dataType:"json",
			type:"post",
			data:{"code":code},
			success:function(msg){
				if(msg.count==0){
					$(obj).next().html("该编码可用")
				}else{
					$(obj).next().html("该编码不可用")
				}
			}
			
		})
	}
</script>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>角色管理页面 >> 角色添加页面</span>
	</div>
	<div class="providerAdd">
		<form id="roleForm" name="roleForm" method="post" action="roleAdd.do">
			<!--div的class 为error是验证错误，ok是验证成功-->
			<div>
				<label for="roleCode">
					角色编码：
				</label>
				<input type="text" name="rolecode" id="roleCode" onblur="checkCode(this)" value="">
				<!-- 放置提示信息 -->
				<font color="red"><fm:errors path="rolecode"></fm:errors>  </font>
			</div>
			<div>
				<label for="roleName">
					角色名称：
				</label>
				<input type="text" name="rolename" id="roleName" value="">
				<font color="red"></font>
			</div>

			<div class="providerAddBtn">
				<input type="button" name="save" id="save" value="保存">
				<input type="button" id="back" name="back" value="返回">
			</div>
		</form>
	</div>
</div>
</section>
<%@include file="../foot.jsp"%>