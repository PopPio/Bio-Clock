package com.poppio.bioclock;

public class Information {
	private int description;
	private int extra;
	private int noti;
	private int time;
	
	public void setDescription(int description) {
		this.description = description;
	}

	public void setExtra(int extra) {
		this.extra = extra;
	}

	public void setNoti(int noti) {
		this.noti = noti;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Information (){
		this.time = 0;
		this.description = 0;
		this.extra = 0;
		this.noti = 0;
	}
	
	public Information(int time, int info, int extra, int noti){
		this.time = time;
		this.description = info;
		this.extra = extra;
		this.noti = noti;
	}
	
	
	public int getDescription(){
		return this.description;
	}
	public int getExtra(){
		return this.extra;
	}
	public int getTime(){
		return this.time;
	}
	public int getNoti(){
		return this.noti;
	}
}
