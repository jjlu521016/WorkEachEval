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
            	<td >考试学生</td>
                <td >所属考试</td>
                <td >批改状态</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="tasklist" >
        
        <s:iterator value="#tasklist" var="t">
        <s:hidden name ="tid"></s:hidden>
			<tr class="TableDetail1 template">
				<td>${student.name}&nbsp;</td>
				<td>${examPaper.exam.name}&nbsp;</td>
				<td>
				<font color="red">已批改</font>	
				</td>
			</tr>
        </s:iterator>

        </tbody>
    </table>
    
			<div id="TableTail">
			</div>
</div>
</body>
</html>
