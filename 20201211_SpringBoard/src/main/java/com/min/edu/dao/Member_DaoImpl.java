package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.Member_Dto;

@Repository
public class Member_DaoImpl implements IMember_Dao{
	
	private final String NS = "com.min.edu.dto.Member_Dto.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<Member_Dto> memberList() {
		return sqlSession.selectList(NS+"memberList");
	}

	@Override
	public boolean signUpMember(Member_Dto dto) { // 암호화
		String enPassword = passwordEncoder.encode(dto.getPw());
		dto.setPw(enPassword);
		int cnt = sqlSession.insert(NS+"signUpMember",dto);
		return cnt>0?true:false;
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		int cnt= sqlSession.selectOne(NS+"idDuplicateCheck", id);
		return cnt>0?true:false;
	}

	@Override
	public Member_Dto loginMember(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"loginMember", map);
	}

	@Override
	public String selStringPw(String id) {
		return sqlSession.selectOne(NS+"selStringPw",id);
	}

	@Override
	public Member_Dto enLogin(Map<String, Object> map) {
		Member_Dto mDto = null;
		String enPw = passwordEncoder.encode((String)map.get("pw"));
		String dbPw = sqlSession.selectOne(NS+"selStringPw",map.get("id"));
		
		if(passwordEncoder.matches((String)map.get("pw"), dbPw)) { //enPw쓰면 안되나?
			mDto = sqlSession.selectOne(NS+"enLogin",map);
		}
		
		return mDto;
	}

}
