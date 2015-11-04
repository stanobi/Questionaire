package com.practise.activity.splashScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.practise.actionbar.R;
import com.practise.activity.Questionaire;

public class Page extends Activity {

	Handler pageHandler = new Handler();
	Handler progressHandler = new Handler();
	ProgressBar progressBar;
	TextView progressBarTextview;
	int progress = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//the first page to be seen by the user
		setContentView(R.layout.activity_splashscreen_page);
		
		progressBar = (ProgressBar)findViewById(R.id.splashscreen_progressBar);
		progressBarTextview = (TextView)findViewById(R.id.splashscreen_TextView);
		
		progressBar.setVisibility(View.GONE);
		
		new AsynchProgressBar().execute(" ");
	}
	
	class AsynchProgressBar extends AsyncTask<String, Integer, String>{

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressBar.setVisibility(View.VISIBLE);
		}
		
		@Override
		protected String doInBackground(String... params) {
			int progressCounter = 0;
			while(progressCounter < 100)
			{
				progressCounter += 5;
				
				publishProgress(progressCounter);
				SystemClock.sleep(1000);
			}
			return "Completed";
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			progressBar.setProgress(values[0]);
			progressBarTextview.setText("Loading...");
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Intent intent = new Intent(getBaseContext(),Questionaire.class);
			startActivity(intent);
		}
	}
}
