package com.final_proj.winslow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends Activity implements OnClickListener{
	private Button choice1, choice2, choice3, choice4;
	private ImageView image;
	private Resources res;
	private TextView text1, text2, text3, text4;
	private int a, b, c, d;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		startGame();
		
		
	}

	public void startGame(){
		res = getApplicationContext().getResources();
		
		String[] names = res.getStringArray(R.array.peoplenames);
		
		TypedArray images = getResources().obtainTypedArray(R.array.random_imgs);
		List<Integer> list = new ArrayList<Integer>();
		
		int a = ((int)(Math.random() * 4));
		list.add(a);
		
		int i = 0;
		int rand;
		while(i != 3)
		{
			rand = ((int)(Math.random() * 4));
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
	
		if(v == choice1){
			image.setImageResource(R.drawable.trexel);
		}
		if(v == choice2){
			image.setImageResource(R.drawable.leslie);
		}
		if(v == choice3){
			image.setImageResource(R.drawable.herb);
		}
		if(v == choice4){
			image.setImageResource(R.drawable.patrick);
		}
	}
}
