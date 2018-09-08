<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../header.jsp"%>
<script type="text/javascript">
	$(function(){
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
          <span>供应商管理页面 >> 供应商修改页</span>
      </div>
      <div class="providerAdd">
          <form id="providerForm" name="providerForm" method="post" action="providerModify.do" enctype="multipart/form-data">
             <input type="hidden" name="id" value="${provider.id}"/>
              <!--div的class 为error是验证错误，ok是验证成功-->
              <div class="">
                  <label for="proCode">供应商编码：</label>
                  <input type="text" name="procode" id="proCode" value="${provider.procode}" readonly="readonly"> 
              </div>
              <div>
                  <label for="proName">供应商名称：</label>
                 <input type="text" name="proname" id="proName" value="${provider.proname}"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="proContact">联系人：</label>
                  <input type="text" name="procontact" id="proContact" value="${provider.procontact}"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="proPhone">联系电话：</label>
                  <input type="text" name="prophone" id="proPhone" value="${provider.prophone}"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="proAddress">联系地址：</label>
                  <input type="text" name="proaddress" id="proAddress" value="${provider.proaddress}"> 
              </div>
              
              <div>
                  <label for="proFax">传真：</label>
                  <input type="text" name="profax" id="proFax" value="${provider.profax}">
              </div>
              
              <div>
                  <label for="proDesc">描述：</label>
                  <input type="text" name="prodesc" id="proDesc" value="${provider.prodesc}"> 
              </div>
              <div>
                	<label for="m_companyLicPicPath">企业营业执照：</label>
                	<input type="hidden" id="errorinfo" value=""/>
                   	<input type="file" name="rolecphoto" id="m_companyLicPicPath"/>
              		<c:choose>
	                   	<c:when test="${requestScope.provider.cardphoto!=null}">
	                   		<img src="${requestScope.provider.cardphoto}" width="200px" height="200px" style="margin-left: 200px"/>
	                   	</c:when>
	                   	<c:otherwise>
	                   		暂无企业营业执照
	                   	</c:otherwise>
                   	</c:choose>
                  	<font color="red"></font>
               </div>
              
               <div>
                	<label for="m_orgCodePicPath">组织机构代码证：</label>
                	<input type="hidden" id="errorinfo" value=""/>
                   	<input type="file" name="rolewphoto" id="m_orgCodePicPath"/>
                    <c:choose>
	                   	<c:when test="${requestScope.provider.workphoto!=null}">
	                   		<img src="${requestScope.provider.workphoto}" width="200px" height="200px" style="margin-left: 200px"/>
	                   	</c:when>
	                   	<c:otherwise>
	                   		暂组织机构代码证照
	                   	</c:otherwise>
                   	</c:choose>
                    
                    <font color="red"></font>
	            </div>
              <div class="providerAddBtn">
                  <input type="button" name="save" id="save" value="保存">
				  <input type="button" id="back" name="back" value="返回" >
              </div>
          </form>
      </div>
  </div>
</section>
<%@include file="../foot.jsp"%>
