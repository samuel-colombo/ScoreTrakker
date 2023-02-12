import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class ScoreTrakker {
	
	private ArrayList<Student> students;
	
	public ScoreTrakker() {
		super();
		this.students = new ArrayList<Student>();
	}
	public void loadDataFile (String fileName) throws FileNotFoundException {
		// read the file
        FileReader read = new FileReader(fileName);
        // scan the file
        Scanner scan = new Scanner(fileName);
        // create temp student to be add to the array list
        Student curStudent = new Student();
        // char to keep track of what being read in, N for name, S for score
        char curRead = 'N';
        // loop through the scanned file to set name and score then add to the array list
        while(scan.hasNextLine()) {
            // set name
        	if(curRead == 'N') {
        		curStudent.setName(scan.nextLine());
        		// change for the next read
        		curRead = 'S';
        	} else {
        		// set score
                curStudent.setScore(scan.nextInt());
                // add student to array list
                this.students.add(curStudent);
                // change for the next read to be name again
                curRead = 'N';
        	}
        }
        // close read and scan
        scan.close();
        try {
			read.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public void printInOrder () {
		Collections.sort(this.students);
		Iterator<Student> iter = this.students.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
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
