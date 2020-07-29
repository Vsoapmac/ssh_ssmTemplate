$(function() {
	// 循环
	$(".nav-sidebar li").each(function(i) {
		// 添加事件
		$(".nav-sidebar li:eq(" + i + ")").click(function() {
			/* 完成对导航的视觉操作 */
			// 移除所有的active状态
			$(".nav-sidebar li").removeClass("active");
			// 在相应的地方添加active状态
			$(".nav-sidebar li:eq(" + i + ")").addClass("active");

			/* 对页面的内容进行编辑 */
			// 将所有的内容全部隐藏
			$(".main").css("display", "none")
			// 获取值
			var sidebar = $(".nav-sidebar li:eq(" + i + ")").attr("time");
			// 显示相应的内容
			// $("."+ sidebar +"").css("display","auto");
			$("." + sidebar + "").fadeIn("fast");
			if (i == 2) {}
		});
	}); //end 	$(".nav-sidebar li").each(function(i) 

	//可以弹出警告框
	$("#name").popover();
	$("#phone").popover();
	$("#username").popover();
	$("#password").popover();
	$("#passwordAgain").popover();

	//提交事件
	$("#regiester").submit(function() {
		var name = document.getElementById("name").value;
		var phone = document.getElementById("phone").value;
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var passwordAgain = document.getElementById("passwordAgain").value;

		if (name == "") {
			//初始化所有的错误信息
			initWrong();
			/* 首先让提示框显示为校验错误的状态 */
			$("#nameBox").addClass("has-error");
			$("#nameBox").append(
				"<span class='glyphicon glyphicon-remove form-control-feedback' aria-hidden='true'></span><span id='inputError2Status' class='sr-only'>(error)</span>"
			);

			/* 弹出框设置值 */
			$("#name").attr("data-content", "您的名字没写呢(〜￣△￣)〜");
			return false;
		} else if (phone == "") {
			//初始化所有的错误信息
			initWrong();
			/* 首先让提示框显示为校验错误的状态 */
			$("#phoneBox").addClass("has-error");
			$("#phoneBox").append(
				"<span class='glyphicon glyphicon-remove form-control-feedback' aria-hidden='true'></span><span id='inputError2Status' class='sr-only'>(error)</span>"
			);

			/* 弹出框设置值 */
			$("#phone").attr("data-content", "电话号码没写呢(〜￣△￣)〜");
			return false;
		} else if (username.length < 5) {
			//初始化所有的错误信息
			initWrong();
			/* 首先让提示框显示为校验错误的状态 */
			$("#usernameBox").addClass("has-error");
			$("#usernameBox").append(
				"<span class='glyphicon glyphicon-remove form-control-feedback' aria-hidden='true'></span><span id='inputError2Status' class='sr-only'>(error)</span>"
			);

			/* 弹出框设置值 */
			$("#username").attr("data-content", "用户名的长度不能小于5");
			return false;
		} else if (password == "") {
			//初始化所有的错误信息
			initWrong();
			/* 首先让提示框显示为校验错误的状态 */
			$("#passwordBox").addClass("has-error");
			$("#passwordBox").append(
				"<span class='glyphicon glyphicon-remove form-control-feedback' aria-hidden='true'></span><span id='inputError2Status' class='sr-only'>(error)</span>"
			);

			/* 弹出框设置值 */
			$("#password").attr("data-content", "密码没写呢(〜￣△￣)〜");
			return false;
		} else if (passwordAgain != password) {
			//初始化所有的错误信息
			initWrong();
			/* 首先让提示框显示为校验错误的状态 */
			$("#passwordAgainBox").addClass("has-error");
			$("#passwordAgainBox").append(
				"<span class='glyphicon glyphicon-remove form-control-feedback' aria-hidden='true'></span><span id='inputError2Status' class='sr-only'>(error)</span>"
			);

			/* 弹出框设置值 */
			$("#passwordAgain").attr("data-content", "密码不一致哦(〜￣△￣)〜");
			return false;
		} else {
			/* ajax对表单的操作 */
			$.ajax({
				url: '${pageContext.request.contextPath}/isRepeatAction',
				type: 'post',
				data: {
					"phone": phone,
					"name": name,
					"username": username,
					"password": password
				},
				dataType: 'json',
				success: function(data) {
					var jsonData = JSON.parse(data); //将data转json格式
					var isRepeat = jsonData.isRepeat; //判断是否有重复的

					if (isRepeat) {
						var repeatType = jsonData.repeatType; //判断重复的类型
						switch (repeatType) {
							case "nameRepeat":
								//初始化所有的错误信息
								initWrong();
								/* 首先让提示框显示为校验错误的状态 */
								$("#nameBox").addClass("has-error");
								$("#nameBox").append(
									"<span class='glyphicon glyphicon-remove form-control-feedback' aria-hidden='true'></span><span id='inputError2Status' class='sr-only'>(error)</span>"
								);

								/* 弹出框设置值 */
								$("#name").attr("data-content", "你已经注册过了，密码忘记了，咱工作人员也要休息的嘛(〜￣△￣)〜");
								return false;

							case "usernameRepeat":
								//初始化所有的错误信息
								initWrong();
								/* 首先让提示框显示为校验错误的状态 */
								$("#usernameBox").addClass("has-error");
								$("#usernameBox").append(
									"<span class='glyphicon glyphicon-remove form-control-feedback' aria-hidden='true'></span><span id='inputError2Status' class='sr-only'>(error)</span>"
								);

								/* 弹出框设置值 */
								$("#username").attr("data-content", "你的账号被别人占去了喔(〜￣△￣)〜");
								return false;
						}
					} else {
						//初始化所有的错误信息
						initWrong();
						/* 成功 */
						$("#phoneBox").addClass("has-success");
						$("#phoneBox").append(
							"<span class=\"glyphicon glyphicon-ok form-control-feedback\" aria-hidden=\"true\"></span><span id=\"inputSuccess2Status\" class=\"sr-only\">(success)</span>"
						);

						$("#nameBox").addClass("has-success");
						$("#nameBox").append(
							"<span class=\"glyphicon glyphicon-ok form-control-feedback\" aria-hidden=\"true\"></span><span id=\"inputSuccess2Status\" class=\"sr-only\">(success)</span>"
						);

						$("#usernameBox").addClass("has-success");
						$("#usernameBox").append(
							"<span class=\"glyphicon glyphicon-ok form-control-feedback\" aria-hidden=\"true\"></span><span id=\"inputSuccess2Status\" class=\"sr-only\">(success)</span>"
						);

						$("#passwordBox").addClass("has-success");
						$("#passwordBox").append(
							"<span class=\"glyphicon glyphicon-ok form-control-feedback\" aria-hidden=\"true\"></span><span id=\"inputSuccess2Status\" class=\"sr-only\">(success)</span>"
						);

						$("#passwordAgainBox").addClass("has-success");
						$("#passwordAgainBox").append(
							"<span class=\"glyphicon glyphicon-ok form-control-feedback\" aria-hidden=\"true\"></span><span id=\"inputSuccess2Status\" class=\"sr-only\">(success)</span>"
						);

						/* 刷新当前页面 */
						setTimeout("window.location.reload()", "300");
					}
				}
			}); //end $.ajax({})
		} //end else
	}); //end $("#regiester").submit(function() {})
	
	$("#addBook").submit(function(){
		var bk_name = document.getElementById("bk_name").value;
		var bk_time = document.getElementById("bk_time").value;
		var bk_press = document.getElementById("bk_press").value;
		var bk_author = document.getElementById("bk_author").value;
		var bk_type = document.getElementById("bk_type").value;
		var pic_url = document.getElementById("pic_url").value;
		var bk_show = document.getElementById("bk_show").value;
		$.ajax({
			url: '${pageContext.request.contextPath}/addBookAction',
			type: 'post',
			data: {
				"bk_name": bk_name,
				"bk_time": bk_time,
				"bk_press": bk_press,
				"bk_author": bk_author,
				"bk_type": bk_type,
				"pic_url": pic_url,
				"bk_show": bk_show,
			},
			dataType: 'json',
			success: function(data) {
				var jsonData = JSON.parse(data); //将data转json格式
				var status = jsonData.status;//获取状态（可有可无）
				
				if(status.status == "success"){
					alert("添加成功,要想看到结果请刷新页面,或者继续添加图书");
					$("#addBook div").each(function(i){
						$("#addBook div:eq("+i+") input").val("");
					});
				}
			}
		});
	});// end $("#addBook").submit(function(){
	
	$("#writeName").click(function(){
		var writeDownName = document.getElementById("writeDownName").value;
		
		$.ajax({
			url: '${pageContext.request.contextPath}/findNameAction',
			type: 'post',
			data: {
				"writeDownName": writeDownName,
			},
			dataType: 'json',
			success: function(data) {
				var jsonData = JSON.parse(data); //将data转json格式
				
				/* 转换为var */
				var Bk_author = jsonData.Bk_author;
				var Bk_name = jsonData.Bk_name;
				var Bk_press = jsonData.Bk_press;
				var Bk_show = jsonData.Bk_show;
				var Bk_time = jsonData.Bk_time;
				var Bk_type = jsonData.Bk_type;
				var Pic_url = jsonData.Pic_url;
				var Book_id = jsonData.Book_id;
				
				if(Bk_name!=null || Bk_author!=null || Bk_show!=null){
					/* 将值注入文本框 */
					$("#UOD_Book_id").val(Book_id);
					$("#UOD_bk_name").val(Bk_name);
					$("#UOD_bk_time").val(Bk_time);
					$("#UOD_bk_press").val(Bk_press);
					$("#UOD_bk_author").val(Bk_author);
					$("#UOD_bk_type").val(Bk_type);
					$("#UOD_bk_show").val(Bk_show);
				}else{
					/* 将书本的信息全部设置为空值 */
					$("#UOD_bk_name").attr("placeholder",null);
					$("#UOD_bk_time").attr("placeholder",null);
					$("#UOD_bk_press").attr("placeholder",null);
					$("#UOD_bk_author").attr("placeholder",null);
					$("#UOD_bk_type").attr("placeholder",null);
					$("#UOD_bk_show").attr("placeholder",null);
					
				}//end else
			}
		});//end $.ajax({}
	});//end $("#writeName").submit(function(){
	
	/* 修改按钮 */
	$("#updateBtnFromFindBook").click(function(){
		/* 移除所有的只读状态(id除外) */
		$("#UOD_bk_name").removeAttr("readonly");
		$("#UOD_bk_time").removeAttr("readonly");
		$("#UOD_bk_press").removeAttr("readonly");
		$("#UOD_bk_author").removeAttr("readonly");
		$("#UOD_bk_type").removeAttr("readonly");
		$("#UOD_bk_show").removeAttr("readonly");
		
		/* 把修改和删除按钮隐藏 */
		$("#updateBtnFromFindBook").attr("style","display: none;");
		$("#deleteBtnFromFindBook").attr("style","display: none;");
		
		/* 把提交和返回显示 */
		$("#submitBtnFromFindBook").removeAttr("style");
		$("#retrunFormupdate").removeAttr("style");
		
		//alert("在文本框里面书写要修改的内容就可以了,注意要全部填写");
	});//end $("#updateBtnFromFindBook").click(function()
	
	/* 返回按钮 */
	$("#retrunFormupdate").click(function(){
		/* 变成只读状态 */
		$("#UOD_Book_id").attr("readonly" , "null");
		$("#UOD_bk_name").attr("readonly" , "null");
		$("#UOD_bk_time").attr("readonly", "null");
		$("#UOD_bk_press").attr("readonly", "null");
		$("#UOD_bk_author").attr("readonly", "null");
		$("#UOD_bk_type").attr("readonly", "null");
		$("#UOD_bk_show").attr("readonly", "null");
		
		/* 把提交和返回按钮隐藏 */
		$("#submitBtnFromFindBook").attr("style","display: none;");
		$("#retrunFormupdate").attr("style","display: none;");
		/* 把修改和删除显示 */
		$("#updateBtnFromFindBook").removeAttr("style");
		$("#deleteBtnFromFindBook").removeAttr("style");
		
	});//end $("#retrunFormupdate").click(function()
	
	/* 修改按钮 */
	$("#updateOrDelete").submit(function(){
		/* 获取所有在文本框中的消息 */
		var book_id = document.getElementById("UOD_Book_id").value;
		var bk_author = document.getElementById("UOD_bk_author").value;
		var bk_name = document.getElementById("UOD_bk_name").value;
		var bk_press = document.getElementById("UOD_bk_press").value;
		var bk_show = document.getElementById("UOD_bk_show").value;
		var bk_time = document.getElementById("UOD_bk_time").value;
		var bk_type = document.getElementById("UOD_bk_type").value;
		
		$.ajax({
			url: '${pageContext.request.contextPath}/updateBookAction',
			type: 'post',
			data: {
				"book_id": book_id,
				"bk_author": bk_author,
				"bk_name": bk_name,
				"bk_press": bk_press,
				"bk_show": bk_show,
				"bk_time": bk_time,
				"bk_type": bk_type
			},
			dataType: 'json',
			success: function(data) {
				var jsonData = JSON.parse(data); //将data转json格式
				
				var status = jsonData.status;
				if(status == "success"){
					alert("修改成功");
					setTimeout("window.location.reload()", "300");//刷新
				}
			}
		});//end $.ajax
		setTimeout("window.location.reload()", "300");//刷新
	});// end $("#updateOrDelete").submit(function()
	
	/* 删除按钮 */
	$("#deleteBtnFromFindBook").click(function() {
		var book_id = document.getElementById("UOD_Book_id").value;
		$.ajax({
			url: '${pageContext.request.contextPath}/deleteAction',
			type: 'post',
			data: {
				"id": book_id,
			},
			dataType: 'json',
		});
		alert("删除成功");
		setTimeout("window.location.reload()", "300");//刷新
	});//end $("#deleteBtnFromFindBook").click(function()
	
	
	
}); // end $(function(){});

/* 初始化所有的错误 */
function initWrong() {
	/* 将所有的异常状态移除 */
	$("#name").removeAttr("data-content");
	$("#nameBox").removeClass("has-error");
	$("#nameBox span").remove(".glyphicon");
	$("#nameBox span").remove(".sr-only");

	$("#phone").removeAttr("data-content");
	$("#phoneBox").removeClass("has-error");
	$("#phoneBox span").remove(".glyphicon");
	$("#phoneBox span").remove(".sr-only");

	$("#username").removeAttr("data-content");
	$("#usernameBox").removeClass("has-error");
	$("#usernameBox span").remove(".glyphicon");
	$("#usernameBox span").remove(".sr-only");

	$("#passwordPop").removeAttr("data-content");
	$("#passwordBox").removeClass("has-error");
	$("#passwordBox span").remove(".glyphicon");
	$("#passwordBox span").remove(".sr-only");

	$("#password").removeAttr("data-content");
	$("#passwordBox").removeClass("has-error");
	$("#passwordBox span").remove(".glyphicon");
	$("#passwordBox span").remove(".sr-only");

	$("#passwordAgain").removeAttr("data-content");
	$("#passwordAgainBox").removeClass("has-error");
	$("#passwordAgainBox span").remove(".glyphicon");
	$("#passwordAgainBox span").remove(".sr-only");
};
