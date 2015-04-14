$(document).ready(function(){
	
	$("#subject").change(function(){
		var sid = $("#subject").val();
		var url = "${pageContext.request.contextPath}/charpterAction_selectCharpterCascade.action?time="+new Date().getTime();
		//alert(sid);
		$.getJSON(url,{sid:sid},function(json){
			var length = json.length;
			var cOption = $("#charpter");
			if(length != 0 ){
				cOption.html("");
				cOption.append("<option value= -1 >--请选择章节--</option>");
				for(var i = 0 ; i < length ; i ++){
					cOption.append("<option value='"+json[i].cid+"'>"+json[i].cname+"</option>" );
				}
			}else{
				cOption.html("");
				cOption.append("<option value= -1 >--请选择章节--</option>");
				alert("章节没有数据，请先添加章节");
			}
		});
	});
	
//bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
	
	//ffffffffffffffffffffffffffffffffff
	
	$("#charpter").change(function(){
		var cid = $("#charpter").val();
		var url = "${pageContext.request.contextPath}/knowledgeAction_selectKnowledgeByCid.action?time="+new Date().getTime();
		$.getJSON(url,{cid:cid},function(json){
			var length = json.length;
			var cOption = $("#knowledge");
			if(length != 0){
				cOption.html("");
				cOption.append("<option value= -1 >--请选择知识点--</option>");
				for(var i = 0 ; i < length ; i ++){
					cOption.append("<option value='"+json[i].kid+"'>"+json[i].kname+"</option>" );
				}
			}else{
				cOption.html("");
				cOption.append("<option value= -1 >--请选择知识点--</option>");
				alert("没有数据，请先添加知识点");
			}
		})
	});
	
	//hhhhhhhhhhhhhhhhhhhhhh
	$("#t_type").change(function(){
		
		var type = $("#t_type").val();
		
		var url = "${pageContext.request.contextPath}/typesAction_selectStyle.action?time="+new Date().getTime();
		$.post(url,{tid:type},function(date){
			//alert(date);
			if(date == 2){
				$("#notSelectDiv").show();//普通答案显示
				showPThideHigher();
				//清空选择题答案
				
				//清空checkbox被选中状态
				var check = $("input:checked");
				var length =check.length;
				for ( var i = 0; i < length; i++) {
					$(check[i]).attr("checked", false);
				}
				//清空input:text 的value
				var inputText = $("input:text[name*='answerText']");
				var textLength  = inputText.length ;
				for ( var j = 0; j < textLength; j++) {
					$(inputText[j]).val("");
				}
			}
			else if(date == 4){//判断题
				$("#judgeDiv").show();
				$("#selectDiv").hide();
				$("#notSelectDiv").hide();
				$("#higherAnswer").hide();
				$("#flg").val("2");
			}
			else if (date == 1){//是选择题
				$("#selectDiv").show();
				$("#judgeDiv").hide();
				$("#notSelectDiv").hide();
				$("#higherAnswer").hide();
				$("#qtextarea").html("");//普通答案清空
				$("#flg").val("1");
			//	$("#qContentAnswer").html("");//清空高级答案
			}
			else if (date == 3){
				//alert("执行3");
				$("#notSelectDiv").show();
				showPThideHigher();
				$("#higherAnswer").show();
				$("#notSelectSpan").hide();
				$("#judgeDiv").hide();
				$("#selectDiv").hide();
				$("#qtextarea").html("");//普通答案清空
				$("#flg").val("4");
			}
});
		//jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
	//编辑高级答案
		$("#higherAnswerLink").click(function(){
			$("#higherAnswer").show();
			$("#notSelectSpan").hide();
			$("#judgeDiv").hide();
			$("#selectDiv").hide();
			$("#qtextarea").html("");//普通答案清空
			$("#flg").val("4");
		});
		//gggggggggggggggggggggggggggggggggggggggg
		
		$("#ptAnswerLink").click(showPThideHigher);
		function showPThideHigher(){
			$("#notSelectSpan").show();
			$("#higherAnswer").hide();
			$("#selectDiv").hide();//选择题
			$("#judgeDiv").hide();
			$("#flg").val("3");
			//清空高级答案
		}

		});
	

		$("#newAnswer").click(function(){
		var div = $("#selectSpan").append("<span><br/><input type = 'text'  name = 'answerText'/><input type = 'checkbox' name = 'answerText'  value = 'thisMeanRightAnswerYouKnowFuck'></input>" +
				"<a name= 'deletea'><span style='text-decoration:none; color:rgb(0, 85, 255); '>删除</span></a></span>")
		.find("a[name='deletea']").click(deleteAnswer).end();
	});
		//kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
		function deleteAnswer(){
		var aaa = $(this).parents("span").remove();
	
	};
});








