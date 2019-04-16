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


        configuration();

        Emailinput    =   findViewById(R.id.email_id);
        Passwordinput =   findViewById(R.id.pass_id);
       /* subButton     =    (Button)   findViewById(R.id.submitBtn);

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email       =   Emailinput.getText().toString();
                password    =   Passwordinput.getText().toString();
                //showToast(email);
                //showToast(password);

            }
        });
*/

    }

    private void configuration(){
        Button loginButton = findViewById(R.id.submitBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this, MainActivity.class));
            }
        });
    }



    private void showToast(String text){
        Toast.makeText(loginActivity.this, text, Toast.LENGTH_SHORT).show();
    }

}
