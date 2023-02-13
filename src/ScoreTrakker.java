import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};
	
	/**
	 * Default Constructor
	 */
	public ScoreTrakker() {
		super();
		this.students = new ArrayList<Student>();
	}
	
	/**
	 * isNumber: helper method to check if passed in string is a number.
	 * @param inString: the input string need to be check.
	 * @return false, if not an integer, and true, if it is not.
	 */
	public static boolean isNumber(String inString) {
		if(inString == null) {
			return false;
		}
		try {
			// parse if the string is a number, if not throw exception of NumberFormat
			int parseInt = Integer.parseInt(inString);
		} catch (NumberFormatException e){
			return false;
		}
		return true;
	}
	
	/**
	 * loadDataFile: open the file and read its content and add to array list of student object.
	 * @param fileName: name of target file, if exist.
	 * @throws Exception: if the read value that was supposed to score is not a number, throws an exception.
	 */
	public void loadDataFile (String fileName) throws Exception{
		// read the file
        FileReader read = null;
		try {
			read = new FileReader(fileName);
		} catch (FileNotFoundException e1) {
			System.out.println("Can't open file: " + fileName);
		}
        // scan the file
        Scanner scan = new Scanner(fileName);
        // create temp student to be add to the array list
        Student curStudent = new Student();
        // create a temp string to catch what is read
        String curLine = "";
        // char to keep track of what being read in, N for name, S for score
        char curRead = 'N';
        // loop through the scanned file to set name and score then add to the array list
        while(scan.hasNextLine()) {
        	curLine = scan.nextLine();
        	// check if read value is a number for when reading a score
        	if (isNumber(curLine) && curRead == 'S') {
        		// set score
                curStudent.setScore(Integer.parseInt(curLine));
                // add student to array list
                this.students.add(curStudent);
                // change for the next read to be name again
                curRead = 'N';
        	} else {
        		if(curRead == 'N') {
        			// set name
        			curStudent.setName(curLine);
            		// change for the next read
            		curRead = 'S';
        		} else {
        			// if the current reading is not score and not a number
        			throw new Exception("Incorrect format, not a valid score: " + curLine);
        		}
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
	public void processFiles() throws Exception {
		loadDataFile("scores.txt");
		printInOrder();
	}
	public static void main(String[] args) throws Exception {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
}
