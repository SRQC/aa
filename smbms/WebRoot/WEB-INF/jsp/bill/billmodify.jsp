<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../header.jsp"%>
<script>
	$(function(){
		$.ajax({
			url:"showRovider.do",
			dataType:"json",
			type:"post",
			success:function(msg){
	
				var text = ""
				var selectid = ${bill.provider.id}
				for(var i=0;i<msg.length;i++){
					var p  =msg[i]
					if(selectid=p.id){
						text +="<option value='"+p.id+"' selected ='selected'>" 
					}else{
						text +="<option value='"+p.id+"'>"; 
						
					}			
					text +=p.proname

					text +="</option>"
				}
				$("#providerId").html(text);
			}
		})
		$("#save").click(function() {
			document.forms[0].submit()
		})
		$("#back").click(function() {
			window.history.go(-1)
		})
	})
</script>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>订单管理页面 >> 订单添加页面</span>
	</div>
	<div class="providerAdd">
		<form id="billForm" name="billForm" method="post" action="billModify.do">
			<input type="hidden" name="id" value="${bill.id}"/>
			<!--div的class 为error是验证错误，ok是验证成功-->
			<div class="">
				<label for="billCode">
					订单编码：
				</label>
				<input type="text" name="billcode" id="billCode" value="${bill.billcode}"
					readonly="readonly">
			</div>
			<div>
				<label for="productName">
					商品名称：
				</label>
				<input type="text" name="productname" id="productName" value="${bill.productname}">
				<font color="red"></font>
			</div>
			<div>
				<label for="productUnit">
					商品单价：
				</label>
				<input type="text" name="productunit" id="productUnit" value="${bill.productunit}">
				<font color="red"></font>
			</div>
			<div>
				<label for="productCount">
					商品数量：
				</label>
				<input type="text" name="productcount" id="productCount" value="${bill.productcount}">
				<font color="red"></font>
			</div>
			<div>
				<label for="totalPrice">
					总金额：
				</label>
				<input type="text" name="totalprice" id="totalPrice" value="${bill.totalprice}">
				<font color="red"></font>
			</div>
			<div>
				<label for="providerId">
					供应商：
				</label>

				<select name="provider.id" id="providerId">
				</select>
				<font color="red"></font>
			</div>
			<div>
				<label>
					是否付款：
				</label>

				<input type="radio" name="ispayment" value="1"<c:if test="${bill.ispayment==1}">checked="checked"</c:if> >
				已付款
				<input type="radio" name="ispayment" value="2"<c:if test="${bill.ispayment==2}">checked="checked"</c:if> >
				未付款
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