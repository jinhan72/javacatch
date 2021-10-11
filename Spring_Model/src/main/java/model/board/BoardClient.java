package model.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {
	
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
				
		BoardService bs=(BoardService)factory.getBean("boardService");
		
		BoardVO vo=new BoardVO();
		vo.setContent("제이디비시 클래스를 이용한 실습완료");
		vo.setTitle("하이");
		vo.setWriter("나다~");
		bs.insertBoard(vo);
		
		List<BoardVO> datas=bs.getBoardList(vo);
		for(BoardVO data:datas) {
			System.out.println(data);
		}
		
		factory.close();
	}
	
}
