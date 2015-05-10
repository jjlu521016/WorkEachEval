<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>试题增加</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript"
	src="${pageContext.request.contextPath}/script/jquery.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/script/pageCommon.js"
	charset="utf-8"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/script/question.js"
	charset="utf-8"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/script/PageUtils.js"
	charset="utf-8"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
<script charset="utf-8"
	src="${pageContext.request.contextPath }/kindeditor/kindeditor.js"></script>
<script charset="utf-8"
	src="${pageContext.request.contextPath }/kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript">
 　　 var editor;
  var qtextFiled;
  var qtextarea;
　　KindEditor.ready(function(K) {
  　　editor = K.create('#description');
  qtextFiled = K.create('#qdescription');
  qtextarea = K.create('#qtextarea');
  
});
var options = {
cssPath :'<%=request.getContextPath()%>/kindeditor/themes/qq/qq.css',
filterMode : true,    
uploadJson :'<%=request.getContextPath()%>/WEB-INF/jsp/upload_json.jsp',
fileManagerJson : '<%=request.getContextPath()%>/WEB-INF/jsp/file_manager_json.jsp',
allowFileManager : true
};

var editor = K.create('textarea[name="description"]', options);
var qtextFiled = K.create('textarea[name="qtext"]', options);

var qtextarea = K.create('textarea[name="ptAnswer"]', options);
    </script>
</head>
<script>


</script>

<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images1/title_arrow.gif" />添加试题
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id=MainArea>

		<s:form action="question_%{qid == null ? 'add' : 'edit'}"
			name="charpter" cssStyle="margin: 0; padding: 0;"
			onsubmit="return checkOnSubmit() ">

			<s:hidden name="subjectId"></s:hidden>
			<s:hidden name="charpterId"></s:hidden>
			<s:hidden name="qid" id="qid"></s:hidden>
			<s:hidden name="exerciseId" ></s:hidden>

			<div id="PageHead"></div>
			<center>
				<div class="ItemBlockBorder">
					<table border="0" cellspacing="1" cellpadding="1" width="100%"
						id="InputArea">

						<tr>
							<td class="InputAreaBg" height="30" width="100px"><div
									class="InputTitle">
									问题类型<font color="red">(*)</font>
								</div></td>
							<td><s:select name="typeId" id="typeId"
									cssClass="SelectStyle" list="#typeList" listKey="tid"
									listValue="tname" headerKey="-1" headerValue="请选择题目类型"
									onchange="return showDiv()" /></td>

							<td>
						</tr>


						<tr>
							<td class="InputAreaBg" height="30" width="100px"><div
									class="InputTitle">
									问题描述<font color="red">(*)</font>
								</div></td>



							<td class="InputAreaBg"><div class="InputContent">
									<s:textfield name="qtext" id="qdescription" cssClass="InputStyle"
										cssStyle="width:80%" />
								</div></td>
						</tr>


						<tr>
							<td>答案内容:</td>
							<td>
								<table>
									<tr>
										<td>
											<div id="myDiv">
												<div id="selectDiv" style="display: none">
													<div id="selectSpan">
													选项A:<s:textfield name="questions.answerses[0].answer"/>
														 <s:hidden name="questions.answerses[0].mark" value="A"></s:hidden>
														 <s:checkbox name="questions.answerses[0].isRight"/>
														 
														<br />
														选项B:<s:textfield name="questions.answerses[1].answer"/>
														 <s:hidden name="questions.answerses[1].mark" value="B"></s:hidden>
														 <s:checkbox name="questions.answerses[1].isRight"/>
														 
														<br />
														选项C:<s:textfield name="questions.answerses[2].answer"/>
														 <s:hidden name="questions.answerses[2].mark" value="C"></s:hidden>
														 <s:checkbox name="questions.answerses[2].isRight"/>
														 
														<br />
														选项D:<s:textfield name="questions.answerses[3].answer"/>
														 <s:hidden name="questions.answerses[3].mark" value="D"></s:hidden>
														 <s:checkbox name="questions.answerses[3].isRight"/>
														 
														<br />
														
														
													</div>
													<div style="color: rgb(255, 0, 0);">是正确答案请勾选</div>
<!-- 													<div id="buttonSpan"> -->
<!-- 														<input type="button" id="newAnswer" name="but" -->
<!-- 															class="InputStyle" value="增加答案" /> -->
<!-- 													</div> -->
												</div>
												<div id='judgeDiv' style="display: none">
													<div id="judgeSpan">
														对<input type="radio" name="judgeAnswer" value='1' checked>
														<br />错<input type="radio" name="judgeAnswer" value='0'></input>

													</div>
												</div>

												<div id="notSelectDiv" style="display: none">
													<span id="notSelectSpan"> 
													
													<s:textfield name="ptAnswer" id="qtextarea" cssClass="InputStyle"
										cssStyle="width:90%" readonly="readOnly" />
													

												</div>
												<div>
												本题分值：<s:textfield name="qscore"></s:textfield>
												</div>
											</div>


										</td>
									</tr>

								</table>

							</td>
						</tr>

						<tr height="30">
							<td class="InputAreaBg" colspan="2" align="center"><input
								type="image" 
								src="${pageContext.request.contextPath}/style/blue/images/button/submit.PNG"
								style="margin-right: 15px;" /> <a
								href="javascript:FormClose();"><img
									src="${pageContext.request.contextPath}/style/blue/images/button/goBack.png" /></a>

							</td>
						</tr>
					</table>

				</div>
			</center>
		</s:form>

	</div>





</body>
</html>
