package com.example.onlineapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class displyShowData extends AppCompatActivity {

    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter contactAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disply_show_data);
        contactAdapter= new ContactAdapter(this,R.layout.row_list);
        listView= (ListView)findViewById(R.id.listView);
        listView.setAdapter(contactAdapter);


        // ekhane main activity theke asa json sting  ta first e catch kora holo

        JSON_STRING= getIntent().getExtras().getString("json_data");
        String name,email,contact,password;

        try {
            // ekhane string theke age object akare  nite hobe er json Array akare nite hobe


            jsonObject=new JSONObject(JSON_STRING);
            int count=0;

            //server_response ta jsondata.php  array r ei name dhukano hoyeche



            /*

            {"server_response":[{"name":"MD. IRFAN HOSSAIN","email":"irfanhossain.mizi@gmail.com",
            "contact":"0174058331","password":"123456"},
            {"name":"\u0987\u09b0\u09ab\u09be\u09a8","email":"irfanhossain.mizi@gmail.com","contact":"\u09e6\u09e7\u09ed\u09ea\u09e6\u09e6\u09eb\u09ee\u09e9\u09e9\u09e7","password":"\u0997\u0997\u0997"},
            {"name":"","email":"","contact":"","password":""},{"name":"","email":"","contact":"","password":""},
            {"name":"","email":"","contact":"","password":""},{"name":"","email":"","contact":"","password":""},
            {"name":"kamal","email":"sumubarasha@gmail.com","contact":"01521460307","password":"258963"},
            {"name":"","email":"","contact":"","password":""},
            {"name":"ratuk","email":"ratul@gmail.com","contact":"124567799","password":"wrygvgihb"},
            {"name":"\u09a8 \u09a1\u09c1\u09b0\u09be\u0987","email":"ghjj@gmail.com","contact":"0143256677","password":"chika"}
            ,{"name":"","email":"","contact":"","password":""},
            {"name":"","email":"","contact":"","password":""}]}
             */


            // ehane json ta "server_response" er vitore json file ta ase tai getJsonArray() vitore server response dite hobe


            jsonArray=jsonObject.getJSONArray("server_response");
            while (count<jsonArray.length()){

                // count 0 dhora hoyecehe erpore jsonArray theke json object neoya hochhe erpore
                // name , email... jinis gula alada alada kora hoche json object er madhome

                JSONObject JO= jsonArray.getJSONObject(count);
                name= JO.getString("name");
                email= JO.getString("email");
                contact= JO.getString("contact");
                password= JO.getString("password");

                // contact class er modhhe information gulo send kora hochhe

                Contact contacts= new Contact(name,email,contact,password);
                contactAdapter.add(contacts);
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}