package com.poppio.bioclock;

import java.util.Calendar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class NotificationCenter extends Service {
	Information [] info = new Information [13];
	private static final int NOTIF_ID = 1;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
//		Toast.makeText(this, "NotificationService.onCreate()", Toast.LENGTH_LONG).show();
		fetchInfo ();
		Log.d("PopPio", "noti onCreate");
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "NotificationService.onBind()", Toast.LENGTH_LONG).show();
		return null;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "NotificationService.onDestroy()", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
//		Toast.makeText(this, "NotificationService.onStart()", Toast.LENGTH_LONG).show();
		
		
		NotificationManager nm = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        long when = System.currentTimeMillis();         // notification time

        Notification notification = new Notification(R.drawable.ic_launcher,"Bio Clock Notification", when);
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.flags |= notification.FLAG_AUTO_CANCEL;
        Intent notificationIntent = new Intent(this, Info_screen.class);
        
        Time now = new Time(Time.getCurrentTimezone());
		now.setToNow();
		
	
		int nowID = MainActivity.computeTime(now.hour); 
		int notiId = info[nowID].getNoti();
		
        notificationIntent.putExtra("timeID", nowID);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent , 0);
        String notiText;
        
        if(getString(notiId).equals("null")){
        	notiText = "";
        	notification.setLatestEventInfo(getApplicationContext(), "Bio Clock Notification", "This should not show up", contentIntent);
        }else{
        	notiText = getString(notiId);
        	notification.setLatestEventInfo(getApplicationContext(), "Bio Clock Notification", notiText, contentIntent);
        	nm.notify(NOTIF_ID, notification);
        }
        
        
        
        Log.d("PopPio", "notify user");
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "NotificationService.onUnbind()", Toast.LENGTH_LONG)
				.show();
		return super.onUnbind(intent);
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
}