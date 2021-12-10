package kr.com.iot.web.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.com.iot.model.board.dto.BoardVO;
import kr.com.iot.model.board.dto.PageInfo;
import kr.com.iot.model.board.dto.PageVO;
import kr.com.iot.service.board.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/writeForm")
	public String writeForm(HttpServletRequest request,HttpServletResponse response,
							Model model, BoardVO vo,PageVO pvo) {
		
		logger.info(""+vo.toString());
		if(vo != null && vo.getNum() != 0 && vo.getRef()!=0) {
			model.addAttribute("dto",vo);
		}
		return "board/writeForm";
	}
	
	@RequestMapping("/writePro")
	public String writePro(HttpServletRequest request,HttpServletResponse response, 
			Model model, BoardVO vo,PageVO pvo) {
		
		vo.setIp(request.getRemoteAddr());

		int r = boardService.writePro(vo);
		String msg,url;
		if(r > 0) {
			msg="게시글 저장";
		}else {
			msg="게시글 실패";
		}
	
		url="list";
		
		model.addAttribute("msg",msg);
		model.addAttribute("url",url);
	
		return "board/MsgPage";
		//return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,HttpServletResponse response, Model model, BoardVO vo,PageVO pvo) {
		
		if(pvo.getCurrentPage()==0) {
			pvo.setCurrentPage(1);
		}
		if(pvo.getCurrentBlock()==0) {
			pvo.setCurrentBlock(1);
		}
		
		pvo.setAllCount(boardService.getAllCount());
		List<BoardVO> list = boardService.getArticles(vo,pvo);
		
		if(pvo.getAllCount() % PageInfo.ROW_PER_PAGE==0) {
			pvo.setPagAllCnt(pvo.getAllCount()/ PageInfo.ROW_PER_PAGE);
		}else {
			pvo.setPagAllCnt(pvo.getAllCount()/ PageInfo.ROW_PER_PAGE+1);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("pvo",pvo);
		return "board/list";
	}
	
	@RequestMapping("/content")
	public String content(HttpServletRequest request,HttpServletResponse response, Model model, BoardVO vo,PageVO pvo) {
	
		if(pvo.getCurrentPage()==0) {
			pvo.setCurrentPage(1);
		}
		if(pvo.getCurrentBlock()==0) {
			pvo.setCurrentBlock(1);
		}
		logger.info(""+vo.toString());
		BoardVO svo = boardService.getArticle(vo);
		logger.info(""+svo.toString());
		model.addAttribute("dto",svo);
		model.addAttribute("pvo",pvo);
		return "board/content";
	}
	
	@RequestMapping("/deleteForm")
	public String deleteForm(HttpServletRequest request,HttpServletResponse response, Model model, BoardVO vo,PageVO pvo) {
		
		if(pvo.getCurrentPage()==0) {
			pvo.setCurrentPage(1);
		}
		if(pvo.getCurrentBlock()==0) {
			pvo.setCurrentBlock(1);
		}
		
		int r = boardService.deleteArticle(vo);
		String msg,url;
		if(r > 0) {
			msg="게시글 삭제";
		}else {
			msg="게시글 실패";
		}
	
		url="list";
		
		model.addAttribute("msg",msg);
		model.addAttribute("url",url);
		model.addAttribute("pvo",pvo);
	
		return "board/MsgPage";
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(HttpServletRequest request,HttpServletResponse response, Model model, BoardVO vo,PageVO pvo) {
	
		model.addAttribute("dto",vo);
		model.addAttribute("pvo",pvo);	
		return "board/updateForm";
	}
	
	@RequestMapping("/updatePro")
	public String updatePro(HttpServletRequest request,HttpServletResponse response, Model model, BoardVO vo,PageVO pvo) {
	
		if(pvo.getCurrentPage()==0) {
			pvo.setCurrentPage(1);
		}
		if(pvo.getCurrentBlock()==0) {
			pvo.setCurrentBlock(1);
		}
		vo.setIp(request.getRemoteAddr());
		int r = boardService.updatePro(vo);
		String msg,url;
		if(r>0) {
			msg ="업데이트 성공";
		}else {
			msg = "업데이트 실패";
		}
		url ="list?currentPage="+pvo.getCurrentPage();
		model.addAttribute("msg",msg);
		model.addAttribute("url",url);
		model.addAttribute("pvo",pvo);	
		return "board/MsgPage";
	}
	
}
