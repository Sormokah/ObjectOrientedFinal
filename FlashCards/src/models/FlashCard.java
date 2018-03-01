package models;

import java.io.Serializable;

public class FlashCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyWord;
	private String definition;
	
	
	public FlashCard(String keyWord, String definition){
		setKeyWord(keyWord);
		setDefinition(definition);
	}
	
	public void setKeyWord(String keyWord){
		this.keyWord = keyWord;
	}
	
	public void setDefinition(String definition){
		this.definition = definition;
	}
	
	public String getKeyWord(){
		return this.keyWord;
	}
	
	public String getDefinition(){
		return this.definition;
	}
	
	@Override
	public String toString() {
		return getKeyWord() + ":  " + getDefinition();
	}
	

}