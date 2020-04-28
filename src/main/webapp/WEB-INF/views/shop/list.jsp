<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<title>가로세로</title>

	
	


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
			<ul>
		 <c:forEach items="${list}" var="list">
		 <li>
		  <div class="goodsThumb">
		   <img id="goodslist" src="${list.gdsThumbImg}">
		  </div> 
		  <div class="goodsName" >
		   <a href="/shop/view?n=${list.gdsNum}">${list.gdsName}</a>
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
