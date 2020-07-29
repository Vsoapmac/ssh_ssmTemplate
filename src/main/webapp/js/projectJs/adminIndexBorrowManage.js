$(function(){
	/* 借书事件 */
	$("#borrowBook").submit(function(){
		var borrowu_id =document.getElementById("borrowu_id").value;
		var borrowu_name =document.getElementById("borrowu_name").value;
		var borrowu_type =document.getElementById("borrowu_type").value;
		var borrowu_ins =document.getElementById("borrowu_ins").value;
		var borrowbk_id =document.getElementById("borrowbk_id").value;
		var borrowbk_name =document.getElementById("borrowbk_name").value;
		
		if(borrowu_id == ""){
			initBorrow();
			/* 首先让提示框显示为校验错误的状态 */
			$("#borrowu_idBox").addClass("has-error");
			$("#borrowu_idBox").append(
				"<span class='glyphicon glyphicon-remove form-control-feedback' aria-hidden='true'></span><span id='inputError2Status' class='sr-only'>(error)</span>"
			);

			/* 弹出框设置值 */
			$("#borrowu_id").attr("data-content", "S.H.I.T用户id是空的");
			return false;
		}else if(borrowbk_id == ""){
			initBorrow();
			/* 首先让提示框显示为校验错误的状态 */
			$("#borrowbk_idBox").addClass("has-error");
			$("#borrowbk_idBox").append(
				"<span class='glyphicon glyphicon-remove form-control-feedback' aria-hidden='true'></span><span id='inputError2Status' class='sr-only'>(error)</span>"
			);

			/* 弹出框设置值 */
			$("#borrowbk_id").attr("data-content", "神奇海螺说您没写书本的id");
			return false;
		}else{
			initBorrow();
			$.ajax({
				url: '${pageContext.request.contextPath}/borrowBookAction',
				type: 'post',
				data: {
					"borrowu_id": borrowu_id,
					"borrowu_name": borrowu_name,
					"borrowu_type": borrowu_type,
					"borrowu_ins": borrowu_ins,
					"borrowbk_id": borrowbk_id,
					"borrowbk_name": borrowbk_name
				},
				dataType: 'json',
				success: function(data) {
					$("#borrowu_id").val("");
					$("#borrowu_name").val("");
					$("#borrowu_type").val("");
					$("#borrowu_ins").val("");
					$("#borrowbk_id").val("");
					$("#borrowbk_name").val("");
				}
			});// end $.ajax
		}
	});// end $("#borrowBook").submit(function()
});//end $(function()

function initBorrow(){
	/* 将所有的异常状态移除 */
	$("#borrowu_id").removeAttr("data-content");
	$("#borrowu_idBox").removeClass("has-error");
	$("#borrowu_idBox span").remove(".glyphicon");
	$("#borrowu_idBox span").remove(".sr-only");
	
	$("#borrowu_name").removeAttr("data-content");
	$("#borrowu_nameBox").removeClass("has-error");
	$("#borrowu_nameBox span").remove(".glyphicon");
	$("#borrowu_nameBox span").remove(".sr-only");
	
	$("#borrowu_type").removeAttr("data-content");
	$("#borrowu_typeBox").removeClass("has-error");
	$("#borrowu_typeBox span").remove(".glyphicon");
	$("#borrowu_typeBox span").remove(".sr-only");
	
	$("#borrowu_ins").removeAttr("data-content");
	$("#borrowu_insBox").removeClass("has-error");
	$("#borrowu_insBox span").remove(".glyphicon");
	$("#borrowu_insBox span").remove(".sr-only");
	
	$("#borrowbk_id").removeAttr("data-content");
	$("#borrowbk_idBox").removeClass("has-error");
	$("#borrowbk_idBox span").remove(".glyphicon");
	$("#borrowbk_idBox span").remove(".sr-only");
	
	$("#borrowbk_name").removeAttr("data-content");
	$("#borrowbk_nameBox").removeClass("has-error");
	$("#borrowbk_nameBox span").remove(".glyphicon");
	$("#borrowbk_nameBox span").remove(".sr-only");
	
}