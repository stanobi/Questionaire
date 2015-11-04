package com.practise.model;

public class QuestionAnswer 
{
	private int mQuestion;
	private String mTrue_option; 
	// we are using int because while using the R.string.xxx it returns an integer but generates a string 
	//on the view part 
	
	public QuestionAnswer(int question,String true_option)
	{
		setQuestion(question);
		setTrue_option(true_option);
	}
	public int getQuestion() {
		return mQuestion;
	}
	public void setQuestion(int question) {
		mQuestion = question;
	}
	public String getTrue_option() {
		return mTrue_option;
	}
	public void setTrue_option(String true_option) {
		mTrue_option = true_option;
	}
	
}
