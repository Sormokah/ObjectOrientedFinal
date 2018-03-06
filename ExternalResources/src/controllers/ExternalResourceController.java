package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import models.ExternalResource;

public class ExternalResourceController {

	private static ArrayList<ExternalResource> webLinks;
	private static ArrayList<ExternalResource> textBooks;
	private static ArrayList<ExternalResource> videos;
	
	
	public static void addWebLink(String link, String content) {
		
		webLinks.add(new ExternalResource(link, content));

	}
	
	public void addTextBook(String link, String content) {

		textBooks.add(new ExternalResource(link, content));
		
	}
	
	public void addVideo(String link, String content) {

		videos.add(new ExternalResource(link, content));
		
	}
	
	public void saveAll(Stage primaryStage) {
		ArrayList<ArrayList<ExternalResource>> allResources = new ArrayList<ArrayList<ExternalResource>>();
		allResources.add(webLinks);
		allResources.add(textBooks);
		allResources.add(videos);

		try {
			String filePath = getFilePath(primaryStage, true);
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(allResources);

			oos.close();
			fos.close();
			}catch(IOException e){
				
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
				ArrayList<ArrayList<ExternalResource>> allResources = (ArrayList<ArrayList<ExternalResource>>) ois.readObject();
				webLinks.addAll(allResources.get(0));
				textBooks.addAll(allResources.get(1));
				videos.addAll(allResources.get(2));
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			ois.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String getFilePath(Stage primaryStage, boolean isSaving) {
		try {
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().add(new ExtensionFilter("External Resource File", "*.fc"));	
			File useMe = new File("");
			if(isSaving) {
				fileChooser.setTitle("Save External Resourec File");
				useMe = fileChooser.showSaveDialog(primaryStage);
			}else {
				fileChooser.setTitle("Load External Resourec File");
				useMe = fileChooser.showOpenDialog(primaryStage);
			}	
			
			String filePath = useMe.getPath();
			return filePath;
		}catch(NullPointerException e) {
			return "Error: NullPointerException while loading file";
		}
	}
	
	
	public static  ArrayList<ExternalResource> getWebLinks() {
		return webLinks;
	}
	
	public static ArrayList<ExternalResource> getTextBooks() {
		return textBooks;
	}
	
	public static ArrayList<ExternalResource> getVideos() {
		return videos;
	}
}
