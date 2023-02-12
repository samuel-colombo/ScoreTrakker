import java.util.ArrayList;

public class ScoreTrakker {
	
	private ArrayList<Student> students;
	
	public void loadDataFile (String fileName) {
		
	}
	public void printInOrder () {
		
	}
	public void processFiles() {
		loadDataFile("scores.txt");
		printInOrder();
	}
	public static void main(String[] args) {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
}
