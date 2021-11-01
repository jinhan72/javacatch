package model.news;

import java.util.List;


public interface NewsService {
	void insertNews(NewsVO vo);
	void updateNews(NewsVO vo);
	void deleteNews(NewsVO vo);
	List<NewsVO> getNewsList(NewsVO vo);
	NewsVO getNews(NewsVO vo);

}
