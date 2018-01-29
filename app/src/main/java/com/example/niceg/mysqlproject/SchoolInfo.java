package com.example.niceg.mysqlproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SchoolInfo extends Activity {

    static CharSequence school_name = "";
    static CharSequence mascot_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_info);

        TextView name;
        TextView mascot;
        name = (TextView) findViewById(R.id.et_player_num);
        name.setText(getSchool_name());
        mascot = (TextView) findViewById(R.id.et_player_name);
        mascot.setText(getMascot_name());
    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onClearClick(View view) {
        TextView name;
        TextView mascot;
        name = (TextView) findViewById(R.id.et_player_num);
        name.setText("");
        mascot = (TextView) findViewById(R.id.et_player_name);
        mascot.setText("");
    }

    public void onDoneClick(View view) {
        TextView name;
        TextView mascot;
        CharSequence nameText;
        CharSequence mascotText;
        name = (TextView) findViewById(R.id.et_player_num);
        nameText = name.getText();
        school_name = nameText;
        mascot = (TextView) findViewById(R.id.et_player_name);
        mascotText = mascot.getText();
        mascot_name = mascotText;

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public CharSequence getSchool_name() {
        return school_name;
    }

    public CharSequence getMascot_name() {
        return mascot_name;
    }

}
