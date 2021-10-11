package com.kim.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("pjp���ڸ� ���� �޼��忡�� ����ϴ� ���� -1");
		System.out.println("�޼����: "+pjp.getSignature().getName());
		StopWatch sw=new StopWatch();
		
		sw.start();
		
		Object obj = pjp.proceed();
		
		sw.stop();
		
		System.out.println("�ҿ�ð�: "+sw.getTotalTimeMillis());
		System.out.println("pjp���ڸ� ���� �޼��忡�� ����ϴ� ���� -2");
		return obj;
	}
}
