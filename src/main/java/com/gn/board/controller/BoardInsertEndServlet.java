package com.gn.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gn.board.service.BoardService;
import com.gn.board.vo.Board;

@WebServlet("/boardInsertEnd")
public class BoardInsertEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BoardInsertEndServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("parent_board_title");
		String content = request.getParameter("parent_board_content");
		
		Board b = new Board();
		b.setBoard_title(title);
		b.setBoard_content(content);
	
		int result = new BoardService().insertBoard(b); 
		System.out.println("test2");
		String resp_code = "500";
		if(result > 0) {
			resp_code = "200";
		}
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(resp_code);
		
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
