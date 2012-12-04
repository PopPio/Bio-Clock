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

public class Score_screen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score_activity);
		
		Typeface penna = Typeface.createFromAsset(getAssets(),"fonts/penna.ttf");
		Typeface vanilla = Typeface.createFromAsset(getAssets(),"fonts/Vanilla.ttf");
		
		TextView time = (TextView) findViewById(R.id.scoreText);
		time.setTypeface(vanilla);
		
		TextView textDate = (TextView) findViewById(R.id.score_date);
		textDate.setTypeface(penna,Typeface.BOLD);
		TextView textDate1 = (TextView) findViewById(R.id.score_date1);
		textDate1.setTypeface(penna,Typeface.BOLD);
		TextView textDate2 = (TextView) findViewById(R.id.score_date2);
		textDate2.setTypeface(penna,Typeface.BOLD);
		TextView textDate3 = (TextView) findViewById(R.id.score_date3);
		textDate3.setTypeface(penna,Typeface.BOLD);
		TextView textDate4 = (TextView) findViewById(R.id.score_date4);
		textDate4.setTypeface(penna,Typeface.BOLD);
		TextView textDate5 = (TextView) findViewById(R.id.score_date5);
		textDate5.setTypeface(penna,Typeface.BOLD);
		TextView textDate6 = (TextView) findViewById(R.id.score_date6);
		textDate6.setTypeface(penna,Typeface.BOLD);
		TextView textDate7 = (TextView) findViewById(R.id.score_date7);
		textDate7.setTypeface(penna,Typeface.BOLD);
		TextView textDate8 = (TextView) findViewById(R.id.score_date8);
		textDate8.setTypeface(penna,Typeface.BOLD);

		TextView textScore = (TextView) findViewById(R.id.score_score);
		textScore.setTypeface(penna,Typeface.BOLD);
		TextView textScore1 = (TextView) findViewById(R.id.score_score1);
		textScore1.setTypeface(penna,Typeface.BOLD);
		TextView textScore2 = (TextView) findViewById(R.id.score_score2);
		textScore2.setTypeface(penna,Typeface.BOLD);
		TextView textScore3 = (TextView) findViewById(R.id.score_score3);
		textScore3.setTypeface(penna,Typeface.BOLD);
		TextView textScore4 = (TextView) findViewById(R.id.score_score4);
		textScore4.setTypeface(penna,Typeface.BOLD);
		TextView textScore5 = (TextView) findViewById(R.id.score_score5);
		textScore5.setTypeface(penna,Typeface.BOLD);
		TextView textScore6 = (TextView) findViewById(R.id.score_score6);
		textScore6.setTypeface(penna,Typeface.BOLD);
		TextView textScore7 = (TextView) findViewById(R.id.score_score7);
		textScore7.setTypeface(penna,Typeface.BOLD);
		TextView textScore8 = (TextView) findViewById(R.id.score_score8);
		textScore8.setTypeface(penna,Typeface.BOLD);
		
		
		//back button
		ImageButton backButton = (ImageButton) findViewById(R.id.score_backButton);
		backButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Log.d("PopPio", "score's backButton was clicked");
				startActivity(new Intent(Score_screen.this, MainActivity.class));
			}
		});
		
	}
	
	@Override
	public void onStart(){
		super.onStart();
		
	}
	
	
}