package com.poppio.bioclock;

import java.util.Calendar;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AnalogClock;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//	Known Issue:
//	-Clock don't change bg if you not change view -> need to implement runable
//	-Alarm only notify you 1 next notification -> need to implement chain alarm
//	-Didn't implement score view
//	-Didn't implement setting view

public class MainActivity extends Activity {
	private PendingIntent pendingIntent;
	int hour;
	Information [] info;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//add notification , also compute other stuffs
		notification();
		
//		Button clockButton = (Button) findViewById(R.id.clockButton);
//		clockButton.setOnClickListener(new OnClickListener() {
//			public void onClick(View v) {
//				Log.d("PopPio", "clockButton was clicked");
//				
//				Time now = new Time(Time.getCurrentTimezone());
//				now.setToNow();
//				Log.d("PopPio", "current Hour is " + now.hour);
//				int sendID = computeTime(now.hour);
//				Log.d("PopPio", "computed hour id is "+ sendID);
//				
//				Intent intent = new Intent(MainActivity.this, Info_screen.class);
//				intent.putExtra("timeID", computeTime(now.hour));
//				startActivity(intent);
//				
//			}
//		});
		
	}
	
	
	@Override
	public void onStart(){
		super.onStart();
		
		//Assign correct analog clock bg
		ImageView clockBg = (ImageView) findViewById(R.id.clockBg);
		if(hour>=18){
			clockBg.setImageResource(R.drawable.clock_night);
		}else if(hour>=6){
			clockBg.setImageResource(R.drawable.clock_day);
		}else{
			clockBg.setImageResource(R.drawable.clock_night);
		}
		
		//Analog clock button 
			AnalogClock ac = (AnalogClock) findViewById(R.id.analogClock);
			ac.setClickable(true);
			ac.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
				Log.d("PopPio", "clockButton was clicked");
				
				Time now = new Time(Time.getCurrentTimezone());
				now.setToNow();
				Log.d("PopPio", "current Hour is " + now.hour);
				int sendID = computeTime(now.hour);
				Log.d("PopPio", "computed hour id is "+ sendID);
				
				Intent intent = new Intent(MainActivity.this, Info_screen.class);
				intent.putExtra("timeID", computeTime(now.hour));
				startActivity(intent);
				
			}
		});
		
		//checkbox
		final ImageButton checkHome = (ImageButton) findViewById(R.id.checkHome);
		if(((GlobalVar)getApplication()).isCheck()){
			checkHome.setImageResource(R.drawable.circle_check);
		}else{
			checkHome.setImageResource(R.drawable.circle_none);
		}
		checkHome.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Log.d("PopPio", "check was clicked");
				
				if(((GlobalVar)getApplication()).isCheck()){ //already checked, so we uncheck it
					checkHome.setImageResource(R.drawable.circle_none);
					((GlobalVar)getApplication()).setCheck(false);
				}else{
					checkHome.setImageResource(R.drawable.circle_check);
					((GlobalVar)getApplication()).setCheck(true);
					
				}
			}
		});
		
		
		info = ((GlobalVar)getApplication()).getInfo();
		
		//text in box
		TextView textHome = (TextView) findViewById(R.id.textHome);
		textHome.setText(info[computeTime(hour)].getNoti());
		
	}
	

	
	public void notification(){
		Intent myIntent = new Intent(MainActivity.this,NotificationCenter.class);
		
		pendingIntent = PendingIntent.getService(MainActivity.this, 0, myIntent, 0);

		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

		Calendar calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		calendar.set(Calendar.HOUR_OF_DAY, computeAlarm(hour));
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		
		
//		calendar.setTimeInMillis(System.currentTimeMillis());
//		calendar.add(Calendar.SECOND, 10);
		alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(), pendingIntent);
		Log.d("PopPio", "set notificationTest completed");
//		Toast.makeText(MainActivity.this, "Start Alarm Test", Toast.LENGTH_LONG).show();
		
	}
	
	
	public static int computeTime(int time){
    	if(time>=23){
    		return 12;
    	}else if(time>=21){
    		return 11;
    	}else if(time>=19){
    		return 10;
    	}else if(time>=17){
    		return 9;
    	}else if(time>=15){
    		return 8;
    	}else if(time>=13){
    		return 7;
    	}else if(time>=11){
    		return 6;
    	}else if(time>=9){
    		return 5;
    	}else if(time>=7){
    		return 4;
    	}else if(time>=5){
    		return 3;
    	}else if(time>=3){
    		return 2;
    	}else if(time>=1){
    		return 1;
    	}else{
    		return 12;
    	}
    }
	
	
	public static int computeAlarm(int time){
    	if(time>=23){
    		return 1;
    	}else if(time>=21){
    		return 23;
    	}else if(time>=19){
    		return 21;
    	}else if(time>=17){
    		return 19;
    	}else if(time>=15){
    		return 17;
    	}else if(time>=13){
    		return 15;
    	}else if(time>=11){
    		return 13;
    	}else if(time>=9){
    		return 11;
    	}else if(time>=7){
    		return 9;
    	}else if(time>=5){
    		return 7;
    	}else if(time>=3){
    		return 5;
    	}else if(time>=1){
    		return 3;
    	}else{
    		return 1;
    	}
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	

}