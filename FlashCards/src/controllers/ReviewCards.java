package controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Random;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import models.FlashCard;

public class ReviewCards {

	private static HashMap<String, FlashCard> cards = new HashMap<>();
	
	//review one card at a time
	public static void review() {
		//testing hash map
//			cards.put("First", new FlashCard("First", "first.0"));
//			cards.put("Second",  new FlashCard("Second", "Second.0"));
		//
		//putting hashmap into an array
		String[] cardKeyArray = cards.keySet().toArray(new String[cards.size()]);
		FlashCard[] cardsArray = new FlashCard[cardKeyArray.length];
		for (int i = 0; i < cardsArray.length; i++) {
			cardsArray[i] = cards.get(cardKeyArray[i]);
		}
		
		
		
		//Setting up the random number generator
		Random gen = new Random();
		int max = cards.size();
		int randomValue = gen.nextInt(max);
		
		FlashCard tempCard = cardsArray[randomValue];
		
		//Display a single card keyWord
		
		/*testing*/ System.out.println(tempCard.getKeyWord());
		
		//Wait for input
		
		//Display the matching definition
		
		/*testing*/ System.out.println(tempCard.getDefinition());
		
	}
	//shows all cards at once
	public static void view() {
		
		//<testing hashmap>
		
//		cards.put("First", new FlashCard("First", "first.0"));
//		cards.put("Second",  new FlashCard("Second", "Second.0"));
		
		//<testing hashmap/>
		
		//puts keys into a String[]
		String[] cardsAsArray = cards.keySet().toArray(new String[cards.size()]);
		
		//puts FlashCard objects into a String[] via toStrings (keyWord + ":  " + definition")
		String[] cardToStrings = new String[cards.size()];
		for (int i= 0; i<cardToStrings.length;i++) {
			cardToStrings[i] = cards.get(cardsAsArray[i]).toString();						
		}
		
		//PRINTS ALL TOsTRINGS
		for (String string : cardToStrings) {
			System.out.println(string);
		}
		
	}
	
	//Adds a flashcard object to the hashmap
	public static void addFlashCard() {
		
		//get gui input and set the string to it
		String newKey = "Gui Input";
		//get gui input and set string to it
		String newDefinition = "Gui Input";
		//create new flashcard with those paramiters and add it to the hashmap
		cards.put(newKey, new FlashCard(newKey, newDefinition));
		
		
		
	}
	
	//removes a flashcard from the hashmap
	public static void removeFlashCard() {
		
		//get input from gui
		String keyToRemove = "GuiInput";
		
		//remove flashcard with the key from the hashmap
		cards.remove(keyToRemove);
		
	}
	
	//Saves hashmap to filepath as a .fc
	public static void saveFlashCard(Stage primaryStage) {
		try {
		String filePath = getFilePath(primaryStage, true);
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(cards);

		oos.close();
		fos.close();
		}catch(IOException e){
			
		}
	}
	//load cards from a file path from a .fc
	@SuppressWarnings("unchecked")
	public static void load(Stage primaryStage) {
		String filePath = getFilePath(primaryStage, false);
		System.out.println(filePath);
		try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);

			try {
				cards = (HashMap<String, FlashCard>) ois.readObject();
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
			fileChooser.getExtensionFilters().add(new ExtensionFilter("Flash Card File", "*.fc"));	
			File useMe = new File("");
			if(isSaving) {
				useMe = fileChooser.showSaveDialog(primaryStage);
			}else {
				fileChooser.setTitle("Load FlashCard File");
				useMe = fileChooser.showOpenDialog(primaryStage);
			}	
			
			String filePath = useMe.getPath();
			return filePath;
		}catch(NullPointerException e) {
			return "Error: NullPointerException while loading file";
		}
		

	}
}
