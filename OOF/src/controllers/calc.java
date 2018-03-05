package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import models.Assignment;
import models.Category;

public class calc {

	private static HashMap<Category, ArrayList<Assignment>> grades = new HashMap<>();
	private static float overallGrade = 0;


	// Edit Categories Button
	// Edit Assignments Button
	// Calculate
	// Save
	// Load

	// this is when Edit Categories is clicked
	public static void editCategories() {
		// this is to change the gui to the category menu, which will display the
		// current categories + weights and have 2 buttons: add category and remove
		// category
	}

	// this will run when the Add Categories button is clicked
	public static void addCategories() {
		// I need a String name that will be acquired from the user
		// I also need a float weight that will be acquired from the user
		String nameInput;

		nameInput = "temp";
		float weightInput = 10;

		Category newCategory = new Category(nameInput, weightInput);
		grades.put(newCategory, new ArrayList<Assignment>());

	}

	// this will run when the Remove Categories button is clicked
	public static void removeCategories() {
		// I need a name of a category from the user
		int input = 0;
		Category[] gradesArray = grades.keySet().toArray(new Category[grades.size()]);
		grades.remove(gradesArray[input]);

	}

	// this will run when the edit assignments button is clicked
	public static void editAssignments() {
		// this is to change the gui to the assignment menu, which will first ask for
		// the category they wish to add assignments to, and then display
		// the 2 buttons: add assignment and remove assignment
	}

	// this will run when the add assignments button is clicked
	public static void addAssignments() {
		// first, they need to enter which category they want to add assignemnts to
		// so this will go on a while loop until they click exit or something, or until
		// they enter exit, whichever is easier
		// I will need a String from the user for the Assignmeent Name
		// I will need a float from the user for the Assignment's obtained points
		// i will need a float from the user for the Assignment's possible points
		// I'm thinking that they should enter the 3 text boxes that they can type into,
		// and then a "submit" button under it or somewhere that
		// will add their info to the category's array list of assignments

		// I'm making this new caategory as a temporary thing. This will be changed to
		// whatever category they inputted/selected
		Category selectedCategory = new Category("Temp", 10);
		boolean wantsToContinue = true;
		while (wantsToContinue) {
			// the rest of this will only happen after they click the "submit" button
			String assignmentNameInput = "temp";
			float assignmentObtainedPointsInput = 10;
			float assignmentPossiblePointsInput = 10;
			Assignment newAssignment = new Assignment(assignmentNameInput, assignmentObtainedPointsInput,
					assignmentPossiblePointsInput);
			grades.get(selectedCategory).add(newAssignment);

			// here we will check if the exit button is clicked. If it is, then we'll break
			// the loop. Otherwise, it'll keep going
		}

	}

	// this will run when the remove assignments button is clicked
	public static void removeAssignments() {
		// first, I'll need the category they want to edit
		// next, I need them to input the assignment name that they want to remove
		Category selectedCategory = new Category("Temp", 10);
		int theirSelectedIndexNumber = 0;
		grades.get(selectedCategory).remove(theirSelectedIndexNumber);

	}

	// this will run when the save button is clicked
	public static void saveGrades() {

	}

	// this will run when the load button is clicked
	public static void loadGrades() {

	}

	public static void calculate() {
		overallGrade = 0;
		float sumOfCategoryWeights = 0;
		for (Category category : grades.keySet()) {
			sumOfCategoryWeights = sumOfCategoryWeights + category.getWeight();
		}

		for (Category category : grades.keySet()) {
			float pointsObtainedFromAllAssignments = 0;
			float pointsPossibleFromAllAssignments = 0;

			for (Assignment assignment : grades.get(category)) {
				pointsObtainedFromAllAssignments = pointsObtainedFromAllAssignments + assignment.getPointsObtained();
				pointsPossibleFromAllAssignments = pointsPossibleFromAllAssignments + assignment.getPointsPossible();
			}
			float categoryAverage = pointsObtainedFromAllAssignments / pointsPossibleFromAllAssignments;
			float categoryPercent = category.getWeight() / sumOfCategoryWeights;
			float categoryPoints = categoryPercent * categoryAverage;
			overallGrade = overallGrade + categoryPoints;
		}

	}

}
