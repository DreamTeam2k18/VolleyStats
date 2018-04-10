package com.example.niceg.mysqlproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SchoolInfo extends Activity {

    static CharSequence home_name = "";
    static CharSequence away_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_info);

        TextView name;
        TextView mascot;
        name = (TextView) findViewById(R.id.et_home);
        name.setText(getHome_name());
        mascot = (TextView) findViewById(R.id.et_away);
        mascot.setText(getAway_name());
    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onClearClick(View view) {
        TextView name;
        TextView mascot;
        name = (TextView) findViewById(R.id.et_home);
        name.setText("");
        mascot = (TextView) findViewById(R.id.et_away);
        mascot.setText("");
    }

    public void onDoneClick(View view) {
        TextView name;
        TextView mascot;
        CharSequence nameText;
        CharSequence mascotText;
        name = (TextView) findViewById(R.id.et_home);
        nameText = name.getText();
        home_name = nameText;
        mascot = (TextView) findViewById(R.id.et_away);
        mascotText = mascot.getText();
        away_name = mascotText;

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public String getHome_name() {
        return (String)home_name;
    }

    public String getAway_name() {
        return (String)away_name;
    }

}
