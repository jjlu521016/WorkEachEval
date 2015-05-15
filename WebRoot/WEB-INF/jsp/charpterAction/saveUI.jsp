<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>章节管理</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<script language="javascript"
	src="${pageContext.request.contextPath}/script/charpter.js"
	charset="utf-8"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/forum.css" />
<script charset="utf-8"
	src="${pageContext.request.contextPath }/kindeditor/kindeditor.js"></script>
<script charset="utf-8"
	src="${pageContext.request.contextPath }/kindeditor/lang/zh_CN.js"></script>
<base target="_self" />

 <script>

   </script>
</head>
<!-- <body onload="ChangeMode(document.getElementById('cname').value);"> -->
<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				章节管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id="MainArea">

		<s:form action="charpter_%{cid == null ? 'add' : 'edit'}"
			name="charpter" cssStyle="margin: 0; padding: 0;">

			<s:hidden name="subjectId"></s:hidden>
			<s:hidden name="cid" id="cid"></s:hidden>

			<div id="PageHead"></div>
			<center>
				<div class="ItemBlockBorder">
					<table border="0" cellspacing="1" cellpadding="1" width="100%"
						id="InputArea">
						<tr>
							<td class="InputAreaBg" height="30" width="100px"><div
									class="InputTitle">
									章节名称<font color="red">(*)</font>
								</div></td>
							<td class="InputAreaBg"><div class="InputContent">
									<s:textfield name="cname" id="cname" cssClass="InputStyle"
										cssStyle="width:50%" readonly="readOnly"/>
								</div></td>
						</tr>
						<tr height="240">
							<td class="InputAreaBg"><div class="InputTitle">章节描述</div></td>
							<td class="InputAreaBg">
								<div class="InputContent">
									<s:textarea name="description" id="description"
										style="width:650px;height:200px;"></s:textarea>
								</div>
							</td>

						</tr>
						<tr height="30">
							<td class="InputAreaBg" colspan="2" align="center"><input
								type="image" onclick="return saveTips()"
								src="${pageContext.request.contextPath}/style/blue/images/button/submit.PNG"
								style="margin-right: 15px;" />
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
