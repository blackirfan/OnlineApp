package com.example.onlineapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String JSON_STRING;
    String json_string;

    Button insertBUtton , showDataBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertBUtton =findViewById(R.id.insertBtn);

        showDataBtn = findViewById(R.id.showDataBtn);

//       ekhane joson file exicute korar jonno eta age kora hoye che

         new BackgroundTask().execute();


        insertBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //button click korar karone ekhane onno intent e chole gelo

                Intent intent = new Intent(MainActivity.this,insert.class);
                startActivity(intent);
            }
        });


        showDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new BackgroundTask().execute();

                Intent intent= new Intent(MainActivity.this,displyShowData.class);

                // ekhane  display show data.java file e  key ar json sting akare pathano holo
                intent.putExtra("json_data",JSON_STRING);
                startActivity(intent);

            }
        });




    }

    class BackgroundTask extends AsyncTask<Void,Void,String> {

        // api ta string akare rakha holo

        String json_url="https://mdirfanhossain.000webhostapp.com/getjsondata.php";



        @Override

        /// eta onek impportant ekta method

        protected String doInBackground(Void... voids) {

            try {

                // ekkhane ulr ta neoya holo
                URL url= new URL(json_url);

                // http url connection kora hocche

                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                InputStream inputStream= httpURLConnection.getInputStream();
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder= new StringBuilder();


                //connection complete korar por json file ta sting akare neo ya holo

                while ((json_string=bufferedReader.readLine())!=null){

                    stringBuilder.append(json_string+"\n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        public BackgroundTask() {
            super();
        }

        @Override
        protected void onPostExecute(String result) {
//            showData.setText(result);


            // ei method e result ta  sting akare niye JSON_STRING e rakha holo


            JSON_STRING = result;

//            Toast.makeText(getApplicationContext(),JSON_STRING,Toast.LENGTH_SHORT).show();

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
