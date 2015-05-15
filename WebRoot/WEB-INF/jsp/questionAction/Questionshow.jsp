<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>${charpter.cname}中的作业问题</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<script language="javascript"
	src="${pageContext.request.contextPath}/script/question.js"
	charset="utf-8"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/forum.css" />
<%
	//接收传入的参数

	String charpterId = "";
	String subjectId="";
	String qid = "";
	charpterId = request.getParameter("cid");
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
					color="red"> 【${charpter.cname}】</font>中的作业问题
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<s:form action="charpter_showQuestionById?cid=%{cid}">
		<div id="MainArea">
			<table cellspacing="0" cellpadding="0" class="TableStyle">

				<!-- 表头-->
				<thead>
					<tr align="CENTER" valign="MIDDLE" id="TableTitle">
						<td>编号</td>
						<td width="250px">问题名称</td>
						<td>题目类型</td>
						<td width="250px">所属课程</td>
						<td width="250px">所属章节</td>
						<td  width="100px">相关操作</td>
					</tr>
				</thead>

				<!--显示数据列表-->
				<tbody id="TableData" class="dataContainer" datakey="questionList">

					<s:iterator value="recordList"  var ="q" status="status">
						<tr class="TableDetail1 template">
							<s:hidden name="qid" id="qid"></s:hidden>
							<td >
							1
							</td>
							<td>${qtext}&nbsp;</td>
							<td>
							 <s:if test="#q.types.tid == 1">选择题</s:if> 
							<s:if test="#q.types.tid == 2">判断题</s:if> 
							<s:if test="#q.types.tid == 3">简答题</s:if>
							<td>${subject.sname }&nbsp; </td>
							<td>${charpter.cname }</td>
							<td><s:a action="question_delete?qid=%{qid}"
								onclick="return delConfirm()">删除</s:a> <s:a
								action="question_editUI?qid=%{qid}">修改</s:a></td></td>
						</tr>
					</s:iterator>

				</tbody>
			</table>

			
		</div>
	</s:form>
<!-- 其他功能超链接 -->
			<div id="TableTail">
				<div id="TableTail_inside">
					<s:a action="question_addUI?subjectId=%{#charpter.subject.sid}&charpterId=%{#charpter.cid}">
						<img
							src="${pageContext.request.contextPath}/style/images/createNew.png" style="visibility: visible;" />
					</s:a>&nbsp;
				</div>
			</div>
	<!--分页信息-->
	<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>
	<s:form action="charpter_showQuestionById?cid=%{#charpter.cid}&sid=%{#subject.sid}"></s:form>


</body>
</html>
