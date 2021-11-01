package model.news;


public class NewsVO {

	private int npk;
	private String writer;
	private String title;
	private String content;
	private String ntype;
	private String ndate;
	private String condition;
	private String keyword;
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getNpk() {
		return npk;
	}
	public void setNpk(int npk) {
		this.npk = npk;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getNtype() {
		return ntype;
	}
	public void setNtype(String ntype) {
		this.ntype = ntype;
	}
	
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	@Override
	public String toString() {
		return "NewsVO [npk=" + npk + ", writer=" + writer + ", title=" + title + ", content=" + content + ", ntype="
				+ ntype + ", ndate=" + ndate + ", condition=" + condition + ", keyword=" + keyword + "]";
	}

	
	
}
