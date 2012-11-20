package com.poppio.bioclock;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class Info_screen extends Activity {
	Information [] info = new Information [13];
	int currentId = 0;
	int hour;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		
	}
	
	@Override
	public void onStart(){
		super.onStart();
		
		//get current timeID from home screen
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			currentId = extras.getInt("timeID");
		}
		
		
		
		changeContent(currentId);
		
		//set back button
		ImageButton back = (ImageButton) findViewById(R.id.backButton);
		back.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.d("PopPio", "backButton was clicked");
				startActivity(new Intent(Info_screen.this, MainActivity.class));
			}
		});
		
		//set more info button
		ImageButton selectTime = (ImageButton) findViewById(R.id.seleteTimebutton);
		selectTime.setOnClickListener(new OnClickListener() {
			public void onClick(View vv) {
				Log.d("PopPio", "selectTimeButton was clicked");
				registerForContextMenu(vv); 
			    openContextMenu(vv);
			    unregisterForContextMenu(vv);
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
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.context_time, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		
		Typeface penna = Typeface.createFromAsset(getAssets(),"fonts/penna.ttf");
		Typeface vanilla = Typeface.createFromAsset(getAssets(),"fonts/Vanilla.ttf");
		
		Calendar calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		int currentTimeID = MainActivity.computeTime(hour);
		
		TextView time = (TextView) findViewById(R.id.timeText);
		TextView infoText = (TextView) findViewById(R.id.infoText);
		TextView extra = (TextView) findViewById(R.id.extraText);
		
		info = ((GlobalVar)getApplication()).getInfo();
		int infoTextId;
		int timeTestId;
		int extraId;
		int selectID;
		
		if(id==R.id.time1){
			selectID = 1;
		}else if(id==R.id.time2){
			selectID = 2;
		}else if(id==R.id.time3){
			selectID = 3;
		}else if(id==R.id.time4){
			selectID = 4;
		}else if(id==R.id.time5){
			selectID = 5;
		}else if(id==R.id.time6){
			selectID = 6;
		}else if(id==R.id.time7){
			selectID = 7;
		}else if(id==R.id.time8){
			selectID = 8;
		}else if(id==R.id.time9){
			selectID = 9;
		}else if(id==R.id.time10){
			selectID = 10;
		}else if(id==R.id.time11){
			selectID = 11;
		}else{
			selectID = 12;
		}
		
		infoTextId = info[selectID].getDescription();
		timeTestId = info[selectID].getTime();
		extraId = info[selectID].getExtra();
		
		time.setText(timeTestId);
		infoText.setText(infoTextId);
		if(getString(extraId).equals("null")){
			extra.setVisibility(View.GONE);
		}else{
			extra.setVisibility(View.VISIBLE);
			extra.setText(extraId);
			extra.setTypeface(penna,Typeface.BOLD);
		}
		
		ImageButton check = (ImageButton) findViewById(R.id.checkInfo);
		if(currentTimeID==selectID){
			check.setEnabled(true);
			
			if(((GlobalVar)getApplication()).isCheck()){
				check.setImageResource(R.drawable.circle_check);
			}else{
				check.setImageResource(R.drawable.circle_none);
			}
			
		}else{
			check.setImageResource(R.drawable.circle_none);
			check.setEnabled(false);
		}
		
		return super.onContextItemSelected(item);
	}
	
	private void changeContent(int timeID){
		//get string info from global variable
				info = ((GlobalVar)getApplication()).getInfo();
		
		//set text
				int infoTextId = info[timeID].getDescription();
				int timeTestId = info[timeID].getTime();
				int extraId = info[timeID].getExtra();
				setContentView(R.layout.info_activity);
				
				Typeface penna = Typeface.createFromAsset(getAssets(),"fonts/penna.ttf");
				Typeface vanilla = Typeface.createFromAsset(getAssets(),"fonts/Vanilla.ttf");
				
				TextView time = (TextView) findViewById(R.id.timeText);
				time.setText(timeTestId);
				time.setTypeface(vanilla);
				
				TextView infoText = (TextView) findViewById(R.id.infoText);
				infoText.setText(infoTextId);
				infoText.setTypeface(penna,Typeface.BOLD);
				
				TextView extra = (TextView) findViewById(R.id.extraText);
				if(getString(extraId).equals("null")){
					extra.setVisibility(View.GONE);
				}else{
					extra.setText(extraId);
					extra.setTypeface(penna,Typeface.BOLD);
				}
	}
}