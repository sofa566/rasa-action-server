package com.interinfo.rasa_action.server;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(sdf.format(new Date()));
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));
		//設定預設時區
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8")); 
		System.out.println("java.runtime.version:\t"+System.getProperty("java.runtime.version"));
		System.out.println("當前時間:\t\t"+new Date().toLocaleString());
		
		new Main();
	}
	public Main() {
	       SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	        System.out.println(sdf.format(new Date()));
	    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
	        System.out.println(dtf.format(LocalDateTime.now()));
		
	}

}
