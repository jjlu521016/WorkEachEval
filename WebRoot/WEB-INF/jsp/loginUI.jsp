<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>作业互评系统</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<link href="${pageContext.request.contextPath}/style/blue/login.css"
	type=text/css rel=stylesheet>
<script type="text/javascript">
	$(function() {
		document.forms[0].loginName.focus();
	});

	// 在被嵌套时就刷新上级窗口
	if (window.parent != window) {
		window.parent.location.reload(true);
	}
</script>

</head>

<body leftmargin=0 topmargin=0 marginwidth=0 marginheight=0
	class=PageBody>
	<!-- 显示表单 -->
	<s:form action="user_login" focusElement="loginNameInput" name="loginForm" id="loginForm">
		<div id="CenterAreaBg">
			<div id="CenterArea">

				<div id="LogoImg">
					<div id="titl">
						<h1 align="left">
							<font color="#FFFFFF"> 欢迎登录作业互评系统</font>
						</h1>
					</div>
					<div>
						<img border="0"
							src="${pageContext.request.contextPath}/style/blue/images/logo.png" />
					</div>

				</div>
				<div id="LoginInfo">
					<table BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
						<tr>
							<td colspan="3">
								<!-- 显示错误 --> <font color="red"><s:fielderror /></font>
							</td>
						</tr>
						<tr>
							<td width=45 class="Subject"><img border="0"
								src="${pageContext.request.contextPath}/style/blue/images/login/userId.gif" /></td>
							<td><s:textfield name="loginName" size="20" tabindex="1"
									cssClass="TextField required" id="loginNameInput" /></td>
							<td rowspan="2" style="padding-left: 10px;"><input
								type="image" tabindex="3"
								src="${pageContext.request.contextPath}/style/blue/images/login/userLogin_button.gif" />
							</td>
							<td rowspan="2" style="padding-left: 10px;">
							 <a href="user_registerUI.action"><img src="${pageContext.request.contextPath}/style/blue/images/login/reg2.png" /></a>	
							  
							  	</td>


						</tr>
						<tr>
							<td class="Subject"><img border="0"
								src="${pageContext.request.contextPath}/style/blue/images/login/password.gif" /></td>
							<td><s:password name="password" id="aa" size="20"
									tabindex="2" showPassword="false" cssClass="TextField required" /></td>

						</tr>
						<tr>
							<td></td>

							<td>
							
<%-- 							<s:a action="user_registerUI"> --%>
							
<%-- 							</s:a> --%>
							</td>
						</tr>
					</table>
				</div>
				<div id="CopyRight" align="right">&copy; 2015 版权所有
					滁州学院计算机与信息工程学院</div>
			</div>
		</div>
	</s:form>
</body>

</html>

