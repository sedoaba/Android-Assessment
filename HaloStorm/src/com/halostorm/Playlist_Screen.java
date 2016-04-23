package com.halostorm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import android.R.raw;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Playlist_Screen extends Activity {
	
	private ListView listholder;
	private ImageButton btnSelector;
	public SimpleAdapter adapter;
	
	int[] trackimage = new int[]{
			
			R.drawable.track_1,
			R.drawable.track_2,
			R.drawable.track_3,
			R.drawable.track_4,
			R.drawable.track_5,
			R.drawable.track_6,
			R.drawable.track_7,
			R.drawable.track_8,
			R.drawable.track_9,
			R.drawable.track_10
	};
	
	String[] description = new String[]{
		"Jhené Aiko was featured Mail Music on this track, this came about when Mali Music where on a tour in SA.",
		"Local Artist from Boksburg hitting the hot waves with her hit single Let you go.",
		"Super hit by Drake and Partynextdoor preach played in every club in SA, its also on the Top 10 charts.",
		"Burna Boy - Soke killer hit taken from his album dropping on the 24th may 2016. Album available on itunes.",
		"simfy africa states this track never forget you by zara larsson will be the song of the year. never forget you its been on number one for two weeks",
		"Madonna taken from Lupe Fiasco album Tetsuo & Youth. album realsed on simfy africa last night. ",
		"Ngud allowing guys to buy cheap in clubs lol kwesta ft cassper nyovest saved pay days, nomore high spendings. ",
		"usher had to featur Nas on this single chains, usher droped his album last week a million copies were sold.",
		"Eye Adaba African mama her single is on the top charts on simfy africa for five weeks and still going strong, we counting six weeks friday",
		"No Way by Young Thung with his out of this world voice, making hits like no other artist. No way better love it"
	};
	
	String[] heading = new String[]{
		"Mali Music - Contradiction ft. Jhené Aiko ",
		"local Artist",
		"Drake - Preach (Feat. PARTYNEXTDOOR",
		"Burna Boy - Soke",
		"Zara Larsson  MNEK - Never Forget You ",
		"Madonna",
		"ngud-kwesta-ft-cassper-nyovest",
		"Usher-Ft.-Nas-Bibi-Bourelly",
		"Asa - Eye Adaba",
		"Young Thug - No Way"
	};
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_playlist);
		listholder = (ListView)findViewById(R.id.listHolder);
		btnSelector = (ImageButton)findViewById(R.id.btnselector);
		List<HashMap<String, String>> playlist = new ArrayList<HashMap<String,String>>();
		
		for(int i=0; i<10; i++)
		{
			HashMap<String, String> add = new HashMap<String, String>();
			add.put("image", Integer.toString(trackimage[i]));
			add.put("desc", description[i]);
			playlist.add(add);
		}
		
		String[] from = {"image","desc"};
		int[] to = {R.id.btnselector,R.id.txtmusic_desc};
		adapter = new SimpleAdapter(getApplicationContext(), playlist, R.layout.playlist_listview, from, to);
		listholder.setAdapter(adapter);
		
	
	}
	

}
