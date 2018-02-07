package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public class Home extends AppCompatActivity {
    static VolleyStats vol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        VolleyStats temp = new VolleyStats();
        vol = temp;
        vol.templatesList = temp.getTemplatesList();
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
        //VolleyStats emmasVolleyStats = new VolleyStats();
        //intent.putExtra("volleyStatsClass", (Serializable) emmasVolleyStats);
        startActivity(intent);
    }

    public VolleyStats getVolHome() {
        return vol;
    }

}
