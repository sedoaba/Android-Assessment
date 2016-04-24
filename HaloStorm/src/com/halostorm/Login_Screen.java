package com.halostorm;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Screen extends Activity{
	
	private EditText username;
	private Button sumbit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		sumbit = (Button)findViewById(R.id.btnSubmit);
		username = (EditText)findViewById(R.id.editusername);
		
		sumbit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(username.getText().toString().equals(""))
				{
					Toast.makeText(getApplicationContext(), "Please enter your name", Toast.LENGTH_SHORT).show();
					return;
				}
				
				 Intent dashboard = new Intent(getApplicationContext(), Dashboard_Screen.class);
				 SharedPreferences preferences = getSharedPreferences("temp", getApplicationContext().MODE_PRIVATE);
				 Editor editor = preferences.edit();
				 editor.putString("Name", username.getText().toString());
				 editor.apply();
				 String pushlog = "0";
				 dashboard.putExtra("log", pushlog);
				 startActivity(dashboard);
				 finish();
			}
		});
	}
}
