package com.final_proj.winslow;

import android.app.Activity;
import android.content.res.TypedArray;
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
		
		/*TypedArray imgs = getResources().obtainTypedArray(R.array.random_imgs);
		imgs.getResourceId(1, -1);
		// or set you ImageView's resource to the id
		mImgView1.setImageResource(imgs.getResourceId(1, -1));*/
		
		//int[] ImageList = new int[]{R.drawable.trexel};
		//myImageView.setImageResource(ImageList[1]);
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
			setContentView(R.layout.game);
		}
		
	}

}
