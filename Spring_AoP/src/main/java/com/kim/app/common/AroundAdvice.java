package com.kim.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("메서드명: "+ pjp.getSignature().getName());
		StopWatch sw = new StopWatch();
		sw.start();
		Object obj = pjp.proceed(); // 오브젝트로 받아야하고, 예외처리를 해야함
		sw.stop();
		System.out.println("소요시간: "+sw.getTotalTimeMillis());
		// 클라이언트가 호출한 것을 받을 인자를 넣어야함
		System.out.println("pjp인자를 갖는 메서드에서 출력하는 문구");

		return obj;
	}
}
