package model.board;

import java.util.List;

public interface BoardService {
	void insertBoard(BoardVO vo); // 메서드 시그니처
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
}
