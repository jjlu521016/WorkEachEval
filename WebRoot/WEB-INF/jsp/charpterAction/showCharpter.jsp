<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>章节列表</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 章节管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">序号</td>
                <td width="100">章节名称</td>
                <td width="100">所属科目</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
        
        <s:iterator value="#charpterList" id="c" status="stat">
			<tr>
				<td>&nbsp; <s:property value="#stat.index +1" /></td>
				<td>${ cname} &nbsp;</td>
				<td>${s_id} &nbsp;</td>
				<td><a
					href="javascript:del('<s:property value = 'cid'/>','<s:property value = 'cname'/>')">删除</a>
					/ <a id='modify'
					href="${pageContext.request.contextPath}/charpterAction_edit.action?cid=<s:property value = 'cid'/>">修改</a>

				</td>
			</tr>
		</s:iterator> 
            
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a action="charpter_saveUI"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></s:a>
        </div>
    </div>
</div>

<!-- 分页信息 -->
<%-- <%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%> --%>
<s:form action="charpter_list"></s:form>


</body>
</html>
