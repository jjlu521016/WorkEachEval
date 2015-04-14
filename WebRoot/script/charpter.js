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

function ChangeMode(cname){
}


function editWindows(subjectId, cid) {
	/*
	 * ================================================================================
	 * 功能描述 : 打开一个新的窗口 作用窗体 : 输入参数 : subjectId, cid
	 * ================================================================================
	 */
	var url = "";
	if (cid == -1) {
		url = "/WorkEachEval/charpter_addUI.action?subjectId=" + subjectId + "";
	} else {
		
		url = "/WorkEachEval/charpter_editUI.action?cid=" + cid + "&subjectId="+ subjectId + "";
	}
//	var arguments = window;
	var retValue = window
			.showModalDialog(
					url,
					this,
					"dialogHeight: 420px; dialogWidth: 900px; resizable: Yes; status: yes;center: yes");

	if (retValue == 1) {
		window.parent.right.location.reload(true);
	}

}