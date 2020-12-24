package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dao.IMember_Dao;
import com.min.edu.dto.Member_Dto;

@Service
public class MemberServiceImpl implements IMember_Service {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IMember_Dao dao;
	
	@Override
	public List<Member_Dto> memberList() {
		logger.info("회원 목록 조회 memberList");
		return dao.memberList();
	}

	@Override
	public boolean signUpMember(Member_Dto dto) {
		logger.info("회원가입 signUpMember:{}", dto);
		return dao.signUpMember(dto);
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		logger.info("아이디 중복 체크 idDuplicateCheck:{}",id);
		return dao.idDuplicateCheck(id);
	}

	@Override
	public Member_Dto loginMember(Map<String, Object> map) {
		logger.info("로그인 loginMember");
		return dao.loginMember(map);
	}

	@Override
	public String selStringPw(String id) {
		logger.info("암호화 된 비밀번호 selStringPw");
		return dao.selStringPw(id);
	}

	@Override
	public Member_Dto enLogin(Map<String, Object> map) {
		logger.info("암호화 된 enLogin");
		return dao.enLogin(map);
	}

}
