
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
   <%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
<title>作业管理</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/forum.css" />
<script charset="utf-8"	
	src="${pageContext.request.contextPath }/kindeditor/kindeditor.js"></script>
	<script charset="utf-8"
	src="${pageContext.request.contextPath }/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//给上一题的按钮添加事件
// 		$("input[type=button]").click(function() {
// 			//点击上一题后，将上一题强制转换成
// 			$("form").attr("action", "examPaper_preQuestion.action").submit();
// 		})
		$("#pre").click(function() {
			//点击上一题后，将上一题强制转换成
			$("form").attr("action", "examPaper_preQuestion.action").submit();
		})
		
		$("#uppaper").click(function() {
			//点击提交后，将submit换去
			$("form").attr("action", "examPaper_submitPaper.action").submit();
		})
	});
	</script>	
	
	<script type="text/javascript">
 　　 var editor;
  	  var editor2;
  　　KindEditor.ready(function(K) {
          　　editor = K.create('#editor_id',{
        	  items : []

          　　}); 
         editor2 = K.create('#editor2',{
        	  items : [],
        	  readonlyMode : true

          　　}); 
  　　});
  　　var options = {
 	cssPath :'<%=request.getContextPath()%>/kindeditor/themes/qq/qq.css',
  　　 filterMode : true,    
     uploadJson :'<%=request.getContextPath()%>/WEB-INF/jsp/upload_json.jsp',
     fileManagerJson : '<%=request.getContextPath()%>/WEB-INF/jsp/file_manager_json.jsp',
     allowFileManager : true
　	};
var editor = K.create('textarea[name="answers[0].answer"]', options);
var editor = K.create('textarea[name="q.answers[0].answer"]', options);
</script>

</head>
<body>
	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
			 <img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" /><font>
					作业管理 
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="showquestion">
		<h1></h1>
		<font color="black">第${index+1}题：${q.qtext}</font>
		<hr>
		<s:form action="examPaper_nextQuestion">
			<!-- 隐藏字段用于维护数据 -->
			<s:hidden name="index" />
			<s:hidden name="paperId" />
			<s:hidden name="bz"></s:hidden>

			<s:if test="#q.types.tid==1">
				<font size="4px" color="red">(选择题${q.qscore }分)</font>
				<hr>
				A:${q.answerses[0].answer }</br>
				B:${q.answerses[1].answer} </br>
				C:${q.answerses[2].answer} </br>
				D:${q.answerses[3].answer} </br>
				
				<s:if test="#bz==1">
					<hr>
					正确答案是：
					<s:iterator value="#q.answerses" var="a">
					<s:if test="#a.isRight"><font color="red">${a.mark}:${a.answer} </font></s:if> 
					</s:iterator>
				</s:if>

			</s:if>
			<s:elseif test="#q.types.tid==2">
				<font size="4px" color="red">(判断题${q.qscore }分)</font>
				</br>
				
				<s:if test="#bz==1">
						<hr>
						正确答案是：
						<s:iterator value="#q.answerses" var="a">
						<s:if test="#a.isRight==1"><font color="red">
						 <s:if test="#a.answer==0">错误</s:if>
						  <s:if test="#a.answer==1">正确</s:if> </font></s:if> 
						</s:iterator>
				</s:if>
			</s:elseif>
			<s:elseif test="#q.types.tid==3">
				<font size="4px" color="red">(问答题${q.qscore }分)</font>
				</br>
				<s:if test="#bz==1">
				<hr>
				参考答案：</br>
			<s:textarea id="editor2" name="#q.answerses[0].answer"
				style="width:70%;height:140px;"></s:textarea>
			<s:hidden name="answers[0].aid" />
			</s:if>
			</s:elseif>
			<hr>
			你的答案是：
		<s:if test="#q.types.tid==1">
			<s:checkbox name="answers[0].isRight" />
				<s:hidden name="answers[0].mark" value="A" />
				<s:hidden name="answers[0].aid" />
				A
				<s:checkbox name="answers[1].isRight" />
				<s:hidden name="answers[1].mark" value="B" />
				<s:hidden name="answers[1].aid" />
				B
			<s:checkbox name="answers[2].isRight" />
				<s:hidden name="answers[2].mark" value="C" />
				<s:hidden name="answers[2].aid" />
				C
			<s:checkbox name="answers[3].isRight" />
				<s:hidden name="answers[3].mark" value="D" />
				<s:hidden name="answers[3].aid" />
				D
			</br>

			</s:if>
			<s:elseif test="#q.types.tid==2">
				</br>
				<s:radio list="#{'1':'正确','0':'错误'}" name="answers[0].isRight" />
				<s:hidden name="answers[0].aid" />
				
			</s:elseif>
			<s:elseif test="#q.types.tid==3">
				</br>
				<s:textarea id="editor_id" name="answers[0].answer"
					style="width:70%;height:140px;"></s:textarea>
					<s:hidden name="answers[0].aid" />
			</s:elseif>
			<hr>
			<input type="button" value="上一题" id="pre"/>
			<input type="submit" value="下一题" />
			
			<s:if test="#bz!=1">
			<input type="button" value="交卷" id="uppaper"/>
			</s:if>
			
		</s:form>
	</div>
	<s:if test="#bz==1">
	<s:if test="#q.types.tid==3">
		</br></br>
	<!-- 显示批改信息 -->
		<div id="MainArea">
		<h4>本题批改信息</h4>
				<table cellspacing="0" cellpadding="0" class="TableStyle">
					<!-- 表头-->
					<thead>
						<tr align="CENTER" valign="MIDDLE" id="TableTitle">
							<td >本题得分</td>
							<td >本题评语</td>
						</tr>
					</thead>
					<!--显示数据列表-->
					<tbody id="TableData" class="dataContainer" datakey="questionList">
						<s:iterator value="questionList" var="e" status="status">
						<td class="ForumPageTableDataLine"><b>${e.score}</b></td>
						<td class="ForumPageTableDataLine"><b>${e.opinion}</b></td>
						</s:iterator>
					</tbody>
				</table>
			</div>
</s:if>
</s:if>
</body>
</html>
