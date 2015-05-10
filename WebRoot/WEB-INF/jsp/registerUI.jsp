<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>用户注册</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<script language="javascript" src="${pageContext.request.contextPath}/script/register.js" charset="utf-8"></script>

</head>
<body>

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				用户注册
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id=MainArea>

		<s:form action="user_register" onsubmit="return check();">
			<div class="ItemBlock_Title1">
				<!-- 信息说明 -->
				<div class="ItemBlock_Title1">
					<img border="0" width="4" height="7"
						src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
					用户注册
				</div>
			</div>

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table cellpadding="0" cellspacing="0" class="mainForm">

						<tr>
							<td>登录名</td>
							<td><input type="text" name="loginName" id="loginName"
								class="required" /> 
						<tr>
							<td>密码：</td>
							<td><input type="password" name="password" id="password"
								class="required" /> 
						</tr>
						<tr>
							<td>确认密码：</td>
							<td><input type="password" name="repassword" id="repassword"
								class="required" /> 
						</tr>
						<tr>
							<td>姓名</td>
							<td><input type="text" name="name" id="name"
								class="required" /> 
						</tr>
						<tr>
							<td>性别</td>
							<td><s:radio name="gender" list="{'男', '女'}"></s:radio></td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td><input type="text" name="phoneNumber" id="phoneNumber"
								class="required" /></td>
							
						</tr>
						<tr>
							<td>E-mail</td>
							<td><input type="text" name="email" id="email"
								class="required" /></td>
						</tr>
						<tr>
							<td width="100">所属院系</td>
							<td><s:select name="departmentId" cssClass="SelectStyle"
									list="#departmentList" listKey="id" listValue="name"
									headerKey="" headerValue="==请选择部门==" /></td>
						</tr>
						<tr>
							<td>用户类型：</td>
							<td><s:radio id="roleIds" name="roleIds"
									list="#{'3':'学生','2':'教师'}" listKey="key" listValue="value" />
							</td>
						</tr>
					</table>
				</div>
			</div>

			<!-- 表单操作 -->
			<div id="InputDetailBar1">
				<input type="image"
					src="${pageContext.request.contextPath}/style/images/save.png" />
				<a href="javascript:history.go(-1);"><img
					src="${pageContext.request.contextPath}/style/images/goBack.png" /></a>
			</div>
		</s:form>
	</div>
</body>
</html>
