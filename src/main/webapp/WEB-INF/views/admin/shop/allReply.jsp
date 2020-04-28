  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<title>Admin Page</title>
	
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
	<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp" %>
			</div>
			
			<style>
			
 body { font-family:'맑은 고딕', verdana; padding:0; margin:0; }
 ul { padding:0; margin:0; list-style:none;  }

 div#root { width:90%; margin:0 auto; }
 
 header#header { font-size:60px; padding:20px 0; }
 header#header h1 a { color:#000; font-weight:bold; }
 
 nav#nav { padding:10px; text-align:right; }
 nav#nav ul li { display:inline-block; margin-left:10px; }

   section#container { padding:20px 0; border-top:2px solid #eee; border-bottom:2px solid #eee; }
 section#container::after { content:""; display:block; clear:both; }
 aside { float:left; width:200px; }
 div#container_box { float:right; width:calc(100% - 200px - 20px); }
 
 aside ul li { text-align:center; margin-bottom:10px; }
 aside ul li a { display:block; width:100%; padding:10px 0;}
 aside ul li a:hover { background:#eee; }
 
			</style>
			
			<style>
			
	.replyControll {text-align:right; padding:10px; }
.replyControll button { border:2px solid #999; background:#fff; }		

 .inputArea { margin:10px 0; }
select { width:100px; }
label { display:inline-block; width:70px; padding:5px; }
label[for='gdsDes'] { display:block; }
input { width:150px; }
textarea#gdsDes { width:400px; height:180px; }
			</style>
			
			<style>
	/*	#container_box table {width:900px;}
		#container_box table th {font-size:20px; font-weight:bold; text-align:center; padding:10px;}
 		#container_box table td { padding:10px; text-align:center; }
 		#container_box table tr:hover {background:#ffc0cb;}
 		#container_box table img{width:150px; height:150px;}*/
 		
 		
 div#container_box ul li { border:5px solid #eee; padding:10px 20px; margin-bottom:20px; }
 div#container_box .orderList span { font-size:20px; font-weight:bold; display:inline-block; width:90px; margin-right:10px; }

#container_box ul li { margin-bottom:20px; border:10px solid #eee; }
.replyInfo { background:#eee; padding:10px; font-size:18px; }
.replyInfo span { font-size:20px; font-weight:bold; margin-right:20px; }
.replyContent { padding:10px; }

</style>
			
			
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp" %>

			</div>
		</nav>
		<aside>
	<%@include file="../include/aside.jsp" %>
		</aside>	
	
		<section id="container">
<div id="container_box">
<ul>
<c:forEach items="${reply}" var="reply">
  <li>
   <div class="replyInfo">
    <p>
     <span>작성자</span>${reply.userName} (${reply.userId})
    </p>
    <p>
     <span>작성된 상품</span> <a href="/shop/view?n=${reply.gdsNum}">바로가기</a>
    </p>
   </div>
   <div class="replyContent">
   ${reply.getRContent()}
   </div>
   <div class="replyControll">
   <form role="form" method="post" action="/admin/shop/allReply" >
     <input type="hidden" name="rNum" value="${reply.getRNum()}" />
 <button type="submit" class="delete_${reply.getRNum()}Btn">삭제</button>
</form>
</div>
  </li>     
  </c:forEach>

</ul></div>


		</section>
		
		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp" %>
			</div>
		</footer>

</div>


</body>
</html>
 