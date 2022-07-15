package com.spring.boardweb.controller.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boardweb.BoardVO;
import com.spring.boardweb.Criteria;
import com.spring.boardweb.PageVO;
import com.spring.boardweb.UserVO;
import com.spring.boardweb.service.board.BoardService;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(HttpSession session, Model model,
					@RequestParam Map<String, String> paramMap, Criteria cri) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "user/login";
		}
		
		List<BoardVO> boardList = boardService.getBoardList(paramMap, cri);
		
		int total = boardService.getBoardCnt(paramMap);
		
//		List<Map<String, String>> boardList = boardService.getBoardList();
		
		
//		for(int i = 0; i < boardList.size(); i++) {
//			System.out.println(boardList.get(i).toString());
//		}
	
//		boardList.forEach(num -> System.out.print(num));
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageMaker", new PageVO(cri, total)); // 만들어진 객체를 넘겨준다.
		
		//searchCondition 의 값이 안비어있을때
		if(paramMap.get("searchCondition") != null && !paramMap.get("searchCondition").equals("")) {
			System.out.println("searchCondition=============" + paramMap.get("searchCondition"));
			model.addAttribute("searchCondition", paramMap.get("searchCondition"));
		}
		
		return "board/getBoardList";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(HttpSession session, @RequestParam int boardSeq, Model model) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "user/login";
		}
		
		// 조회수 올려주기 위한거
		boardService.updateBoardCnt(boardSeq);
		
		BoardVO board = boardService.getBoard(boardSeq);
		//board라는 키값으로 
		model.addAttribute("board", board);
		
		return "/board/getBoard";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(HttpSession session, BoardVO boardVO) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "user/login";
		}
		
		if(boardVO.getBoardTitle() == null || boardVO.getBoardTitle().equals("")){
			//입력 내용이 없을때
			return "board/insertBoard";
		}
		
		boardService.insertBoard(boardVO);
		return "redirect:getBoardList.do";
	}
	
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(@RequestParam int boardSeq) {
		
		boardService.deleteBoard(boardSeq);
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO boardVO) {
		
		boardService.updateBoard(boardVO);
		
		//redirect:getBoardList.do 로 보내는 이유는 바로 화면으로 이동하면 게시글 목록 데이터를 조회하지 못함
		//return "board/getBoardList";
		//게시글 목록 데이터를 조회한 후에 화면으로 이동시키기 위해서
		//getBoardList.do로 보내야함
		return "redirect:getBoardList.do";
	}
	
//	//VO에 search, key그 jps 검색만든거 없기에 그냥 Map으로 받아주겠다.
//	@RequestMapping("/getBoardListSearch.do")
//	public String getBoardListSearch(@RequestParam Map<String, String> paramMap, Model model) {
//		
//		//검색을해도 리스트로 나오겠죠
//		List<BoardVO> searchBoardList = boardService.getBoardListSearch(paramMap);
//		
//		//<c:forEach> 로 boardList로 뿌려지기에 해당 부분 이용
//		model.addAttribute("boardList", searchBoardList);
//		
//		//화면은 boardBoardList에서 뿌려주면 되니까
//		return "board/getBoardList";
//	}
}
