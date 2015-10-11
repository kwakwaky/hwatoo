package com.webapp.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.webapp.board.model.BoardModel;

public interface BoardMapper {
	
	// 모든 게시글의 수
	int totalCount();
	
	// 모든 게시글 집합
	List<BoardModel> selectAll();
	// 현재 페이지 게시글 집합
	List<BoardModel> selectCurrentPage(@Param("startNum") int startNum, @Param("endNum") int endNum);
}
