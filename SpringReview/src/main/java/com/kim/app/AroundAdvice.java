package com.kim.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	@Around("PointcutCommon.bPointcut()")
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("+++++");
		System.out.println("메서드명: "+pjp.getSignature().getName());
		StopWatch sw=new StopWatch();
		sw.start();
		Object obj = pjp.proceed();
		sw.stop();
		System.out.println("소요시간: "+sw.getTotalTimeMillis());
		System.out.println("+++++");
		return obj;
	}
	
}
