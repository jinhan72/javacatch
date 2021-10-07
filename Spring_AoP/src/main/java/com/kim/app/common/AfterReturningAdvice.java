package com.kim.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

public class AfterReturningAdvice {
	public void printLog(JoinPoint jp, Object obj) {
		String name= jp.getSignature().getName();
		if(obj instanceof MemberVO) { // obj�� ĳ������ �Ǵ��� Ȯ�κ��� �ؾ���
			MemberVO data = (MemberVO)obj;
			if(data.getRole().equals("ADMIN")) {
				System.out.println("������ �α���");
			}
			else {
				System.out.println("�Ϲݻ���� �α���");
			}
		}	
		System.out.println(" get()�� ���յǴ� ����������");

	}
}
