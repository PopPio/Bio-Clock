package com.poppio.bioclock;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class Info_screen extends Activity {
	Information [] info = new Information [13];
	int currentId = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//get current timeID from home screen
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			currentId = extras.getInt("timeID");
		}
		
		//get string info from global variable
		info = ((GlobalVar)getApplication()).getInfo();
		
		//set text
		int infoTextId = info[currentId].getDescription();
		int timeTestId = info[currentId].getTime();
		int extraId = info[currentId].getExtra();
		setContentView(R.layout.info_activity);
		
		Typeface penna = Typeface.createFromAsset(getAssets(),"fonts/penna.ttf");
		Typeface vanilla = Typeface.createFromAsset(getAssets(),"fonts/Vanilla.ttf");
		
		TextView time = (TextView) findViewById(R.id.timeText);
		time.setText(timeTestId);
		time.setTypeface(vanilla);
		
		TextView info = (TextView) findViewById(R.id.infoText);
		info.setText(infoTextId);
		info.setTypeface(penna,Typeface.BOLD);
		
		TextView extra = (TextView) findViewById(R.id.extraText);
		if(getString(extraId).equals("null")){
			extra.setVisibility(View.GONE);
		}else{
			extra.setText(extraId);
			extra.setTypeface(penna,Typeface.BOLD);
		}
		
		//set back button
		ImageButton back = (ImageButton) findViewById(R.id.backButton);
		back.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.d("PopPio", "backButton was clicked");
				startActivity(new Intent(Info_screen.this, MainActivity.class));
			}
		});
		
		//set checkbox
		final ImageButton check = (ImageButton) findViewById(R.id.checkInfo);
		if(((GlobalVar)getApplication()).isCheck()){
			check.setImageResource(R.drawable.circle_check);
		}else{
			check.setImageResource(R.drawable.circle_none);
		}
		check.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Log.d("PopPio", "check was clicked");
				
				if(((GlobalVar)getApplication()).isCheck()){ //already checked, so we uncheck it
					check.setImageResource(R.drawable.circle_none);
					((GlobalVar)getApplication()).setCheck(false);
				}else{
					check.setImageResource(R.drawable.circle_check);
					((GlobalVar)getApplication()).setCheck(true);
					
				}
			}
		});
		
	}
	
}