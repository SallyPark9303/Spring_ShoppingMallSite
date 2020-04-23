package com.board.app;



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
//			 System.out.println("replylist :" + replylist.get(0).getUserName());
//			 System.out.println("replylist :" + replylist.get(0).getRDate());
//			 System.out.println("replylist :" + replylist.get(1).getRContent());
  		   model.addAttribute("replylists", replylist);
// 소감 목록을 읽어오는 메서드가 따로 생성되어서 상품 조회용 메서드에 있는 소감 목룍 부분은 이제 필요 없음.	 
		 
	 }
	 
	 //상품 소감
	 @ResponseBody
	 @PostMapping("/view/registerReply")
	 public void registerReply(ReplyVO reply, HttpSession session) {
		 MemberVO member =(MemberVO)session.getAttribute("member"); 
		 //HttpSession을 이용하여 현재세션에 저장되어있는 유저아이디값을 얻음
		 reply.setUserId(member.getUserId()); //reply.userId에 member의 userId값을 넣음
		System.out.println("GDSNUM : " + reply.getGdsNum());
		 shopService.registerReply(reply);
		 
		 //return "redirect:/shop/view?n=" +reply.getGdsNum(); 
		 //상품번호(소감을 썼던 번호를 달고 view로 이동)
	 }
	 
	 //상품 소감 목록
	 @ResponseBody
	 @GetMapping("view/replyList")
	 public List<ReplyListVO> getReplyList(@RequestParam("n") int gdsNum){
	
	 List<ReplyListVO> reply = shopService.replylist(gdsNum);
	 
	 return reply;
	 
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
}
	

