package com.kim.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

public class AfterThrowingAdvice {
	public void printLog(JoinPoint jp, Exception excep) {
		String name= jp.getSignature().getName();
		System.out.println("���ܹ߻��� ȣ���");
	}
}
