package com.example.spider_appdevtask_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class Lorentzprac extends AppCompatActivity {

    EditText ques,ans;
    TextView res;
    double c=299792458;
    double velocity,lorentzFactor;
    String user;
    TextView answer;
    BigDecimal rndoff;
    ConstraintLayout temp;
    void calculatorLorentz(){
        if(velocity>c){
            Toast.makeText(this, "Given velocity is greater than speed of light", Toast.LENGTH_SHORT).show();
        }
        else if (velocity<0){
            Toast.makeText(this, "Given velocity is negative ", Toast.LENGTH_SHORT).show();
        }
        else {
            lorentzFactor=Math.pow((Math.sqrt(1-(Math.pow(velocity,2)/Math.pow(c,2)))),-1);
            rndoff= BigDecimal.valueOf(lorentzFactor).setScale(7, BigDecimal.ROUND_HALF_UP);
            if(rndoff.toString().equals(user)){
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
                res.setText("");
                temp.setBackgroundColor(Color.parseColor("#75ff8a"));
            }
            else {
                String st=rndoff.toString();
                answer.setText("Lorentz Factor: "+st);
                Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                Vibrator vibrator=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(500);
                temp.setBackgroundColor(Color.parseColor("#ff6161"));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lorentzprac);
        ques=findViewById(R.id.input2);
        ans=findViewById(R.id.input3);
        res=findViewById(R.id.ans2);
        answer=findViewById(R.id.ans2);
        temp=findViewById(R.id.row);
    }
    public void sub(View view){
        if(ques.getText().toString().equals("")){
            Toast.makeText(this, "Enter velocity", Toast.LENGTH_SHORT).show();
        }
        else if (ans.getText().toString().equals("")){
            Toast.makeText(this, "Enter the calculated Lorentz Factor", Toast.LENGTH_SHORT).show();
        }
        else {
            velocity=Double.parseDouble(ques.getText().toString());
            user=ans.getText().toString();
            calculatorLorentz();
        }
    }
    public void backFrm2(View view){
        Intent intent=new Intent(Lorentzprac.this,MainActivity.class);
        startActivity(intent);
    }
}