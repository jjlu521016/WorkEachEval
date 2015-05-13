<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>用户列表</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 成绩管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
	<div id="TableTail" align="right">
       	 <a href="score_querylistUI.action"><input type="button" value="查询" id="searchBtn" ></button></a>
    </div>      	
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">考试名称</td>
            	<td width="100px">学生姓名</td>
                <td width="100px">主观题得分</td>
                <td width="100px">客观题得分</td>
                <td width="100px">总得分</td>
                <td width="100px">批改人</td>
                <td width="100px">试卷总分</td>
                <td width="100px">是否及格</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="scoreList">
       
        <s:iterator value="recordList">
			<tr class="TableDetail1 template">
				<td>${paper.exam.name}&nbsp;</td>
				<td>${student.name}&nbsp;</td>
				<td>${autoscore}&nbsp;</td>
				<td>${manualscore}&nbsp;</td>
				<td>${totalscore}&nbsp;</td>
				<td>${tasker.name}&nbsp;</td>	
				<td>${paperscore}&nbsp;</td>
				<td>
				<s:if test="#rate< 0.6">
				<font color="red">不及格</font>
				</s:if>
				<s:else>
				及格
				</s:else>
				</td>
			</tr>
        </s:iterator>

        </tbody>
    </table>
    
        <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
        </div>
    </div>
</div>
<!-- 分页信息 -->
<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%> 
<s:form action="score_list"></s:form>
</body>
</html>
