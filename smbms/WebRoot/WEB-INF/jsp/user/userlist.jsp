<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../header.jsp" %>
<script>
	var currentPage = 1;	//当前页
	$(function(){
		bindData(currentPage);
		
		bindEvent();
	})

	function bindData(currentPage){
		var queryname = $("#queryname").val();
		var queryUserRole = $("#queryUserRole").val();
		$.ajax({
			url : "userlist.do",
			dataType : "json",
			data : {"queryname" : queryname , "queryUserRole" : queryUserRole,"currentPage" : currentPage},
			type : "post",
			success : function(msg){
				var text = "";
				for(var i = 0;i < msg.list.length;i++){
					var u = msg.list[i];
					text += "<tr>"
					text += "	<td>"
					text += "	<span>"+u.usercode+"</span>"
					text += "	</td>"
					text += "	<td>"
					text += "	<span>"+u.username+"</span>"
					text += "	</td>"
					text += "	<td>"
					text += "		<span>"
					text += u.gender==1?"男":"女"
					text += "		</span>"
					text += "	</td>"
					text += "	<td>"
					text += "	<span>"+u.birthday+"</span>"
					text += "	</td>"
					text += "	<td>"
					text += "	<span>"+u.phone+"</span>"
					text += "	</td>"
					text += "	<td>"
					text += "		<span>"+u.role.rolename+"</span>"
					text += "	</td>"
					text += "	<td>"
					text += "	<span><a class=\"viewUser\" href=\"javascript:void(0);\" userid='"+u.id+"'><img src=\"statics/images/read.png\" alt=\"查看\" title=\"查看\"/></a></span>"
					text += "	<span><a class=\"modifyUser\" href=\"javascript:void(0);\" userid='"+u.id+"'><img src=\"statics/images/xiugai.png\" alt=\"修改\" title=\"修改\"/></a></span>"
					text += "	<span><a class=\"deleteUser\" href=\"javascript:void(0);\" userid='"+u.id+"'><img src=\"statics/images/schu.png\" alt=\"删除\" title=\"删除\"/></a></span>"
					text += "	</td>"
					text += "</tr>"
				}
				$(".providerTable tr:not(:first)").remove();
				$(".providerTable").append(text);
				$("#count").html(msg.count)			//总记录数
				$("#totalPage").html(msg.totalPage) //总页数
				$("#currentPage").html(currentPage) //当前页
			}
		})
	
	}
	
	var id = 0;
	
	function bindEvent(){
	
		$("#yes").click(function(){
			window.location = "userDelete.do?id="+id
		})
		$("#no").click(function(){
			$(".zhezhao,.remove").hide();
		})
		
		$(".deleteUser").live("click",function(){
			$(".zhezhao,.remove").show();
			id = $(this).attr("userid")
		})
		
		$(".viewUser").live("click",function(){
			var id = $(this).attr("userid");
			window.location = "userview/"+id
		})
		
		$(".modifyUser").live("click",function(){
			var id = $(this).attr("userid");
			window.location = "toUserModify.do?id="+id
		})
	
		$("#searchbutton").click(function(){
			currentPage = 1;
			bindData(currentPage)
		})
		
		$(".first").click(function(){
			currentPage = 1;
			bindData(currentPage)
		})
		
		$(".prev").click(function(){
			if(currentPage == 1){
				return;
			}
			currentPage--;
			bindData(currentPage)
		})
		
		$(".next").click(function(){
			if(currentPage == $("#totalPage").html()){
				return;
			}
			currentPage++;
			bindData(currentPage)
		})
		
		
		$(".last").click(function(){
			currentPage =  $("#totalPage").html();
			bindData(currentPage)
		})
		
		$(".page-btn").click(function(){
			var inputPage = parseInt($("#inputPage").val());
			var totalPage = parseInt($("#totalPage").html())
			if(inputPage > totalPage){
				inputPage = totalPage
			}
			$("#inputPage").val(inputPage)
			currentPage =  inputPage;
			bindData(currentPage)
		})
	}
</script>



	<div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
					 <span>用户名：</span>
					 <input id="queryname" class="input-text"	type="text" value="">
					 
					 <span>用户角色：</span>
					 <select id="queryUserRole">
						
						   <option value="0">--请选择--</option>
						   <c:forEach items="${requestScope.rlist}" var="r">
						   	<option value="${r.id }">${r.rolename }</option>
						   
						   </c:forEach>
						
	        		</select>
					 <input type="hidden" name="pageIndex" value="1"/>
					 <input	value="查 询" type="submit" id="searchbutton">
					 <a href="toUserAdd.do" >添加用户</a>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">生日</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户角色</th>
                    <th width="30%">操作</th>
                </tr>
                  
			</table>
		
		  	<div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共<span id="count"></span>条记录&nbsp;&nbsp; <span id="currentPage"></span>/<span id="totalPage"></span>页</li>
				
					<a href="javascript:void(0)" class="first">首页</a>
					<a href="javascript:void(0)" class="prev">上一页</a>
			
				
					<a href="javascript:void(0)" class="next">下一页</a>
					<a href="javascript:void(0)" class="last">最后一页</a>
				
				&nbsp;&nbsp;
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" >GO</button>
		</span>
		</div> 
        </div>
    </section>

	<!--点击删除按钮后弹出的页面-->
	<div class="zhezhao"></div>
	<div class="remove" id="removeUse">
		<div class="removerChid">
			<h2>提示</h2>
			<div class="removeMain">
				<p>你确定要删除该用户吗？</p>
				<a href="javascript:void(0)" id="yes">确定</a>
				<a href="javascript:void(0)" id="no">取消</a>
			</div>
		</div>
	</div>

<%@include file="../foot.jsp" %>