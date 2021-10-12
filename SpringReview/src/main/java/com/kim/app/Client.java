package com.kim.app;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.board.BoardService;
import model.board.BoardVO;
import model.member.MemberService;
import model.member.MemberVO;

public class Client {

	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms=(MemberService)factory.getBean("memberService");

		MemberVO vo=new MemberVO();
		vo.setId("admin");
		vo.setPassword("12345");
		MemberVO data=ms.getMember(vo);

		if(data!=null) {
			// 로그인 성공
			System.out.println("로그인 성공!");
		}
		else {
			// 로그인 실패
			System.out.println("로그인 실패!");
		}
		
		BoardService bs=(BoardService)factory.getBean("boardService");
		
		BoardVO vo2=new BoardVO();
		vo2.setContent("jdbcTemplate 클래스를 이용한 실습완료");
		vo2.setTitle("제목입니다!");
		vo2.setWriter("관리자");
		bs.insertBoard(vo2);
		
		vo2.setTitle("입니다!");
		List<BoardVO> datas=bs.getBoardList(vo2);
		System.out.println("==검색결과==");
		for(BoardVO v:datas) {
			System.out.println(v);
		}
		System.out.println("=====");
		
		factory.close();
	}

}
