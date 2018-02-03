package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class TemplatesMenu extends AppCompatActivity {

//    Template[] templates;
//    templates = new Template[4];
//    Template basic;
//    Template intermediate;
//    Template comprehensive;
//    Template comprehensive2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates_menu);
    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onAddClick(View view) {
        Intent intent = new Intent(this, NewTemplate.class);
        startActivity(intent);
        //final RadioButton btn = new RadioButton();
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
