package com.final_proj.winslow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends Activity implements OnClickListener{
	private Button choice1, choice2, choice3, choice4;
	private ImageView image;
	private Resources res;
	private TextView text1, text2, text3, text4, scoreText, mTextView;
	private int a, b, c, d, temp, score;
	long mMilliseconds = 30000;
	String[] names;
	List<Integer> scoreList = new ArrayList<Integer>();
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);

	    mTextView = (TextView) findViewById(R.id.textview);
		mCountDownTimer.start();
		startGame();	
	}

	CountDownTimer mCountDownTimer = new CountDownTimer(mMilliseconds, 1000) {
        @Override
        public void onFinish() {
        	finish();
        	Intent myIntent = new Intent(Game.this, Finished.class);
        	myIntent.putExtra("score", score);
			Game.this.startActivity(myIntent);	
        }

        public void onTick(long millisUntilFinished) {
            mTextView.setText("" + millisUntilFinished/1000);
        }
    };
    
	public int getTemp(){
		return temp;
	}
	
	public void setTemp(int temporary){
		temp = temporary;
	}
	
	public void startGame(){
	
		scoreText = (TextView) findViewById(R.id.score);
		scoreText.setText(""+score);
		
		res = getApplicationContext().getResources();
		
		names = res.getStringArray(R.array.peoplenames);
		
		TypedArray images = getResources().obtainTypedArray(R.array.random_imgs);
		List<Integer> list = new ArrayList<Integer>();
		
		int a = ((int)(Math.random() * 39));
		setTemp(a);
		list.add(a);
		
		int i = 0;
		int rand;
		while(i != 3)
		{
			rand = ((int)(Math.random() * 39));
			if(!list.contains(rand))
			{
				list.add(rand);
				i++;
			}
		}

		Collections.shuffle(list);
		
		image = (ImageView) findViewById(R.id.personpic);
		image.setImageResource(images.getResourceId(a, -1));
		
		text1 = (TextView) findViewById(R.id.option1);
		text1.setText(names[list.get(0)]);
		text2 = (TextView) findViewById(R.id.option2);
		text2.setText(names[list.get(1)]);
		text3 = (TextView) findViewById(R.id.option3);
		text3.setText(names[list.get(2)]);
		text4 = (TextView) findViewById(R.id.option4);
		text4.setText(names[list.get(3)]);

		choice1 = (Button) findViewById(R.id.option1);
		choice1.setOnClickListener(this);
		choice2 = (Button) findViewById(R.id.option2);
		choice2.setOnClickListener(this);
		choice3 = (Button) findViewById(R.id.option3);
		choice3.setOnClickListener(this);
		choice4 = (Button) findViewById(R.id.option4);
		choice4.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v){
		temp = getTemp();
		Button b = (Button)v;
		String buttonText = b.getText().toString();
		
		if(buttonText.equals(names[temp])){
			score = score + 10;
			startGame();
		}
		else{
			b.setText("Incorrect");
			score = score - 20;
		}
	}
}
