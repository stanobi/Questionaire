package com.practise.fragment.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.practise.actionbar.R;
import com.practise.activity.Questionaire;
import com.practise.fragment.FragmentQuestionaire;

public class Login extends Fragment {
	
	private TextView txtUsername;
	private Button startTextButton;
	
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		//inflating the fragment
		View v = inflater.inflate(R.layout.fragment_login, container, false);
		
		//inflating the widgets on the fragment
		txtUsername = (TextView)v.findViewById(R.id.username);
		startTextButton = (Button)v.findViewById(R.id.startText);
		startTextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(),"you are welcome",Toast.LENGTH_LONG).show();
				((Questionaire)getActivity()).switchFragments(R.id.Fragment_container_Questions, new FragmentQuestionaire());
			}
		});
		
		return v;
	}
}
