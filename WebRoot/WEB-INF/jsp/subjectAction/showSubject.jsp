<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>课程列表</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<style type="text/css">
.disabled {
	color: gray;
	cursor: pointer;
}
</style>
</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				课程管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td width="250px">课程编号</td>
					<td width="250px">课程名称</td>
					<td width="300px">说明</td>
					<td>相关操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer" datakey="subjectList">

				<s:iterator value="recordList" status="status">
					<tr class="TableDetail1 template">
						<td>${subject_code}&nbsp;</td>
						<td>${sname}&nbsp;</td>
						<td>${description}&nbsp;</td>
						<td><s:a action="subject_delete?sid=%{sid}"
								onclick="return delConfirm()">删除</s:a> <s:a
								action="subject_editUI?sid=%{sid}">修改</s:a></td>
					</tr>
				</s:iterator>

			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<s:a action="subject_addUI">
					<img
						src="${pageContext.request.contextPath}/style/images/createNew.png" />
				</s:a>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
<s:form action="subject_list"></s:form>
</body>
</html>
