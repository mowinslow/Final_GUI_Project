package com.final_proj.winslow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button play, howToPlay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		play = (Button) findViewById(R.id.playButton);
		howToPlay = (Button) findViewById(R.id.howToButton);
		play.setOnClickListener(this);
		howToPlay.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		if(v == play)
		{
			Intent myIntent = new Intent(MainActivity.this, Game.class);
			MainActivity.this.startActivity(myIntent);
			//setContentView(R.layout.game);
		}
		if(v == howToPlay){
			Intent myIntent = new Intent(MainActivity.this, HowToPlay.class);
			MainActivity.this.startActivity(myIntent);
		}
		
	}

}
