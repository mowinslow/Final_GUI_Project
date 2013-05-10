package com.final_proj.winslow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HowToPlay extends Activity implements OnClickListener{

	private Button next, previous, done;
	private TextView texthelp;
	private ImageView imagehelp;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.how_to_play);
		
		next = (Button) findViewById(R.id.next);
		previous = (Button) findViewById(R.id.previous);
		done = (Button) findViewById(R.id.done);
		next.setOnClickListener(this);
		previous.setOnClickListener(this);
		done.setOnClickListener(this);
		
		imagehelp = (ImageView) findViewById(R.id.helppic2);
		imagehelp.setVisibility(View.INVISIBLE);
		texthelp = (TextView) findViewById(R.id.helptext2);
		texthelp.setVisibility(View.INVISIBLE);
		previous.setVisibility(View.INVISIBLE);
	}
	
	@Override
	public void onClick(View v){
		
		if(v == next){
			imagehelp = (ImageView) findViewById(R.id.helppic2);
			imagehelp.setVisibility(View.VISIBLE);
			texthelp = (TextView) findViewById(R.id.helptext2);
			texthelp.setVisibility(View.VISIBLE);
			previous.setVisibility(View.VISIBLE);
			
			imagehelp = (ImageView) findViewById(R.id.helppic);
			imagehelp.setVisibility(View.INVISIBLE);
			texthelp = (TextView) findViewById(R.id.helptext);
			texthelp.setVisibility(View.INVISIBLE);
			next.setVisibility(View.INVISIBLE);
		}
		
		if(v == previous){
			imagehelp = (ImageView) findViewById(R.id.helppic);
			imagehelp.setVisibility(View.VISIBLE);
			texthelp = (TextView) findViewById(R.id.helptext);
			texthelp.setVisibility(View.VISIBLE);
			previous.setVisibility(View.INVISIBLE);
			
			imagehelp = (ImageView) findViewById(R.id.helppic2);
			imagehelp.setVisibility(View.INVISIBLE);
			texthelp = (TextView) findViewById(R.id.helptext2);
			texthelp.setVisibility(View.INVISIBLE);
			next.setVisibility(View.VISIBLE);
		}
		
		if(v == done){
			Intent myIntent = new Intent(HowToPlay.this, MainActivity.class);
			HowToPlay.this.startActivity(myIntent);
		}
	}
}
