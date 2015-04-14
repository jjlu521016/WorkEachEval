<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
	<title>知识点管理</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/forum.css" />
</head>
<body>
<div id="Title_bar">
	<div id="Title_bar_Head">
		<div id="Title_Head"></div>
		<div id="Title">
			<!--页面标题-->
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 课程列表 </div>
		<div id="Title_End"></div>
	</div>
</div>
<div id="MainArea">
	<center>
		<div class="ForumPageTableBorder" style="margin-top: 25px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			
				<!--表头-->
				<tr align="center" valign="middle">
					<td width="80" class="ForumPageTableTitleLeft"></td>
					<td width="80" class="ForumPageTableTitleLeft">课程编号</td>
					<td width="80" class="ForumPageTableTitle">课程名称</td>
					<td width="80" class="ForumPageTableTitle">任课教师</td>
					<td  class="ForumPageTableTitle">课程介绍</td>
					
					
				</tr>
				<tr height="1" class="ForumPageTableTitleLine"><td colspan="9"></td></tr>
				<tr height="3"><td colspan="9"></td></tr>
			
				<!--课程列表-->
				<tbody class="dataContainer" datakey="subjectlist">
				
				<s:iterator value="#subjectlist">
					<tr height="78" align="center" class="template">

						<td width="75" class="ForumPageTableDataLine">
							<img src="${pageContext.request.contextPath}/style/images/forumpage3.gif" />
						</td>
						<td class="ForumPageTableDataLine"><b>${subject_code}</b>
						
<!-- 						class="ForumPageTableDataLine"> -->
<!-- 							<ul class="ForumPageTopicUl"> -->
<%-- 								<li class="ForumPageTopic"><s:a cssClass="ForumPageTopic" action="forum_show?id=%{id}">${subject_code}</s:a></li> --%>
<!-- 							</ul> -->
						</td>
						<td class="ForumPageTableDataLine"><b>
						<s:a cssClass="ForumPageTopic" action="subject_showsubjectById?sid=%{sid}">${sname}&nbsp;&nbsp;</s:a></b></td>
						<td class="ForumPageTableDataLine"><b>${author.name}</b></td>
						<td class="ForumPageTableDataLine"><b>${description}</b></td>
		
						<td width="3"></td>
					</tr>
				</s:iterator>	
					
				</tbody>
				<!-- 版面列表结束 -->
				
				<tr height="3"><td colspan="9"></td></tr>
			</table>
		</div>
	</center>
</div>
</body>
</html>
