<%@ page import="Dao.User" %>
<%@ page import="Sql.SqlTemplate" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <script>
            function ContactUs() {
                alert("谢谢您宝贵的意见");
            }

        </script>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Always force latest IE rendering engine -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Meta Keyword -->
        <meta name="keywords" content="one page, business template, single page, onepage, responsive, parallax, creative, business, html5, css3, css3 animation">
        <!-- meta character set -->
        <meta charset="utf-8">

        <!-- Site Title -->
        <title>首页</title>
        <style>
            #gggg:hover{
                width: 150%;
                height: 150%;
            }

        </style>
        
        <!--
        Google Fonts
        ============================================= -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700" rel="stylesheet" type="text/css">
		
        <!--
        CSS
        ============================================= -->
        <!-- Fontawesome -->
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Fancybox -->
        <link rel="stylesheet" href="css/jquery.fancybox.css">
        <!-- owl carousel -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <!-- Animate -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Main Stylesheet -->
        <link rel="stylesheet" href="css/main.css">
        <!-- Main Responsive -->
        <link rel="stylesheet" href="css/responsive.css">
		
		
		<!-- Modernizer Script for old Browsers -->
        <script src="js/vendor/modernizr-2.6.2.min.js"></script>
		
		
		
<!--
		<meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" href="css/style.css">
-->

		
    </head>
	<% Cookie[] cookies=request.getCookies();
	for(Cookie c:cookies){
	    if(c.getName().equals("User")){
	        String username=c.getValue();
	        if(username!=null &&username.length()>0){
	            User user= SqlTemplate.findUser(username);
	            session.setAttribute("User",user);
	            if(user.getBoss()){
	                response.sendRedirect("../admin/datatables.jsp");
                }
            }
        }
    }%>
    <body>

        <!--
        Fixed Navigation
        ==================================== -->
        <header id="navigation" class="navbar-fixed-top">
            <div class="container">

                <div class="navbar-header">
                    <!-- responsive nav button -->
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- /responsive nav button -->

                    <!-- logo -->
                    <h1 class="navbar-brand">
                        <a href="#body">
<!--                            <img src="img/logo.png" alt="Kasper Logo">-->
                        </a>
                    </h1>
                    <!-- /logo -->

                    </div>

                    <!-- main nav -->
                    <nav class="collapse navigation navbar-collapse navbar-right" role="navigation">
                        <ul id="nav" class="nav navbar-nav">
                            <li class="current"><a href="#home">主页</a></li>
                            <li><a href="#service">服务</a></li>
                            <li><a href="#portfolio">图片广场</a></li>
                            <li><a href="#about">关于我们</a></li>
<!--                            <li><a href="#pricing">登录/注册</a></li>-->
                            <li><a href="#contact">联系我们</a></li>
                            <% if (session.getAttribute("User")==null) { %>
							<li><a href="${pageContext.request.contextPath}/login.jsp">登录/注册</a></li>
                            <% } else{ %>
                            <li><a href="../logoutServlet" onclick="logOutCom()">注销</a></li>
                            你好,<%=((User)session.getAttribute("User")).getUsername() %>

                            <% } %>

                            <script>
                                function logOutCom() {
                                    confirm("确定要登出吗");
                                }
                            </script>
                        </ul>
                    </nav>
                    <!-- /main nav -->
                </div>

            </div>
        </header>
        <!--
        End Fixed Navigation
        ==================================== -->


        <!--
        Home Slider
        ==================================== -->
        <section id="home">     
            <div id="home-carousel" class="carousel slide" data-interval="false">
                <ol class="carousel-indicators">
                    <li data-target="#home-carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#home-carousel" data-slide-to="1"></li>
                    <li data-target="#home-carousel" data-slide-to="2"></li>
                </ol>
                <!--/.carousel-indicators-->

                <div class="carousel-inner">

                    <div class="item active"  style="background-image: url('img/slider/bg1.jpg')" >
                        <div class="carousel-caption">
                            <div class="animated bounceInRight">
                                <h2>你好，创造 <br>我们守护你的创意！</h2>
                                <p>这是一个高效的图片管理系统——在这里，你可以方便快捷地上传并管理你的图片，你还可以与他人一切分享你的成果
								，结识志同道合的朋友，我们将热情地为你提供这个平台。</p>
                            </div>
                        </div>
                    </div>              

                    <div class="item" style="background-image: url('img/slider/bg2.jpg')">                
                        <div class="carousel-caption">
                            <div class="animated bounceInDown">
                                <h2>你好，创意 <br>我们一起分享创意</h2>
                                <p>图片管理系统为大家提供了一个与众不同的设计社区：你可以分享你的
								作品，下载免费的素材。我们期待着成为你寻找灵感的创意之源。</p>
                            </div>
                        </div>
                    </div>

                    <div class="item" style="background-image: url('img/slider/bg3.jpg')">                 
                         <div class="carousel-caption">
                            <div class="animated bounceInUp">
                                <h2>你好，创新 <br>我们帮你管理创新</h2>
                                <p>在图片管理系统的帮助下，你可以天马行空地发挥你的灵感，我们会为你
								做好图片的管理工作，为你免去管理图片的繁琐事务，从而让你更好的发挥创新</p>
                            </div>
                        </div>
                    </div>
                </div>
                <!--/.carousel-inner-->
                <nav id="nav-arrows" class="nav-arrows hidden-xs hidden-sm visible-md visible-lg">
                    <a class="sl-prev hidden-xs" href="#home-carousel" data-slide="prev">
                        <i class="fa fa-angle-left fa-3x"></i>
                    </a>
                    <a class="sl-next" href="#home-carousel" data-slide="next">
                        <i class="fa fa-angle-right fa-3x"></i>
                    </a>
                </nav>

            </div>
        </section>
        <!--
        End #home Slider
        ========================== -->

        
        <!--
        #service
        ========================== -->
        <div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
        <section id="service">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-title text-center wow fadeInDown">
                            <h2>服务</h2>    
                            <p>以下为图片管理系统的部分用例展示，如果以下用例符合您的需求可以直接使用，
								如果您需要新的用途可以 联系告诉我们</p>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <script>
                        function checkUser() {
                            <% if(session.getAttribute("User")==null){%>
                                alert("请先登录");
                                <%}%>
                        }
                    </script>
                    <div class="col-md-6 col-sm-12 wow fadeInLeft">
                        <div class="media">
                            <a href="${pageContext.request.contextPath}/user/new.html" onclick="checkUser()" class="pull-left">
                                <img id="gggg" src="img/icons/monitor.png" class="media-object" alt="Monitor" >
                            </a>
                            <div class="media-body">
                                <h3 id="kkkk">图库</h3>
                                <p>图片、视频、文档、灵感、素材管理，可按颜色，形状，评分查找筛选</p>
                            </div>
                        </div>

                    </div>

                    <div class="col-md-6 col-sm-12 wow fadeInRight" data-wow-delay="0.2s">
                        <div class="media">
                            <div href="" class="pull-left">
                                <img src="img/icons/cog.png" alt="Cog">
                            </div>
                            <div class="media-body">
                                <h3>视频管理</h3>
                                <p>能够读取FPS,时长等元信息，并用于筛选。（暂未实现）</p>
                            </div>
                        </div>
                        
                    </div>

                    <div class="col-md-6 col-sm-12 wow fadeInLeft">
                        <div class="media">
                            <div  class="pull-left">
                                <img src="img/icons/ruler.png" alt="Ruler">
                            </div>
                            <div class="media-body">
                                <h3>课件系统</h3>
                                <p>用于学校使用的课件管理系统，教师之间共享课件及教学相关文档。（暂未实现）</p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-sm-12 wow fadeInRight" data-wow-delay="0.2s">
                        <div class="media">
                            <div href="" class="pull-left">
                                <img src="img/icons/camera.png" alt="Camera">
                            </div>
                            <div class="media-body">
                                <h3>照片管理</h3>
                                <p>企业相册，图片工作协同等用途，支持IPTC,EXIF元数据。（暂未实现）</p>
                            </div>
                        </div>
                    </div>

                </div> <!-- end .row -->
            </div> <!-- end .container -->
        </section>
        <!--
        End #service
        ========================== -->

        <!--
        #service-bottom
        ========================== -->
	
	
	

	
        
<!--
        <section id="service-bottom">
            <div class="container">
                    <div class="mobile-device">
                       <img data-wow-delay="0.2s" class="img-responsive black  wow fadeInLeftBig" src="img/icons/iphone-black.png" alt="iPhone Black">
                        <img data-wow-delay="0.5s" class="img-responsive white  wow fadeInLeftBig" src="img/icons/iphone-white.png" alt="iPhone White">
                    </div>
                <div class="service-features wow fadeInRight">
                    <h3>OUR DESIGNS COMES WITH...</h3>
                    <ul>
                        <li>Responsive Design</li>
                        <li>Modern And Clean Design</li>
                        <li>Clean Code</li>
                        <li>Browser Friendly</li>
                    </ul>
                </div>
            </div>
-->
			
			
			
			
<!--
			<div id="wrap">
  <a href="#" class="hb">
	<div class="c">
	  <img src="images/1.jpg" alt=""/>
	  <div class="txt">
		<h1>Title here</h1>
		<p>Some longer text here thats wide enough to span on several lines.</p>
	  </div>
	</div>
  </a>
  <div class="fullBg">
	<img src="images/1.jpg" alt=""/>
  </div>
  <a href="#" class="hb">
	<div class="c">
	  <img src="images/2.jpg" alt=""/>
	  <div class="txt">
		<h1>Title here</h1>
		<p>Some longer text here thats wide enough to span on several lines.</p>
	  </div>
	</div>
  </a>
  <div class="fullBg">
	<img src="images/2.jpg" alt=""/>
  </div>
  <a href="#" class="hb">
	<div class="c">
	  <img src="images/3.jpg" alt=""/>
	  <div class="txt">
		<h1>Title here</h1>
		<p>Some longer text here thats wide enough to span on several lines.</p>
	  </div>
	</div>
  </a>
  <div class="fullBg">
	<img src="images/3.jpg" alt=""/>
  </div>
  <a href="#" class="hb">
	<div class="c">
	  <img src="images/4.jpg" alt=""/>
	  <div class="txt">
		<h1>Title here</h1>
		<p>Some longer text here thats wide enough to span on several lines.</p>
	  </div>
	</div>
  </a>
  <div class="fullBg">
	<img src="images/4.jpg" alt=""/>
  </div>
</div>

<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
	  var docWidth = $('body').width(),
		  $wrap = $('#wrap'),
		  $images = $('#wrap .hb'),
		  slidesWidth = $wrap.width();
	  
	  $(window).on('resize', function(){
		docWidth = $('body').width();
		slidesWidth = $wrap.width();
	  })
	  
	  $(document).mousemove(function(e) {
		var mouseX = e.pageX,
			offset = mouseX / docWidth * slidesWidth - mouseX / 2;
		
		$images.css({
		  '-webkit-transform': 'translate3d(' + -offset + 'px,0,0)',
				  'transform': 'translate3d(' + -offset + 'px,0,0)'
		});
	  });
	})
</script>
			
			
-->
			
			
			
<!--        </section>-->
        <!--
        End #service-bottom
        ========================== -->


        <!--
        #Portfolio
        ========================== -->
        
        <section id="portfolio">

            <div class="section-title text-center wow fadeInDown">
                <h2>图片广场</h2>    
                <p>图片广场是一个致力于设计作品分享、发现、寻找灵感的专业平台。</p>
            </div>
            
            <nav class="project-filter clearfix text-center wow fadeInLeft"  data-wow-delay="0.5s">
                <ul class="list-inline">
                    <li><a href="javascript:;" class="filter" data-filter="all">所有</a></li>
                    <li><a href="javascript:;" class="filter" data-filter=".app">卫星</a></li>
                    <li><a href="javascript:;" class="filter" data-filter=".photography">建筑</a></li>
                    <li><a href="javascript:;" class="filter" data-filter=".web">生活</a></li>
                    <li><a href="javascript:;" class="filter" data-filter=".print">食物</a></li>
                </ul>
            </nav>

            <div id="projects" class="clearfix">

                <figure class="mix portfolio-item app">
                    <img class="img-responsive" src="img/portfolio/portfolio-1.jpg" 
						 alt="Portfolio Item">
                    <a href="img/portfolio/portfolio-1.jpg" title="Title One" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                    <figcaption class="mask">
                        <h3>遥感卫星</h3>
                        <span>地理面貌</span>
                    </figcaption>
                </figure>

                <figure class="mix portfolio-item photography">
                    <img class="img-responsive" src="img/portfolio/portfolio-2.jpg" 
						 alt="Portfolio Item" >
                    <a href="img/portfolio/portfolio-2.jpg" title="Title Two" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                    <figcaption class="mask">
                        <h3>雄伟建筑</h3>
                        <span>摩天大楼</span>
                    </figcaption>
                </figure>

                <figure class="mix portfolio-item web">
                    <img class="img-responsive" src="img/portfolio/portfolio-3.jpg" 
						 alt="Portfolio Item" >
                    <a href="img/portfolio/portfolio-3.jpg" title="Title Three" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                    <figcaption class="mask">
                        <h3>美好生活</h3>
                        <span>热爱自然</span>
                    </figcaption>
                </figure>

                <figure class="mix portfolio-item print">
                    <img class="img-responsive" src="img/portfolio/portfolio-4.jpg" 
						 alt="Portfolio Item" >
                    <a href="img/portfolio/portfolio-4.jpg" title="Title Four" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                    <figcaption class="mask">
                        <h3>可口美食</h3>
                        <span>味蕾体验</span>
                    </figcaption>
                </figure>

                <figure class="mix portfolio-item app">
                    <img class="img-responsive" src="img/portfolio/portfolio-5.jpg" 
						 alt="Portfolio Item" >
                    <a href="img/portfolio/portfolio-5.jpg" title="Title Five" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                    <figcaption class="mask">
                        <h3>卫星航拍</h3>
                        <span>辽阔大地</span>
                    </figcaption>
                </figure>

                <figure class="mix portfolio-item photography">
                    <img class="img-responsive" src="img/portfolio/portfolio-6.jpg" 
						 alt="Portfolio Item" >
                    <a href="img/portfolio/portfolio-6.jpg" title="Title Six" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                    <figcaption class="mask">
                        <h3>传统建筑</h3>
                        <span>历史风格</span>
                    </figcaption>
                </figure>

                <figure class="mix portfolio-item app ">
                    <img class="img-responsive" src="img/portfolio/portfolio-7.jpg" 
						 alt="Portfolio Item" >
                    <a href="img/portfolio/portfolio-7.jpg" title="Title Seven" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                    <figcaption class="mask">
                        <h3>红外卫星</h3>
                        <span>高分摄影</span>
                    </figcaption>
                </figure>

                <figure class="mix portfolio-item  web">
                    <img class="img-responsive" src="img/portfolio/portfolio-8.jpg" 
						 alt="Portfolio Item" >
                    <a href="img/portfolio/portfolio-8.jpg" title="Title Eight" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                    <figcaption class="mask">
                        <h3>拥抱生活</h3>
                        <span>享受自然</span>
                    </figcaption>
                </figure>

            </div> <!-- end #projects -->

        </section>
        <!--
        End #Portfolio
        ========================== -->

        <!--
        #about
        ========================== -->
        <section id="about">
            <div class="container">
                <div class="row">

                    <div class="section-title text-center wow fadeInUp">
                        <h2>关于我们</h2>    
                        <p>由黄逸宏、姚东旭、杨舒潮构成的JavaEE小组</p>
                    </div>
                    
<!--
                    <div class="about-us text-center wow fadeInDown">
                        <img src="img/about.png" alt="About Us" class="img-responsive">
                    </div>
-->
                </div>
            </div>
        </section>
        <!--
        End #about
        ========================== -->
        

        <!--
        #count
        ========================== -->
        
<!--
        <section id="count">
            <div class="container">
                <div class="row">
                    <div class="counter-section clearfix">

                        <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInLeft" data-wow-delay="0.5s">
                            <div class="fact-item text-center">
                                <div class="fact-icon">
                                    <i class="fa fa-check-square fa-lg"></i>
                                </div>
                                <span data-to="120">0</span>
                                <p>Completed Projects</p>
                            </div>
                        </div>
                        
                        <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInLeft" data-wow-delay="0.8s">
                            <div class="fact-item text-center">
                                <div class="fact-icon">
                                    <i class="fa fa-users fa-lg"></i>                                    
                                </div>
                                <span data-to="152">0</span>
                                <p>Satisfied Clients</p>
                            </div>
                        </div>
                        
                        <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInLeft" data-wow-delay="1.1s">
                            <div class="fact-item text-center last">
                                <div class="fact-icon">
                                    <i class="fa fa-clock-o fa-lg"></i>
                                </div>
                                <span data-to="2500">0</span>
                                <p>Working Hours</p>
                            </div>
                        </div>
                        
                        <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInLeft" data-wow-delay="1.3s">
                            <div class="fact-item text-center last">
                                <div class="fact-icon">
                                    <i class="fa fa-trophy fa-lg"></i>
                                </div>
                                <span data-to="150">0</span>
                                <p>Award Won</p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section>
-->
        <!--
        End #count
        ========================== -->

        <!--
        #about-us
        ========================== -->
        <section id="about-us">
            <div class="container">
                <div class="row">
                    
                    <div class="col-md-5 col-md-offset-1 wow fadeInLeft">

                        <div class="subtitle text-center">
                            <h3>人员介绍</h3>
                            <p>由我们共同努力完成</p>
                        </div>

                        <div id="testimonial">

                            <div class="tst-item clearfix">
                                <div class="tst-single clearfix">
                                    <img src="img/client/1.jpg" alt="Client" class="img-circle">
                                    <div class="tst-content">
                                        <p>我主要负责的是后端开发，使用java语言，应用jsp+servlet+mysql技术栈
                                    和一点点spring的框架。</p>
                                        <span>黄逸宏</span>
                                    </div>
                                </div>

<!--
                                <div class="tst-single clearfix">
                                    <img src="img/client/2.jpg" alt="Client" class="img-circle">
                                    <div class="tst-content">
                                        <p>Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Mauris blandit aliquet elit, eget tincidunt.</p>
                                        <span>John Doe,CEO</span>
                                    </div>
                                </div>
-->
                            </div>

                            <div class="tst-item">
                                <div class="tst-single clearfix">
                                    <img src="img/client/2.jpg" alt="Client" class="img-circle">
                                    <div class="tst-content">
                                        <p>Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Mauris blandit aliquet elit, eget tincidunt.</p>
                                        <span>姚东序</span>
                                    </div>
                                </div>
<!--
                                <div class="tst-single clearfix">
                                    <img src="img/client/1.jpg" alt="Client" class="img-circle">
                                    <div class="tst-content">
                                        <p>Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Mauris blandit aliquet elit, eget tincidunt.</p>
                                        <span>John Doe,CEO</span>
                                    </div>
                                </div>
-->
                            </div>

                            <div class="tst-item">
                                <div class="tst-single clearfix">
                                    <img src="img/client/3.jpg" alt="Client" class="img-circle">
                                    <div class="tst-content">
                                        <p>Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Mauris blandit aliquet elit, eget tincidunt.</p>
                                        <span>杨舒潮</span>
                                    </div>
                                </div>
<!--
                                <div class="tst-single clearfix">
                                    <img src="img/client/3.jpg" alt="Client" class="img-circle">
                                    <div class="tst-content">
                                        <p>Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Mauris blandit aliquet elit, eget tincidunt.</p>
                                        <span>John Doe,CEO</span>
                                    </div>
                                </div>
-->
                            </div>

                        </div> <!-- end #testimonial -->
                    </div> <!-- end .col-md-5 -->

                    <div class="col-md-5 col-md-offset-1 wow fadeInRight">

                        <div class="subtitle text-center">
                            <h3>OUR SKILLS</h3>
                            <p></p>
                        </div>

                        <div class="progress-bars">
                            
                            <span>HTML 5 - <small>95%</small></span>
                            <div class="progress"  data-progress="95">
                                <div class="bar"></div>
                            </div>
                            <span>CSS 3 - <small>93%</small></span>
                            <div class="progress"  data-progress="93">
                                <div class="bar"></div>
                            </div>
                            <span>JAVASCIPRT - <small>93%</small></span>
                            <div class="progress"  data-progress="93">
                                <div class="bar"></div>
                            </div>
                            <span>JAVA - <small>95%</small></span>
                            <div class="progress" data-progress="95">
                                <div class="bar"></div>
                            </div>
                            <span>mySQL - <small>87%</small></span>
                            <div class="progress kill-margin"  data-progress="87">
                                <div class="bar"></div>
                            </div>

                        </div>  <!-- progress-bars -->

                    </div>  <!-- end .col-md-5 -->

                </div>
            </div>
        </section>

        <section id="contact">
            <div class="container">
                <div class="row">

                    <div class="section-title text-center wow fadeInDown">
                        <h2>联系我们</h2>
                        <p>我们期待着您的建议帮助我们改进产品</p>
                    </div>
                    
                    <div class="col-md-8 col-sm-9 wow fadeInLeft">
                        <div class="contact-form clearfix">
                            <form action="" method="post">
<!--
                                <div class="input-field">
                                    <input type="text" class="form-control" name="name" placeholder="Your Name" required="">
                                </div>
-->
                                <div class="input-field">
                                    <input type="email" class="form-control" name="email" placeholder="您的邮箱" required="">
                                </div>
                                <div class="input-field message">
                                    <textarea name="message" class="form-control" placeholder="您的意见或建议" required=""></textarea>
                                </div>
                                <input type="button" class="btn btn-blue pull-right" value="提交信息" id="msg-submit" onclick="ContactUs()">
                            </form>
                        </div> <!-- end .contact-form -->
                    </div> <!-- .col-md-8 -->

<!--
                    <div class="col-md-4 col-sm-3 wow fadeInRight">
                        <div class="contact-details">
                            <span>GET IN TOUCH</span>
                            <p>+00 123.456.789 <br> <br> +00 123.456.789</p>
                        </div> 

                        <div class="contact-details">
                            <span>GET IN TOUCH</span>
                            <p>+00 123.456.789 <br> <br> +00 123.456.789</p>
                        </div> 
                    </div> 
-->

                </div>
            </div>
        </section>
        <!--
        End #contact
        ========================== -->

        <!--
        #footer
        ========================== -->
        <footer id="footer" class="text-center">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
<!--

                        <div class="footer-logo wow fadeInDown">
                            <img src="img/logo.png" alt="logo">
                        </div>
-->

<!--
                        <div class="footer-social wow fadeInUp">
                            <h3>We are social</h3>
                            <ul class="text-center list-inline">
                                <li><a href="http://goo.gl/RqhEjP"><i class="fa fa-facebook fa-lg"></i></a></li>
                                <li><a href="#/hUfpSB"><i class="fa fa-twitter fa-lg"></i></a></li>
                                <li><a href="#/r4xzR4"><i class="fa fa-google-plus fa-lg"></i></a></li>
                                <li><a href="#/k9zAy5"><i class="fa fa-dribbble fa-lg"></i></a></li>
                            </ul>
                        </div>
-->
<!--

                        <div class="copyright">
                           
                            <p>Theme by GraphBerry - Developed by Themefisher.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
                        </div>
-->

                    </div>
                </div>
            </div>
        </footer>
        <!--
        End #footer
        ========================== -->


        <!--
        JavaScripts
        ========================== -->
        
        <!-- main jQuery -->
        <script src="js/vendor/jquery-1.11.1.min.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        <!-- jquery.nav -->
        <script src="js/jquery.nav.js"></script>
        <!-- Portfolio Filtering -->
        <script src="js/jquery.mixitup.min.js"></script>
        <!-- Fancybox -->
        <script src="js/jquery.fancybox.pack.js"></script>
        <!-- Parallax sections -->
        <script src="js/jquery.parallax-1.1.3.js"></script>
        <!-- jQuery Appear -->
        <script src="js/jquery.appear.js"></script>
        <!-- countTo -->
        <script src="js/jquery-countTo.js"></script>
        <!-- owl carousel -->
        <script src="js/owl.carousel.min.js"></script>
        <!-- WOW script -->
        <script src="js/wow.min.js"></script>
        <!-- theme custom scripts -->
        <script src="js/main.js"></script>
    </body>

</html>
