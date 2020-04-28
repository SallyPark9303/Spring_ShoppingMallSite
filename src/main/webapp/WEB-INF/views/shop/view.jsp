<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<link rel="stylesheet" href="../resources/css/style.css">
	
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<title>상세보기</title>
	
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
						<input type="hidden" name="gdsNum" id="gdsNum" value="${view.gdsNum }" />
						<!-- 히든: 장바구니에 추가하는 기능과 소감 남기기(댓글) 기능 이용하기 위함. -->
					</form>
					<div class="goodsview">
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
                              <c:if test="${view.gdsStock !=0 }">
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
							
							</c:if>
							<c:if test="${view.gdsStock == 0 }">
							<p>상품 수량 부족</p>
							</c:if>
						</div>

						<div class="gdsDes">${view.gdsDes}</div>
					</div>
				
							<div id="reply">
							
							 <c:if test="${member == null }">
							  <p>소감을 남기시려면 <a href="/member/signin">로그인</a>해주세요</p>
							 </c:if>
							 
							 <c:if test="${member != null}">
							 <section class="replyForm">
							  <form role="form" method="post" autocomplete="off">
							   <input type="hidden" name="gdsNum" value="${view.gdsNum}">
							   <div class="input_area">
							    <textarea name="rContent" id="rContent"></textarea>
							   </div>
							   
							   <div class="input_area">
							    <button type="submit" id="replyBtn">소감 남기기</button>
							   </div>
							   
							  </form>
							 </section>
							 </c:if>
							 
							 <section class="replyList">
							  <ol>
							   <li>댓글 목록</li>
							   </ol>    
							 </section>
							</div>

						<section class="replyList">
							<ol>
						
								<c:forEach items="${replylists }" var="replys">
									<li>
									 	<div class="userInfo">
											<span class="username">${replys.userName } </span>
											 <span class="date"><fmt:formatDate value="${replys.getRDate()}"
													pattern="yyyy-MM-dd" /></span>
										</div>
										<div class="replyContent">${replys.getRContent()}</div>

									</li>
								</c:forEach> 
							</ol></section>
						
							
						<script>
 $(document).on("click", ".delete", function(){ //스크립트로인해 생성된 동적html코드 이기때문에 일반적인 클릭 메서드 .clcik()이 아니라 .on()메서드를 사용해야함.
  var deleteConfirm = confirm("정말로 삭제하시겠습니까?");
 if(deleteConfirm) {
	 
 
 
 var data = {rNum : $(this).attr("data-rNum")};
   
  $.ajax({
   url : "/shop/view/deleteReply",
   type : "post",
   data : data,
  
	   success : function(result){
		   
		   if(result == 1) {
		    replyList();
		   } else {
		    alert("작성자만 삭제할 수 있습니다.");     
		   }
		  },
		  error : function(){
			  alert("로그인하셔야합니다.")
			 }
   });
  
 }
  });
 

 

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
