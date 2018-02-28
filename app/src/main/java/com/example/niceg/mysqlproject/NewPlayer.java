package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewPlayer extends AppCompatActivity {

    static Player newPlayer;
    static final int FROM_NEW_PLAYER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);
    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onClearClick(View view) {
        TextView fname;
        TextView lname;
        TextView num;
        fname = (TextView) findViewById(R.id.fname);
        lname = (TextView) findViewById(R.id.lname);
        num = (TextView) findViewById(R.id.num);

        fname.setText("");
        lname.setText("");
        num.setText("");
    }

    public void onDoneClick(View view) {
        TextView name;
        CharSequence nameText;
        String finalFname;
        String finalLname;
        String finalNum;

        name = (TextView) findViewById(R.id.fname);
        nameText = name.getText();
        finalFname = nameText.toString();

        name = (TextView) findViewById(R.id.lname);
        nameText = name.getText();
        finalLname = nameText.toString();

        name = (TextView) findViewById(R.id.num);
        nameText = name.getText();
        finalNum = nameText.toString();

        newPlayer = new Player(finalFname, finalLname, finalNum);

        Intent intent = new Intent(this, PlayerInfo.class);

        startActivityForResult(intent, FROM_NEW_PLAYER);
    }

    public Player getNewPlayer() {
        return newPlayer;
    }
}
