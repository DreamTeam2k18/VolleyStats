package com.example.niceg.mysqlproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Array;

public class TemplatesMenu extends AppCompatActivity {

    //Template[] templates;
    //Template templates[] = new Template;

    Template[] templates = new Template[4];
//    Template basic;
//    Template intermediate;
//    Template comprehensive;
//    Template comprehensive2;

    CheckBox[] checkBoxes = new CheckBox[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates_menu);

//        for(int i = 0; i < 4; i++) {
//            new CheckBox()templates[i]
//        }

        Bundle extras = getIntent().getExtras();
        //if (extras != null) {
            String value = extras.getString("btnName");

        //}
        newTemplate(value);

    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onAddClick(View view) {
        Intent intent = new Intent(this, NewTemplate.class);
        startActivity(intent);

//        RadioButton radioButton = new RadioButton(this);
//        radioButton.layout(0,16,24,0);
//        radioButton.setText("test");
//        radioButton.setTextSize(30);
//        //radioButton.setTextColor(111);
//
//
//
//
//        RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
//        rg.addView(radioButton);



     }

     public void newTemplate(String name) {
         RadioButton radioButton = new RadioButton(this);
         radioButton.layout(0,16,24,0);
         radioButton.setText(name);
         radioButton.setTextSize(30);
         //radioButton.setId(0);
         //radioButton.setTextColor(111);

         RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
         rg.addView(radioButton);
     }

//    public void onBasicEditClick(View view) {
//        Intent intent = new Intent(this, .class);
//        startActivity(intent);
//    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.checkBoxB:
                if (checked)

                    break;
            case R.id.checkBoxI:
                if (checked)

                    // Pirates are the best
                    break;
            case R.id.checkBoxC:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }


}
