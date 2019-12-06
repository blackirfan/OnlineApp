package com.example.onlineapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter {


    // ekhane ekta list neoya holo

    List list= new ArrayList();
    public ContactAdapter(Context context, int resource) {
        super(context, resource);
    }


    // add method getCount getItem getView ei four method banate hobe

    public void add(Contact object) {
        super.add(object);

        // jei array list banano holo set ate object add kora hochhe
        list.add(object);
    }

    @Override
    public int getCount() {

        // list er size bole deoya holo jate getView koto gula hobe seta bole deoya holo
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return  list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row=convertView;
        //niche Contact holder name eekta class banano hoyeche erpor eta initialize kora holo

        ContactHolder contactHolder;
        if(row==null){
            LayoutInflater layoutInflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_list,parent,false);
            contactHolder= new ContactHolder();

            //ekhane type  cast kora holo

            contactHolder.tx_name= (TextView) row.findViewById(R.id.name);
            contactHolder.tx_email= (TextView) row.findViewById(R.id.email);
            contactHolder.tx_contact= (TextView) row.findViewById(R.id.contact);
            contactHolder.tx_password= (TextView) row.findViewById(R.id.password);

//            row er modhe contact holder ta set kora holo
            row.setTag(contactHolder);
        }
        else {
            contactHolder= (ContactHolder) row.getTag();

        }

        Contact contacts= (Contact) this.getItem(position);

        // contact class er get method gulo use kora hochhe

        contactHolder.tx_name.setText(contacts.getName());
        contactHolder.tx_email.setText(contacts.getEmail());
        contactHolder.tx_contact.setText(contacts.getContact());
        contactHolder.tx_password.setText(contacts.getPassword());
        return row;
    }

    static class ContactHolder{

        TextView tx_name,tx_email,tx_contact,tx_password;

    }
}