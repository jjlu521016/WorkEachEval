<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>${subject.sname}中的章节列表</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<script language="javascript" src="${pageContext.request.contextPath}/script/charpter.js" charset="utf-8"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/forum.css" />
	<%
 	String subjectId = "11";
     subjectId = request.getParameter("sid");
	%>
<script type="text/javascript">
 
</script>
</head>
<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" /><font
					color="red"> 【${subject.sname}】</font>中的章节列表
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<s:form action="charpter_show?sid=%{sid}">
		<div id="MainArea">
			<table cellspacing="0" cellpadding="0" class="TableStyle">

				<!-- 表头-->
				<thead>
					<tr align="CENTER" valign="MIDDLE" id="TableTitle">
						<td width="250px">章节名称</td>
						<td width="250px">章节说明</td>
						<td>相关操作</td>
					</tr>
				</thead>

				<!--显示数据列表-->
				<tbody id="TableData" class="dataContainer" datakey="charpterList">

					<s:iterator value="#charpterList" status="status">
						<tr class="TableDetail1 template">
							<td>
							<s:a cssClass="ForumPageTopic" action="charpter_showCharpterById?cid=%{cid}">${cname}&nbsp;</s:a></b></td>
							<td>${description}&nbsp;</td>
							<td><s:a action="charpter_delete?cid=%{cid}&subjectId=%{#subject.sid}"
									onclick="return delConfirm('你要删除这条数据吗？')">删除</s:a> <s:a
									action="charpter_editUI?cid=%{cid}&subjectId=%{#subject.sid}">修改</s:a></td>
						</tr>
					</s:iterator>

				</tbody>
			</table>

			<!-- 其他功能超链接 -->
			<div id="TableTail">
				<div id="TableTail_inside">
<%-- 					<s:a action="charpter_addUI?subjectId=%{#subject.sid}"> --%>
						<img onclick="return editWindows('<%=subjectId %>')"
							src="${pageContext.request.contextPath}/style/images/createNew.png" />
<%-- 					</s:a> --%>
				</div>
			</div>
		</div>
	</s:form>

	<!--分页信息-->
	<%-- <%@ include file="/WEB-INF/jsp/public/pageView.jspf" %> --%>


</body>
</html>
