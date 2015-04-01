<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>作业互评系统</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.cookie.js"></script>
</head>

<frameset rows="*,25" framespacing=0 border=0 frameborder="0">
	<frameset cols="300,*" id="resize">
		<frame noresize name="course" scrolling="yes"
			src="${pageContext.request.contextPath}/knowledgeAnalyManage_list.action">
		<frame noresize name="course_detail" scrolling="yes" src="">
	</frameset>
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html>
