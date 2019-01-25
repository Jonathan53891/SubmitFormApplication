package com.itexps.app.submitformapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //get data that is sent by main activity then asking them to variables
        String name = getIntent().getStringExtra("name");
        String lastname = getIntent().getStringExtra("lastname");
        String gender = getIntent().getStringExtra("gender");
        String educationLevel = getIntent().getStringExtra("educationLevel");
        String termsAccepted = getIntent().getStringExtra("termsAccepted");

        //find the textView components that we added to second activity layout
        TextView txtName = (TextView) findViewById(R.id.txtName);
        TextView txtLastName = (TextView) findViewById(R.id.txtLastName);
        TextView txtGender = (TextView) findViewById(R.id.txtGender);
        TextView txtEducation = (TextView) findViewById(R.id.txtEducationLevel);
        TextView txtTermsAccepted = (TextView) findViewById(R.id.txtTermsAccepted);

        //bind the variables to textView Components
        txtName.setText(name);
        txtLastName.setText(lastname);
        txtGender.setText(gender);
        txtEducation.setText(educationLevel);
        txtTermsAccepted.setText(termsAccepted);
    }
}
