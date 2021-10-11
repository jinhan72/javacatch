package com.kim.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("pjp인자를 갖는 메서드에서 출력하는 문구 -1");
		System.out.println("메서드명: "+pjp.getSignature().getName());
		StopWatch sw=new StopWatch();
		
		sw.start();
		
		Object obj = pjp.proceed();
		
		sw.stop();
		
		System.out.println("소요시간: "+sw.getTotalTimeMillis());
		System.out.println("pjp인자를 갖는 메서드에서 출력하는 문구 -2");
		return obj;
	}
}
