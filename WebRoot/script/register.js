$(function() {
	
		var count1=0,count2=0,count3=0,count4=0,count5=0,count6=0;
		$(":input.required").each(function() {
			var $required = $("<strong>*</strong>");
			$(this).parent().append($required);
			
		});
		$(":input.required").blur(function() {
			if(count1==1 && count2==1 && count3==1 && count4==1 && count5==1 && count1==1){
				$(":input[type=image]").removeAttr("disabled");
			}
			// 判断一下鼠标离开谁了
			if ($(this).is("#loginName")) {
				$(".formtip").remove();
				var $this = $(this)
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
			}
			
			
			// 姓名
			if($(this).is("#name")){
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
			}
			// 密码
			if($(this).is("#password")){
				$(".password").remove();
				// 按照用户名的规则去验证
				if (this.value == "" || this.value.length < 6) {
					var errMsg = "<span class='password'>密码至少是6个字母</span>";
					$(this).parent().append(errMsg);
				} else {
					count3 =1;
					var msg = "<span class='password'>密码可以使用</span>";
					$(this).parent().append(msg);
				}
			}
			// 确认密码
			if($(this).is("#repassword")){
				$(".repassword").remove();
				if(this.value != $("#password").val())
					{
					var errMsg = "<span class='repassword'>两次密码输入的不同！请重新输入！</span>";
					$(this).parent().append(errMsg);
					}
				else {
					count4 =1;
					var msg = "<span class='repassword'>两次密码一致</span>";
					$(this).parent().append(msg);
				}
			}
			// 判断是电话号码
			if ($(this).is("#phoneNumber")) {
				$(".phonetip").remove();
				// 按照手机号码的规则去验证
				var reg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
				var $phoneNumber = $("#phoneNumber").val();
				if (!reg.test($phoneNumber)) {
					var errMsg = "<span class='phonetip'>电话号码不合法</span>";
					$(this).parent().append(errMsg);
				} else {
					count5 =1;
					var Msg = "<span class='phonetip'>电话号码可以使用</span>";
					$(this).parent().append(Msg);
				}
			}
			
			// 判断一下如果是email的话,应该按照email的规则去验证
			if ($(this).is("#email")) {
				$(".emailtip").remove();
				// 按照email的规则去验证
				var reg = /^\w{1,}@\w+\.\w+$/;
				var $email = $("#email").val();
				if (!reg.test($email)) {
					var errMsg = "<span class='emailtip'>邮箱不合法</span>";
					$(this).parent().append(errMsg);
				} else {
					count6 =1;
					var Msg = "<span class='emailtip'>邮箱可以使用</span>";
					$(this).parent().append(Msg);
				}
			}
		});
		
	})