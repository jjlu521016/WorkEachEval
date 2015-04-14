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
	var title = document.getElementById('title').value;
	if (title == "") {
		alert("提示：请输入知识点名称！");
		return false;
	}

	alert("添加成功！");
//	window.returnValue = 1;

	window.close();

}
/**
 * 打开一个新的窗口
 * 
 * @returns {Boolean}
 */
function editWindows(charpterId, kid) {

	var url = "";
	if (kid == -1) {
		url = "/WorkEachEval/knowledge_addUI.action?charpterId=" + charpterId
				+ "";
	} else {
		url = "/WorkEachEval/knowledge_addUI.action?kid=" + kid
				+ "&charpterId=" + charpterId + "";
	}

	var retValue = window
			.showModalDialog(
					url,
					"",
					"dialogHeight: 420px; dialogWidth: 900px; resizable: Yes; status: yes;center: yes");
	alert(retValue);
	if (retValue == 1) {
		window.parent.right.location.reload(true);
	}
}