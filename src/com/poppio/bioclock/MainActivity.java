package com.poppio.bioclock;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		notification ();
		
		Button clockButton = (Button) findViewById(R.id.clockButton);
		clockButton.setOnClickListener(new OnClickListener() {
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
	}
	
	public void notification () {
		Intent notiIntent = new Intent(this , NotificationCenter.class);
		AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
	    PendingIntent pendingIntent = PendingIntent.getService(this, 0, notiIntent, 0);

	    Calendar calendar = Calendar.getInstance();
//	    calendar.set(Calendar.HOUR_OF_DAY, 00);
//	    calendar.set(Calendar.MINUTE, 29);
//	    calendar.set(Calendar.SECOND, 00);
	    
	    alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis() , pendingIntent); 
	    Log.d("PopPio", "set notification completed");
	    
	    Log.d("PopPio", "calendar:"+calendar.get(Calendar.DAY_OF_MONTH)+"-"+calendar.get(Calendar.MONTH)+"--"+calendar.get(Calendar.HOUR_OF_DAY)+"-"+calendar.get(Calendar.MINUTE));
	}
	
	public int computeTime(int time){
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}