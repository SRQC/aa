<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../header.jsp" %>
<script src="statics/calendar/WdatePicker.js"></script>
<script>
	$(function(){
		$.ajax({
			url : "showRole.do",
			dataType : "json",
			type : "post",
			success : function(msg){
				var selectid = ${requestScope.u.role.id}
				var text = "";
				for(var i = 0;i < msg.length;i++){
					if(selectid == msg[i].id){
						text += "<option value='"+msg[i].id+"' selected='selected'>"
					}else{
						text += "<option value='"+msg[i].id+"'>"
					}
					text += msg[i].rolename
					text += "</option>"
				}
				$("#userRole").html(text)
			}
		})
		
		$("#save").click(function(){
			//一些还没有来得及写的验证
			
			document.forms[0].submit();
		})
	})

</script>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="userModify.do" enctype="multipart/form-data">
			<input type="hidden" value="${requestScope.u.id }" name="id"/>
			 <div>
                    <label for="userName">用户编码：</label>
                    <input type="text" value="${requestScope.u.usercode }" readonly="readonly"> 
             </div>
			 <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="username" id="userName" value="${requestScope.u.username }"> 
					<font color="red"></font>
             </div>
			 <div>
                    <label >用户性别：</label>
                    <select name="gender" id="gender">
							
								<option value="1" <c:if test="${requestScope.u.gender==1}">selected="selected"</c:if>>男</option>
					    		<option value="2" <c:if test="${requestScope.u.gender==2}">selected="selected"</c:if>>女</option>
						
					 </select>
             </div>
			 <div>
                    <label for="data">出生日期：</label>
                    
                    <input type="text" class="Wdate" id="birthday" name="birthday" value="<fm:formatDate value="${requestScope.u.birthday }" pattern="yyyy-MM-dd"/>"
					readonly="readonly" onclick="WdatePicker();">
                    <font color="red"></font>
              </div>
			
		       <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value="${requestScope.u.phone }"> 
                    <font color="red"></font>
               </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="address" id="address" value="${requestScope.u.address }">
                </div>
				<div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
					
					<select name="role.id" id="userRole">
						
					</select>
        			<font color="red"></font>
                </div>
                <div>
                	<label for="m_idPicPath">证件照：</label>
                	
	            	 		<input type="hidden" id="errorinfo" value=""/>
                   			<input type="file" name="cphoto" id="m_idPicPath"/><br/>
                   			
                   			<c:choose>
	                   			<c:when test="${requestScope.u.cardphoto!=null}">
	                   				<img src="${requestScope.u.cardphoto}" width="200px" height="200px" style="margin-left: 200px"/>
	                   			</c:when>
	                   			<c:otherwise>
	                   				暂无证件照
	                   			</c:otherwise>
                   			</c:choose>
                    		<font color="red"></font>
	            		
                </div>
               <div>
               	   <label for="m_workPicPath">工作证照片：</label>
	              
	            	 		<input type="hidden" id="errorinfo_wp" value=""/>
                   			<input type="file" name="wphoto" id="m_workPicPath"/><br/>
                   			<c:choose>
	                   			<c:when test="${requestScope.u.workphoto!=null}">
	                   				<img src="${requestScope.u.workphoto}" width="200px" height="200px" style="margin-left: 200px"/>
	                   			</c:when>
	                   			<c:otherwise>
	                   				暂无工作照
	                   			</c:otherwise>
                   			</c:choose>
                    		<font color="red"></font>
	            		
                </div>
			 <div class="providerAddBtn">
                    <input type="button" name="save" id="save" value="保存" />
                    <input type="button" id="back" name="back" value="返回"/>
                </div>
            </form>
        </div>
    </div>
</section>

<%@include file="../foot.jsp" %>