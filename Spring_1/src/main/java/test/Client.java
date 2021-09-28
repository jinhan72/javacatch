package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
   public static void main(String[] args) {

      // 1. 스프링 컨테이너를 동작시켜보자!~~
      AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
      
      // 2. 객체를 요청하면, 해당 객체를 준다.
      //  == Look up
    
      Test test = (Test)factory.getBean("test");
      test.print();
      
      Lgtv lg = (Lgtv)factory.getBean("lg");
      lg.powerOn();
      
      Samsungtv sam = (Samsungtv)factory.getBean("sam");
      sam.powerOn();
      
      // 3. 스프링 컨테이너 종료
      factory.close();
      
      // => Console
      // 현재 <bean> 등록된 모든 클래스에 대한 객체를 미리 만들어놓습니다!
      // 기본 생성자 호출됨!
      
      // => Console
      // 기본 생성자 호출됨!
      // 출력
      
   }
}