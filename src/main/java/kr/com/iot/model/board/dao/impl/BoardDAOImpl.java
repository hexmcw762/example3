package kr.com.iot.model.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.com.iot.model.board.dao.BoardDAO;
import kr.com.iot.model.board.dto.BoardVO;

@Repository(value="boardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	String namespace="kr.com.iot.model.board.dao.BoardDAO.";

	@Override
	public List<BoardVO> getArticles(BoardVO vo) {
		
		return sqlSession.selectList(namespace+"getArticles",vo);
	}

	@Override
	public int writePro(BoardVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+"writePro",vo);
	}

	@Override
	public int getAllCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getAllCount");
	}

	@Override
	public BoardVO getArticle(BoardVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getArticle",vo);
	}

	@Override
	public int updateReadCount(BoardVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"updateReadCount",vo);
	}

	@Override
	public int deleteArticle(BoardVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+"deleteArticle",vo);
	}

	@Override
	public int updatePro(BoardVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"updatePro",vo);
	}
	
	
}
