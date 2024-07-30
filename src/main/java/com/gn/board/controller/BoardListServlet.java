package com.gn.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Board;


@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BoardListServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board option = new Board();
		
		String orderType = request.getParameter("order_type");
		option.setOrder_type(orderType);
		
		String boardTitle = request.getParameter("board_title");
		option.setBoard_title(boardTitle);
		
		String boardContent = request.getParameter("board_content");
		option.setBoard_content(boardContent);
		
		String nowPage = request.getParameter("nowPage");
		if(nowPage != null) {
			option.setNowPage(Integer.parseInt(nowPage));
		}
		
		option.setTotalData(new BoardService().selectBoardCount(option));
		
		// Board 목록 조회(mybatis)해서 화면으로 전달(jstl)
		List<Board> resultList = new BoardService().selectBoardList(option);	
		request.setAttribute("paging", option);
		request.setAttribute("resultList", resultList);
		RequestDispatcher view = request.getRequestDispatcher("/views/board/list.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
