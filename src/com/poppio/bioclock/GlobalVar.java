package com.poppio.bioclock;

import android.app.Application;
import android.util.Log;

public class GlobalVar extends Application {
    private boolean check = false;
    private Information [] info;

    public boolean isCheck() {
            return check;
    }

    public void setCheck(boolean value) {
            this.check = value;
    }
    
    public Information [] getInfo(){
    	return info;
    }
    
    @Override
    public void onCreate() {
            //reinitialize variable
    	Log.d("PopPio", "Global Var onCreate()");
    	info = new Information [13];
    	fetchInfo ();
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
		
		
		for (int i = 1; i < 13; i++) {
			if(getString(info[i].getNoti()).equalsIgnoreCase("null")){
				info[i].setNoti(R.string.nullValue);
			}
		}
	}
}