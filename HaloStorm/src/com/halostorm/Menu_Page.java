package com.halostorm;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Menu_Page extends Activity {
	
	public Button Btn_Playlist,Btn_Login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		Btn_Playlist = (Button)findViewById(R.id.btnplayer);
		Btn_Login = (Button)findViewById(R.id.btnlogin);
		
		
		//Music Player event listener
		Btn_Playlist.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//starting a activity
				Intent music = new Intent(getApplicationContext(), Playlist_Screen.class);
				startActivity(music);
				
			}
		});
		
		//login event listener
		Btn_Login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences preferences =getSharedPreferences("temp", getApplicationContext().MODE_PRIVATE);
				String username = preferences.getString("Name",null);
				if(username.equals(""))
				{
					
					Intent login= new Intent(getApplicationContext(), Login_Screen.class);
					
					startActivity(login);
				}
				else
				{
					Intent Dashboard = new Intent(getApplicationContext(), Dashboard_Screen.class);
					String pushlog = "1";
					Dashboard.putExtra("log", pushlog);
					startActivity(Dashboard);
				}
			}
		});
		
		if (getIntent().getBooleanExtra("EXIT", false)) {
		    finish();  
		}
		
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_page, menu);
		return true;
	}

}
