package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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

}
