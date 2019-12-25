<%@page pageEncoding="UTF-8" %>
<!doctype html>
<html  lang="en">

    <head>


			<% if(session.getAttribute("RegisterSuccess")!=null){
				System.out.println(session.getAttribute("RegisterSuccess"));
				out.println("<script>\n" +
						"\t\t\talert(\"注册成功\")\n" +
						"\t\t</script>");
				session.removeAttribute("RegisterSuccess");



			}
				if(session.getAttribute("User")!=null){
					response.sendRedirect("index.jsp");
				}
			%>


        <!-- meta data -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!--font-family-->
		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&amp;subset=devanagari,latin-ext" rel="stylesheet">
        
        <!-- title of site -->
        <title>登录</title>

        <!-- For favicon png -->
		<link rel="shortcut icon" type="image/icon" href="assets/logo/favicon.png"/>
       
        <!--font-awesome.min.css-->
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
		
		<!--animate.css-->
        <link rel="stylesheet" href="assets/css/animate.css">
		
        <!--bootstrap.min.css-->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
		
		<!-- bootsnav -->
		<link rel="stylesheet" href="assets/css/bootsnav.css" >	
        
        <!--style.css-->
        <link rel="stylesheet" href="assets/css/style.css">
        
        <!--responsive.css-->
        <link rel="stylesheet" href="assets/css/responsive.css">
        
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		
        <!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
	
	<body>
		<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->
		
		<!-- signin end -->
		<section class="signin popup-in">
			<div class="container">
				<div class="sign-content popup-in-content">
					<div class="popup-in-txt">
						<h2>Log in</h2>

						<div class="row">
							<div class="col-sm-12">
								<div class="signin-form">
									<form action="/hello/loginServlet">
										<div class="form-group">
										    <label for="signin_form" >用户名</label>
										    <input type="text" class="form-control" name="golden_username" placeholder="Enter your username">
										</div><!--/.form-group -->
										<div class="form-group">
											<label for="signin_form">密码</label>
										    <input type="password" class="form-control" name="golden_password" placeholder="Enter your password">
										</div><!--/.form-group -->
										<p style="letter-spacing: 1px;"><input type="checkbox" name="autoLogin" value="自动登录" /> 自动登录 </p>
								</div><!--/.signin-form -->
							</div><!--/.col -->
						</div><!--/.row -->

						<div class="row">
							<div class="col-sm-12">
								<div class="signin-password">
									<div class="password-circle">
										<div class="single-password-circle">
<%--											<input type="radio" id="radio01" name="radio">--%>
												<label for="radio01">
													<span class="round-boarder">
														<span class="round-boarder1"></span>
													</span>
												</label>
										</div><!--/.single-password-circle-->

									</div><!--/.password-circle-->
								</div><!--/.signin-password -->
							</div><!--/.col -->
						</div><!--/.row -->

						<div class="row">
							<div class="col-sm-12">
								<div class="signin-footer">
									<input type="submit" value="登录" class="btn signin_btn signin_btn_two" data-toggle="modal" data-target=".signin_modal">
									<script>
										<% if((session.getAttribute("error")!=null))
										{ %>
											alert("${sessionScope.error}");
										<%	} %>
									</script>

									<p>
										没有账号？
										<a href="register.jsp">注册</a>
									</p>
								</div><!--/.signin-footer -->
							</div><!--/.col -->
						</div><!--/.row -->
					</div><!-- .popup-in-txt -->
				</div><!--/.sign-content -->
			</div><!--/.container -->
		</section><!--/.signin -->
		</form><!--/form -->
		<!-- signin end -->

		<!--footer copyright start -->
		<footer class="footer-copyright">
			<div id="scroll-Top">
				<i class="fa fa-angle-double-up return-to-top" id="scroll-top" data-toggle="tooltip" data-placement="top" title="" data-original-title="Back to Top" aria-hidden="true"></i>
			</div><!--/.scroll-Top-->

		</footer><!--/.hm-footer-copyright-->
		<!--footer copyright  end -->


		 <!-- Include all js compiled plugins (below), or include individual files as needed -->

		<script src="assets/js/jquery.js"></script>
        
        <!--modernizr.min.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		
		<!--bootstrap.min.js-->
        <script src="assets/js/bootstrap.min.js"></script>
		
		<!-- bootsnav js -->
		<script src="assets/js/bootsnav.js"></script>
		
		<!-- jquery.sticky.js -->
		<script src="assets/js/jquery.sticky.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
		
        
        <!--Custom JS-->
        <script src="assets/js/custom.js"></script>

    </body>
	
</html>