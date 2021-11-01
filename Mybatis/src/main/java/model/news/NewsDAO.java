package model.news;

import java.util.List;

import org.apache.ibatis.session.SqlSession;



public class NewsDAO {

	private SqlSession mybatis;
	
	public NewsDAO() {
		mybatis=SqlSessionFactoryBean.getSqlSessionInstance();
	}
	public void insertNews(NewsVO vo) {
		mybatis.insert("newsdao.insertNews", vo);
		mybatis.commit();
	}
	
	public void updateNews(NewsVO vo) {
		mybatis.update("newsdao.updateNews", vo);
		mybatis.commit();
	}
	
	public void deleteNews(NewsVO vo) {
		mybatis.delete("newsdao.deleteNews", vo);
		mybatis.commit(); 
	}
	
	public NewsVO getNews(NewsVO vo) {
		return (NewsVO) mybatis.selectOne("newsdao.getNews", vo);		
	}
	
	public List<NewsVO> getNewsList(NewsVO vo) {
		return mybatis.selectList("newsdao.getNewsList", vo);
	}
}
