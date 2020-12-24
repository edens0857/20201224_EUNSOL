package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.Member_Dto;

public interface IMember_Dao {

	public List<Member_Dto> memberList();
	public boolean signUpMember(Member_Dto dto);
	public boolean idDuplicateCheck(String id);
	public Member_Dto loginMember (Map<String, Object> map);
	// 암호화 
	public String selStringPw (String id);
	public Member_Dto enLogin(Map<String, Object> map);
}
