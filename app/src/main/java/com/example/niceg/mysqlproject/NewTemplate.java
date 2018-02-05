package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class NewTemplate extends AppCompatActivity {

    CharSequence templateName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_template);

        TextView name;
        name = (TextView) findViewById(R.id.name);
        name.setText(getTemplateName());
    }

    public CharSequence getTemplateName() {
        return templateName;
    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onClearClick(View view) {
        TextView name;
        TextView mascot;
        name = (TextView) findViewById(R.id.name);
        name.setText("");
    }

    public void onDoneClick(View view) {
        TextView name;
        CharSequence nameText;
        name = (TextView) findViewById(R.id.name);
        nameText = name.getText();
        templateName = nameText;


        //Template tmp = new Template(findViewById(R.id.name), findViewById(R.id.srv_rcv_0), findViewById(R.id.srv_p));

        Intent intent = new Intent(this, TemplatesMenu.class);
        intent.putExtra("btnName", templateName);
        //RadioButton radioButton = (RadioButton) findViewById(R.id.)
        startActivity(intent);
    }
}
