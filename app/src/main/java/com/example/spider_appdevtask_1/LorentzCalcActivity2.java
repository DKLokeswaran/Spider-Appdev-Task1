package com.example.spider_appdevtask_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.math.BigDecimal;

public class LorentzCalcActivity2 extends AppCompatActivity {

    EditText speed;
    TextView answer;
    double velocity,lorentzFactor;
    BigDecimal rndoff;
    double c=299792458;

    public void calculatorLorentz(){
        if(velocity>c){
            Toast.makeText(this, "Given velocity is greater than speed of light", Toast.LENGTH_SHORT).show();
            answer.setText("Lorentz Factor:");
        }
        else if (velocity<0){
            Toast.makeText(this, "Given velocity is negative ", Toast.LENGTH_SHORT).show();
            answer.setText("Lorentz Factor:");
        }
        else {
            lorentzFactor=1/((Math.sqrt(1-((Math.pow(velocity,2))/(Math.pow(c,2))))));
            rndoff=BigDecimal.valueOf(lorentzFactor).setScale(7, BigDecimal.ROUND_HALF_UP);
            String st=rndoff.toString();
            answer.setText("Lorentz Factor: "+st);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lorentz_calc2);
        speed=findViewById(R.id.input1);
        answer=findViewById(R.id.ans1);
    }
    public void enter(View view){
        if(speed.getText().toString().equals("")){
            Toast.makeText(this, "Enter a value", Toast.LENGTH_SHORT).show();
            answer.setText("Lorentz Factor:");
        }
        else {
            velocity=Double.parseDouble(speed.getText().toString());
            calculatorLorentz();
        }
    }
    public void backFrm1(View view){
        Intent intent=new Intent(LorentzCalcActivity2.this,MainActivity.class);
        startActivity(intent);
    }
}