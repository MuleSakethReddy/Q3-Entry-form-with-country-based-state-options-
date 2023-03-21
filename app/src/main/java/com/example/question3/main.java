package com.example.question3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.regex.*;
import java.util.HashMap;
public class main extends Activity {
    Spinner count,state;
    EditText e1,e2,e3,e4,city,postal,add2,add1,email;
    Button b;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        e1=findViewById(R.id.t5);
        e2=findViewById(R.id.t6);
        e3=findViewById(R.id.t7);
        e4=findViewById(R.id.t8);
        city=findViewById(R.id.city);
        postal=findViewById(R.id.postal);
        add2=findViewById(R.id.add2);
        add1=findViewById(R.id.add1);
        email=findViewById(R.id.email);
        b=findViewById(R.id.b);
        count=findViewById(R.id.count);
        state=findViewById(R.id.state);
        HashMap<String, String[]> csmap = new HashMap<String, String[]>();
        csmap.put("India", new String[] {"Andaman and Nicobar Islands","Andhra Pradesh","Arunachal Pradesh ","Assam","Bihar","Chandigarh","Chhattisgarh","Dadra and Nagar Haveli","Daman and Diu","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Lakshadweep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","National Capital Territory of Delhi","Odisha","Puducherry","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"});
        csmap.put("Pakistan",new String[]{"Azad Kashmir","Balochistan","Gilgit-Baltistan","Khyber Pakhtunkhwa","Sindh"});
        csmap.put("China",new String[]{"Anhui Province","Beijing Municipality","Fujian Province","Guangxi Zhuang Autonomous Region","Henan Province","Hubei Province","Jilin Province","Inner Mongolia Autonomous Region"});
        csmap.put("Australia", new String[]{"New South Wales","Queensland","South Australia","Tasmania","Victoria","Western Australia","The Australian Capital Territory","The Northern Territory"});
        csmap.put("United States of America", new String[] {"Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "U.S. Virgin Islands", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"});
        String[] countries = {"India","Pakistan","China","Australia", "United States of America"};

        ArrayAdapter<String> s1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, csmap.get(countries[0]));
        s1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(s1);
        ArrayAdapter<String> arad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countries);
        arad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        count.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String[] newStates = csmap.get(countries[position]);
                ArrayAdapter<String> s2 = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, newStates);
                s2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                state.setAdapter(s2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        count.setAdapter(arad);
     }

    public void sub(View bv) {
        int a, b, c, d, e,s;
        e = add1.getText().toString().length();
        s = email.getText().toString().length();
        a = e1.getText().toString().length();
        b = e2.getText().toString().length();
        c = e3.getText().toString().length();
        d = e4.getText().toString().length();
        if (a == 0) {
            Toast.makeText(getApplicationContext(), "Enter Title details", Toast.LENGTH_SHORT).show();
            e1.setError("This field cannot be empty");
        }
        if (b == 0) {
            Toast.makeText(getApplicationContext(), "Enter First details", Toast.LENGTH_SHORT).show();
            e2.setError("This field cannot be empty");
        }
        if (c == 0) {
            Toast.makeText(getApplicationContext(), "Enter Last details", Toast.LENGTH_SHORT).show();
            e3.setError("This field cannot be empty");
        }
        if (e == 0) {
            Toast.makeText(getApplicationContext(), "Enter Address details", Toast.LENGTH_SHORT).show();
            add1.setError("This field cannot be empty");
        }
        if (s == 0) {
            Toast.makeText(getApplicationContext(), "Enter Email details", Toast.LENGTH_SHORT).show();
            email.setError("This field cannot be empty");
        }

        if(TextUtils.isEmpty(email.getText().toString()) || !Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
        {
            Toast.makeText(getApplicationContext(),"Invalid email",Toast.LENGTH_SHORT).show();
            email.setError("Email address is invalid");
        }
        else if(a!=0 && b!=0 && c!=0 && e!=0 && s!=0 )
        {
            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_LONG).show();
        }

    }
}
