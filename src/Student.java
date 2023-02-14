
public class Student implements Comparable<Student>{

	private String name;
	private int score;

	public Student (String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	/*
	 * Override compareTo for Collections.sort
	 */
	@Override
	public int compareTo(Student s) {
		return name.compareTo(s.name);
	}
	
	/*
	 * Override toString for printing student behavior
	 */
	@Override
	public String toString() {
		return name + " " + score;
	}
	
	
	/*
	 * Getters & Setters:
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
