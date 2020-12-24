package com.min.edu.service;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.Board_Dto;

public interface IBoard_Service {

	public List<Board_Dto> selectDynamic(Map<String, String> map);

	public boolean writeBoard(Board_Dto dto);

	public boolean reply(Board_Dto dto);
	
	public Board_Dto getOneBoard(String seq);
	
	public void readCountBoard(String seq);
	
	public boolean modifyBoard(Map<String, Object> map);
	
	public boolean multiDelete(String seq);
	
	public boolean multiDelete2(Map<String, String[]> map);
	
	
}
