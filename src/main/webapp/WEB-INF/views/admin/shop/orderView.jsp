  
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
 		#container_box table img{width:150px; height:150px;}
*/
/*
 .orderInfo { border:5px solid #eee; padding:10px 20px; margin:20px 0;}
 .orderInfo span { font-size:20px; font-weight:bold; display:inline-block; width:90px; }
 */
 .orderView li { margin-bottom:20px; padding-bottom:20px; border-bottom:1px solid #999; }
 .orderView li::after { content:""; display:block; clear:both; }
 
 .thumb { float:left; width:200px; }
 .thumb img { width:200px; height:200px; }
 .gdsInfo { float:right; width:calc(100% - 220px); line-height:2; }
 .gdsInfo span { font-size:20px; font-weight:bold; display:inline-block; width:100px; margin-right:10px; }

.deliveryChange { text-align:right; }
.delivery1_btn,
.delivery2_btn { font-size:16px; background:#fff; border:1px solid #999; margin-left:10px; }
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
<div class="orderInfo">
  <c:forEach items="${orderView}" var="orderView" varStatus="status">
  
  
 <c:if test="${status.first}">
 <p><span>주문자</span>${orderView.userId}</p>
 <p><span>수령인</span>${orderView.orderRec}</p>
 <p><span>주소</span>(${orderView.userAddr1}) ${orderView.userAddr2} ${orderView.userAddr3}</p>
 <p><span>가격</span><fmt:formatNumber pattern="###,###,###" value="${orderView.amount}" /> 원</p>
 <p><span>상태</span>${orderView.delivery}</p>
 
 <div class="deliveryChange"> <!-- 버튼 클릭-> 컨트롤러에 데이터 넘김 -->
 <form role="form" method="post" class=deliveryForm>
 <input type="hidden" name="orderId" value="${orderView.orderId }"/>
 <input type="hidden" name="delivery" class="delivery" value=""/> 
   <button type="button" class="delivery1Btn">배송 중</button>
   <button type="button" class="delivery2Btn">배송 완료</button>
 </form>
 <script>
 //버튼을 클릭하면 숨겨져있는 인풋박스에 값이 입력되고, 인풋박스의 데이터를 컨트롤러로 전송.
 $(".delivery1Btn").click(function(){
	 $(".delivery").val("배송 중");
	 run();
 });
 
 $(".delivery2Btn").click(function(){
	 $(".delivery").val("배송 완료");
	 run();
 });
 
 function run() {
	 $(".deliveryForm").submit();	 
 }
 </script>
 
 </div>
</c:if>
  
 </c:forEach>
</div>



 
</ul>



		</section>
		
		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp" %>
			</div>
		</footer>

</div>


</body>
</html>
 