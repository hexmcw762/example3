package kr.com.iot.service.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.com.iot.model.board.dao.BoardDAO;
import kr.com.iot.model.board.dto.BoardVO;
import kr.com.iot.model.board.dto.PageInfo;
import kr.com.iot.model.board.dto.PageVO;
import kr.com.iot.service.board.BoardService;

@Service(value="boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public int writePro(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.writePro(vo);
	}

	@Override
	public List<BoardVO> getArticles(BoardVO vo, PageVO pvo) {
		
		int startRow = (pvo.getCurrentPage()-1)*PageInfo.ROW_PER_PAGE+1;
		int endRow = startRow+PageInfo.ROW_PER_PAGE-1;
		vo.setStartRow(startRow);
		vo.setEndRow(endRow);
		return boardDAO.getArticles(vo);
	}

	@Override
	public int getAllCount() {
		// TODO Auto-generated method stub
		return boardDAO.getAllCount();
	}

	@Override
	public BoardVO getArticle(BoardVO vo) {
		
		/*
		 * boardDAO.updateReadCount(vo);
		 * 
		 * return boardDAO.getArticle(vo);
		 */
		
		BoardVO svo = new BoardVO();
		int r = boardDAO.updateReadCount(vo);
		if(r>0) {
			svo = boardDAO.getArticle(vo);
		}
		return svo;

	}

	@Override
	public int deleteArticle(BoardVO vo) {
		
		return boardDAO.deleteArticle(vo);
	}

	@Override
	public int updatePro(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.updatePro(vo);
	}

}
