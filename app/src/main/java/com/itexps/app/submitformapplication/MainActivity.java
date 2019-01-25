package com.itexps.app.submitformapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtLastName;
    RadioGroup rgGender;
    RadioButton rbGender;
    Spinner spEducationLevel;
    CheckBox chbAcceptTerms;

    String name;
    String lastname;
    String gender;
    String educationLevel;
    String termsAccepted="No";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Education Spinner

        //Create an adapter which is a container of spinner values
        ArrayAdapter<String> myAddapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.educationlevel));

        //Specify this adaptor will have a drop down list

        myAddapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //bind adapter to spinner
        spEducationLevel = (Spinner)
                findViewById(R.id.spEducationLevel);
        spEducationLevel.setAdapter(myAddapter);
        //when a spinner item is selected, get the text if selected element

        spEducationLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                educationLevel = spEducationLevel.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

        //Gender ratio button

        //when this method is called we will find out which radiobutton is clicked
    public void rbClick(View view){

        rgGender=(RadioGroup)findViewById(R.id.rgGender);

        int radioButtonGenderID=rgGender.getCheckedRadioButtonId();
        rbGender=(RadioButton)findViewById(radioButtonGenderID);

        //get the text of the selected radiobutton
        gender=rbGender.getText().toString();

    }
    //AcceptedTerms CheckBox
    //when the submit button is clicked
    public void onClick(View view) {

        edtName=(EditText)findViewById(R.id.edtName);
        edtLastName=(EditText) findViewById(R.id.edtLastName);
        chbAcceptTerms=(CheckBox)findViewById(R.id.chbAcceptTerms);

        //get name, last name
        name=edtName.getText().toString();
        lastname=edtLastName.getText().toString();

        //check if the check box is checked
        if (chbAcceptTerms.isChecked()){
            termsAccepted="Yes";
        }

        Intent intent= new Intent(MainActivity.this,SecondActivity.class);

        intent.putExtra("name",name);
        intent.putExtra("lastname",lastname);
        intent.putExtra("gender",gender);
        intent.putExtra("educationLevel",educationLevel);
        intent.putExtra("termsAccepted",termsAccepted);

        startActivityForResult(intent,44);
    }
}
