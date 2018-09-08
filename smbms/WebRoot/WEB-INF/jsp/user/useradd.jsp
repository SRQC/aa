<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@include file="../header.jsp"%>

<script>
	$(function(){
		$.ajax({
			url : "showRole.do",
			dataType : "json",
			type : "post",
			success : function(msg){
				var text = "";
				for(var i = 0;i < msg.length;i++){
					text += "<option value='"+msg[i].id+"'>"
					text += msg[i].rolename
					text += "</option>"
				}
				$("#userRole").html(text)
			}
		})
		
		$("#add").click(function(){
			//一些还没有来得及写的验证
			
			document.forms[0].submit();
		})
		
		$("#back").click(function() {
			window.history.go(-1)
		})
	})
	
	function checkCode(obj){
		var code = $(obj).val();
		$.ajax({
			url : "checkCode.do",
			dataType : "json",
			type : "post",
			data : {"code":code},
			success : function(msg){
				if(msg.count == 0){
					$(obj).next().html("该编码可以使用")
				}else{
					$(obj).next().html("该编码不可以使用")
				}
			}
		})
	}
	
</script>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
<!--             <form id="userForm" name="userForm" method="post" action="useradd.do" > -->
			<fm:form action="useradd.do" method="post" modelAttribute="uuu" enctype="multipart/form-data">
	
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userCode">用户编码：</label>
<!--                     <input type="text" name="usercode" id="userCode" value="">  -->
					<fm:input path="usercode" onblur="checkCode(this)"/>
					<!-- 放置提示信息 -->
					<font color="red"><fm:errors  path="usercode" ></fm:errors></font>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
<!--                     <input type="text" name="username" id="userName" value="">  -->
					<fm:input path="username"/>
					<font color="red"><fm:errors  path="username"></fm:errors></font>
                </div>
                <div>
                    <label for="userPassword">用户密码：</label>
                    <input type="password" name="userpassword" id="userPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="ruserPassword">确认密码：</label>
                    <input type="password" name="ruserPassword" id="ruserPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label >用户性别：</label>
					<select name="gender" id="gender">
					    <option value="1" selected="selected">男</option>
					    <option value="2">女</option>
					 </select>
                </div>
               <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" class="Wdate" id="birthday" name="birthday" 
					onclick="WdatePicker()" readonly="readonly">
					<font color="red"></font>
                </div>
                <div>
                    <label for="phone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                   <input name="address" id="address"  value="">
                </div>
                <div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
					<select name="role.id" id="userRole"></select>
	        		<font color="red"></font>
                </div>
                
                <div>
                    <label for="a_idPicPath">证件照：</label>
                   	<input type="file" name="cphoto" id="a_idPicPath"/>
                    <font color="red"></font>
                </div>
               <div>
     
                    <label for="a_workPicPath">工作证照片：</label>
                   	<input type="file" name="wphoto" id="a_workPicPath"/>
                    <font color="red"></font>
                </div>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
          	</fm:form>
        </div>
</div>
</section>
<script src="statics/calendar/WdatePicker.js"></script>
<%@include file="../foot.jsp" %>