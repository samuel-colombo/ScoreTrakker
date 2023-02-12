
public class Student {

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
	
}
