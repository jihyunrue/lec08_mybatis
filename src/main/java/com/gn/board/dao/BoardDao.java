package com.gn.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.vo.Board;

public class BoardDao {
	
	public List<Board> selectBoardList(SqlSession session, Board option){
		return session.selectList("boardMapper.selectBoardList",option);
	}
	
	public int selectBoardCount(Board option, SqlSession session) {
		return session.selectOne("boardMapper.selectBoardCount",option);
	}
	
	public Board selectBoardOne(int boardNo, SqlSession session) {
		return session.selectOne("boardMapper.selectBoardOne",boardNo);
	}
	
	public int updateBoard(Board b,SqlSession session) {
		return session.update("boardMapper.updateBoard",b);
	}
	
	public int deleteBoard(int boardNo, SqlSession session) {
		return session.delete("boardMapper.deleteBoard",boardNo);
	}
	
	public int insertBoard(Board b, SqlSession session) {
		return session.insert("boardMapper.insertBoard",b);
	}

}
