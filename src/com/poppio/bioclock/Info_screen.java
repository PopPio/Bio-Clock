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
	Information [] info = new Information [13];
	int currentId = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		fetchInfo ();
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			currentId = extras.getInt("timeID");
		}
		
		int infoTextId = info[currentId].getDescription();
		int timeTestId = info[currentId].getTime();
		int extraId = info[currentId].getExtra();
		setContentView(R.layout.info_activity);
		
		TextView info = (TextView) findViewById(R.id.infoText);
		info.setText(infoTextId);
		
		TextView time = (TextView) findViewById(R.id.timeText);
		time.setText(timeTestId);
		
		TextView extra = (TextView) findViewById(R.id.extraText);
		if(getString(extraId).equals("null")){
			extra.setVisibility(View.GONE);
		}else{
			extra.setText(extraId);
		}
		
		
		ImageButton back = (ImageButton) findViewById(R.id.backButton);
		back.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Log.d("PopPio", "backButton was clicked");
				startActivity(new Intent(Info_screen.this, MainActivity.class));
			}
		});
	}
	
	private void fetchInfo (){
		info[0] = new Information(0, 0, 0, 0);
		info[1] = new Information(R.string.time1, R.string.info1, R.string.infoEx1, R.string.noti1);
		info[2] = new Information(R.string.time2, R.string.info2, R.string.infoEx2, R.string.noti2);
		info[3] = new Information(R.string.time3, R.string.info3, R.string.infoEx3, R.string.noti3);
		info[4] = new Information(R.string.time4, R.string.info4, R.string.infoEx4, R.string.noti4);
		info[5] = new Information(R.string.time5, R.string.info5, R.string.infoEx5, R.string.noti5);
		info[6] = new Information(R.string.time6, R.string.info6, R.string.infoEx6, R.string.noti6);
		info[7] = new Information(R.string.time7, R.string.info7, R.string.infoEx7, R.string.noti7);
		info[8] = new Information(R.string.time8, R.string.info8, R.string.infoEx8, R.string.noti8);
		info[9] = new Information(R.string.time9, R.string.info9, R.string.infoEx9, R.string.noti9);
		info[10] = new Information(R.string.time10, R.string.info10, R.string.infoEx10, R.string.noti10);
		info[11] = new Information(R.string.time11, R.string.info11, R.string.infoEx11, R.string.noti11);
		info[12] = new Information(R.string.time12, R.string.info12, R.string.infoEx12, R.string.noti12);
	}

	// public void stop(){
	// super.onStop();
	// }
}