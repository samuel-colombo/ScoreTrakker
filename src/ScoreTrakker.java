import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTrakker {
	
	private ArrayList<Student> students;
	
	public void loadDataFile (String fileName) throws FileNotFoundException {
		// read the file
        FileReader read = new FileReader(fileName);
        // scan the file
        Scanner scan = new Scanner(fileName);
        // create temp student to be add to the array list
        Student curStudent = new Student();
        // loop through the scanned file to set name and score then add to the array list
        while(scan.hasNextLine()) {
            // set name
            curStudent.setName(scan.nextLine());
            // set score
            curStudent.setScore(Integer.parseInt(scan.nextLine()));
            // add student to array list
            students.add(curStudent);
        }
	}
	public void printInOrder () {
		
	}
	public void processFiles() throws FileNotFoundException {
		loadDataFile("scores.txt");
		printInOrder();
	}
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
}
