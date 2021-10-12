package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private SpringBoardDAO boardDAO; // alt+shift+R -> 이름 한번에 변경 가능!
	
	@Override
	public void insertBoard(BoardVO vo) {
		/*if(vo.getId()==0) {
			throw new IllegalArgumentException("id PK : 0 불가능!");
			// 런타임 예외(실행시에 발생,체크되는 예외)
		}*/
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

}
