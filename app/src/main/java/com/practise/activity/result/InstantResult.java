package com.practise.activity.result;

import com.practise.actionbar.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InstantResult extends Activity{

	private TextView TheText;
	private Button TheButton;
	private ImageView r_img;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_instant);
		
		String text = (String)getIntent().getExtras().get("key");
		String sTitle = getIntent().getExtras().getString("title");
		String status_1 = getIntent().getExtras().getString("answer_status"); 
		r_img = (ImageView)findViewById(R.id.result_image);
		
		if(status_1.equalsIgnoreCase("correct"))
		{
			r_img.setImageResource(R.drawable.correct_result_image);
		}
		else if(status_1.equalsIgnoreCase("no answer"))
		{
			r_img.setImageResource(R.drawable.no_answer_result_image);
		}
		else
		{
			r_img.setImageResource(R.drawable.wrong_result_image);
		}
		TheText = (TextView)findViewById(R.id.Message);
		TheButton = (Button)findViewById(R.id.Ok_button);
		
	    this.setTitle(sTitle);
		TheText.setText(text);
		TheButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			finish();
			setResult(RESULT_OK);
			}
		});
		
		
	}
}
