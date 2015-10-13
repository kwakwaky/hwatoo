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
	List<BoardModel> selectCurrentPage(@Param("startNum")	int startNum,
									   @Param("endNum")		int endNum);
	// 선택한 게시글 읽기
	BoardModel readContentByNum(int num);
	
	
	// dummy data insert
	int insertDummyData(@Param("name")		String name,
						@Param("password")	String password,
						@Param("subject")	String subject, 
						@Param("content")	String content);
	// 게시글 등록
	int writeItem(BoardModel boardModel);
	
	// 게시글 수정
	int updateItem(BoardModel boardModel);
	
}
