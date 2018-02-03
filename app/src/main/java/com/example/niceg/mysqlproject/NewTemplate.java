package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewTemplate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_template);
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
//        TextView name;
//        TextView mascot;
//        CharSequence nameText;
//        CharSequence mascotText;
//        name = (TextView) findViewById(R.id.et_player_num);
//        nameText = name.getText();
//        school_name = nameText;
//        mascot = (TextView) findViewById(R.id.et_player_name);
//        mascotText = mascot.getText();
//        mascot_name = mascotText;

        //Template tmp = new Template(findViewById(R.id.name), findViewById(R.id.srv_rcv_0), findViewById(R.id.srv_p));

        Intent intent = new Intent(this, TemplatesMenu.class);
        startActivity(intent);
    }
}
