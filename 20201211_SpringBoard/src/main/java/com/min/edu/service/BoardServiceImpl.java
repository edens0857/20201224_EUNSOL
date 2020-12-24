package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.dao.IBoard_Dao;
import com.min.edu.dto.Board_Dto;


@Service
public class BoardServiceImpl implements IBoard_Service {

	@Autowired
	private IBoard_Dao dao;
	
	@Override
	public List<Board_Dto> selectDynamic(Map<String, String> map) {
		return dao.selectDynamic(map);
	}

	@Override
	public boolean writeBoard(Board_Dto dto) {
		return dao.writeBoard(dto);
	}
	
	@Override
	@Transactional 
	public boolean reply(Board_Dto dto) {
		boolean isc1 = dao.replyBoardUp(dto);
		boolean isc2 = dao.replyBoardIn(dto);
		return (isc1||isc2)?true:false;
	}

	@Override
	public Board_Dto getOneBoard(String seq) {
		return dao.getOneBoard(seq);
	}

	@Override
	public void readCountBoard(String seq) {
		dao.readCountBoard(seq);
	}

	@Override
	public boolean modifyBoard(Map<String, Object> map) {
		return dao.modifyBoard(map);
	}
	
	@Override
	public boolean multiDelete(String seq) {
		return dao.multiDelete(seq);
	}

	@Override
	public boolean multiDelete2(Map<String, String[]> map) {
		return dao.multiDelete2(map);
	}



}
