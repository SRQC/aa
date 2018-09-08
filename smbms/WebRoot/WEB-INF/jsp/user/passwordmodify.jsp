<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<script>
    	$(function(){
    		
    		save();
    	
    	})
    	
    	function save(){
    	
    	var inputold;
    	
    	var trueold;
    	
    	var new1;
    	
    	var new2;
    	
    		$("#save").click(function(){
    		
    			 trueold = $("#hidpwd").val();
    			 
    			 inputold = $("#oldpassword").val(); 
    		
    			 var rs = cathcPwd(trueold,inputold)
    			 
    			 console.log("正确的的密码"+trueold)
    			  console.log("当前的输入密码"+inputold)
    			 
    			 if(false==rs){
    			 
    			 	alert('原始密码错误');
    			 
    			 } else if(true==rs) {
    			 
    			 	new1 = $("#newpassword").val();
    			 	
    			 	new2 = $("#rnewpassword").val();
    			 	
    			 	if(new1 == new2){
    			 		
    			 		GoUpdate(new1);
    			 	
    			 	} else {
    			 	
    			 		alert('两次密码输入不一致');
    			 		
    			 		$("#newpassword").val("");
    			 		$("#rnewpassword").val("");
    			 			
    			 	}
    			 
    			 }
    			
    		})
    	
    	}
    	
    	function cathcPwd(trueold,inputold){
    	
    		if(trueold==inputold){
    		
    			return true;
    		
    		} else if(trueold!=inputold){
    		
    			return false;
    		}
    		
    	}
    	
    	function GoUpdate(new1){
    		$.ajax({
    			url : "updatePwd.do",
    			type : "post",
    			data : {"id" : $("#hiduid").val(),"userpassword" : $("#newpassword").val()},
    			success : function(data){
    				
    				if(data==1){
    					
    					alert('密码更新成功');
    					
    				} else {
    				
    					alert('系统维护中');
    				
    				}
    				
    			}
    		
    		})
    		
    	}
    	
    </script>
<div class="right">
	<input type="hidden" id="hidpwd" value="${user.userpassword}">
	<input type="hidden" id="hiduid" value="${user.id}">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>密码修改页面</span>
	</div>
	<div class="providerAdd">
		<form id="userForm" name="userForm" method="post" action="">
			<!--div的class 为error是验证错误，ok是验证成功-->
			<div class="info"></div>
			<div class="">
				<label for="oldPassword">
					旧密码：
				</label>
				<input type="password" name="oldpassword" id="oldpassword" value="">
				<font color="red"></font>
			</div>
			<div>
				<label for="newPassword">
					新密码：
				</label>
				<input type="password" name="newpassword" id="newpassword" value="">
				<font color="red"></font>
			</div>
			<div>
				<label for="reNewPassword">
					确认新密码：
				</label>
				<input type="password" name="rnewpassword" id="rnewpassword"
					value="">
				<font color="red"></font>
			</div>
			<div class="providerAddBtn">
				<!--<a href="#">保存</a>-->
				<input type="button" name="save" id="save" value="保存"
					class="input-button">
			</div>
		</form>
	</div>
</div>

<%@include file="../foot.jsp"%>