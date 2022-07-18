package com.spring.boardweb.service.board.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boardweb.BoardFileVO;
import com.spring.boardweb.BoardVO;
import com.spring.boardweb.Criteria;

@Repository
public class BoardDAO {

	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		mybatis.insert("BoardDAO.insertBoard", boardVO);
	}

	public List<BoardVO> getBoardList(Map<String, String> paramMap, Criteria cri) {
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("boardSearch", paramMap);
		cri.setStartNum((cri.getPageNum() - 1) * cri.getAmount());
		pMap.put("cri", cri);
		return mybatis.selectList("BoardDAO.getBoardList", pMap);
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
		
		BoardFileVO boardFileVO = new BoardFileVO();
		boardFileVO.setBoardSeq(boardSeq);
		
		mybatis.delete("BoardDAO.deleteBoardFile", boardFileVO);
		
		mybatis.delete("BoardDAO.deleteBoard", boardSeq);
		
//		mybatis.update("BoardDAO.updateFileBoardSeq", boardSeq);
		
		mybatis.update("BoardDAO.updateBoardSeq", boardSeq);
	}

	public void updateBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		mybatis.update("BoardDAO.updateBoard", boardVO);
	}

	public int getBoardCnt(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BoardDAO.getBoardCnt", paramMap);
	}

	public int getNextBoardSeq() {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BoardDAO.getNextBoardSeq");
	}

	public void insertBoardFile(List<BoardFileVO> fileList) {
		// TODO Auto-generated method stub
		//List를 insert하는 방법
		//1. for문을 사용하여 list.size만큼 insert구문 호출
//		for(BoardFileVO boardFile : fileList) {
//			mybatis.insert("BoardDAO.insertBoardFile", boardFile);
//		}
		
		//2. mybatis의 <forEach> 태그 사용
		mybatis.insert("BoardDAO.insertBoardFile", fileList);
		
	}

	public List<BoardFileVO> getBoardFile(int boardSeq) {
		// TODO Auto-generated method stub
		return mybatis.selectList("BoardDAO.getBoardFile", boardSeq);
	}

	public void deleteBoardFile(BoardFileVO boardFileVO) {
		// TODO Auto-generated method stub
		mybatis.delete("BoardDAO.deleteBoardFile", boardFileVO);
		mybatis.update("BoardDAO.updateBoardFileSeq", boardFileVO);
	}

//	public List<BoardVO> getBoardListSearch(Map<String, String> paramMap) {
//		// TODO Auto-generated method stub
//		return mybatis.selectList("BoardDAO.getBoardListSearch", paramMap);
//	}

}
