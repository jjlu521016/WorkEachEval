<%@page
	import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<script charset="utf-8"
	src="${pageContext.request.contextPath }/script/task.js"></script>
<script type="text/javascript">
 　　 var editor;
  	  var editor2; 
  　　KindEditor.ready(function(K) {
          　　editor = K.create('#editor1',{
        	  items : [],
        	  readonlyMode : true

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
  editor.readonly(true); 
var editor = K.create('textarea[name="answers[0].answer"]', options);
var editor = K.create('textarea[name="q.answers[0].answer"]', options);
</script>
<style type="text/css">
textarea {
	resize: none;
}
</style>
</head>
<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" /><font>
					批改作业 
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="showquestion">
		<h1></h1>
		第${index+1}题：${q.qtext}<font size="4px" color="red">(简答题${q.qscore }分)</font>
		<hr>
		<form action="task_nextQuestion.action">
			<!-- 隐藏字段用于维护数据 -->
			<s:hidden name="index" />
			<s:hidden name="paperId" />
			<s:hidden name="taskId"/>
			学生答案：
			<s:textarea id="editor1" name="#answer[0].answer"
				style="width:70%;height:140px;"></s:textarea>
			<s:hidden name="answer[0].aid" />


			<font color="red">参考答案：</font>
			<s:textarea id="editor2" name="#q.answerses[0].answer"
				style="width:70%;height:140px;"></s:textarea>
			<s:hidden name="answers[0].aid" />

			<hr>
			本题得分：
			<s:textfield name="manualscore"></s:textfield>

			</br> </br>
<!-- 			批改意见： -->
<%-- 			<s:textarea name="opinion" style="width:60%;height:100px;"></s:textarea> --%>
			<hr>
			<input type="button" value="上一题" id="pre" /> <input type="submit"
				value="下一题" /> <input type="button" value="完成" id="uppaper" />
		</form>
	</div>

</body>
</html>
