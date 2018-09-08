<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<script type="text/javascript">

	$(function(){
		bindData();
		bindEvent();
	})
	
	function bindData(){

		$.ajax({

			url:"findRole.do",

			dataType:"json",
	
			type:"post",
						
			success:function(msg){
				
				var text="";
				
				for (var i=0; i<msg.list.length; i++) {

					var b = msg.list[i];

					text += "<tr>"
						text += "<td>"
						text += "<span>"+b.rolecode+"</span>"
						text += "</td>"
						text += "<td>"
						text += "<span>"+b.rolename+"</span>"
						text += "</td>"
						text += "<td>"
						text += "<span>"+b.creationdate+"</span>"
						text += "</td>"
						text += "<td>"
						text += "<span><a class=\"modifyRole\" href=\"javascript:;\" roleid='"+b.id+"'><img src=\"statics/images/xiugai.png\" alt=\"修改\" title=\"修改\"/></a></span>"
						text += "<span><a class=\"deleteRole\" href=\"javascript:;\" roleid='"+b.id+"'><img src=\"statics/images/schu.png\" alt=\"删除\" title=\"删除\"/></a></span>"
						text += "</td>"
					text += "</tr>"
				}
				$(".providerTable tr:not(:first)").remove()
				$(".providerTable").append(text);
			}
		})
	}

	var id;

	function bindEvent() {

		$("#yes").click(function() {
			window.location = "roledelete.do?id="+id
		})
		
		$("#no").click(function(){
			$(".zhezhao,.remove").hide();
	
		})
		
		$(".providerTable").delegate(".deleteRole","click",function(){
			$(".zhezhao,.remove").show();
			id = $(this).attr("roleid")
		})
		
		$(".providerTable").delegate(".modifyRole","click",function(){
			var id = $(this).attr("roleid");
			window.location = "toRoleModify.do?id="+id						
		})

	}
</script>

<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>角色管理页面</span>
	</div>
	<div class="search">
		<a href="toRoleAdd.do">添加角色</a>
	</div>
	<table class="providerTable" cellpadding="0" cellspacing="0">
		<tr class="firstTr">
			<th width="10%">角色编码</th>
			<th width="20%">角色名称</th>
			<th width="10%">创建时间</th>
			<th width="30%">操作</th>
		</tr>
	</table>
</div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeRole">
	<div class="removerChid">
		<h2>
			提示
		</h2>
		<div class="removeMain">
			<p>
				你确定要删除该角色吗？
			</p>
			<a href="#" id="yes">确定</a>
			<a href="#" id="no">取消</a>
		</div>
	</div>
</div>
<%@include file="../foot.jsp"%>
