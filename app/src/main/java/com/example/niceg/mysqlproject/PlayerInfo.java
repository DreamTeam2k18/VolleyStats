package com.example.niceg.mysqlproject;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class PlayerInfo extends AppCompatActivity {

    public static Roster roster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        ComponentName sender = getCallingActivity();

        if(sender != null){
            NewPlayer newPlayer = new NewPlayer();
            Player temp = newPlayer.getNewPlayer();
            roster.playersList.add(temp);
        }
        else {
            Home home = new Home();
            roster = home.getRosterHome();
        }

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
//        savePlayers(roster.playersList);
//        Player newPlayer = new Player();
//        roster.playersList.add(newPlayer);
//        clearPlayers();
//        drawPlayers(roster.playersList);
        Intent intent = new Intent(this, NewPlayer.class);
        startActivity(intent);
    }

    public void onEditClick(View view) {
        Intent intent = new Intent(this, Home.class);
        //intent.putExtra("player", )
        startActivity(intent);
    }

    private View.OnClickListener ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onEditClick(v);
        }
    };

    private View.OnClickListener RemoveClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            removeOnClick(v);
        }
    };

    public void removeOnClick(View view) {
//        TextView num = findViewById(R.id.)
//        TextView fname = new TextView(this);
//        TextView lname = new TextView(this);
//
//        ImageButton trash = new ImageButton(this);
//        ImageButton edit = new ImageButton(this);



    }

    public void drawPlayers(List newPlayer) {

        for(int i = 0; i < newPlayer.size(); i++) {
            Player temp = (Player)newPlayer.get(i);

            LinearLayout player = new LinearLayout(this);

            TextView num = new TextView(this);
            TextView fname = new TextView(this);
            TextView lname = new TextView(this);

//            ImageButton trash = new ImageButton(this);
//            trash.setImageResource(android.R.drawable.ic_menu_delete);
//            trash.setBackgroundColor(0);
//            trash.setOnClickListener(RemoveClickListener);
//            trash.setId(i);
//
//            ImageButton edit = new ImageButton(this);
//            edit.setImageResource(android.R.drawable.ic_menu_edit);
//            edit.setBackgroundColor(0);
//            edit.setOnClickListener(ClickListener);
//            edit.setId(i);

            num.layout(0, 10, 0, 0 );
            num.setPadding(110, 0, 0, 0);
            num.setText(temp.getNum());
            num.setTextSize(20);
            num.setAllCaps(true);
            num.setMinWidth(150);
            num.setMaxWidth(150);
            num.setMaxLines(1);
            num.setId(i);

            fname.layout(0, 10, 0, 0);
            fname.setPadding(120, 0, 0, 0);
            fname.setText(temp.getFname());
            fname.setTextSize(20);
            fname.setAllCaps(true);
            fname.setMinWidth(400);
            fname.setMaxWidth(500);
            fname.setMaxLines(1);
            fname.setId(i);

            lname.layout(0, 10, 0, 0);
            lname.setPadding(120, 0,0,0);
            lname.setText(temp.getLname());
            lname.setTextSize(20);
            lname.setAllCaps(true);
            lname.setMinWidth(500);
            lname.setMaxWidth(600);
            lname.setMaxLines(1);
            lname.setId(i);

//            player.addView(trash);
//            player.addView(edit);
            player.addView(num);
            player.addView(fname);
            player.addView(lname);

            LinearLayout group = (LinearLayout)findViewById(R.id.playerGroup);
            group.addView(player);

        }
    }
//
//    public void clearPlayers() {
//       LinearLayout group = findViewById(R.id.playerGroup);
//       group.removeAllViews();
//    }
//
//    public void savePlayers(List list) {
//        LinearLayout group = findViewById(R.id.playerGroup);
//
//        int count = group.getChildCount();
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

