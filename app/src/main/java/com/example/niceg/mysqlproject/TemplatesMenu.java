package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Templates;

public class TemplatesMenu extends AppCompatActivity {
    VolleyStats vol;
    Template basic = new Template("BASIC", false, false);
    Template intermediate = new Template("INTERMEDIATE", false, false);
    Template comprehensive = new Template("COMPREHENSIVE", false, false);
    Template comprehensive2 = new Template("COMPREHENSIVE2", false, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        vol = (VolleyStats) getIntent().getSerializableExtra("volleyStatsClass");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates_menu);

        if( vol.templatesList.isEmpty()) {
            vol.templatesList.add(basic);
            vol.templatesList.add(intermediate);
            vol.templatesList.add(comprehensive);
            vol.templatesList.add(comprehensive2);
        }

        newTemplate(vol.templatesList);
    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onAddClick(View view) {

        //Bundle b = new Bundle();
        //b.putSerializable("list", vol);

        Intent intent = new Intent(this, NewTemplate.class);

        //intent.putExtra("listBundle", b);

        intent.putExtra("volleyStatsClass2", (Serializable) vol);

        startActivity(intent);
     }

     public void newTemplate(List list) {
        //loop through list and make buttons for each template

         for (int i = 0; i < list.size(); i++) {

             Template temp = (Template)list.get(i);

             RadioButton radioButton = new RadioButton(this);
             radioButton.layout(0,16,24,0);
             radioButton.setText(temp.getNameEmma());
             radioButton.setTextSize(30);
             //radioButton.setTextColor(Color.parseColor("#aaa"));

             RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
             rg.addView(radioButton);
         }

     }

     public VolleyStats getVol() {
        return vol;
     }

}