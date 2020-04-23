<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body>
<style>

#loginBtn {font-size:20px; }
#joinBtn{font-size:20px;}

</style>

</body>
<ul>
<c:if test="${member == null}">
 <li>
  <a href="/member/signin" id="loginBtn">가로세로 회원이세요?</a>
 </li>
 <li>
  <a href="/member/signup" id="joinBtn">처음이세요? 회원가입하기</a>
 </li>
</c:if>
<c:if test="${member != null}">
<c:if test="${member.verify==3 }">
 <li>
 <a href="/admin/index">관리자 화면</a>
 </li>
 </c:if>
 <li>  
  ${member.userName}님 환영합니다.

 </li>
 <li>
 <a href="/shop/cartList">카트 리스트</a>
 </li>
 <li>
  <a href="/member/signout">로그아웃</a>
 </li>
</c:if>
</ul>