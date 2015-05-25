<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>任务列表</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 任务列表
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td >学生</td>
                <td >作业名称</td>
                <td >互评人1</td>
                <td >互评人2</td>
                <td >互评人3</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="tasklist" >
        
        <s:iterator value="recordList" var="t">
			<tr class="TableDetail1 template">
				<td>${student.name}&nbsp;</td>
				<td>${examPaper.exam.name}&nbsp;</td>
				<td>${Tasker1.name }</td>
				<td>${Tasker2.name }</td>
				<td>${Tasker3.name }</td>
			</tr>
        </s:iterator>

        </tbody>
    </table>
    
			<div id="TableTail">
			</div>
</div>

<!-- 分页信息 -->
<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%> 
<s:form action="task_show"></s:form>
</body>
</html>
