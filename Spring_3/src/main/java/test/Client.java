package test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import test2.CBean;
import test2.KakaoT;

public class Client {
   public static void main(String[] args) {

      // 1. 스프링 컨테이너를 동작시켜보자!~~
      AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
      
      // 2. 객체를 요청하면, 해당 객체를 준다.
      //  == Look up
    
//      Test test = (Test)factory.getBean("test");
//      test.print();
//      
//      Lgtv lg = (Lgtv)factory.getBean("lg");
//      lg.powerOn();
//      
    
      
   /*   CBean cb =(CBean)factory.getBean("cb");
      List<String> list=cb.getList();
      for(String v: list) {
    	  System.out.println(v);
      }*/
      
    
  /*    CBean cb =(CBean)factory.getBean("cb");
      Map<String,String> map = cb.getMap();
      System.out.println(map);*/
      
          Phone phone=(Phone)factory.getBean("phone");
          phone.power();

      
      
      KakaoT kt = (KakaoT)factory.getBean("kt");
      List<String> list= kt.getList();
      System.out.println("친구목록");
      for(String v: list) {
    	  System.out.println(v+"");
      }
      
 //     Samsungtv sam =(Samsungtv)factory.getBean("sam");
 //     sam.powerOn();
 //     sam.PowerOff();
      
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