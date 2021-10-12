package com.kim.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect // 위빙처리의 대상==포인트컷+어드바이스 결합
public class BeforeAdvice {
	
	@Before("PointcutCommon.aPointcut()")
	public void printLog(JoinPoint jp) {
		Object[] args=jp.getArgs();
		String name=jp.getSignature().getName();
		
		System.out.println("=====");
		System.out.println("핵심관심 전에 호출됨");
		System.out.println("메서드명: "+name);
		System.out.println("매개변수정보: "+args[0]);
		System.out.println("=====");
	}
	
}
