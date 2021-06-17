package com.example.spider_appdevtask_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class spiFac extends AppCompatActivity {

    Date date=new Date();
    TextView spi,timer;
    double hrs,min,sec;
    Calendar calendar= GregorianCalendar.getInstance();
    String str1,str2,str3;


    public double factorial(double n){
        if(n==0||n==1){
            return 1;
        }
        else {
            return n*factorial(n-1);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spi_fac);
        spi=findViewById(R.id.ans3);
        timer=findViewById(R.id.time);
        calendar.setTime(date);
        Thread thread=new Thread(){
            @Override
            public void run() {
                try{
                    while (!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Date date=new Date();
                                calendar.setTime(date);
                                sec= calendar.get(Calendar.SECOND);
                                min=calendar.get(Calendar.MINUTE);
                                if(calendar.get(Calendar.HOUR)==0){
                                    hrs=12;
                                }
                                else {
                                    hrs=calendar.get(Calendar.HOUR);
                                }
                                if((sec/10)<1){
                                    str3="0"+(int)sec;
                                }
                                else{
                                    str3=String.valueOf((int)sec);
                                }if((min/10)<1){
                                    str2="0"+(int)min;
                                }
                                else{
                                    str2=String.valueOf((int)min);
                                }if((hrs/10)<1){
                                    str1="0"+(int)hrs;
                                }
                                else{
                                    str1=String.valueOf((int)hrs);
                                }
                                double spiF=factorial(hrs)/(Math.pow(min,3)+sec);
                                spi.setText(Double.toString(spiF));
                                timer.setText(str1+":"+str2+":"+str3);
                            }
                        });

                    }
                }
                catch (Exception e){
                    spi.setText("Error");
                }
            }
        };
        thread.start();
    }
    public void backFrm3(View view){
        Intent intent=new Intent(spiFac.this,MainActivity.class);
        startActivity(intent);

    }
}