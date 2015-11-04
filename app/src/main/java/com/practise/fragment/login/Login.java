package com.practise.fragment.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.practise.actionbar.R;

public class Login extends Fragment {
	
	private TextView txtUsername;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		//inflating the fragment
		View v = inflater.inflate(R.layout.fragment_login, container);
		
		//inflating the widgets on the fragment
		txtUsername = (TextView)v.findViewById(R.id.username);
		
		return v;
	}
}
