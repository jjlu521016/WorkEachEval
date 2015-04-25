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
function check() {
	alert("aaaaaaa");
	return false;
}
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
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" /><font>
					作业管理 
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
	<s:form action="anweruser_add">
	<div align="center" id="MainArea"><font color="black" size="6px">以下是本次的作业，请同学们认真作答。</font></div>
	
	<div id="MainArea">
		<table cellspacing="0" cellpadding="0" class="TableStyle">
					
			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer" datakey="recordList">
				
				<s:iterator value="#recordList" var="q" status="status">
					<s:hidden name="sqrId" id="sqrId"></s:hidden>
					<s:hidden name="#q.question.qid" id="qid"></s:hidden>
					<!-- 根据题目的类型判断属于什么题型 -->
					<s:if test="#q.question.types.tid==1">
						<font size="4px" color="red">(选择题${q.question.qscore }分)</font>
					</s:if>
					<s:elseif test="#q.question.types.tid==2">
						<font size="4px" color="red">(判断题${q.question.qscore }分)</font>
					</s:elseif>
					<s:elseif test="#q.question.types.tid==3">
						<font size="4px" color="red">(问答题${q.question.qscore }分)</font>
					</s:elseif>


					<font size="4px">第${status.index+1}题：${question.qtext}</font> 
					</br>
					</br>
					
						<s:if test="#q.question.types.tid==1">
<%-- 							<s:checkbox name="chkanswer" /> ${a.answer} --%>
				
					<s:checkboxlist name="useranswer" list="#q.question.answerses" listKey="aid" listValue="answer"	/>
					</s:if>
					
					<s:iterator value="#q.question.answerses" var="a">
						<s:elseif test="#q.question.types.tid==2">
							<s:radio list="#{'1':'正确','0':'错误'}" name="useranswer" />
						</s:elseif>
						<s:elseif test="#q.question.types.tid==3">
							<s:textarea id="editor_id" name="useranswer"
								style="width:650px;height:300px;"></s:textarea>
						</s:elseif>

					</s:iterator>
					<hr>
				</s:iterator>

			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
			
			<s:submit value="提交作业"  onclick="check()"></s:submit>
<%-- 				<s:a action="exam_addUI?subjectId=%{#subject.sid}"> --%>
					 

<%-- 				</s:a> --%>
			</div>
		</div>
	
	</div>
</s:form>
	<!--分页信息-->
	<%-- <%@ include file="/WEB-INF/jsp/public/pageView.jspf" %> --%>

</body>
</html>
