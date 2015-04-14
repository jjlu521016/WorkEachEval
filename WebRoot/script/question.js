var num = 0;
function rem(i) {
	var oDiv = document.getElementById("myDiv");
	var text = document.getElementById("text" + i);
	var but = document.getElementById("but" + i);
	var br = document.getElementById("br" + i);
	var checkbox = document.getElementById("checkbox" + i);
	oDiv.removeChild(text);
	oDiv.removeChild(but);
	oDiv.removeChild(checkbox);
	oDiv.removeChild(br);
}

function addB() {
	var oDiv = document.getElementById("myDiv");
	var br = document.createElement("br");
	br.setAttribute("id", "br" + num);

	oDiv.innerHTML += "<input type='text' id=text" + num + " name ='answers'>";

	oDiv.innerHTML += "<input type='checkbox' id=checkbox" + num
			+ " name ='just" + num + "'value='1'/>";
	oDiv.innerHTML += "<input type='button' id=but" + num
			+ " name ='bb' value ='删除本条答案' onClick='rem(" + num + ")'>";
	num++;
	// oDiv.innerHTML=oDiv.innerHTML+"sss"
	oDiv.appendChild(br);
}
// 根据下拉框控制显示的div层
function showDiv() {
	var objS = document.getElementById("typeId").value;
	var selectDiv = document.getElementById("selectDiv");
	var judgeDiv = document.getElementById("judgeDiv");
	var notSelectDiv = document.getElementById("notSelectDiv");
	if (objS == '1') {

		notSelectDiv.style.display = 'none';
		judgeDiv.style.display = 'none';
		selectDiv.style.display = 'block';
	} else if (objS == '2') {

		notSelectDiv.style.display = 'none';
		selectDiv.style.display = 'none';
		judgeDiv.style.display = 'block';

	} else {

		judgeDiv.style.display = 'none';
		selectDiv.style.display = 'none';
		notSelectDiv.style.display = 'block';
	}
}

/*
 * =======================================================================================
 * 
 * ===========================================================================================
 */
function FormClose() {
	/*
	 * ================================================================================
	 * 功能描述 : 关闭弹出窗口 作用窗体 : 输入参数 : 无 输出参数 : 无
	 * ================================================================================
	 */
	window.close();
}

function saveTips() {
	/*
	 * ================================================================================
	 * 功能描述 : 保存提示及校验 作用窗体 : 输入参数 : 无 输出参数 : 无
	 * ================================================================================
	 */
	var cname = document.getElementById('cname').value;
	if (cname == "") {
		alert("提示：请输入章节名称！");
		return false;
	}

	window.returnValue = 1;
	alert("操作成功！");
	window.close();

}

function ChangeMode(cname) {
}

function checkOnSubmit() {
	var type = document.getElementById("typeId");
	var qtext = document.getElementById("qtext").value;
	
	alert(qtext);
	if (type.value == "-1") {
		alert("请选择题型！");
		return false;
	}

	if (qtext == "" || qtext == null) {
		alert("请填写问题描述！");
		return false;
	}
	return true;
}

function editWindows(subjectId, charpterId, qid) {
	/*
	 * ================================================================================
	 * 功能描述 : 打开一个新的窗口 作用窗体 : 输入参数 : subjectId, cid
	 * ================================================================================
	 */
	alert("hello");
	alert("subjectId=" + subjectId + "===" + "charpterId" + charpterId
			+ "=====" + "qid" + qid);
	return false;
	var url = "";
	if (cid == -1) {
		url = "/WorkEachEval/charpter_addUI.action?subjectId=" + subjectId + "";
	} else {

		url = "/WorkEachEval/charpter_editUI.action?cid=" + cid + "&subjectId="
				+ subjectId + "";
	}
	// var arguments = window;
	var retValue = window
			.showModalDialog(
					url,
					this,
					"dialogHeight: 420px; dialogWidth: 900px; resizable: Yes; status: yes;center: yes");

	if (retValue == 1) {
		window.parent.right.location.reload(true);
	}

}