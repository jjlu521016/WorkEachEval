<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>查看主题：${topic.title}</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/forum.css" />

<script charset="utf-8"
	src="${pageContext.request.contextPath }/kindeditor/kindeditor.js"></script>
<script charset="utf-8"
	src="${pageContext.request.contextPath }/kindeditor/lang/zh_CN.js"></script>
<script>
        　　 var editor;
         　　KindEditor.ready(function(K) {
                 　　editor = K.create('#editor_id');
         　　});
         　　var options = {
          　　cssPath : '/kindeditor/themes/qq/qq.css',
         　　 filterMode : true
    　　　　};
   　　　　var editor = K.create('textarea[name="content"]', options);
   
 　　　 </script>
</head>
<body >

	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				查看主题
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--内容显示-->
	<div id="MainArea">
		<div id="PageHead"></div>
		<center>
			<div class="ItemBlock_Title1" style="width: 98%">
				<font class="MenuPoint"> &gt; </font>
				<s:a action="forum_list">论坛</s:a>
				<font class="MenuPoint"> &gt; </font>
				<s:a action="forum_show?id=%{#topic.forum.id}">${topic.forum.name}</s:a>
				<font class="MenuPoint"> &gt;&gt; </font> 帖子阅读 <span
					style="margin-left: 30px;"> <s:a
						action="topic_addUI?forumId=%{#topic.forum.id}">
						<img align="absmiddle"
							src="${pageContext.request.contextPath}/style/blue/images/button/publishNewTopic.png" />
					</s:a>
				</span>
			</div>

			<div class="ForumPageTableBorder dataContainer" datakey="replyList">

				<!--显示主题标题等-->
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr valign="bottom">
						<td width="3" class="ForumPageTableTitleLeft">&nbsp;</td>
						<td class="ForumPageTableTitle"><b>本帖主题：${topic.title}</b></td>
						<td class="ForumPageTableTitle" align="right"
							style="padding-right: 12px;"><s:a cssClass="detail"
								action="reply_addUI?topicId=%{#topic.id}">
								<img border="0"
									src="${pageContext.request.contextPath}/style/images/reply.gif" />
							回复
						</s:a>
						</td>
						<td width="3" class="ForumPageTableTitleRight">&nbsp;</td>
					</tr>
					<tr height="1" class="ForumPageTableTitleLine">
						<td colspan="4"></td>
					</tr>
				</table>

				<!-- ~~~~~~~~~~~~~~~ 显示主帖（主帖只在第1页显示） ~~~~~~~~~~~~~~~ -->
				<%-- 			<s:if test="currentPage == 1"> --%>
				<div class="ListArea">
					<table border="0" cellpadding="0" cellspacing="1" width="100%">
						<tr>
							<td rowspan="3" width="130" class="PhotoArea" align="center"
								valign="top">
								<!--作者头像-->
								<div class="AuthorPhoto">
									<img border="0" width="110" height="110"
										src="${pageContext.request.contextPath}/style/images/defaultAvatar.gif"
										onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/style/images/defaultAvatar.gif';" />
								</div> <!--作者名称-->
								<div class="AuthorName">${topic.author.name}</div>
							</td>
							<td align="center">
								<ul class="TopicFunc">
									<!--操作列表-->
									<li class="TopicFuncLi">
									<s:a class="detail" action="reply_addUI?topicId=%{#topic.id}"><img
											border="0"
											src="${pageContext.request.contextPath}/style/images/edit.gif" />编辑</s:a>
										<a class="detail" href="#"
										onClick="return confirm('确定要删除本帖吗？')"><img border="0"
											src="${pageContext.request.contextPath}/style/images/delete.gif" />删除</a>
									</li>
									<!-- 文章的标题 -->
									<li class="TopicSubject">${topic.title}</li>
								</ul>
							</td>
						</tr>
						<tr>
							文章内容
							<td valign="top" align="center">
								<div class="Content">${topic.content}</div>
							</td>
						</tr>
						<tr>
							<!--显示楼层等信息-->
							<td class="Footer" height="28" align="center" valign="bottom">
								<ul style="margin: 0px; width: 98%;">
									<li style="float: left; line-height: 18px;"><font
										color=#C30000>[楼主]</font> ${topic.postTime}</li>
									<li style="float: right;"><a href="javascript:scroll(0,0)">
											<img border="0"
											src="${pageContext.request.contextPath}/style/images/top.gif" />
									</a></li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
				<%-- 			</s:if> --%>
				<!-- ~~~~~~~~~~~~~~~ 显示主帖结束 ~~~~~~~~~~~~~~~ -->


				<!-- ~~~~~~~~~~~~~~~ 显示回复列表 ~~~~~~~~~~~~~~~ -->
				<s:iterator value="recordList" status="status">
					<div class="ListArea template">
						<table border="0" cellpadding="0" cellspacing="1" width="100%">
							<tr>
								<td rowspan="3" width="130" class="PhotoArea" align="center"
									valign="top">
									<!--作者头像-->
									<div class="AuthorPhoto">
										<img border="0" width="110" height="110"
											src="${pageContext.request.contextPath}/style/images/defaultAvatar.gif"
											onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/style/images/defaultAvatar.gif';" />
									</div> <!--作者名称-->
									<div class="AuthorName">${author.name}</div>
								</td>
								<td align="center">
									<ul class="TopicFunc">
										<!--操作列表-->
										<li class="TopicFuncLi"><a class="detail"
											href="${pageContext.request.contextPath}/BBS_Topic/saveUI.html"><img
												border="0"
												src="${pageContext.request.contextPath}/style/images/edit.gif" />编辑</a>
											<a class="detail" href="#"
											onClick="return confirm('确定要删除本帖吗？')"><img border="0"
												src="${pageContext.request.contextPath}/style/images/delete.gif" />删除</a>
										</li>
										<!-- 文章表情与标题 -->
										<li class="TopicSubject">${title}</li>
									</ul>
								</td>
							</tr>
							<tr>
								<!-- 文章内容 -->
								<td valign="top" align="center">
									<div class="Content">${content}</div>
								</td>
							</tr>
							<tr>
								<!--显示楼层等信息-->
								<td class="Footer" height="28" align="center" valign="bottom">
									<ul style="margin: 0px; width: 98%;">
										<li style="float: left; line-height: 18px;"><font
											color=#C30000>[${(currentPage - 1) * pageSize + status.count}楼]</font>
											${postTime}</li>
										<li style="float: right;"><a
											href="javascript:scroll(0,0)"> <img border="0"
												src="${pageContext.request.contextPath}/style/images/top.gif" /></a>
										</li>
									</ul>
								</td>
							</tr>
						</table>
					</div>
				</s:iterator>
				<!-- ~~~~~~~~~~~~~~~ 显示回复列表结束 ~~~~~~~~~~~~~~~ -->
			</div>


			<!--分页信息-->
					<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>
			<s:form action="topic_show?id=%{id}"></s:form>


			<div class="ForumPageTableBorder" style="margin-top: 25px;">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr valign="bottom">
						<td width="3" class="ForumPageTableTitleLeft">&nbsp;</td>
						<td class="ForumPageTableTitle"><b>快速回复</b></td>
						<td width="3" class="ForumPageTableTitleRight">&nbsp;</td>
					</tr>
					<tr height="1" class="ForumPageTableTitleLine">
						<td colspan="3"></td>
					</tr>
				</table>
			</div>
		</center>

		<!--快速回复-->
		<div class="QuictReply">
			<s:form action="reply_add">
			<s:hidden name="topicId" value="%{#topic.id}"></s:hidden>
				<div style="padding-left: 3px;">
					<table border="0" cellspacing="1" width="98%" cellpadding="5"
						class="TableStyle">
						<tr height="30" class="Tint">
							<td width="50px" class="Deep"><b>标题</b></td>
							<td class="InputAreaBg"><div class="InputContent">
									<s:textfield name="title" cssClass="InputStyle"
										cssStyle="width:100%" value="回复：%{#topic.title}" />
								</div></td>
						</tr>
						<tr class="Tint" height="200">
							<td valign="top" rowspan="2" class="Deep"><b>内容</b></td>
							<td valign="top" class="no_color_bg">
<!-- 							<textarea name="content" style="width: 95%; height: 100px"></textarea></td> -->
						<s:textarea id="editor_id" name="content" style="width: 95%;height:300px;"></s:textarea>
						</tr>
						<tr height="30" class="Tint">
							<td class="no_color_bg" colspan="2" align="center"><input
								type="image"
								src="${pageContext.request.contextPath}/style/blue/images/button/submit.PNG"
								style="margin-right: 15px;" /></td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>
	</div>


</body>
</html>
