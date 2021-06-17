package com.example.spider_appdevtask_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button lorCalc,lorPrac,sFac;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lorentzcalc:
                Intent intent1=new Intent(MainActivity.this,LorentzCalcActivity2.class);
                startActivity(intent1);
                break;
            case R.id.lorentzprac:
                Intent intent2=new Intent(MainActivity.this,Lorentzprac.class);
                startActivity(intent2);
                break;
            case R.id.spifac:
                Intent intent3=new Intent(MainActivity.this,spiFac.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lorCalc=findViewById(R.id.lorentzcalc);
        lorPrac=findViewById(R.id.lorentzprac);
        sFac=findViewById(R.id.spifac);
        lorPrac.setOnClickListener(this);
        lorCalc.setOnClickListener(this);
        sFac.setOnClickListener(this);
    }
    public void exit(View view){
        this.finishAffinity();
    }
}