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

}
