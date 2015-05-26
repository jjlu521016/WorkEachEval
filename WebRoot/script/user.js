$(document).ready(function(){
		var uid = $(':hidden[name=id]').val();
		if(uid==""){}
		else{
			$(':text[name=loginName]').attr("readonly","true");
		}	
	//登录名	
		$(':text[name=loginName]').blur(function(){
		$(".formtip").remove();
		var $this = $(this);
		// 按照用户名的规则去验证
		if (this.value == "" || this.value.length < 6) {
			var errMsg = "<span class='formtip'>用户名至少是6个字母</span>";
			$(this).parent().append(errMsg);
			return false;
		} else {
			
			var url="user_checkUserIsExist.action";
			var args ={"loginName":this.value};
			$.post(url,args,function(data){
				if(data=="1"){
					count1 =1;
					var msg = "<span class='formtip'>用户名可以使用</span>";
					$this.parent().append(msg);
				}else if(data=="0"){
					var msg = "<span class='formtip'>用户名已经存在，请换登录名！</span>";
					$this.parent().append(msg);
				}
				else{alert("服务器错误！");}
			})
		}
		})
		// 姓名
		$(':text[name=name]').blur(function(){
			$(".name").remove();
			// 按照用户名的规则去验证
			if (this.value == "" || this.value.length < 2) {
				var errMsg = "<span class='name'>姓名至少是2个字母</span>";
				$(this).parent().append(errMsg);
			} else {
				count2 = 1;
				var msg = "<span class='name'>姓名可以使用</span>";
				$(this).parent().append(msg);
			}
		})
	})