package com.example.niceg.mysqlproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TakeStats extends AppCompatActivity {

    static Roster roster;
    static Template template;
    static VolleyStats vol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_stats);

        Home home = new Home();
        roster = home.getRosterHome();
        vol = home.getVolHome();

        if (!vol.templatesList.isEmpty()) {
            boolean flag = false;
            for (int i = 0; i < vol.templatesList.size(); i++) {

                Template temp = (Template) vol.templatesList.get(i);

                if(temp.m_selected == true) {
                    template = temp;
                    flag = true;
                }
            }
            if(!flag) {
                template = vol.templatesList.get(3);
            }
        }

        drawStats();
    }

    public void drawStats() {
        for(int i = 0; i < roster.playersList.size(); i++) {
            LinearLayout info = new LinearLayout(this);

            TextView num = new TextView(this);
            TextView player = new TextView(this);

            num.setText(roster.playersList.get(i).getNum());
            player.setText(roster.playersList.get(i).getFname());

            info.addView(num);
            info.addView(player);

            LinearLayout layout = findViewById(R.id.playersGroup);

            layout.addView(info);
        }
    }
}
