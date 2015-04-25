<%@page
	import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>作业管理</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/forum.css" />
<%
	String subjectId = "";
	String charpterId = "";
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
					color="red"> 作业管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

		<div id="MainArea">
			<table cellspacing="0" cellpadding="0" class="TableStyle">

				<!-- 表头-->
				<thead>
					<tr align="CENTER" valign="MIDDLE" id="TableTitle">

						<td width="280px">作业名称</td>

						<td width="150px">所属课程</td>
						<td width="150px">所属章节</td>
						<td width="60px">作业状态</td>
						<td width="100px">开始时间</td>
						<td width="100px">结束时间</td>
						<td width="100px">发布人</td>
						<td>相关操作</td>
					</tr>
				</thead>

				<!--显示数据列表-->
				<tbody id="TableData" class="dataContainer" datakey="examList">

					<s:iterator value="#examList" var="e" status="status">
						<s:hidden name="qid" id="qid"></s:hidden>
						<td>${name}&nbsp;</b></td>
						<td>${subject.sname}&nbsp;</b></td>
						<td>${charpter.cname}&nbsp;</td>
						<td>${startTime}&nbsp;</b></td>
						<td>${stopTime}&nbsp;</td>
						<td><s:if test="#e.flg == 1">已发布</s:if> <s:if
								test="#e.flg == 0">未发布</s:if> <%-- 						<td>${statu}&nbsp;</td> --%>
						<td>${author.name}&nbsp;</b></td>
						

						<td>&nbsp;&nbsp; <s:if test="#e.flg != 1">
								<s:a
									action="exam_delete?eid=%{eid}&subjectId=%{#subject.sid}"
									onclick="return delConfirm('你要删除这条数据吗？')">删除</s:a>&nbsp;&nbsp; <s:a
									action="exam_editUI?eid=%{eid}&subjectId=%{#subject.sid}">修改</s:a> &nbsp;&nbsp;
								
								
								<s:a action="exam_publish?eid=%{eid}&subjectId=%{#subject.sid}"
								 onclick="return  publishConfirm('确定要发布本次作业吗？发布之后不能更改！')">发布本作业</s:a>
								</s:if> <s:if test="#e.flg == 1">
								<font color="red"> 已发布</font>
							</s:if>
						
						</td>

						</tr>
					</s:iterator>

				</tbody>
			</table>

			<!-- 其他功能超链接 -->
			<div id="TableTail">
				<div id="TableTail_inside">
					<s:a action="exam_addUI?subjectId=%{#subject.sid}">
						<img
							src="${pageContext.request.contextPath}/style/images/createNew.png" />

					</s:a>
				</div>
			</div>
		</div>

	<!--分页信息-->
	<%-- <%@ include file="/WEB-INF/jsp/public/pageView.jspf" %> --%>

</body>
</html>
