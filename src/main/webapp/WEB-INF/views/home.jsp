<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
   <link rel="stylesheet" href="../resources/css/style.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | E-Shopper</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->
	<title>Home</title>
	<link rel="stylesheet" href="/resources/css/style.css">
	<style>
	
 body { margin:0; padding:0; font-family:'맑은 고딕', verdana; }
 a { color:#05f; text-decoration:none; }
 a:hover { text-decoration:underline; }
 
 h1, h2, h3, h4, h5, h6 { margin:0; padding:0; }
 ul, lo, li { margin:0; padding:0; list-style:none; }

 /* ---------- */
 
 div#root { width:900px; margin:0 auto; }
 header#header { }
 nav#nav { }
 section#container { }
  section#content { float:right; width:700px; }
  aside#aside { text-align:center width:180px; }
  section#container::after { content:""; display:block; clear:both; } 
 footer#footer { background:#eee; padding:20px; }
 
 /* ---------- */
 
 header#header div#header_box { text-align:center; padding:30px 0; }
 header#header div#header_box h1 { font-size:50px; }
 header#header div#header_box h1 a { color:#000; }
 
 



.thumbImg {padding: 10px;

               width: 200px;
    height: 250px;  }	
.goodsPrice{color: 0000ff;}

.goodsLists{left: 150px;}
	
	</style>
</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="include/header.jsp" %>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="include/nav.jsp" %>

			</div>

		</nav>

			<aside id="aside">
				<%@ include file="include/aside.jsp" %>
			</aside>


		<section id="container">
<section id="content">
		<ul>

					<c:forEach items="${allgoodsList }" var="allgoodsList">
						<li>
						
							
							<div class="goodsThumb"> <img src="${allgoodsList.gdsThumbImg }" class="thumbImg"/></div>
								<div class="goodsPrice"><a href="/shop/view?n=${allgoodsList.gdsNum }">${allgoodsList.gdsPrice } 원</a></div>
											<!--상품 상세 페이지로 이동 -->
						</li>
					</c:forEach>
		</ul>
			</section>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="include/footer.jsp" %>
			</div>
		</footer>

</div>
</body>
</html>
