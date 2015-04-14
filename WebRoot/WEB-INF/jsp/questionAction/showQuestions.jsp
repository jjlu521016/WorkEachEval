<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>
<head>
    <title>试题浏览</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
	<script type = "text/javascript" src = "${pageContext.request.contextPath}/script/showQuestions.js"></script>
<body> 

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images1/title_arrow.gif"/>试题浏览
        </div>
        <div id="Title_End"></div>
    </div>
</div>


<div id="MainArea">
  <div id = 'div1' >
 
<table cellspacing="0" cellpadding="0" class="TableStyle"  border="1" >
	<thead>
		<tr align="CENTER" valign="MIDDLE" id="TableTitle" >
<!-- 			<th>序号</th> -->
			<th>题型</th>
			<th>题目内容</th>
			<th>知识点</th>
			<th>章 节</th>
			<th>科 目</th>
		 	<th width="80px" nowrap>操 作</th>  
		</tr>
	</thead>
	<tbody id="TableData" class="dataContainer" datakey="formList">
	<s:iterator value="#request.pageResultSet.list" id='q' status="stat">
		<tr class="TableDetail1 template">
<%-- 			<td><s:property --%>
<%-- 				value="(#request.pageResultSet.pageInfo.currentPage-1)*10+#stat.index +1" /></td> --%>
				<td>
			<s:if test="#q.tid == 1">选择题</s:if>
			<s:if test="#q.tid == 2">判断题</s:if>
			<s:if test="#q.tid == 3">简答题</s:if>
			</td>
			<td><s:property value="#q.qtext" escape="false" /></td>
			<td><s:property value="#q.kname" /></td>
			<td><s:property value="#q.cname" /></td>
			<td><s:property value="#q.sname" /></td>
	        <td><a href="#?id=<s:property value="#q.qid" />">修改</a>&nbsp;
	        <a  href="${pageContext.request.contextPath}/questionsAction_deleteQuestion.action?id=<s:property value="#q.qid" />">删除</a></td>
	       </tr> 
	</s:iterator>
</tbody>
</table>
<br/>
	</div>
		<br/>
		<br/>
</div>
</body>
</html>
