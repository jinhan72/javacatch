package com.kim.app.news;

import java.util.Date;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: News
 *
 */
@Entity
@Table(name="NEWS") // @을 활용해서 테이블과 클래스를 연결하고, name속성을 사용해서 테이블 명을 지정해줄 수 있음 가독성 증가를 위해 테이블명을 대문자로 지정해준다
public class News  {

	@Id // 식별자 필드를 지정
	@GeneratedValue //
	private int npk; // 식별자 필드 == PK
	private String writer;
	private String title;
	private String content;
	private String files;
	private String ntype;
	@Temporal(TemporalType.DATE)
	private Date ndate;
	@Transient // 테이블 매핑에서 제외를 하고 싶을때 사용하는 어노테이션
	private String condition;
	@Transient
	private String keyword;

	
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

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getNtype() {
		return ntype;
	}

	public void setNtype(String ntype) {
		this.ntype = ntype;
	}

	public Date getNdate() {
		return ndate;
	}

	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}

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

	

	
	
	@Override
	public String toString() {
		return "News [npk=" + npk + ", writer=" + writer + ", title=" + title + ", content=" + content + ", files="
				+ files + ", ntype=" + ntype + ", ndate=" + ndate + ", condition=" + condition + ", keyword=" + keyword
				+ "]";
	}
	
	
   
}
