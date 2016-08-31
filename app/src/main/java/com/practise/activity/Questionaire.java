package com.practise.activity;

import com.practise.actionbar.R;
import com.practise.fragment.FragmentQuestionaire;
import com.practise.fragment.login.Login;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;


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

        if(findViewById(R.id.Fragment_container_Questions) == null){
                getSupportFragmentManager().beginTransaction().add(R.id.Fragment_container_Questions,new Login()).commit();
        }
        else{
            Log.d("Debugging","Debugging");
            if(savedInstanceState != null){
                Log.d("Debugging1","Debugging");
            	getSupportFragmentManager().beginTransaction()
                    .replace(R.id.Fragment_container_Questions,new Login())
                    .commit();
            }
            else{
                Log.d("Debugging2","Debugging");
            	getSupportFragmentManager().beginTransaction()
                    .add(R.id.Fragment_container_Questions,new Login()).commitAllowingStateLoss();
            }
        }
	}

    public void switchFragments(int contentFrameId, android.support.v4.app.Fragment replacingFragment) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(contentFrameId, replacingFragment).commitAllowingStateLoss();
    }
}
