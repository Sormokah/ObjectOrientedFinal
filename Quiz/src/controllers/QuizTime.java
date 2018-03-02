package controllers;

import java.util.ArrayList;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import models.Quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class QuizTime {
	private static ArrayList<Quiz> quiz = new ArrayList<Quiz>();

	public static void takeQuiz(String input) {
		int correct = 0;
		int incorrect = 0;
		// This is where the code will check to see if the answer is equal to the choice
		for (int i = 0; i < quiz.size(); i++) {
			if (input.equals(quiz.get(i).getAnswer())) {
				correct++;
			} else {
				incorrect++;
			}
		}
	}

	// This method is to add the a question to the array list 'quiz'
	public static String addQuestion() {
		String ques = "Gui Input";
		return ques;
	}

	// This method is to add the answer to a question into the array list
	public static String addAnswer() {
		String ans = "Gui input";
		return ans;
	}

	// This method is used to add the other choices for a question
	public static ArrayList<String> addMultipleChoice() {
		ArrayList<String> choices = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				choices.add(addAnswer());
			} else {
				addAChoice(choices);
			}
		}
		return choices;
	}

	// This method is just to print out true and false options in the arrayList
	public static ArrayList<String> addTrueOrFalse() {
		ArrayList<String> choices = new ArrayList<String>();
		String trueString = "True";
		String falseString = "False";
		choices.add(trueString);
		choices.add(falseString);
		return choices;
	}

	// this is called to add the choice from the both methods above to the arraylist
	public static void addAChoice(ArrayList<String> choices) {
		String choice = "Gui Input";
		choices.add(choice);
	}

	// This is the way a true or false question will be added to the array list
	public static void addTrueOrFalseToQuiz() {
		Quiz Question = new Quiz(addQuestion(), addAnswer(), addTrueOrFalse());
		quiz.add(Question);
	}

	// This is the way a multiple choice question will be addede to the array list
	public static void addMultipleChoiceToQuiz() {
		Quiz Question = new Quiz(addQuestion(), addAnswer(), addMultipleChoice());
		quiz.add(Question);
	}

	// This is the way you can remove a question from the arraylist
	public static void removeQuestion(int remove) {
		quiz.remove(remove);
	}

	public static void saveQuiz(Stage primaryStage) {
		try {
			String filePath = getFilePath(primaryStage, true);
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(quiz);

			oos.close();
			fos.close();
		} catch (IOException e) {

		}
	}

	@SuppressWarnings("unchecked")
	public static void load(Stage primaryStage) {
		String filePath = getFilePath(primaryStage, false);
		System.out.println(filePath);
		try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);

			try {
				quiz = (ArrayList<Quiz>) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			ois.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getFilePath(Stage primaryStage, boolean isSaving) {

		try {
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().add(new ExtensionFilter("Quiz File", "*.qz"));
			File useMe = new File("");
			if (isSaving) {
				useMe = fileChooser.showSaveDialog(primaryStage);
			} else {
				fileChooser.setTitle("Load Quiz");
				useMe = fileChooser.showOpenDialog(primaryStage);
			}

			String filePath = useMe.getPath();
			return filePath;
		} catch (NullPointerException e) {
			return "Error: NullPointerException while loading file";
		}

	}
}