package com.gn.board.service;

import static com.gn.common.SessionTemplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Board;

public class BoardService {
	
	public List<Board> selectBoardList( Board option){
		SqlSession session = getSqlSession();
		List<Board> resultList = new BoardDao().selectBoardList(session,option);
		session.close();
		return resultList;
 	}
	
	public int selectBoardCount(Board option) {
		SqlSession session = getSqlSession();
		int count = new BoardDao().selectBoardCount(option,session);
		session.close();
		return count;
	}
	
	public Board selectBoardOne(int boardNo) {
		SqlSession session = getSqlSession();
		Board detail = new BoardDao().selectBoardOne(boardNo,session);
		session.close();
		return detail;
	}
	
	public int updateBoard(Board b) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().updateBoard(b,session);
		session.close(); 
		return result;
	}
	
	public int deleteBoard(int boardNo) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().deleteBoard(boardNo,session);
		session.close();
		return result;
	}
	
	public int insertBoard(Board b) {
		SqlSession session = getSqlSession();
		int result = new BoardDao().insertBoard(b,session);
		session.close();
		return result;
	}
}
