package com.halostorm;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.DisplayMetrics;


public class Player extends Activity{
	
	public MediaPlayer mediaPlayer;
	private Button btnClose,btnPlayer;
	private TextView stringHeading,stringDescription;
	private String extraheading,extradescription,Tracknumber;
	private int trackNumber;
	
	int[] track = new int[]{
			R.raw.track_1,
			R.raw.track_2,
			R.raw.track_3,
			R.raw.track_4,
			R.raw.track_5,
			R.raw.track_6,
			R.raw.track_7,
			R.raw.track_8,
			R.raw.track_9,
			R.raw.track_10
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pop_player);
		
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int width = dm.widthPixels;
		int height = dm.heightPixels;
		getWindow().setLayout((int)(width*.8), (int)(height*.6));
		
		btnClose = (Button)findViewById(R.id.btnclose);
		btnPlayer = (Button)findViewById(R.id.btnPlay);
		stringDescription = (TextView)findViewById(R.id.txtlong_desc);
		stringHeading = (TextView)findViewById(R.id.txtheading);
		
		extraheading = getIntent().getStringExtra("Heading");
		extradescription = getIntent().getStringExtra("Description");
		Tracknumber = getIntent().getStringExtra("Track");
		trackNumber = Integer.parseInt(Tracknumber.toString());
		
		stringHeading.setText(extraheading);
		stringDescription.setText(extradescription);
		
		btnClose.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mediaPlayer.stop();
				finish();
			}
		});
		
		btnPlayer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mediaPlayer.start();
			}
		});
		
		initializeViews();
		
	}
	
	
	public void initializeViews(){
		mediaPlayer = MediaPlayer.create(this, track[trackNumber]);
	}
	
}