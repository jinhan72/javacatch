package com.kim.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	@Pointcut("execution(* model.board.*Impl.get*(..))")
	public void aPointcut() {}
	@Before("PointcutCommon.aPointcut()")
	public void printLog() {
		System.out.println("����Ͻ� �޼��带 �����ϱ� ���� ��µǴ� �α�!!!");
		// �������� ����!
	}
}
// 1. get*()����ÿ���
// 2. �ش� �ٽɰ��� ������ ����ɼ��ֵ���
// 3. LogAdvice�� printLog()��