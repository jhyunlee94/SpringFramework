package com.spring.boardweb.service.board.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boardweb.BoardVO;
import com.spring.boardweb.service.board.BoardService;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		boardDAO.insertBoard(boardVO);
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList();
	}

	@Override
	public BoardVO getBoard(int boardSeq) {
		// TODO Auto-generated method stub
		return boardDAO.getBoard(boardSeq);
	}

	@Override
	public void updateBoardCnt(int boardSeq) {
		// TODO Auto-generated method stub
		boardDAO.updateBoardCnt(boardSeq);
		
	}

	@Override
	public void deleteBoard(int boardSeq) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(boardSeq);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(boardVO);
	}






}
