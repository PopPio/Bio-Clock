package com.poppio.bioclock;

import android.os.Bundle;
import android.app.Activity;
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

		Button clockButton = (Button) findViewById(R.id.clockButton);
		clockButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Log.d("PopPio", "clockButton was clicked");
				
				Time now = new Time(Time.getCurrentTimezone());
				now.setToNow();
				
				int sendID = computeTime(now.hour);
				Log.d("PopPio", "computed hour id is "+ sendID);
				
				Intent intent = new Intent(MainActivity.this, Info_screen.class);
				intent.putExtra("timeID", computeTime(now.hour));
				startActivity(intent);
//				startActivity(new Intent(MainActivity.this, Info_screen.class));
			}
		});
	}
	
	public int computeTime(int time){
    	if(time>23){
    		return 12;
    	}else if(time>21){
    		return 11;
    	}else if(time>19){
    		return 10;
    	}else if(time>17){
    		return 9;
    	}else if(time>15){
    		return 8;
    	}else if(time>13){
    		return 7;
    	}else if(time>11){
    		return 6;
    	}else if(time>9){
    		return 5;
    	}else if(time>7){
    		return 4;
    	}else if(time>5){
    		return 3;
    	}else if(time>3){
    		return 2;
    	}else if(time>1){
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