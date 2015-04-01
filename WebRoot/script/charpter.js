/**
 * 保存提示及校验
 * @returns {Boolean}
 */

function saveTips() {
	
	var cname = document.getElementById('cname').value;
	if (cname == "") {
		alert("提示：请输入章节名称！");
		return false;
	}

	alert("添加成功！");
	
	window.close();
	return;

}
/**
 * 打开一个新的窗口
 * @returns {Boolean}
 */
function editWindows(subjectId) {
	
	var url = "/WorkEachEval/charpter_addUI.action?subjectId="+subjectId+"";
	var width = 1000;
	var height = 600;
	var arguments = window;

	if (!width)
		width = 350;
	if (!height)
		height = 350;
	var left = (screen.width - width) / 2;
	var top = (screen.height - height) / 2;
	var features = ""
			+ "dialogWidth:" + width + "px;"// 宽度
			+ "dialogHeight:" + height + "px;"// 高度
			+ "center: yes;"// 是否居中
			+ "resizable: yes;"// 是否可以改变大小
			+ "scroll: yes;"// 当内容超过窗口大小时是否显示滚动条
			+ "status: yes;"// 是否显示状态栏
	var returnValue = window.showModalDialog(url, arguments, features);

	window.parent.right.location.reload(true);
	return ;
}