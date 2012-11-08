package com.poppio.bioclock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class Info_screen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_activity);
		TextView info = (TextView) findViewById(R.id.infoText);
		info.setText(R.string.info2);
		TextView time = (TextView) findViewById(R.id.timeText);
		time.setText(R.string.time2);
		
		ImageButton back = (ImageButton) findViewById(R.id.backButton);
		back.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d("PopPio", "backButton was clicked");
				startActivity(new Intent(Info_screen.this, MainActivity.class));
			}
		});
	}
	
//	public void stop(){
//		super.onStop();
//	}
}
