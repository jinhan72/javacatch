package test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import test2.CBean;
import test2.KakaoT;

public class Client {
   public static void main(String[] args) {

      // 1. ������ �����̳ʸ� ���۽��Ѻ���!~~
      AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
      
      // 2. ��ü�� ��û�ϸ�, �ش� ��ü�� �ش�.
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
      System.out.println("ģ�����");
      for(String v: list) {
    	  System.out.println(v+"");
      }
      
 //     Samsungtv sam =(Samsungtv)factory.getBean("sam");
 //     sam.powerOn();
 //     sam.PowerOff();
      
      // 3. ������ �����̳� ����
      factory.close();
      
      // => Console
      // ���� <bean> ��ϵ� ��� Ŭ������ ���� ��ü�� �̸� ���������ϴ�!
      // �⺻ ������ ȣ���!
      
      // => Console
      // �⺻ ������ ȣ���!
      // ���
      
   }
}