<%@page
	import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>作业管理</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
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
						
						<td width="100px">结束时间</td>
						<td width="60px">作业状态</td>
						<td>相关操作</td>
					</tr>
				</thead>

				<!--显示数据列表-->
				<tbody id="TableData" class="dataContainer" datakey="paperlist">

					<s:iterator value="recordList" var="e" status="status">
						<s:hidden name="epid" id="epid"></s:hidden>
						<td>${exam.name}&nbsp;</b></td>
						<td>${exam.subject.sname}&nbsp;</b></td>
						<td>${exam.charpter.cname}&nbsp;</td>
						<td>${stopTime}&nbsp;</td>
						<td><s:if test="#e.flg == 1">已完成</s:if> <s:if
								test="#e.flg == 0">未完成</s:if> 
						

						<td>&nbsp;&nbsp; <s:if test="#e.flg != 1">
									
								
								<s:a action="examPaper_doQuestion?paperId=%{epid}">开始本次作业</s:a>
								</s:if> <s:if test="#e.flg == 1">
								<s:a action="examPaper_doQuestion?paperId=%{epid}&bz=1"> <font color="red"> 查看作业</font></s:a>
							</s:if>
						
						</td>

						</tr>
					</s:iterator>

				</tbody>
			</table>

			<!-- 其他功能超链接 -->
			<div id="TableTail">
			<!--分页信息-->
	<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>
	<s:form action="examPaper_list"></s:form>
			</div>
		</div>

	

</body>
</html>
