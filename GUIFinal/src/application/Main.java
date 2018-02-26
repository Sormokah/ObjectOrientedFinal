package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.sun.glass.events.MouseEvent;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	
	
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
			mainMenu(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	protected void mainMenu(Stage primaryStage) throws FileNotFoundException {
		// This section of Code is for the Main Menu / Main bits of the Application such as the Logo and Title
		
		//Imports the Logo From the Image Folder
		FileInputStream logo = new FileInputStream("Images//StudyBuddyLogo.png");
		Image icon = new Image(logo);
		//Buttons for Each of the main choices on the Main Menu
		Button review = new Button("Review");
		review.setOnAction(e->{
			try {
				flashCardMenu(primaryStage);
			} catch (FileNotFoundException e1) {
			}
		});
		Button quiz = new Button("Quizes");
		quiz.setOnAction(e->{
			try {
				quizMenu(primaryStage);
			} catch (FileNotFoundException e1) {
			}
		});
		Button studyGuide = new Button("Study Guide");
		studyGuide.setOnAction(e->{
			try {
				studyGuideMenu(primaryStage);
			} catch (FileNotFoundException e1) {
			}
		});
		Button gradCalc = new Button("Grad Calculator");
		gradCalc.setOnAction(e->{
			try {
				gradeCalculatorMenu(primaryStage);
			} catch (FileNotFoundException e1) {
			}
		});
		//The Vbox Allows for Labels to and the grid pane to flow smoothly
		VBox vbo = new VBox();
		//The Grid Pane is to Allow for more freedom in the placement of Items
		GridPane mainArea = new GridPane();
		GridPane decals = new GridPane();
		
		Label welcome = new Label("Welcome to Study Buddy!");
		ImageView localLogo = new ImageView(icon);
		decals.setAlignment(Pos.CENTER);
		decals.add(localLogo, 1, 1);
		decals.add(welcome, 1, 2);
		mainArea.setHgap(10);
		mainArea.setVgap(10);
		mainArea.setAlignment(Pos.CENTER);
		mainArea.add(review, 0, 1);
		mainArea.add(quiz, 0, 0);
		mainArea.add(studyGuide, 1, 0);
		mainArea.add(gradCalc, 1, 1);
		
		vbo.getChildren().addAll(decals,mainArea);
		Scene Menu = new Scene(vbo,400,400);
		Menu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//Sets the Title and Icon and What Scene to Show which in this case is the Main Menu
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("StudyBuddy");
		primaryStage.setScene(Menu);
		primaryStage.show();
	}
	
	protected void flashCardMenu(Stage primaryStage) throws FileNotFoundException {
		FileInputStream logo = new FileInputStream("Images//StudyBuddyLogo.png");
		Image icon = new Image(logo);
		FileInputStream flash = new FileInputStream("Images//Notecard.jpg");
		Image noteCard = new Image(flash);
		ImageView localLogo = new ImageView(noteCard);
		GridPane choice = new GridPane();
		Button create = new Button("Create FlashCards");
		Button review = new Button("Review FlashCards");
		Button backToMain = new Button("Back To Main Menu");
		backToMain.setOnAction(e->{
			try {
				mainMenu(primaryStage);
			} catch (FileNotFoundException e1) {
			}
		});
		Label blank = new Label();
		choice.add(create,0,0);
		choice.add(blank,1,0);
		choice.add(review,2,0);
		choice.addColumn(1, backToMain);
		choice.setAlignment(Pos.CENTER);
		Scene flashCardMenu = new Scene(choice,400,400);
		flashCardMenu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("StudyBuddy");
		primaryStage.setScene(flashCardMenu);
		primaryStage.show();
	}
	
	protected void studyGuideMenu(Stage primaryStage) throws FileNotFoundException {
		FileInputStream logo = new FileInputStream("Images//StudyBuddyLogo.png");
		Image icon = new Image(logo);
		GridPane choice = new GridPane();
		Button create = new Button("Create Study Guide");
		Button review = new Button("Review Study Guide");
		Button backToMain = new Button("Back To Main Menu");
		backToMain.setOnAction(e->{
			try {
				mainMenu(primaryStage);
			} catch (FileNotFoundException e1) {
			}
		});
		Label blank = new Label();
		choice.add(create,0,0);
		choice.add(blank,1,0);
		choice.add(review,2,0);
		choice.addColumn(1, backToMain);
		choice.setAlignment(Pos.CENTER);
		Scene studyGuideMenu = new Scene(choice,400,400);
		studyGuideMenu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("StudyBuddy");
		primaryStage.setScene(studyGuideMenu);
		primaryStage.show();
	}
	
	protected void quizMenu(Stage primaryStage) throws FileNotFoundException {
		FileInputStream logo = new FileInputStream("Images//StudyBuddyLogo.png");
		Image icon = new Image(logo);
		GridPane choice = new GridPane();
		Button create = new Button("Create Quiz");
		Button review = new Button("Take A Quiz");
		Button backToMain = new Button("Back To Main Menu");
		backToMain.setOnAction(e->{
			try {
				mainMenu(primaryStage);
			} catch (FileNotFoundException e1) {
			}
		});
		Label blank = new Label();
		choice.add(create,0,0);
		choice.add(blank,1,0);
		choice.add(review,2,0);
		choice.addColumn(1, backToMain);
		choice.setAlignment(Pos.CENTER);
		Scene quizMenu = new Scene(choice,400,400);
		quizMenu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("StudyBuddy");
		primaryStage.setScene(quizMenu);
		primaryStage.show();
	}
	
	protected void gradeCalculatorMenu(Stage primaryStage) throws FileNotFoundException {
		FileInputStream logo = new FileInputStream("Images//StudyBuddyLogo.png");
		Image icon = new Image(logo);
		GridPane choice = new GridPane();
		Button create = new Button("Create Grade Calculation");
		Button review = new Button("View Grade Calculation");
		Button backToMain = new Button("Back To Main Menu");
		backToMain.setOnAction(e->{
			try {
				mainMenu(primaryStage);
			} catch (FileNotFoundException e1) {
			}
		});
		Label blank = new Label();
		choice.add(create,0,0);
		choice.add(blank,1,0);
		choice.add(review,2,0);
		choice.addColumn(1, backToMain);
		choice.setAlignment(Pos.CENTER);
		Scene gradeCalculatorMenu = new Scene(choice,400,400);
		gradeCalculatorMenu.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("StudyBuddy");
		primaryStage.setScene(gradeCalculatorMenu);
		primaryStage.show();
	}
}





