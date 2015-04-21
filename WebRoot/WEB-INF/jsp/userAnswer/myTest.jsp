<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${charpter.cname}中的章节列表</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<script language="javascript"
	src="${pageContext.request.contextPath}/script/question.js"
	charset="utf-8"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/forum.css" />
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
					color="red"> 【${exercise}】</font>中的作业问题
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<s:form action="charpter_showQuestionById?cid=%{cid}">
		<div id="MainArea">
			<table cellspacing="0" cellpadding="0" class="TableStyle">
				<!--显示数据列表-->
				<tbody id="TableData" class="dataContainer" datakey="questionList">

					<s:iterator value="#questionList" var="q" status="status" id="List">
						<s:hidden name="qid" id="qid"></s:hidden>
						<tr class="TableDetail1 template">

							<td>第${status.count}题：${List.qtext}-->${List.answerses.size()}</td>
							
							<s:iterator value="#List.answerses" var="a" id="a">
                                   <tr>
                                       <td>qqq
                                       ${a.answer}
                                       <s:property value="#a.answer"/></td>
                                   </tr>
                               </s:iterator>

<%-- 							<s:iterator value="#List.answerses" id="a"> --%>
<!-- 									66666 -->
<%--  									${a.answerses.answer } --%> 
<%-- 									<s:property value="#a.answer" /> --%>
<%-- 							</s:iterator> --%>
						</tr>
					</s:iterator>

				</tbody>
			</table>


		</div>
	</s:form>
	<!-- 其他功能超链接 -->
	<div id="TableTail"></div>
	<!--分页信息-->
	<%-- <%@ include file="/WEB-INF/jsp/public/pageView.jspf" %> --%>


</body>
</html>
