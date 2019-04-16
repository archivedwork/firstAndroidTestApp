package com.tbruej.luhncheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class loginActivity extends AppCompatActivity {

    String email, password;



    EditText Emailinput;
    EditText Passwordinput;

    Button subButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



        // call function here
        configuration();



    }

    private void configuration(){

        Emailinput    =   findViewById(R.id.email_id);
        Passwordinput =   findViewById(R.id.pass_id);

        Button loginButton = findViewById(R.id.submitBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email      = Emailinput.getText().toString();
                password   = Passwordinput.getText().toString();


                if((email.equals("md@gmail.com")) && (password.equals("123"))){
                    startActivity(new Intent(loginActivity.this, MainActivity.class));

                }else {
                   showToast("Wrong entry!");
                }
            }
        });
    }



    private void showToast(String text){
        Toast.makeText(loginActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}
