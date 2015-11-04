package com.practise.model;

import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

public class TimeKeeper extends CountDownTimer{
  
	private TextView displayText;
	private int QuestionCounter = 1;
	private long startTime;
	private boolean isRuning = false;
	private Handler n = new Handler();
	private Runnable runnable;
	
		public TimeKeeper(long startTime,long interval) 
		{
			// TODO Auto-generated constructor stub
			super(startTime, interval);
			this.setStartTime(startTime);
			n.removeCallbacks(runnable); //stop the initial Handler 
		}

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			this.setRuning(false);
			displayText.setText("Time Up!");
			n.post(runnable);// then start a new Handler
		}

		@SuppressLint("ResourceAsColor")
		@Override
		public void onTick(long millisUntilFinished) {
			// TODO Auto-generated method stub
			long millis = millisUntilFinished; 

			String hms = String.format("%02d:%02d:%02d", 
					TimeUnit.MILLISECONDS.toHours(millis), 
					TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
					TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
			displayText.setText(hms);
		}
		
		public TextView getDisplayText()
		{
			return displayText;
		}
		
		public void setDisplayText(TextView displayText)
		{
			this.displayText = displayText;
		}

		public long getStartTime() {
			return startTime;
		}

		public void setStartTime(long startTime) {
			this.startTime = startTime;
		}

		public boolean isRuning() {
			return isRuning;
		}

		public void setRuning(boolean isRuning) {
			this.isRuning = isRuning;
		}
		
		public int getQuestionCounter()
		{
			return QuestionCounter;
		}
		
		public void setQuestionCounter(int QuestionCounter)
		{
			this.QuestionCounter = QuestionCounter;
		}
		
		public Runnable getRunnable() {
			return runnable;
		}

		public void setRunnable(Runnable runnable) {
			this.runnable = runnable;
		}
	}
