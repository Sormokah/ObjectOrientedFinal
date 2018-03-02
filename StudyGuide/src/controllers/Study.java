package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import models.StudyGuideQuestion;

public class Study {

	private static ArrayList<StudyGuideQuestion> studyGuide = new ArrayList<StudyGuideQuestion>();
	
	/*
	 * This method's use is simply to create a new StudyGuideQuestion object and add it to the arraylist studyGuide
	 */
	public static void addQuestion() {
		// Test variables to add create a temp StudyGuideQuestion
		String question = "Test Question";
		String answer = "Test Answer";

		studyGuide.add(new StudyGuideQuestion(question, answer));
	}
	
	/*
	 * This method's use is to remove a StudyGuideQuestion object frmo the arrayliist studyGuide
	 */
	
	public static void removeQuestion() {
		//Test  variables to remove a StudyGuideQuestion from the arraylist
		int questionToRemove = 1;
		
		studyGuide.remove(questionToRemove);
	}

	/*
	 * This method's use is to save the studyGuide arraylist to a file, it also serializes the object for ouputting
	 */
	public static void saveGuide() {
		String filePath = "C:\\output.sg";

		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(studyGuide);
			fos.close();
			oos.close();

		} catch (FileNotFoundException e) {
			// DEFAULT GENERATED CATCH CHANGE IF NEEDED TO BY GUI MANAGER
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// DEFAULT GENERATED CATCH CHANGE IF NEEDED TO BY GUI MANAGER
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * This method's use is to load the studyGuide arraylist from a file, it also deserializes the object to restore a saved studyGuide arraylist to be used.
	 */
	public static void loadGuide() {
		String filePath = "C:\\output.sg";

		try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			studyGuide = (ArrayList<StudyGuideQuestion>) ois.readObject();
			
			fis.close();
			ois.close();

		} catch (FileNotFoundException e) {
			// DEFAULT GENERATED CATCH CHANGE IF NEEDED TO BY GUI MANAGER
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// DEFAULT GENERATED CATCH CHANGE IF NEEDED TO BY GUI MANAGER
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// DEFAULT GENERATED CATCH CHANGE IF NEEDED TO BY GUI MANAGER
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
