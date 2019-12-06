package com.example.onlineapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class insert extends AppCompatActivity {


    EditText e_name,e_email,e_contact,e_password;
    String name, email,contact, password;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


        e_name = findViewById(R.id.e_name);
        e_email = findViewById(R.id.e_email);
        e_contact = findViewById(R.id.e_contact);
        e_password = findViewById(R.id.e_password);

        submitBtn =findViewById(R.id.submitBtn);



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name =e_name.getText().toString();
                email = e_email.getText().toString();
                contact =e_contact.getText().toString();
                password = e_password.getText().toString();

                String method = "register";
                // BackgroundTask class e method name , email, contact password pass kora holo


                BackgroundTask backgroundTask= new BackgroundTask(insert.this);
                backgroundTask.execute(method,name,email,contact,password);
                finish();


            }
        });
    }
}
