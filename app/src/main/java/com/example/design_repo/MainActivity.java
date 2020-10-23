package com.example.design_repo;

import androidx.appcompat.app.AppCompatActivity;

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
                String name,pass;
               name = username.getText().toString();
               pass = password.getText().toString();

               text.setText(name);
            }
        });
    }
}