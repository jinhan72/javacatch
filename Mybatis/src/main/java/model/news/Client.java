package model.news;

import java.util.List;

public class Client {
	public static void main(String[] args) {
		NewsDAO newsdao = new NewsDAO();
		
		NewsVO vo = new NewsVO();
		
		/*vo.setTitle("제목");
		vo.setWriter("작성자");
		vo.setContent("내용");
		vo.setNtype("카테고리");
		
		newsdao.insertNews(vo);
		*/
		
		vo.setKeyword("제");
		List<NewsVO> datas = newsdao.getNewsList(vo);
		for(NewsVO v: datas) {
			System.out.println(v);
		}
		
		
	}
}
