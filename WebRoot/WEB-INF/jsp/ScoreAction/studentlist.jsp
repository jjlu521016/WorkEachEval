<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>用户列表</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				成绩管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td width="100px">学生姓名</td>
					<td width="200px">考试名称</td>
					<td width="100px">批改人</td>
					<td width="100px">主观题得分</td>
					<td width="100px">客观题得分</td>
					<td width="100px">总得分</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer" datakey="scoreList">

				<s:iterator value="recordList">
					<tr class="TableDetail1 template">
						<td>${student.name}&nbsp;</td>
						<td>${paper.exam.name}&nbsp;</td>
						<td>${tasker.name}&nbsp;</td>
						<td>${autoscore}&nbsp;</td>
						<td>${manualscore}&nbsp;</td>
						<td>${totalscore}&nbsp;</td>
					</tr>
				</s:iterator>

			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<!-- 分页信息 -->
				<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
				<s:form action="score_studentlist"></s:form>
			</div>
		</div>
	</div>

</body>
</html>
