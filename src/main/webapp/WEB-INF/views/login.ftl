<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">

	    <title>Bootstrap 101 Template</title>
	    <link href="../../css/bootstrap.css" rel="stylesheet">
    	<link rel="stylesheet" type="text/css" href="../../css/login2.css">
    	<link rel="stylesheet" href="../../css/supersized.css">
    </head>
    <body>
    	
		<div class="container">
			<div class="form">
				<div id="div-form" class="div-form">
					<form class="form-horizontal form-login" id="login_form">
					<h2 class="form-title">登录</h2>
					<label for="username" class="sr-only">用户名</label>
					<input type="text" name="username" id="username" class="form-control" placeholder="Account" required autofocus />
					<label for="password" class="sr-only">密码</label>
					<input type="password" name="password" id="password" class="form-control" style="margin-top: 20px;" placeholder="password" required autofocus />
					<div class="checkbox">
						<label>
							<input type="checkbox" name="remember_me">记住我
						</label>
					</div>
					<div class="custom-btn-group">
						<button class="btn btn-primary" id="login" type="button">登录</button>
						<button type="button" class="btn btn-info" id="register">注册</button>
					</div>
				</form>
				</div>
			</div>
		</div>


    	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    	<script src="../../js/bootstrap.min.js"></script>
    	<script type="text/javascript" src="../../js/supersized.3.2.7.min.js"></script>
    	<script type="text/javascript" src="../../js/supersized-init.js"></script>
    	<script>
    		jQuery(document).ready(function($) {
//    			alert(1111);
//    			var form_height = $('.form').height();
//    			var div_form_margin_top = form_height/4;
//    			$('#div-form').css('margin-top',div_form_margin_top);

    			 $('#register').click(function(event) {
    			 	alert(111);
              		window.location.href='/user/loginSuccess.do';
           		});

    			 $('#login').click(function(event){
//                     alert('登录点击事件');
                     var username = $('#username').val();
                     var password = $('#password').val();

                     if(username=='' || password==''){
//                         alert('空');
                         return false;
					 }
                     var data = {password: password, userName: username};
					 $.ajax({
						 url:'/user/submitLogin.do',
						 data:data,
						 type:'POST',
						 dataType:'json',
						 beforeSend:function () {
                             console.log('开始登录');
                         },
						 success:function (result) {
//						     alert('成功回调');
							 if(result && result.status != 200){
                                 $('#password').val('');
							 }else {
//                                 setTimeout(function () {
                                     window.location.href = "/user/loginSuccess.do";
//                                 }, 1000);
							 }
                         },
                         error: function(XMLHttpRequest, textStatus, errorThrown) {
                             alert(XMLHttpRequest.readyState);
                             alert(textStatus);
                         }
					 })
				})


    		});
    	</script>
    </body>
</html>