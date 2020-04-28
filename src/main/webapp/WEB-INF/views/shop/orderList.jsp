<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<title>가로세로</title>
	<link rel="stylesheet" href="../resources/css/style.css">
	<style>
	
 /* ---------- */
 

 /* ---------- */

	</style>
	
	 <style>
/* section#content ul li { display:inline-block; margin:5px; }
 section#content div.goodsThumb img { width:200px; height:200px; }
 section#content div.goodsName { padding:10px 0; text-align:center; }
 section#content div.goodsName a { color:#000; }
	*/
 section#content ul li { border:5px solid #eee; padding:10px 20px; margin-bottom:20px; }
 section#content .orderList span { font-size:20px; font-weight:bold; display:inline-block; width:90px; margin-right:10px; }

 div#root { width:900px; margin:0 auto; }
 header#header { }
 nav#nav { }
 section#container { }
  section#content { float:right; width:700px; }
  aside#aside { text-align:center width:180px; }
  section#container::after { content:""; display:block; clear:both; } 
 footer#footer { background:#eee; padding:20px; }
 
	</style>


</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp" %>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp" %>

			</div>

		</nav>

			<aside id="aside">
				<%@ include file="../include/aside.jsp" %>
			</aside>


		<section id="container">
			<div id="container_box">
			<section id="content">
			<ul class="orderList">
		 <c:forEach items="${orderList}" var="orderList">
		 <li>
		  <div>
		  <p><span>주문번호</span><a href="/shop/orderView?n=${orderList.orderId }">${orderList.orderId }</a></p>
		   <p><span>수령인</span>${orderList.orderRec}</p>
		 <p><span>주소</span>(${orderList.userAddr1}) ${orderList.userAddr2} ${orderList.userAddr3}</p>
   		<p><span>가격</span><fmt:formatNumber pattern="###,###,###" value="${orderList.amount}" /> 원</p>
		  </div>
		 </li>
		 </c:forEach>
		</ul>
		</section>

			</div>
		</section>
		
		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp" %>
			</div>
		</footer>

</div>
</body>
</html>
