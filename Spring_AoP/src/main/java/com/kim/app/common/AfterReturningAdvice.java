package com.kim.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

public class AfterReturningAdvice {
	public void printLog(JoinPoint jp, Object obj) {
		String name= jp.getSignature().getName();
		if(obj instanceof MemberVO) { // obj가 캐스팅이 되는지 확인부터 해야함
			MemberVO data = (MemberVO)obj;
			if(data.getRole().equals("ADMIN")) {
				System.out.println("관리자 로그인");
			}
			else {
				System.out.println("일반사용자 로그인");
			}
		}	
		System.out.println(" get()와 조합되는 리턴이이잉");

	}
}
