package com.practise.fragment;

import java.util.Locale;

import com.practise.actionbar.R;
import com.practise.activity.result.InstantResult;
import com.practise.model.QuestionAnswer;
import com.practise.model.TimeKeeper;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentQuestionaire extends android.app.Fragment{

	private TextView Question_TxtVw , Timer_TxtVw , QCounter;
	private Button Op1,Op2,Op3,Op4,Op5 ;
	private QuestionAnswer[] QA; 
	private int QuestionCounter = 1;
	Resources res;
	TimeKeeper tk;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//generating the Questions and their answer.
		QA = new QuestionAnswer[]
				{
				 new QuestionAnswer(R.string.Question_1, this.getString(R.string.option_1)),
				 new QuestionAnswer(R.string.Question_2, this.getString(R.string.option_2)),
				 new QuestionAnswer(R.string.Question_3, this.getString(R.string.option_3)),
				 new QuestionAnswer(R.string.Question_4, this.getString(R.string.option_4)),
				 new QuestionAnswer(R.string.Question_5, this.getString(R.string.option_5)),
				 new QuestionAnswer(R.string.Question_6, this.getString(R.string.option_6)),
				 new QuestionAnswer(R.string.Question_7, this.getString(R.string.option_7)),
				 new QuestionAnswer(R.string.Question_8, this.getString(R.string.option_8)),
				 new QuestionAnswer(R.string.Question_9, this.getString(R.string.option_9)),
				 new QuestionAnswer(R.string.Question_10, this.getString(R.string.option_10)),
				 new QuestionAnswer(R.string.Question_11, this.getString(R.string.option_11)),
				 new QuestionAnswer(R.string.Question_12, this.getString(R.string.option_12)),
				 new QuestionAnswer(R.string.Question_13, this.getString(R.string.option_13)),
				 new QuestionAnswer(R.string.Question_14, this.getString(R.string.option_14)),
				 new QuestionAnswer(R.string.Question_15, this.getString(R.string.option_15))
				};
		//to access the array options
		res = getResources();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//return super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_questionaire,container,false);
		
		
		//connecting the view to the model
		QCounter = (TextView)v.findViewById(R.id.Question_counter);
		Question_TxtVw = (TextView)v.findViewById(R.id.Questions_textView);
		Timer_TxtVw = (TextView)v.findViewById(R.id.Timer_textView);
		Op1 = (Button)v.findViewById(R.id.option1);
		Op2 = (Button)v.findViewById(R.id.option2);
		Op3 = (Button)v.findViewById(R.id.option3);
		Op4 = (Button)v.findViewById(R.id.option4);
		Op5 = (Button)v.findViewById(R.id.option5);
		
		//first Question
		next_Questions(QuestionCounter);
		
		Op1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				instantResult(QuestionCounter, Op1.getText().toString());	
				button_status(false);
			}
		});
		
		Op2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				instantResult(QuestionCounter, Op2.getText().toString());		
				button_status(false);
			}
		});
		
		Op3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				instantResult(QuestionCounter, Op3.getText().toString());	
				button_status(false);
			}
		});

		Op4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				instantResult(QuestionCounter, Op4.getText().toString());		
				button_status(false);
			}
		});
		
		Op5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				instantResult(QuestionCounter, Op5.getText().toString());
				button_status(false);
			}
		});
		
		//Toast.makeText(getActivity(), "the current Question count is "+QuestionCounter, Toast.LENGTH_LONG).show();
		return v;
	}
	
	public void next_Questions(final int Question_count)
	{
		
		//set Questions
		QCounter.setText("Question "+Question_count);
		Question_TxtVw.setText(QA[Question_count-1].getQuestion());
					
		//set options for the Questions
		String[] Options_array = null;
				switch(Question_count)
				{
					case 1:
						Options_array = res.getStringArray(R.array.Q1_Option);
						break;
					case 2:
						Options_array = res.getStringArray(R.array.Q2_Option);
						break;
					case 3:
						Options_array = res.getStringArray(R.array.Q3_Option);
						break;
					case 4:
						Options_array = res.getStringArray(R.array.Q4_Option);
						break;						
					case 5:
						Options_array = res.getStringArray(R.array.Q5_Option);
						break;						
					case 6:
						Options_array = res.getStringArray(R.array.Q6_Option);
						break;						
					case 7:
						Options_array = res.getStringArray(R.array.Q7_Option);
						break;						
					case 8:
						Options_array = res.getStringArray(R.array.Q8_Option);
						break;						
					case 9:
						Options_array = res.getStringArray(R.array.Q9_Option);
						break;						
					case 10:
						Options_array = res.getStringArray(R.array.Q10_Option);
						break;						
					case 11:
						Options_array = res.getStringArray(R.array.Q11_Option);
						break;						
					case 12:
						Options_array = res.getStringArray(R.array.Q12_Option);
						break;						
					case 13:
						Options_array = res.getStringArray(R.array.Q13_Option);
						break;						
					case 14:
						Options_array = res.getStringArray(R.array.Q14_Option);
						break;						
					case 15:
						Options_array = res.getStringArray(R.array.Q15_Option);						
						break;								
				}
				
			Op1.setText(Options_array[0].toString());
			Op2.setText(Options_array[1].toString());
			Op3.setText(Options_array[2].toString());
			Op4.setText(Options_array[3].toString());
			Op5.setText(Options_array[4].toString());

			//this will run after the timer is Up
			Runnable myRunnable = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					instantResult(QuestionCounter, "NO ANSWER");	
				}
			};
			
			//timer for Question
			tk = new TimeKeeper(30000, 1000);
			tk.setDisplayText(Timer_TxtVw);
			tk.setQuestionCounter(QuestionCounter);
			tk.setRunnable(myRunnable);
			tk.start();
			tk.setRuning(true);
	}
	
	
	//this verifies if you are correct or not 
	//then 
	public void instantResult(int currentCount,String chosenAnswer)
	{
		Intent n = new Intent(getActivity(),InstantResult.class);
		String Message = "";
		String status = "";
		//get the correct Answer then compare to determine the message to display
		if(QA[currentCount-1].getTrue_option().toString().equalsIgnoreCase(chosenAnswer))
		{
			Message = "C O R R E C T !!!";
			status = "correct";
		}
		else if( chosenAnswer.equalsIgnoreCase("NO ANSWER"))
		{
			Message = "TIME UP\n";
			Message += "The Actual answer is \n";
			Message += QA[currentCount-1].getTrue_option().toUpperCase(new Locale("ENGLISH"));
			status = "no answer";
		}
		else
		{
			Message = "W R O N G\n";
			Message += "The correct answer is \n";
			Message += QA[currentCount-1].getTrue_option().toUpperCase(new Locale("ENGLISH"));
			status = "wrong";
		}
		n.putExtra("key",Message);
		n.putExtra("title","Question "+currentCount);
		n.putExtra("answer_status", status);
		startActivityForResult(n,1);
		
		//stop the time
		tk.setRuning(false);
		tk.cancel();
	}
	
	//@Override
	@Override
	@SuppressWarnings("static-access")
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 1)
		{
			//go to the next Question		
			if(QuestionCounter < QA.length)
			{
				next_Questions(++QuestionCounter);
				button_status(true);
			}
			else
			{
				//display the result
			}
			if(resultCode == getActivity().RESULT_OK)
			{
				
			}
		}
	}
	
	public void button_status(boolean status)
	{
		Op1.setEnabled(status);
		Op2.setEnabled(status);
		Op3.setEnabled(status);
		Op4.setEnabled(status);
		Op5.setEnabled(status);
	}
}









