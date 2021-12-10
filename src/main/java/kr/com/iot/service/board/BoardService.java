package kr.com.iot.service.board;

import java.util.List;

import kr.com.iot.model.board.dto.BoardVO;
import kr.com.iot.model.board.dto.PageVO;

public interface BoardService {

	public List<BoardVO> getArticles(BoardVO vo, PageVO pvo);

	public int writePro(BoardVO vo);

	public int getAllCount();

	public BoardVO getArticle(BoardVO vo);

	public int deleteArticle(BoardVO vo);

	public int updatePro(BoardVO vo);
}
