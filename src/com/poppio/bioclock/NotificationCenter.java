package com.poppio.bioclock;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NotificationCenter extends IntentService {
	private static final int NOTIF_ID = 1;
	
	public NotificationCenter(){
        super("NotificationService");
        Log.d("PopPio", "notify constructed");
    }
	
	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        long when = System.currentTimeMillis();         // notification time

        Notification notification = new Notification(R.drawable.ic_launcher,"Alert", when);
        notification.defaults |= Notification.DEFAULT_SOUND;
//        notification.flags |= notification.FLAG_AUTO_CANCEL;
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent , 0);
        notification.setLatestEventInfo(getApplicationContext(), "It's about time", "You should open the app now", contentIntent);
        nm.notify(NOTIF_ID, notification);
        Log.d("PopPio", "notify user");
	}

}
