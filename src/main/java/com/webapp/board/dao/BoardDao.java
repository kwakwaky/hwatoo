package com.webapp.board.dao;

import java.util.List;

import com.webapp.board.mapper.BoardMapper;
import com.webapp.board.model.BoardModel;

public class BoardDao implements BoardMapper{
	
	BoardMapper boardMapper;

	public void setBoardMapper(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	
	@Override
	public int totalCount() {
		return boardMapper.totalCount();
	}

	@Override
	public List<BoardModel> selectAll() {
		return boardMapper.selectAll();
	}

	@Override
	public List<BoardModel> selectCurrentPage(int startNum, int endNum) {
		return boardMapper.selectCurrentPage(startNum, endNum);
	}


	@Override
	public int insertDummyData(String name,
							   String password,
							   String subject, 
							   String content) {
		return boardMapper.insertDummyData(name, password, subject, content);
	}

	// 선택한 게시글 읽기
	@Override
	public BoardModel readContentByNum(int num) {
		return boardMapper.readContentByNum(num);
	}

	// 게시글 등록
	@Override
	public int writeItem(BoardModel boardModel) {
		return boardMapper.writeItem(boardModel);
	}
	

	

	

}
