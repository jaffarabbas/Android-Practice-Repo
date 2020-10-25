package com.example.design_repo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text_view,text;
    EditText username,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_view = (TextView)findViewById(R.id.textView);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login_button);
        text = (TextView)findViewById(R.id.textView2);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,pass,filer_name,filer_password;
               name = username.getText().toString();
               pass = password.getText().toString();

               filer_name = "Jaffar";
               filer_password = "1";

               if(name.equals(filer_name) && pass.equals(filer_password)){
                   Intent new_screen = new Intent(MainActivity.this,Welcome_Page.class);
                   startActivity(new_screen);
                   text.setText("Login Succesfull");
               }else if(name.equals("") && pass.equals("")){
                   text.setText("Enter Feild");
               }else if(name!=filer_name || pass != filer_password){
                   text.setText("Wrong");
               }
            }
        });
    }

    public void textTaker(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}