<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>作业管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript"
	src="${pageContext.request.contextPath}/script/jquery.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/script/pageCommon.js"
	charset="utf-8"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/script/PageUtils.js"
	charset="utf-8"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
<script charset="utf-8" type="text/javascript"
	src="${pageContext.request.contextPath }/My97DatePicker/WdatePicker.js"></script>

</head>


<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images1/title_arrow.gif" />作业管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id=MainArea>

		<s:form action="exam_%{eid == null ? 'add' : 'edit'}">
			<s:hidden name="subjectId"></s:hidden>
			<s:hidden name="eid" id="eid"></s:hidden>


			<div id="PageHead"></div>
			<center>
				<div class="ItemBlockBorder">
					<table border="0" cellspacing="1" cellpadding="1" width="100%"
						id="InputArea">

						<tr>
							<td class="InputAreaBg" height="30" width="100px"><div
									class="InputTitle">
									选择章节<font color="red">(*)</font>
								</div></td>
							<td><s:select name="charpterId" id="charpterId"
									cssClass="SelectStyle" list="#charpterList" listKey="cid"
									listValue="cname" headerKey="-1" headerValue="请选择章节" /></td>

							<td>
						</tr>
						<tr>
							<td>作业名称：<font color="red">(*)</font></td>

							<td class="InputAreaBg"><div class="InputContent">
									<s:textfield name="name" id="name" cssClass="InputStyle"
										cssStyle="width:50%"/>
								</div></td>
						</tr>
						<tr>
							<td>开始时间：<font color="red">(*)</font></td>

							<td class="InputAreaBg"><div class="InputContent">
									<s:textfield name="startTime" id="startTime" class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
								</div></td>
						</tr>
						<tr>
							<td>结束时间：<font color="red">(*)</font></td>

							<td class="InputAreaBg"><div class="InputContent">
									<s:textfield name="stopTime" id="stopTime" class="Wdate"
										onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
								</div></td>
						</tr>




						<tr height="30">
							<td class="InputAreaBg" colspan="2" align="center"><input
								type="image"
								src="${pageContext.request.contextPath}/style/blue/images/button/submit.PNG"
								style="margin-right: 15px;" /> <a
								href="javascript:FormClose();"><img
									src="${pageContext.request.contextPath}/style/blue/images/button/goBack.png" /></a>

							</td>
						</tr>
					</table>

				</div>
			</center>
		</s:form>

	</div>


</body>
</html>
