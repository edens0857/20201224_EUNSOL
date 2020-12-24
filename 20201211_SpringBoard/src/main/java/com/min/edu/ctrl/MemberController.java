package com.min.edu.ctrl;

import java.lang.annotation.Retention;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.dto.Member_Dto;
import com.min.edu.service.IMember_Service;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IMember_Service service;
	
	@RequestMapping(value = "/signUpForm.do", method = RequestMethod.GET)
	public String signUpForm(){
		logger.info("회원 가입 폼으로 이동: \t {}", new Date());
		return "signUpForm";
	}
	
	@RequestMapping(value = "/signUp.do",method = RequestMethod.POST)
	public String signUp(Member_Dto dto, @RequestParam("password")String pw) {
		dto.setPw(pw);
		boolean isc = service.signUpMember(dto);
		logger.info("회원가입 : \t {}", dto);
		return isc?"redirect:/loginForm.do":"redirect:/signUpForm.do";
	}
	
	@RequestMapping(value="/idDuplicateForm.do",method=RequestMethod.GET)
	public String idDuplicateForm() {
		logger.info("아이디 중복 검사");
		return "idDuplicateForm";
	}
	
	@RequestMapping(value = "/idDuplicateCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> idDuplicateCheck(String id) {
		Map<String, String> map = new HashMap<String, String>();
		boolean isc = service.idDuplicateCheck(id);
		logger.info("아이디 중복 체크 : 컨트롤러 {}",id);
		map.put("isc", String.valueOf(isc));
		logger.info("true값 테스트 : 컨트롤러 {}",isc);
		return map;
	}
	
	@RequestMapping(value = "/loginForm.do", method=RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}

	@RequestMapping(value="/enLogin.do", method=RequestMethod.POST)
	public String enLogin(@RequestParam Map<String, Object> map, HttpSession session) {
		Member_Dto mDto = service.enLogin(map);
		session.setAttribute("mem", mDto);
		return "redirect:/boardList.do";
	}
}
