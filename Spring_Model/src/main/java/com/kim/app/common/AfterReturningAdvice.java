package com.kim.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import model.member.MemberVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="PointcutCommon.cPointcut()",returning="obj")
	public void printLog(JoinPoint jp,Object obj) {
		String name=jp.getSignature().getName();
		System.out.println("�޼����: "+name);
		if(obj instanceof MemberVO) {
			MemberVO data=(MemberVO)obj;
			if(data.getRole().equals("ADMIN")) {
				System.out.println("������ �α���");
			}
			else {
				System.out.println("�Ϲݻ���� �α���");
			}
		}
	}
}
