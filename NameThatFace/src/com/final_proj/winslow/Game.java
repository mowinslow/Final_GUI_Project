package com.final_proj.winslow;

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

public class Game extends Activity{
	private Button choice1, choice2, choice3, choice4;
	private ImageView image;
	private Resources res;
	private TextView text1, text2, text3, text4;
	int i=0;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		res = getApplicationContext().getResources();
		
		String[] names = res.getStringArray(R.array.peoplenames);
		Log.v("custom", names[0]);
		
		TypedArray images = getResources().obtainTypedArray(R.array.random_imgs);
		
		
		image = (ImageView) findViewById(R.id.personpic);
		image.setImageResource(images.getResourceId(0, 0));
		
		text1 = (TextView) findViewById(R.id.option1);
		text1.setText("poop");
		text2 = (TextView) findViewById(R.id.option2);
		text2.setText(names[1]);
		addListenerOnButton();
	}

	public void addListenerOnButton(){
		
		choice1 = (Button) findViewById(R.id.option1);
		choice1.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v){
				image.setImageResource(R.drawable.ic_launcher);
			}
		});
	}
}
