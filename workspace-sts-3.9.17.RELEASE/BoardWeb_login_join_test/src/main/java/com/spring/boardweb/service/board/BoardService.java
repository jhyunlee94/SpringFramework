package com.spring.boardweb.service.board;

import java.util.List;

import com.spring.boardweb.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO boardVO);

	List<BoardVO> getBoardList();

	BoardVO getBoard(int boardSeq);

	void updateBoardCnt(int boardSeq);

	void deleteBoard(int boardSeq);

	void updateBoard(BoardVO boardVO);

}
