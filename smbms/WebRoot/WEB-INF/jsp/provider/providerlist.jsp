<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<script type="text/javascript">

	var currentPage = 1;
	
	$(function(){
		bindData(currentPage);
		bindEvent();
	})
	
	function bindData(currentPage){
		
		var queryProName = $("#queryProName").val()

		var queryProCode = $("#queryProCode").val()

		$.ajax({

			url:"findProvider.do",

			dataType:"json",
	
			type:"post",
			
			data:{"queryProName":queryProName,"queryProCode":queryProCode,"currentPage":currentPage},
					
			success:function(msg){
				
				var text="";
				
				for (var i=0; i<msg.list.length; i++) {

					var b = msg.list[i];
				
					text += "<tr>"
						text += "<td>"
						text += "<span>"+b.procode+"</span>"
						text += "</td>"
						text += "<td>"
						text += "<span>"+b.proname+"</span>"
						text += "</td>"
						text += "<td>"
						text += "<span>"+b.procontact+"</span>"
						text += "</td>"
						text += "<td>"
						text += "<span>"+b.prophone+"</span>"
						text += "</td>"
						text += "<td>"
						text += "<span>"+b.profax+"</span>"
						text += "</td>"
						text += "<td>"
						text += "<span>"+b.creationdate+"</span>"
						text += "</td>"
						text += "<td>"
						text += "<span><a class=\"viewProvider\" href=\"javascript:;\" Providerid='"+b.id+"'><img src=\"statics/images/read.png\" alt=\"查看\" title=\"查看\"/></a></span>"
						text += "<span><a class=\"modifyProvider\" href=\"javascript:;\" Providerid='"+b.id+"'><img src=\"statics/images/xiugai.png\" alt=\"修改\" title=\"修改\"/></a></span>"
						text += "<span><a class=\"deleteProvider\" href=\"javascript:;\" Providerid='"+b.id+"'><img src=\"statics/images/schu.png\" alt=\"删除\" title=\"删除\"/></a></span>"
						text += "</td>"
					text += "</tr>"
				}
				$(".providerTable tr:not(:first)").remove()
				$(".providerTable").append(text);
				$("#count").html(msg.count)
				$("#currentPage").html(currentPage)
				$("#totalPage").html(msg.totalPage)
			}
		})
	}

	var id;

	function bindEvent() {

		$("#yes").click(function() {
		
			window.location = "providerdelete.do?id="+id
		})
		
		$("#no").click(function(){
			$(".zhezhao,.remove").hide();
	
		})
		
		$(".providerTable").delegate(".deleteProvider","click",function(){
			$(".zhezhao,.remove").show();
			id = $(this).attr("Providerid")
			
		})
		
		$("#searchbutton").click(function(){
			currentPage = 1;
			bindData(currentPage)
		})
		
		$(".providerTable").delegate(".viewProvider","click",function(){
			var id = $(this).attr("Providerid");
			window.location = "providerView.do?id="+id+"&mode=view"						
		})
		
		$(".providerTable").delegate(".modifyProvider","click",function(){
			var id = $(this).attr("Providerid");
			window.location = "providerView.do?id="+id+"&mode=update"						
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
		<span>供应商管理页面</span>
	</div>
	<div class="search">
		<span>供应商编码：</span>
		<input id="queryProCode" type="text" value="">

		<span>供应商名称：</span>
		<input id="queryProName" type="text" value="">
		<input type="hidden" name="pageIndex" value="1" />
		<input value="查 询" type="submit" id="searchbutton">
		<a href="toProviderAdd.do">添加供应商</a>
	</div>
	<!--供应商操作表格-->
	<table class="providerTable" cellpadding="0" cellspacing="0">
		<tr class="firstTr">
			<th width="10%">供应商编码</th>
			<th width="20%">供应商名称</th>
			<th width="10%">联系人</th>
			<th width="10%">联系电话</th>
			<th width="10%">传真</th>
			<th width="10%">创建时间</th>
			<th width="30%">操作</th>
		</tr>

	</table>
	<div class="page-bar">
		<ul class="page-num-ul clearfix">
			<li>
				共
				<span id="count"></span>条记录&nbsp;&nbsp;
				<span id="currentPage"></span>/
				<span id="totalPage"></span>页
			</li>

			<a href="javascript:void(0)" class="first">首页</a>
			<a href="javascript:void(0)" class="prev">上一页</a>


			<a href="javascript:void(0)" class="next">下一页</a>
			<a href="javascript:void(0)" class="last">最后一页</a> &nbsp;&nbsp;
		</ul>
		<span class="page-go-form">
			<label>
				跳转至
			</label> <input type="text" name="inputPage" id="inputPage" class="page-key" />页
			<button type="button" class="page-btn">
				GO
			</button> 
		</span>
	</div>

</div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
	<div class="removerChid">
		<h2>
			提示
		</h2>
		<div class="removeMain">
			<p>
				你确定要删除该供应商吗？
			</p>
			<a href="#" id="yes">确定</a>
			<a href="#" id="no">取消</a>
		</div>
	</div>
</div>
<%@include file="../foot.jsp"%>