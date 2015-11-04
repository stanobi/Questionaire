package com.practise.activity;

import com.practise.actionbar.R;
import com.practise.fragment.FragmentQuestionaire;
import com.practise.fragment.login.Login;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class Questionaire extends FragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questionaire);
		
//		//connecting the fragment
//		android.app.FragmentManager fm = getFragmentManager();
//		android.app.Fragment fragm = fm.findFragmentById(R.id.Fragment_container_Questions);
//		
//		if(fragm == null)
//		{
//			fragm = new FragmentQuestionaire();
//			fm.beginTransaction()
//			.add(R.id.Fragment_container_Questions,fragm)
//			.commit();
//		}
		
        Login authentication = new Login();
        if(findViewById(R.id.Fragment_container_Questions) == null){
                getSupportFragmentManager().beginTransaction().add(R.id.Fragment_container_Questions,authentication).commit();
        }
        else{
            if(savedInstanceState != null){
            	getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Fragment_container_Questions,authentication)
                    .commit();
            }
            else{
            	getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Fragment_container_Questions,authentication)
                    .commit();
            }
        }
	}
}
