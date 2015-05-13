$(document).ready(function() {
		//给上一题的按钮添加事件
// 		$("input[type=button]").click(function() {
// 			//点击上一题后，将上一题强制转换成
// 			$("form").attr("action", "examPaper_preQuestion.action").submit();
// 		})
		$("#pre").click(function() {
			//点击上一题后，将上一题强制转换成
			$("form").attr("action", "task_preQuestion.action").submit();
		})
		
		$("#uppaper").click(function() {
			//点击上一题后，将上一题强制转换成
			alert("hello!!!!@@");
			return false;
			//$("form").attr("action", "task_submitPaper.action").submit();
		})
	});

