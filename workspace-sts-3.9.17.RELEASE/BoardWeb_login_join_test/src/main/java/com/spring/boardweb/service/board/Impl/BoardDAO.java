package com.spring.boardweb.service.board.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boardweb.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		mybatis.insert("BoardDAO.insertBoard", boardVO);
	}

	public List<BoardVO> getBoardList() {
		return mybatis.selectList("BoardDAO.getBoardList");
	}

	public BoardVO getBoard(int boardSeq) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BoardDAO.getBoard", boardSeq);
		//BoardDAO namespace에 getBoard라는 쿼리문을 만드는데, parameter로 boardSeq를 담아서 보낸다.
	}

	public void updateBoardCnt(int boardSeq) {
		// TODO Auto-generated method stub
		mybatis.update("BoardDAO.updateBoardCnt", boardSeq);
	}

	public void deleteBoard(int boardSeq) {
		// TODO Auto-generated method stub
		mybatis.delete("BoardDAO.deleteBoard", boardSeq);
	}

	public void updateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		mybatis.update("BoardDAO.updateBoard", boardVO);
	}

}
