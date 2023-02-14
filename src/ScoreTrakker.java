import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JFileChooser;

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
	 * loadDataFile: open the file and read its content and add to array list of student object.
	 * @param fileName: name of target file, if exist.
	 * @throws Exception: if the read value that was supposed to score is not a number, throws an exception.
	 */
	public void loadDataFile (String fileName) throws Exception{
		// read the file
        FileReader read = null;
        
        //try catch opening file
		try {
			// read & scan the file
			read = new FileReader(fileName);
			Scanner scan = new Scanner(read);
        
	        // loop through the scanned file to set name and score then add to the array list
	        while(scan.hasNextLine()) {
	        	String name = scan.nextLine();
	        	String s_score = scan.nextLine();
	        	try {
	        		int score = Integer.parseInt(s_score);
	        		Student newStudent = new Student(name, score);
	        		students.add(newStudent);
	        	} catch (NumberFormatException a) { //catch non-int score
	        		System.out.println("Incorrect format for " + name + " not a valid score: " + s_score + "\n");
	        	}
	        }
	        
	        // try catch close read and scan
	        try { read.close(); }
			catch (IOException e) { e.printStackTrace(); }
			
		} catch (FileNotFoundException exep) { //catch FileNotFoundException
			throw exep;
		}
	}
	public void printInOrder () {
		System.out.println("Student Score List");
		Collections.sort(this.students);
		Iterator<Student> iter = this.students.iterator(); //iterator for loop
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println('\n'); //newline after printing all students
	}
	public void processFiles() throws Exception {
		for (String file: this.files) {
			try { //try catch for file not founds from loadDataFile
				ScoreTrakker st = new ScoreTrakker();
				st.loadDataFile(file);
				st.printInOrder();
			} catch (FileNotFoundException a) { 
				System.out.println("Can't open file: " + file); //print error message
			}
		}
	}
	/*
	 * Main, runs processFiles
	 */
	public static void main(String[] args) throws Exception {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
}
