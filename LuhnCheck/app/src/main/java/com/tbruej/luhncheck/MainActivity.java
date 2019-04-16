package com.tbruej.luhncheck;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tbruej.luhncheck.loginActivity;

public class MainActivity extends AppCompatActivity {

    EditText CardID;
    String cardNo;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        logoutConfig();
        checkConfig();


    }




// configuration
    private void logoutConfig(){
        Button logout = findViewById(R.id.logoutButton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(MainActivity.this, loginActivity.class));
            finish();
            }
        });
    }


    private void checkConfig(){
        Button checkBtn = findViewById(R.id.checkBtn);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CardID = findViewById(R.id.cardNoText);
                cardNo = CardID.getText().toString();

                TextView displayValidityTxt = findViewById(R.id.validityTxt);


                if (checkLuhn(cardNo) ) {
                    System.out.println("VALID!");
                    displayValidityTxt.setText("Valid!");
                }
                else {
                    System.out.println("NOT VALID!");
                    displayValidityTxt.setText("NOT Valid!");
                }
            }
        });
    }




// checkluhn
    public static boolean checkLuhn(String cardNo){
        int nDigit = cardNo.length();
        int nSum = 0;
        boolean isSecond = false;

        for(int i = nDigit - 1 ; i >= 0; i--){

            int d = cardNo.charAt(i) - '0';

            if (isSecond == true)
                d = d * 2;

            nSum += d  / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }

        return (nSum % 10 == 0);
    }

}