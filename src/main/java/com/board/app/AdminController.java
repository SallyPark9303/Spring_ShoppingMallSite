package com.board.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.board.domain.CategoryVO;
import com.board.domain.GoodsVO;
import com.board.domain.GoodsViewVO;
import com.board.domain.OrderListVO;
import com.board.domain.OrderVO;
import com.board.domain.ReplyListVO;
import com.board.domain.ReplyVO;
import com.board.service.AdminService;
import com.board.utils.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	AdminService adminService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	//관리자 화면
	@GetMapping("index") 
		public void getIndex() {
		logger.info("get index");
		}	
	
	//상품카테고리등록

	@GetMapping("goods/register")
	public void getGoodsRegister(Model model) throws Exception {

		logger.info("get goods register");
		 List<CategoryVO> category = null;
		 category = adminService.category();
		 model.addAttribute("category", 
				 JSONArray.fromObject(category));
		 
	} //CategoryVO 형태의 List변수 category를 선언하고 adminService.category() 를 호출한 뒤
	    // 결과값을 category에 입력,, JSONArray를 이용해 category  category를 JSON타입으로 변경한 뒤, 
	      //category라는 명칭으로 모델에 추가.이 메서드(getGoodsRegister)가 호출 될 때 모델을 jsp에 넘겨서 사용
	
	@PostMapping("goods/register")
	public String postGoodsRegister(GoodsVO vo, MultipartFile file) throws Exception {


		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		
		 // gdsImg에 원본 파일 경로 + 파일명 저장
		  vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  // gdsThumbImg에 썸네일 파일 경로 + 썸네일 파일명 저장
		  vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "noimg.PNG";
		

		vo.setGdsImg(fileName);
		vo.setGdsThumbImg(fileName);
		}
		adminService.register(vo);
		
		return "redirect:/admin/index";

	}	  
	
	//상품 목록
	@GetMapping("goods/list")
	public void getGoodList(Model model) {
		logger.info("get goods list");
		List<GoodsViewVO> list = adminService.goodslist();
		model.addAttribute("list",list);	
	}
	//상품 조회
	@GetMapping("goods/view")
	public void getGoodView(@RequestParam("n") int gdsNum, Model model) {
		logger.info("get goods view");
		GoodsViewVO goods = adminService.goodsview(gdsNum);
		model.addAttribute("goods",goods);
		//매개변수 @RequestParam("n") int gbsNum 은 url주소에서 "n"을 찾아서 int gdsNum에 전달합니다. 
		//목록에서 링크 주소를 /admin/goods/view?n=[상품번호] 형식으로 했기 떄문에 n를 찾는것이며,
		//만약 다른 문자로 했다면 그 문자로 해야합니다.
	}
	
	//상품 삭제
	@PostMapping("goods/delete")
	public String postGoodsDelete(@RequestParam("n") int gdsNum) {
		
		adminService.goodsdelete(gdsNum);
		
		return "redirect:/admin/index";
		
	}
	//상품수정
	@GetMapping("goods/modify")
	public void getGoodsModify(@RequestParam("n") int gdsNum, Model model) {
		GoodsViewVO goods = adminService.goodsview(gdsNum);
		model.addAttribute("goods",goods);
		
		List<CategoryVO> category = null;
		category = adminService.category();
        model.addAttribute("category", JSONArray.fromObject(category));		
		
	}
	@PostMapping("goods/modify")
public String getGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws  Exception {
		//새로운 파일이 등록됬는지 확인
		if(file.getOriginalFilename() !=null && file.getOriginalFilename()!="") {
			//기존 파일 삭제
			new File(uploadPath +req.getParameter("gdsImg")).delete();
			new File(uploadPath +req.getParameter("gdsThumbImg")).delete();
			
			//새로 첨부한 파일 등록
			
			String imgUploadPath = uploadPath + File.separator +"imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		

					  vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
					  vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
					  
					 } else {  // 새로운 파일이 등록되지 않았다면
					  // 기존 이미지를 그대로 사용
					  vo.setGdsImg(req.getParameter("gdsImg"));
					  vo.setGdsThumbImg(req.getParameter("gdsThumbImg"));
					  
					 }
		
		adminService.goodsmodify(vo);
		return "redirect:/admin/index";

	
	}
	//ck 에디터에서 파일 업로드
	@PostMapping("goods/ckUpload")
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res,
	@RequestParam MultipartFile upload) throws Exception{
		 // 랜덤 문자 생성
		 UUID uid = UUID.randomUUID();
		 
		 OutputStream out = null;
		 PrintWriter printWriter = null;
		   
		 // 인코딩
		 res.setCharacterEncoding("utf-8");
		 res.setContentType("text/html;charset=utf-8");
		 
		 try {
		  
		  String fileName = upload.getOriginalFilename();  // 파일 이름 가져오기
		  byte[] bytes = upload.getBytes();
		  
		  // 업로드 경로
		  String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
		  
		  out = new FileOutputStream(new File(ckUploadPath));
		  out.write(bytes);
		  out.flush();  // out에 저장된 데이터를 전송하고 초기화
		  
		  String callback = req.getParameter("CKEditorFuncNum");
		  printWriter = res.getWriter();
		  String fileUrl = "/ckUpload/" + uid + "_" + fileName;  // 작성화면
		  
		  // 업로드시 메시지 출력
//		  printWriter.println("<script type='text/javascript'>"
//		     + "window.parent.CKEDITOR.tools.callFunction("
//		     + callback+",'"+ fileUrl+"','이미지를 업로드하였습니다.')"
//		     +"</script>");
		  
		  printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
		  
		  
		  printWriter.flush();
		  
		 } catch (IOException e) { e.printStackTrace();
		 } finally {
		  try {
		   if(out != null) { out.close(); }
		   if(printWriter != null) { printWriter.close(); }
		  } catch(IOException e) { e.printStackTrace(); }
		 }
		 
		 return; 
		}
		
	// 주문 목록
	@GetMapping("/shop/orderList")
	public void getOrderList(Model model) throws Exception {
	 logger.info("get order list");
	   
	 List<OrderVO> orderList = adminService.orderList();
	 
	 model.addAttribute("orderList", orderList);
	}

	// 주문 상세 목록
	@GetMapping("/shop/orderView")
	public void getOrderView(@RequestParam("n") String orderId,
	      OrderVO order, Model model) throws Exception {
	 logger.info("get order view");
	 
	 order.setOrderId(orderId);  
	 List<OrderListVO> orderView = adminService.orderView(order);
	 
	 model.addAttribute("orderView", orderView);
	}
	//배송 상태 
	@PostMapping("/shop/orderView")
	public String postOrderView(OrderVO order) {
		
		
		
		adminService.delivery(order);
		
		//상품 수량 업데이트
	   List<OrderListVO> orderView =adminService.orderView(order);
		
		GoodsVO goods = new GoodsVO();
		
		for(OrderListVO i : orderView) {
			 goods.setGdsNum(i.getGdsNum());
			 goods.setGdsStock(i.getCartStock());
			
			 adminService.changestock(goods);			
		}
		
		
		return "redirect:/admin/shop/orderView?n=" + order.getOrderId();
       

	
	}
	
	//모든 소감 댓글 목록
	@GetMapping("/shop/allReply")
	public void getAllReply(Model model) throws Exception {
		 logger.info("get all reply");
		   
		 List<ReplyListVO> reply = adminService.replylist();
		 
		 model.addAttribute("reply", reply);

	}
	
	//모든 소감 댓글 삭제
	
	@PostMapping("/shop/allReply")
	public String deleteReply(ReplyVO reply) {
		
		adminService.replydelete(reply.getRNum());
		
		return "redirect:/admin/shop/allReply";
	}
	

	
}

