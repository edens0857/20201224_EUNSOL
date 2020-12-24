package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.dto.Board_Dto;
import com.min.edu.dto.Member_Dto;
import com.min.edu.service.IBoard_Service;
import com.min.edu.service.IMember_Service;

@Controller
public class BoardController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBoard_Service service;
	
	// 전체조회 
	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model) {
		Map<String, String> map = new HashMap<String, String>();
		model.addAttribute("boardList", service.selectDynamic(map));
		return "boardList";
	}
	
	// 상세조회 
	@RequestMapping(value = "/boardDetail.do", method = RequestMethod.GET)
	public String boardDetail(Model model, String seq) {
		System.out.println("boardDetail 이동 완료");
		model.addAttribute("boardList",service.getOneBoard(seq));
		return "boardDetail";
	}
	
	// 글작성 폼으로 이동 
	@RequestMapping(value = "/writeForm.do",method = RequestMethod.GET)
	public String writeForm() {
		return "writeForm";
	}
	
	// 글작성 
	@RequestMapping(value = "/writeBoard.do",method=RequestMethod.POST)
	public String writeBoard(Board_Dto dto, HttpSession session) {
		Member_Dto mDto = (Member_Dto)session.getAttribute("mem");
		dto.setId(mDto.getId());
		logger.info("새글 작성 : \t {}", dto);
		boolean isc = service.writeBoard(dto);
		return isc?"redirect:/boardList.do":"redirect:/writeForm.do";
	}
	
	//글 수정 폼으로 이동
	@RequestMapping(value = "/modifyForm.do",method = RequestMethod.GET)
	public String modifyForm(Model model, String seq) {
		System.out.println("modify Form 이동 완료");
		model.addAttribute("modifyForm",service.getOneBoard(seq));
		System.out.println(seq);
		return "modifyForm";
	}
	
	//글 수정 
	@RequestMapping(value = "/modifyBoard.do", method = RequestMethod.POST)
	public String modifyValue(Model model, Board_Dto dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", dto.getSeq());
		map.put("title", dto.getTitle());
		map.put("content",dto.getContent());
		boolean isc = service.modifyBoard(map);
		System.out.println(dto.getSeq());
		return isc?"redirect:/boardDetail.do?seq="+dto.getSeq():"redirect:/modifyForm.do";
	}
	
	// 글 삭제 
	@RequestMapping(value = "/oneDelete.do",method = RequestMethod.GET)
	public String oneDelete(String seq) {
		boolean isc = service.multiDelete(seq);
		return isc?"redirect:/boardList.do":"redirect:/boardDetail.do";
	}
	
	// 다중 삭제 : 왜 삭제 됐는데 화면엔 그대로지 ?
	@RequestMapping(value = "/multiDelete.do", method = RequestMethod.GET)
	public String multiDelete(@RequestParam String[] seqs) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seqs);
		boolean isc = service.multiDelete2(map);
		System.out.println(isc);
		return isc?"redirect:/boardList.do":"redirect:/boardList.do";
	}
	
	@RequestMapping(value = "/replyForm.do", method = RequestMethod.GET)
	public String replyForm(Model model, String seq) {
//		model.addAttribute("seq", seq);
		model.addAttribute("replyForm", service.getOneBoard(seq));
		System.out.println("reply Form 이동");
		return "replyForm";
	}
	
	@RequestMapping(value = "/reply.do", method = RequestMethod.POST)
	@Transactional
	public String reply(Model model, Board_Dto dto, HttpSession session) {
		Member_Dto mDto = (Member_Dto)session.getAttribute("mem");
		dto.setId(mDto.getId());
		boolean isc = service.reply(dto);
		System.out.println("답글작성 여부 "+isc);
		return isc?"redirect:/boardList.do":"redirect:/replyForm.do";
	}
}
