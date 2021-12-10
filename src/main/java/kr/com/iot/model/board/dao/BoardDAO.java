package kr.com.iot.model.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.com.iot.model.board.dto.BoardVO;

@Mapper
public interface BoardDAO {

	public List<BoardVO> getArticles(BoardVO vo);

	public int writePro(BoardVO vo);

	public int getAllCount();

	public BoardVO getArticle(BoardVO vo);

	public int updateReadCount(BoardVO vo);

	public int deleteArticle(BoardVO vo);

	public int updatePro(BoardVO vo);
}
