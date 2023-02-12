
public class Student implements Comparable<Student>{

	private String name;
	private int score;

	@Override
	public int compareTo(Student s) {
		return name.compareTo(s.name);
	}
	
	@Override
	public String toString() {
		return name + " " + score;
	}
	
	// getters and setters
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
