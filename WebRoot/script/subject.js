$(document).ready(function(){
		var sid = $(':hidden[name=sid]').val();
		if(sid.length == 0){
				$(':text[name=subject_code]').blur(function() {
					var scode = $(':text[name=subject_code]').val();
					if(scode.length >0){
						var url="subject_check.action";
						var args ={"scode":scode};
						var $this = $(this);
						$this.nextAll("span").remove();
						$.post(url,args,function(data){
							if(data=="1"){
								$this.after("<span class='formtip'>该课程编号可用</span>");
							}else if(data=="0"){
								$this.after("<span class='formtip'>该课程编号已经存在！</span>");
							}
							else{alert("服务器错误！");}
							})
					}
				})
		}
		else{
			$(':text[name=subject_code]').attr("readonly","true");
		}	
		
		
	})

		
