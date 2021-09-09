package model;

public class Student {
	private String name;
	private int score;
	public String getName() {
		return name;
	}
	
	public int getNum() {
		return score;
	}

	
	public Student(String name, int score) {
		this.name=name;
		this.score=score;
	}
	
}
