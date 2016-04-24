package com.halostorm;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard_Screen extends Activity {
	
	private TextView welcome;
	private Button back,close;
	private String checklog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashborad);
		checklog= getIntent().getStringExtra("log");
		welcome = (TextView)findViewById(R.id.txtwelcome);
		SharedPreferences preferences =getSharedPreferences("temp", getApplicationContext().MODE_PRIVATE);
		String username = preferences.getString("Name",null);
		
		
		try
		{
			if(checklog.equals("0"))
			{

				welcome.setText("Welcome " +username);
			}
			else
			{
				welcome.setText("Welcome " +username+" thanks for returning, we hope you enjoy your stay!");
			}
		}
		catch(Exception ex)
		{
			Toast.makeText(getApplicationContext(), ""+ex, Toast.LENGTH_SHORT).show();
		}
		
		
		back = (Button)findViewById(R.id.btnback);
		close = (Button)findViewById(R.id.btnclosed);
		
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent login = new Intent(getApplicationContext(), Login_Screen.class);
				SharedPreferences preferences = getSharedPreferences("temp", getApplicationContext().MODE_PRIVATE);
				Editor editor = preferences.edit();
				editor.putString("Name", "");
				editor.apply();
				startActivity(login);
				finish();
			}
		});
		
		close.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), Menu_Page.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("EXIT", true);
				startActivity(intent);
			}
		});
	}

}
