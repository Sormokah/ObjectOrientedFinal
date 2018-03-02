package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Quiz implements Serializable{
	private String question;
	private String answer;
	private ArrayList<String> options = new ArrayList<String>();
	
	public Quiz(String question, String answer, ArrayList<String> options) {
		setQuestion(question);
		setAnswer(answer);
		setOptions(options);
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}

	
}
