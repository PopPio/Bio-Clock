package com.poppio.bioclock;

import android.app.Application;
import android.util.Log;

public class GlobalVar extends Application {
    private boolean check = false;

    public boolean isCheck() {
            return check;
    }

    public void setCheck(boolean value) {
            this.check = value;
    }
    @Override
    public void onCreate() {
            //reinitialize variable
    	Log.d("PopPio", "Global Var onCreate()");
    }
}