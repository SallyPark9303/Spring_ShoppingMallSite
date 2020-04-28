package com.board.app;



import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.domain.CartListVO;
import com.board.domain.CartVO;
import com.board.domain.GoodsViewVO;
import com.board.domain.MemberVO;
import com.board.domain.OrderDetailVO;
import com.board.domain.OrderListVO;
import com.board.domain.OrderVO;
import com.board.domain.ReplyListVO;
import com.board.domain.ReplyVO;

@Controller
@RequestMapping("/shop/*")
public class ShopController {
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired
	com.board.service.shopService shopService;
	 
	
	// 카테고리별 상품 리스트
	 @GetMapping("/list")
	 public void getList(@RequestParam("c") int cateCode,
	      @RequestParam("l") int level, Model model) throws Exception {
	  logger.info("get llist");
	  
	  List<GoodsViewVO> list = null;
	  list = shopService.list1(cateCode);
	 
	  model.addAttribute("list", list);
	  
	 }
	 //상품조회
 @GetMapping("/view")
	public void getView(@RequestParam("n") int gdsNum, Model model) throws Exception {
			 logger.info("get view");
			 
		 GoodsViewVO view = shopService.goodsView(gdsNum);
			 model.addAttribute("view", view);
		 
		 //상품 소감 리스트
		 List<ReplyListVO> replylist = shopService.replylist(gdsNum);

  		   model.addAttribute("replylists", replylist);

	 }
	 
	 //상품 소감 작성
	
	 @PostMapping("/view")
	 public String registerReply(ReplyVO reply, HttpSession session) {
		
		 
		 MemberVO member =(MemberVO)session.getAttribute("member"); 
		 //HttpSession을 이용하여 현재세션에 저장되어있는 유저아이디값을 얻음
		 reply.setUserId(member.getUserId()); //reply.userId에 member의 userId값을 넣음
		System.out.println("GDSNUM : " + reply.getGdsNum());
		 shopService.registerReply(reply);

		 return "redirect:/shop/view?n=" +reply.getGdsNum(); 
		 //상품번호(소감을 썼던 번호를 달고 view로 이동)
	 }
	 
	 //상품 소감 목록

//	 @GetMapping("view/")
//	 public List<ReplyListVO> getReplyList(@RequestParam("n") int gdsNum, Model model){
//		 
//		 GoodsViewVO view =shopService.goodsView(gdsNum);
//		 model.addAttribute("view", view);
//		 
//		 List<ReplyListVO> reply = shopService.replylist(gdsNum);
//		 model.addAttribute("reply", reply);
//	 
//	 return reply;
//	 
//	}
	 
	// 상품 소감(댓글) 삭제
	 @ResponseBody
	 @PostMapping("/view/deleteReply")
	 public int getReplyList(ReplyVO reply,  HttpSession session) throws Exception {
	  logger.info("post delete reply");

	  int result = 0;
	  
	  MemberVO member = (MemberVO)session.getAttribute("member");
	  String userId = shopService.idCheck(reply.getRNum());
	    
	  if(member.getUserId().equals(userId)) {
	   
	   reply.setUserId(member.getUserId());
	   shopService.deleteReply(reply);
	   
	   result = 1;
	  }
	  
	  return result; 
	 }
	 
	 
	 //카트 담기
	 @ResponseBody //Ajax를 사용
	 @PostMapping("/view/addCart")
	 public int addCart(CartVO cart, HttpSession session) {
		int result= 0;
		 
		 MemberVO member =(MemberVO)session.getAttribute("member"); 
		 
		 if(member !=null) {
			 cart.setUserId(member.getUserId());
		     shopService.addCart(cart);
		     result=1;
		 }
		 
	return result;
	 }

	 
	 //카트 목록
	 @GetMapping("/cartList")
	 public void getCartList(HttpSession session, Model model) {
		 
		 MemberVO member =(MemberVO)session.getAttribute("member");
		 String userId= member.getUserId();
		 
		 List<CartListVO> cartList = shopService.cartList(userId);
		 
		 model.addAttribute("cartList", cartList);	 
}
	 
	 //카트 삭제
	 @ResponseBody
	 @PostMapping("/cartList/deleteCart")
	 public int deleteCart(HttpSession session, @RequestParam(value ="chbox[]")List<String> chArr, CartVO cart) {
		 
		 
		 MemberVO member = (MemberVO)session.getAttribute("member");
		 String userId = member.getUserId();
		 
		 int result = 0;
		 int cartNum = 0;
		 
		 
		 if(member != null) {
		  cart.setUserId(userId);
		  
		  for(String i : chArr) {   
		   cartNum = Integer.parseInt(i);
		   cart.setCartNum(cartNum);
		  shopService.deleteCart(cart);
		  }   
		  result = 1;
		 }  
		 return result;   
		 
	 }
	 
	 //주문
	 @PostMapping("/cartList")
	 public String order(HttpSession session, OrderVO order, OrderDetailVO orderDetail) {
		 
		 MemberVO member = (MemberVO)session.getAttribute("member");
		 String userId = member.getUserId();
		 
		 
		 Calendar cal = Calendar.getInstance(); //달력 메서드를 이용해 연/월/일 추출
		 int year= cal.get(Calendar.YEAR);
		 
		 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) +1);
	     //DecimalFormat("00"): 두자릿 수로 자릿수 채우기  ex) 01,11	 
	
		 String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		 String subNum = "";
		 
		 for(int i=1; i <= 6; i ++) {
			 subNum += (int)(Math.random()* 10); //6자리의 랜덤 숫자인 subNum
			 
		 }
		 
		 String orderId = ymd + "_" + subNum; // [날짜]_[랜덤숫자]로 이루어진  고유의 문자열 생성
		 
		 order.setOrderId(orderId);
		 order.setUserId(userId);
		 
		 shopService.orderInfo(order);
		 
		 orderDetail.setOrderId(orderId);
		 shopService.orderInfo_Details(orderDetail);
		 
		 shopService.cartAllDelete(userId);
		 
		 return "redirect:/shop/orderList"; 
	 }
	 //주문 목록
	 @GetMapping("/orderList")
	 public void orderList(HttpSession session, OrderVO order, Model model) {
		 
		 
		 MemberVO member = (MemberVO)session.getAttribute("member"); 
		 String userId = member.getUserId();
		 System.out.println(userId);
		 
		 order.setUserId(userId);
		 List<OrderVO> orderList = shopService.orderList(order);
		 
		 model.addAttribute("orderList", orderList);
		 
	 }
	 
	 //주문 상세 목록
	 @GetMapping("/orderView")
	 public void orderList(@RequestParam("n") String orderId, HttpSession session, OrderVO order, Model model) {
		 
		 
		 MemberVO member = (MemberVO)session.getAttribute("member"); //"n"값을 들고와서 orderId로 사용
		 String userId = member.getUserId();
		 
		 order.setUserId(userId);
		 order.setOrderId(orderId);
		 System.out.println(orderId);
		 
		 List<OrderListVO> orderView = shopService.orderView(order);
		 
		 model.addAttribute("orderView", orderView);
		 
	 }
	 

}
	

