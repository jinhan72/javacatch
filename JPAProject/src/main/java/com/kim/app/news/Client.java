package com.kim.app.news;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Client {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
	EntityManager em = emf.createEntityManager();
	
	EntityTransaction et =em.getTransaction();
	try {
		et.begin();
		
		News news = new News();
		news.setTitle("실습");
		news.setWriter("나");
		news.setContent("실습시러어어");
		
		em.persist(news); // insert문을 생성
		et.commit();
		String jpql = "select n from News n"; // 대소문자 구분 잘하자
		List<News> datas=em.createQuery(jpql, News.class).getResultList();
		System.out.println("확인");
		System.out.println(datas);
		for(News v: datas) {
			System.out.println(v);
		}
	}
	catch(Exception e) {
		et.rollback();
	}finally {		
		em.close();
		emf.close();
	}
	
}
}
