package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Home extends AppCompatActivity {
    static VolleyStats vol;
    static Roster roster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (vol == null) {
            vol = new VolleyStats();
        }

        if(roster == null) {
            roster = new Roster();
        }
    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onSchoolInfoClick(View view) {
        Intent intent = new Intent(this, SchoolInfo.class);
        startActivity(intent);
    }

    public void onPlayerInfoClick(View view) {
        Intent intent = new Intent(this, PlayerInfo.class);
        startActivity(intent);
    }

    public void onTemplatesClick(View view) {
        Intent intent = new Intent(this, TemplatesMenu.class);
        startActivity(intent);
    }

    public void onNewClick(View view) {
        Intent intent = new Intent(this, TakeStats.class);
        startActivity(intent);
    }

    public static VolleyStats getVolHome() {
        return vol;
    }

    public static Roster getRosterHome() {
        return roster;
    }

}
