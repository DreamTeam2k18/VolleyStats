package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TakeStats extends AppCompatActivity {

    static Roster roster;
    static Template template;
    static VolleyStats vol;
    static int m_size;

    //Default values in case user hasn't accessed templatesmenu yet
    Template basic = new Template("BASIC", true, false, false, true,
            true, false, false, false, false, false, false, false,
            false, false, false, false, false, false);
    Template intermediate = new Template("INTERMEDIATE", true, true, true, true,
            true, true, true, true, false, false, false, false,
            false, false, false, false, false, false);
    Template comprehensive = new Template("COMPREHENSIVE", true, true, true, true,
            true, true, true, true, true, true, true, true,
            true, true, true, true, true, false);
    Template comprehensive2 = new Template("COMPREHENSIVE WITHOUT UNFORCED ERRORS", true,
            true, true, true, true, true, true, true, true,
            true, true, true, false, false, false,
            false, false, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_stats);

        //Makes reference to home
        Home home = new Home();
        //Contains players
        roster = home.getRosterHome();
        //Contains templates
        vol = home.getVolHome();

        //Get templates if they do not already exist
        if(vol.templatesList.isEmpty()){
            vol.templatesList.add(basic);
            vol.templatesList.add(intermediate);
            vol.templatesList.add(comprehensive);
            vol.templatesList.add(comprehensive2);
            //Select the Default Template to be Intermediate
            for (int i = 0; i < vol.templatesList.size(); i++) {
                Template temp = vol.templatesList.get(i);
                if (temp.getNameEmma() == "INTERMEDIATE") {
                    temp.m_selected = true;
                }
            }
        }
        //Get templates if they already exist
        else{
            //SOMETHING is Selected SOMEWHERE probably...
        }

        for(int i = 0; i < vol.templatesList.size(); i++) {
            Template temp = vol.templatesList.get(i);
            if (temp.m_selected == true) {
                template = temp;
            }
        }
        
        drawStats();
    }


//    private View.OnClickListener addOne = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            v.findViewById()
//        }
//    };

    public void drawStats() {
        ArrayList<String> list = template.getNames();
        LinearLayout info = new LinearLayout(this);

        for(int j = 0; j < template.getNames().size(); j++) {
            TextView stat = new TextView(this);

            stat.setText(list.get(j));
            stat.setMinWidth(100);
            stat.setMaxWidth(100);
            stat.setTextSize(20);

            info.addView(stat);
        }

        for(int i = 0; i < roster.playersList.size(); i++) {


            TextView num = new TextView(this);
            TextView player = new TextView(this);

            num.setText(roster.playersList.get(i).getNum());
            num.setMaxWidth(50);
            num.setMinWidth(50);
            num.setTextSize(20);
            num.setPaddingRelative(10,10,10,10);

            player.setText(roster.playersList.get(i).getFname());
            player.setMinWidth(200);
            player.setMaxWidth(200);
            player.setTextSize(20);
            player.setPaddingRelative(10,10,10,10);

            info.addView(num);
            info.addView(player);

            for(int j = 0; j < template.getNames().size(); j++) {
                //TextView btn = new TextView(this);
                Button btn = new Button(this);
                btn.setText("0");
                btn.setBackgroundColor(333);
                btn.setWidth(40);
                btn.setHeight(30);
                //btn.setId(j);
                //btn.setOnClickListener(addOne);

                info.addView(btn);

            }

            LinearLayout layout = findViewById(R.id.playersGroup);

            layout.addView(info);
        }
    }
}
