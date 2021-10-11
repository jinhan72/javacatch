package com.kim.app.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	//@AfterThrowing(pointcut="?Pointcut()",throwing="excep")
	public void printLog(JoinPoint jp,Exception excep) {
		String name=jp.getSignature().getName();
		System.out.println("�޼����: "+name);
		System.out.println("����: "+excep);
		
		if(excep instanceof IllegalArgumentException) {
			System.out.println("�Ű������� ���������ʽ��ϴ�!");
			System.out.println("1. id�� PK�ε� 0 or �̹������ϴ°����� ó���ߴ��� Ȯ��");
		}
		else if(excep instanceof ArithmeticException) {
			System.out.println("0���� �����������ϴ�!");
			System.out.println("1. /0 �ߴ��� Ȯ��");
			System.out.println("2. ���ϱ� �̰� ��Ÿ���� �������� ... 3���޼��� ��ŸȮ��");
		}
		else if(excep instanceof Exception) {
			System.out.println("��Ȯ�� �����Դϴ�.");
		}
		
		System.out.println("���ܹ߻��� ȣ���");
	}
}
