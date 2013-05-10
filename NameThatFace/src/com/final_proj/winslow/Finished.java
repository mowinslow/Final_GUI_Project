package com.final_proj.winslow;

import java.util.Collections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Finished extends Game{
	private int score;
	private TextView scoreText1, scoreText2, scoreText3, scoreText4, scoreText5;
	private Button playAgain, home;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finished_game);	
		Bundle extras = getIntent().getExtras();
		
		score = extras.getInt("score");
		
		scoreText1 = (TextView) findViewById(R.id.score1);
		scoreText2 = (TextView) findViewById(R.id.score2);
		scoreText3 = (TextView) findViewById(R.id.score3);
		scoreText4 = (TextView) findViewById(R.id.score4);
		scoreText5 = (TextView) findViewById(R.id.score5);
		
		for(int i = 0; i < 4; i++){
			scoreList.add(0);
		}
		
		scoreList.add(0, score);
		
		Collections.sort(scoreList);
		
		scoreText1.setText("1. " + scoreList.get(4));
		scoreText2.setText("2. " + scoreList.get(3));
		scoreText3.setText("3. " + scoreList.get(2));
		scoreText4.setText("4. " + scoreList.get(1));
		scoreText5.setText("5. " + scoreList.get(0));
		
		playAgain = (Button) findViewById(R.id.playAgain);
		playAgain.setOnClickListener(this);
		home = (Button) findViewById(R.id.homeScreen);
		home.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		
		if(v == playAgain)
		{
			Intent myIntent = new Intent(Finished.this, Game.class);
			Finished.this.startActivity(myIntent);
		}
		
		if(v == home)
		{
			Intent myIntent = new Intent(Finished.this, MainActivity.class);
			Finished.this.startActivity(myIntent);
		}
		
	}
}
