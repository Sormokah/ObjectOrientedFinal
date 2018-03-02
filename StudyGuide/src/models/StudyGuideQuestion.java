package models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StudyGuideQuestion implements Serializable {

	private String question;
	private String answer;

	public StudyGuideQuestion(String question, String answer) {
		setQuestion(question);
		setAnswer(answer);
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
