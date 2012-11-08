package com.poppio.bioclock;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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
				startActivity(new Intent(MainActivity.this, Info_screen.class));
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
