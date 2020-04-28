<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
	<title>Signup</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
</head>
<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp" %>
			</div>
		</header>
<style>

@import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css");
	
	html {
		height: 100%;
	}
	
	body {
	    width:100%;
	    height:100%;
	    margin: 0;
  		padding-top: 50px;
  		padding-bottom: 40px;
  		font-family: "Nanum Gothic", arial, helvetica, sans-serif;
  		background-repeat: no-repeat;
  		background:linear-gradient(to bottom right, white, white);
	}
	
    .card {
    
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 90px; /* Added */
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	}
	
	.form-signin .form-control {
  		position: relative;
  		height: auto;
  		width: 80%;
  		margin:15px;
  		-webkit-box-sizing: border-box;
     	-moz-box-sizing: border-box;
        	 box-sizing: border-box;
  		padding: 10px;
  		font-size: 16px;
	}
	.form-signin-heading{
	font-size : 15px;
	font-family: 나눔고딕;
	margin: 20px;
	}


</style>




 <body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" >
		<div class="card-title" style="margin-top:30px; margin-left:10px;" >
			<h2 class="card-title text-center" style="color:#113366;">가로세로에 오신걸 환영합니다.</h2>
		</div>
		
	<div id="root">
		

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp" %>

			</div>

		</nav>

		<section id="container">
			<div id="container_box">
			<section id="content">
 <form class="form-signin" role="form" method="post" autocomplete="off">
   <h5 class="form-signin-heading">회원가입 정보를 입력해주세요</h5>
 
  <div class="input_area">
   <label  class="sr-only" for="userId">아이디</label>
   <input type="email" id="userId" name="userId"  class="form-control" placeholder="example@email.com" required="required" />      
  </div>
  
  <div class="input_area">
   <label  class="sr-only" for="userPass">패스워드</label>
   <input type="password" id="userPass" name="userPass"  class="form-control" placeholder="비밀번호를 입력해주세요" required="required" />      
  </div>
  
  <div class="input_area">
   <label  class="sr-only" for="userName">닉네임</label>
   <input type="text" id="userName" name="userName"  class="form-control" placeholder="닉네임을 입력해주세요" required="required" />      
  </div>
  
  <div class="input_area">
   <label  class="sr-only" for="userPhon">연락처</label>
   <input type="text" id="userPhon" name="userPhon"  class="form-control" placeholder="연락처를 입력해주세요" required="required" />   <!-- required: 필수입력 -->   
  </div>
  
  <button class="btn btn-lg btn-primary btn-block" type="submit" id="signup_btn" name="signup_btn">회원가입</button>
  
 </form>
 </div>   
</section>
			<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 
    
			
			</div>
		</section>
		
	

</div>
</body>
	<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp" %>
			</div>
		</footer>
</html>
