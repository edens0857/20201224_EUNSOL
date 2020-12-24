package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.Board_Dto;

@Repository
public class BoardDaoImpl implements IBoard_Dao {
	
	private final String NS ="com.min.edu.dto.Board_Dto."; 

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Board_Dto> selectDynamic(Map<String, String> map) {
		return sqlSession.selectList(NS+"selectDynamic",map);
	}

	@Override
	public boolean writeBoard(Board_Dto dto) {
		int cnt = sqlSession.insert(NS+"writeBoard", dto);
		return cnt>0?true:false;
	}

	@Override
	public boolean replyBoardUp(Board_Dto dto) {
		int cnt = sqlSession.insert(NS+"replyBoardUp", dto);
		return cnt>0?true:false;
	}

	@Override
	public boolean replyBoardIn(Board_Dto dto) {
		int cnt = sqlSession.insert(NS+"replyBoardIn", dto);
		return cnt>0?true:false;
	}

	@Override
	public Board_Dto getOneBoard(String seq) {
		return sqlSession.selectOne(NS+"getOneBoard",seq);
	}

	@Override
	public void readCountBoard(String seq) {
		sqlSession.update(NS+"readCountBoard", seq);
	}

	@Override
	public boolean modifyBoard(Map<String, Object> map) {
		int cnt = sqlSession.insert(NS+"modifyBoard", map);
		return cnt>0?true:false;
	}

	@Override
	public boolean multiDelete(String seq) {
		int cnt = sqlSession.update(NS+"multiDelete", seq);
		return cnt>0?true:false;
	}
	
	@Override
	public boolean multiDelete2(Map<String, String[]> map) {
		int cnt = sqlSession.update(NS+"multiDelete2", map);
		return cnt>0?true:false;
	}


	
	
}
