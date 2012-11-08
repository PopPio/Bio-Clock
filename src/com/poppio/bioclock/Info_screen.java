package com.poppio.bioclock;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Info_screen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_activity);
		TextView info = (TextView) findViewById(R.id.infoText);
		info.setText(R.string.info2);
	}
}
