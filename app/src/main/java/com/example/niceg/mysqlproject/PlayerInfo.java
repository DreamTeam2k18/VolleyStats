package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.List;

public class PlayerInfo extends AppCompatActivity {

    public static Roster roster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        Home home = new Home();
        roster = home.getRosterHome();

        drawPlayers(roster.playersList);
    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onClearClick(View view) {

    }

    public void onDoneClick(View view) {
        //clean out emtpy playas
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void onAddClick(View view) {
        //Save all input text
        savePlayers(roster.playersList);
        Player newPlayer = new Player();
        roster.playersList.add(newPlayer);
        clearPlayers();
        drawPlayers(roster.playersList);
    }

    public void drawPlayers(List newPlayer) {

        for(int i = 0; i < newPlayer.size(); i++) {
            Player temp = (Player)newPlayer.get(i);

            LinearLayout player = new LinearLayout(this);

            EditText num = new EditText(this);
            EditText fname = new EditText(this);
            EditText lname = new EditText(this);

            num.layout(0, 10, 0, 0 );
            num.setHint("#");
            num.setText(temp.getNum());
            num.setAllCaps(true);
            num.setEms(2);
            num.setMaxLines(1);

            fname.layout(0, 10, 0, 0);
            fname.setHint("First");
            fname.setText(temp.getFname());
            fname.setAllCaps(true);
            fname.setEms(7);
            fname.setMaxLines(1);

            lname.layout(0, 10, 0, 0);
            lname.setHint("Last");
            lname.setText(temp.getLname());
            lname.setAllCaps(true);
            lname.setEms(7);
            lname.setMaxLines(1);

            player.addView(num);
            player.addView(fname);
            player.addView(lname);

            LinearLayout group = findViewById(R.id.playerGroup);
            group.addView(player);

        }
    }

    public void clearPlayers() {
       LinearLayout group = findViewById(R.id.playerGroup);
       group.removeAllViews();
    }

    public void savePlayers(List list) {
        LinearLayout group = findViewById(R.id.playerGroup);

        int count = group.getChildCount();
        //Get All Views in the playerGroup

//        for(int i=0; i < count;i++) {
//            View x = group.getChildAt(i);
//            roster.playersList.get(i).m_num = x.findViewById(R.id.playerInfo).findViewById(R.id.et_player_fname).toString();
//        }

//emmas bullshit
//        for(int i = 1; i < list.size(); i++) {
//            String fn = group.findViewById(R.id.playerInfo).findViewById(R.id.et_player_fname).toString();
//        }


    }
}
