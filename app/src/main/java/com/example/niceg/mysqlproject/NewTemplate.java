package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class NewTemplate extends AppCompatActivity {

    CharSequence templateName = "";
    static VolleyStats vol;
    static Template newTemplate;
    static final int FROM_NEW_TEMPLATE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TemplatesMenu templatesMenu = new TemplatesMenu();
        vol = templatesMenu.getVolTemplatesMenu();

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
        String finalName;
        name = (TextView) findViewById(R.id.name);
        nameText = name.getText();
        finalName = nameText.toString();
        templateName = finalName;

        //gotta fix this later
        newTemplate = new Template(finalName);
        //vol.templatesList.add(newTemp);

        Intent intent = new Intent(this, TemplatesMenu.class);

        startActivityForResult(intent, FROM_NEW_TEMPLATE);
    }

    public static Template getVolNewTemplate() {
        return newTemplate;
    }
}
