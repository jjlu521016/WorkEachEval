<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>添加新知识点</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>

<script language="javascript"
	src="${pageContext.request.contextPath}/script/knowledge.js"
	charset="utf-8"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/forum.css" />
	<script charset="utf-8"
	src="${pageContext.request.contextPath }/kindeditor/kindeditor.js"></script>
	<script charset="utf-8"
	src="${pageContext.request.contextPath }/kindeditor/lang/zh_CN.js"></script>
	<script>
        　　 var editor;
         　　KindEditor.ready(function(K) {
                 　　editor = K.create('#editor_id',{
               	  items : [],
            	  readonlyMode : true

              　　});
         　　});
         　　var options = {
        	cssPath :'<%=request.getContextPath()%>/kindeditor/themes/qq/qq.css',
         　　 filterMode : true,    
            uploadJson :'<%=request.getContextPath()%>/WEB-INF/jsp/upload_json.jsp',
            fileManagerJson : '<%=request.getContextPath()%>/WEB-INF/jsp/file_manager_json.jsp',
            allowFileManager : true
    　　　　	};

   　　　　var editor = K.create('textarea[name="content"]', options);
 　　　 </script>
 
 
<%
	//章节ID	
	String charpterId = "";
	//知识点ID
	String kid = "";

	charpterId = request.getParameter("charpterId");
%>

<base target="_self" />
</head>
<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				添加新知识点
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id="MainArea">

		<s:form action="knowledge_%{kid == null ? 'add' : 'edit'}"
			name="knowledge" cssStyle="margin: 0; padding: 0;">

			<s:hidden name="charpterId"></s:hidden>
			<s:hidden name="kid"></s:hidden>
			<div id="PageHead"></div>
			<center>
				<div class="ItemBlockBorder">
					<table border="0" cellspacing="1" cellpadding="1" width="100%"
						id="InputArea">
						<tr>
							<td class="InputAreaBg" height="30" width="120px"><div
									class="InputTitle">
									知识点名称<font color="red">(*)</font>
								</div></td>
							<td class="InputAreaBg"><div class="InputContent">
									<s:textfield name="title" id="title" cssClass="InputStyle"
										cssStyle="width:50%" readonly="true"/>
								</div></td>
						</tr>
						<tr height="240">
							<td class="InputAreaBg"><div class="InputTitle">知识点说明</div></td>
							<td class="InputAreaBg">
								<div class="InputContent">

									<s:textarea id="editor_id" name="content"
										style="width:650px;height:300px;"></s:textarea>
									<%-- 									<s:textarea name="content" id="content" --%>
									<%-- 										style="width:650px;height:150px;"></s:textarea> --%>
								</div>
							</td>

						</tr>
						<tr height="30">
							<td class="InputAreaBg" colspan="2" align="center">
								<a href="javascript:history.go(-1);"><img
					src="${pageContext.request.contextPath}/style/images/goBack.png" /></a>
							</td>
						</tr>
					</table>
				</div>
			</center>
		</s:form>
	</div>

</body>
</html>
