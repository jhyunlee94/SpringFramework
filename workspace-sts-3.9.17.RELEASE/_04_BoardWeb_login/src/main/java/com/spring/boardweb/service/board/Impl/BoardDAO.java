package com.spring.boardweb.service.board.Impl;

import java.util.List;
import java.util.Map;

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

	public List<BoardVO> getBoardList(Map<String, String> paramMap) {
		return mybatis.selectList("BoardDAO.getBoardList", paramMap);
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
		mybatis.update("BoardDAO.updateBoardSeq", boardSeq);
	}

	public void updateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		mybatis.update("BoardDAO.updateBoard", boardVO);
	}

//	public List<BoardVO> getBoardListSearch(Map<String, String> paramMap) {
//		// TODO Auto-generated method stub
//		return mybatis.selectList("BoardDAO.getBoardListSearch", paramMap);
//	}

}
