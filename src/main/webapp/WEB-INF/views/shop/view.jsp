<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<title>상세보기</title>

<style>
body {
	margin: 0;
	padding: 0;
	font-family: '맑은 고딕', verdana;
}

a {
	color: #05f;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

h1, h2, h3, h4, h5, h6 {
	margin: 0;
	padding: 0;
}

ul, lo, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

/* ---------- */
div#root {
	width: 900px;
	margin: 0 auto;
}

header#header {
	
}

nav#nav {
	
}

section#container {
	
}

section#content {
	float: right;
	width: 700px;
}

aside#aside {
	text-align: center width:180px;
}

section#container::after {
	content: "";
	display: block;
	clear: both;
}

footer#footer {
	background: #eee;
	padding: 20px;
}

/* ---------- */
header#header div#header_box {
	text-align: center;
	padding: 30px 0;
}

header#header div#header_box h1 {
	font-size: 50px;
}

header#header div#header_box h1 a {
	color: #000;
}

nav#nav div#nav_box {
	font-size: 14px;
	padding: 10px;
	text-align: right;
}

nav#nav div#nav_box li {
	display: inline-block;
	margin: 0 10px;
}

nav#nav div#nav_box li a {
	color: #333;
}

section#container {
	
}

aside#aside h3 {
	font-size: 22px;
	margin-bottom: 20px;
	text-align: left;
}

aside#aside li {
	font-size: 16px;
	text-align: center;
}

aside#aside li:hover {
	backgound: #fff;
}

aside#aside li a {
	color: #000;
	display: block;
	padding: 10px 0;
	margin: 10px;
	border: 0;
	float: left;
}

aside#aside li a:hover {
	text-decoration: none;
	background: #fff;
}

aside#aside ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

aside#aside li {
	position: relative;
}

aside#aside li:hover {
	background: #eee;
}

aside#aside li>ul.low {
	display: none;
	position: absolute;
	top: 0;
	left: 180px;
}

aside#aside li:hover>ul.low {
	display: block;
}

aside#aside li:hover>ul.low li a {
	background: #eee;
	border: 1px solid #eee;
}

aside#aside li:hover>ul.low li a:hover {
	background: #fff;
}

aside#aside li>ul.low li {
	width: 180px;
}

ul, ol, li {
	list-style: none;
	margin: 0;
	padding: 0;
}

ul.myMenu {
	
}

ul.myMenu>li {
	display: inline-block;
	width: 90px;
	padding: 5px 10px;
	background: #eee;
	text-align: center;
	position: relative;
}

ul.myMenu>li ul.submenu {
	display: none;
	position: absolute;
	top: 70px;
	left: 0;
}

ul.myMenu>li:hover ul.submenu {
	display: block;
}

ul.myMenu>li ul.submenu>li {
	display: inline-block;
	width: 90px;
	padding: 5px 10px;
	background: #eee;
	text-align: center;
}

ul.myMenu>li ul.submenu>li:hover {
	background: #fff;
}

footer#footer {
	margin-top: 600px;
	border-radius: 50px 50px 0 0;
}

footer#footer div#footer_box {
	padding: 0 20px;
}
</style>

<style>
div.goods div.goodsImg {
	float: left;
	width: 350px;
}

div.goods div.goodsImg img {
	width: 350px;
	height: auto;
}

div.goods div.goodsInfo {
	float: right;
	width: 330px;
	font-size: 22px;
}

div.goods div.goodsInfo p {
	margin: 0 0 20px 0;
}

div.goods div.goodsInfo p span {
	display: inline-block;
	width: 100px;
	margin-right: 15px;
}

div.goods div.goodsInfo p.cartStock input {
	font-size: 22px;
	width: 50px;
	padding: 5px;
	margin: 0;
	border: 1px solid #eee;
}

div.goods div.goodsInfo p.cartStock button {
	font-size: 26px;
	border: none;
	background: none;
}

div.goods div.goodsInfo p.addToCart {
	text-align: right;
}

div.goods div.gdsDes {
	font-size: 18px;
	clear: both;
	padding-top: 30px;
}

div.goods div.goodsInfo p.cartStock button {
	font-size: 26px;
	border: none;
	background: none;
}
</style>

<style>
section.replyForm {
	padding: 30px 0;
}

section.replyForm div.input_area {
	margin: 10px 0;
}

section.replyForm textarea {
	font-size: 16px;
	font-family: '맑은 고딕', verdana;
	padding: 10px;
	width: 500px;;
	height: 150px;
}

section.replyForm button {
	font-size: 20px;
	padding: 5px 10px;
	margin: 10px 0;
	background: #fff;
	border: 1px solid #ccc;
}

section.replyList {
	padding: 30px 0;
}

section.replyList ol {
	padding: 0;
	margin: 0;
}

section.replyList ol li {
	padding: 10px 0;
	border-bottom: 2px solid #eee;
}

section.replyList div.userInfo {
	
}

section.replyList div.userInfo .userName {
	font-size: 24px;
	font-weight: bold;
}

section.replyList div.userInfo .date {
	color: #999;
	display: inline-block;
	margin-left: 10px;
}

section.replyList div.replyContent {
	padding: 10px;
	margin: 20px 0;
}
</style>

	<script> function replyList(){
		 var gdsNum = ${view.gdsNum};
		 $.getJSON("/shop/view/replyList" + "?n=" + gdsNum, function(data){
		  var str = "";
		  
		  $(data).each(function(){
		   
		   console.log(data);
		   
		   var rDate = new Date(this.rDate);
		   rDate = rDate.toLocaleDateString("ko-US")
		   
		   str += "<li data-gdsNum='" + this.gdsNum + "'>"
		     + "<div class='userInfo'>"
		     + "<span class='userName'>" + this.userName + "</span>"
		     + "<span class='date'>" + rDate + "</span>"
		     + "</div>"
		     + "<div class='replyContent'>" + this.rContent + "</div>"
		     + "</li>";           
		  });
		  
		  $("section.replyList ol").html(str);
		 });}
							//$.getJSON :비동기식으로 제이슨 데이터를 가져오는 메소드
							//"/shop/view/replyList"+"?n=" 로 컨트롤러에 접속하여 데이터를 가져옴
									// 테이블에 저장된 날짜 데이터와 컨트롤러에서 뷰로 보낼때의 날짜 데이터 형식이 다르기 떄문에 
									//컨트롤러에서 toLocaleDateString 를 이용해 1차적으로 데이터 제공.
							</script>

</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>

			</div>

		</nav>



		<section id="container">
			<div id="container_box">
				<section id="content">

					<form role="form" method="post">
						<input type="text" name="gdsNum" id="gdsNum" value="${view.gdsNum }" />
						<!-- 히든: 장바구니에 추가하는 기능과 소감 남기기(댓글) 기능 이용하기 위함. -->
					</form>
					<div class="goods">
						<div class="goodsImg">
							<img src="${view.gdsImg }">
						</div>

						<div class="goodsInfo">
							<p class="gdsName">
								<span>상품명</span>${view.gdsName}</p>

							<p class="cateName">
								<span>카테고리</span>${view.cateName}</p>

							<p class="gdsPrice">
								<span>가격 </span>
								<fmt:formatNumber pattern="###,###,###" value="${view.gdsPrice}" />
								원
							</p>

							<p class="gdsStock">
								<span>재고 </span>
								<fmt:formatNumber pattern="###,###,###" value="${view.gdsStock}" />
								EA
							</p>

							<p class="cartStock">
								<span>구입 수량</span>
								<button type="button" class="plus">+</button>
								<input type="number" class="numBox" min="1"
									max="${view.gdsStock}" value="1" readonly="readonly" />
								<button type="button" class="minus">-</button>

								<script>
									$(".plus").click(function() {
										var num = $(".numBox").val();
										var plusNum = Number(num) + 1;

										if (plusNum >= '${view.gdsStock}') {
											$(".numBox").val(num);
										} else {
											$(".numBox").val(plusNum);
										}
									});

									$(".minus").click(function() {
										var num = $(".numBox").val();
										var minusNum = Number(num) - 1;

										if (minusNum <= 0) {
											$(".numBox").val(num);
										} else {
											$(".numBox").val(minusNum);
										}
									});
								</script>

							</p>

							<p class="addToCart">
								<button type="button" class="addCartBtn">카트에 담기</button>
						<script>
						
						$(".addCartBtn").click(function(){
							
						var gdsNum = $("#gdsNum").val();
						var cartStock =$(".numBox").val();
						
						var data= {
								gdsNum :gdsNum,
								cartStock: cartStock
								
						};
						
						$.ajax({
							
						url : "/shop/view/addCart",
						type :"post",
						data :data,
						success :function(result) {
						
							
							  if(result == 1) { 
								  alert("카드 담기 성공");
							$(".numBox").val("1");
						}else{
							alert("회원만 사용할 수 있습니다.")
							$(".numBox").val("1");			
						}
						},
						error :function(){
							alert("카트 담기 실패");		//세션이 만료되어 로그인이 자동으로 풀렸거나 로그인을 안한 경우					
						}
						});
						
						});						
						</script>
						
						
							</p>
						</div>

						<div class="gdsDes">${view.gdsDes}</div>
					</div>


					<div id="reply">

						<c:if test="${member ==null }">
							<p>
								소감을 남기시려면 <a href="member/signin">로그인해주세요.</a>
							</p>
						</c:if>

						<c:if test="${member !=null }">
							<section class="replyForm">
								<form role="form" method="post" autocomplete="off">
									<input type="text" name="gdsNum" value="${view.gdsNum}" />
									<!-- name=""에서의 값과 ReplyVO에서 선언된 값이 같아야함 -->
									<div class="input_area">
										<textarea name="rContent" id="rContent"></textarea>
									</div>
									<!-- 상품번호는 히든에서, 소감내용은 텍스트에리어에서, 유저 아이디는 현재의 세션에서가져옴 -->
									<div class="input_area">
										<button type="button" id="replyBtn">소감남기기</button>
										<script>
										$("#replyBtn").click(function(){
											
											var formObj =$(".replyForm form[role='form']");
											var gdsNum =$("#gdsNum").val();
											var rContent =$("#rContent").val()
											var data = {
												gdsNum :gdsNum,
												rContent : rContent
											};
											
											$.ajax({
												url: "/shop/view/registerReply", //데이터가 전송될 주소
												type: "post", //타입
												data :data, // 전송이 성공되었을 때 실행될 함수부.
												success :function(){
													replyList();
													$("#rContent").val("");
												}
												//제이슨 형태의 데이터는 {키:벨류, 키:벨류...}
											});						
										});
										</script>
									</div>

								</form>
							</section>
						</c:if>

						<section class="replyList">
							<ol>
						
						<!-- 		<c:forEach items="${replylists }" var="replys">
									<li>
									 	<div class="userInfo">
											<span class="username">${replys.userName } </span>
											 <span class="date"><fmt:formatDate value="${replys.getRDate()}"
													pattern="yyyy-MM-dd" /></span>
										</div>
										<div class="replyContent">${replys.getRContent()}</div>

									</li>
								</c:forEach> -->
							</ol>
						<script>
						replyList();
						</script>
							
						
						</section>
					</div>
				</section>
			</div>
		</section>

		<aside id="aside">
			<%@ include file="../include/aside.jsp"%>
		</aside>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>

	</div>
</body>
</html>
