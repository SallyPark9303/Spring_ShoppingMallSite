package com.board.app;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.MemberVO;
import com.board.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	MemberService service;

	@Autowired
	BCryptPasswordEncoder passwordEncoder; //占쌉력뱄옙占쏙옙 占싻쏙옙占쏙옙占썲를 BCrypt占쏙옙 占쏙옙호화占쏙옙키占쏙옙 占쌕쏙옙 MemberVO占쏙옙 占싼곤옙占쌍댐옙 占쏙옙占�
	
//	@Bean
//	BCryptPasswordEncoder passwordEncoder() 
//	{
//	    return new BCryptPasswordEncoder();
//	}
	
	
	@Autowired
	MemberVO vo;
	  
	// 회占쏙옙 占쏙옙占쏙옙 get
	@GetMapping("signup")
	public void getSignup() throws Exception {
		logger.info("get signup");
	}

	// 회占쏙옙 占쏙옙占쏙옙 post
	@PostMapping("signup")
	public String postSignup(MemberVO vo) throws Exception {
	 logger.info("post signup");
	  
	 String inputPass = vo.getUserPass();
	 String pass = passwordEncoder.encode(inputPass);
	 vo.setUserPass(pass);

	 service.signup(vo);

	 return "redirect:/";
	}
	
	@GetMapping("signin")
	public void getSignin() {
		
	}
	
	@PostMapping("signin")
	public String postSignin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		 logger.info("post signin");
		   
		 MemberVO login = service.signin(vo);  
		 HttpSession session = req.getSession();
		 
		 boolean passMatch = passwordEncoder.matches(vo.getUserPass(), login.getUserPass());
		 
		 if(login != null && passMatch) {
		  session.setAttribute("member", login);
		 } else {
		  session.setAttribute("member", null);
		  rttr.addFlashAttribute("msg", false);
		  return "redirect:/member/signin";
		 }  
		 
		 return "redirect:/";
		}
		  
		// 濡쒓렇�븘�썐
		@RequestMapping(value = "/signout", method = RequestMethod.GET)
		public String signout(HttpSession session) throws Exception {
		 logger.info("get logout");
		 
		 service.signout(session);
		   
		 return "redirect:/";
		}
		
		/*
 passMatch �뒗 �궗�슜�옄媛� �엯�젰�븳 �뙣�뒪�썙�뱶�� �뜲�씠�꽣 踰좎씠�뒪�뿉 ���옣�맂 �뙣�뒪�썙�뱶瑜� 鍮꾧탳�빐�꽌 �룞�씪�븯硫� true,
  洹몃젃吏��븡�떎硫� false瑜� 諛섑솚�빀�땲�떎.
login �뿉 媛믪씠 �뾾�뒗 寃쎌슦�뒗 �븘�씠�뵒瑜� �옒紐살엯�젰�븳 寃쎌슦�씠誘�濡�, 
�븘�씠�뵒�굹 �뙣�뒪�썙�뱶媛� 紐⑤몢 留욎븘�빞 session.setAttribute("member", login);肄붾뱶媛� �떎�뻾�맗�땲�떎.
�븘�씠�뵒�굹 �뙣�뒪�썙�뱶 以� �븯�굹�씪�룄 ��由щ떎硫� else { } 遺��쓽 肄붾뱶媛� �떎�뻾�릺�뒗�뜲 
session.setAttribute("member", null); 濡� �꽭�뀡媛믪쓣 �젣嫄고븯怨� 
rttr.addFlashAttribute("msg", false); �뒗 �듅�젙 �럹�씠吏�濡� �씠�룞�맆 �븣 
msg�쓽 媛�(false)瑜� 遺��뿬�빀�땲�떎. 
�씠�븣 �듅�젙 �럹�씠吏��뒗 return "redirect:/member/signin"; 媛� �맗�땲�떎.
		 */

}
