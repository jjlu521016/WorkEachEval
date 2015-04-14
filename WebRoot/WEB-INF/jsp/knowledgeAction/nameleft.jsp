<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>${charpter.cname}中的章节列表</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<script language="javascript"
	src="${pageContext.request.contextPath}/script/knowledge.js"
	charset="utf-8"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/forum.css" />
<%
	//接收传入的参数

	String charpterId = "";
	String kid = "";
	charpterId = request.getParameter("cid");
%>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" /><font
					color="red"> 【${charpter.cname}】</font>中的知识点列表
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<s:form action="charpter_show?cid=%{cid}">
		<div id="MainArea">
			<table cellspacing="0" cellpadding="0" class="TableStyle">

				表头
				<thead>
					<tr align="CENTER" valign="MIDDLE" id="TableTitle">
						<td width="250px">知识点名称</td>
						<td width="250px">知识点说明</td>
						<td>相关操作</td>
					</tr>
				</thead>

<!-- 				显示数据列表 -->
				<tbody id="TableData" class="dataContainer" datakey="knowledgeList">

					<s:iterator value="#knowledgeList" status="status">
						<tr class="TableDetail1 template">
							<s:hidden name="kid" id="kid"></s:hidden>
							<%
								kid = request.getAttribute("kid").toString();// request.getParameter("cid");//(String)pageContext.getAttribute("cid");
										//out.println(kid);
							%>
							<td>${title}&nbsp;</td>
							<td>${content}&nbsp;</td>
							<td><s:a
									action="knowledge_delete?kid=%{kid}&charoterId=%{#charpter.sid}"> 
									<img onclick="return delConfirm('你要删除这条数据吗？')"
										src="${pageContext.request.contextPath}/style/images/delete.png" /> 
								</s:a> <s:a> 
 									<img 
 										onclick="return editWindows('<%=charpterId %>','<%=kid %>')" 
 										src="${pageContext.request.contextPath}/style/images/edit.png" /> 
								</s:a></td> 
						</tr>
					</s:iterator> 

 				</tbody>
 			</table>

<!-- 			其他功能超链接 -->
 			<div id="TableTail"> 
				<div id="TableTail_inside"> 
 					<s:a>
						<img onclick="return editWindows('<%=charpterId %>',-1)"
							src="${pageContext.request.contextPath}/style/images/createNew.png" />
					</s:a>
				</div>
			</div>
		</div>
	</s:form>

	<!--分页信息 -->
	<%-- <%@ include file="/WEB-INF/jsp/public/pageView.jspf" %> --%>


</body>
</html>
