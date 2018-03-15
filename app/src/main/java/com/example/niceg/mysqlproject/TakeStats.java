package com.example.niceg.mysqlproject;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class TakeStats extends AppCompatActivity {

    static Roster roster;
    static Template template;
    static VolleyStats vol;
    static int m_size;
    int globaltest;

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

        String[] columns = new String[] { "_id", "item", "description" };

        MatrixCursor matrixCursor= new MatrixCursor(columns);
        exportToExcel(matrixCursor);
    }

    public void drawStats() {
        ArrayList<String> list = template.getNames();
        LinearLayout stats = new LinearLayout(this);
        LinearLayout layout = findViewById(R.id.playersGroup);
        LinearLayout title = findViewById(R.id.titleRow);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        for(int j = -2; j < template.getNames().size(); j++) {
            TextView stat = new TextView(this);

            if(j == -2) {
                stat.setText("#");
                stat.setMinWidth(70);
                stat.setMaxWidth(70);
            }
            else if(j == -1) {
                stat.setText("NAME");
                if(template.getNames().size() > 8) {
                    stat.setMinWidth(200);
                    stat.setMaxWidth(200);
                }
                else {
                    stat.setMinWidth(300);
                    stat.setMaxWidth(300);
                }
            }
            else {
                stat.setText(list.get(j));
                stat.setMinWidth(screenWidth / (template.getNames().size() + 2));
                stat.setMaxWidth(screenWidth / (template.getNames().size() + 2));
            }

            stat.setTextSize(16);
            stat.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            stats.addView(stat);
        }

        title.addView(stats);
        //Test size
        int elems  = roster.playersList.size();

        //Notes: i is breaking things, ifit is more than 1
        for(int i = 0; i < roster.playersList.size(); i++) {
            TextView num = new TextView(this);
            TextView player = new TextView(this);

            num.setText(roster.playersList.get(i).getNum());
            num.setMaxWidth(50);
            num.setMinWidth(50);
            num.setTextSize(12);
            num.setPaddingRelative(10, 10, 10, 10);
            num.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            player.setText(roster.playersList.get(i).getFname());

            if(template.getNames().size() > 8) {
                player.setMinWidth(200);
                player.setMaxWidth(200);
            }
            else {
                player.setMinWidth(300);
                player.setMaxWidth(300);
            }

            player.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            player.setMaxLines(1);
            player.setTextSize(12);
            player.setPaddingRelative(10, 10, 10, 10);
            player.setAllCaps(true);

            if((i % 2) == 0) {
                num.setTextColor(Color.MAGENTA);
                player.setTextColor(Color.MAGENTA);
            }

            LinearLayout info = new LinearLayout(this);
            info.addView(num);
            info.addView(player);

           for (int j = 0; j < template.getNames().size(); j++) {
                //Final level bullshit that doesnt make any sense and I hate it.
                final int x = i;
                final int y = j;
                //TextView btn = new TextView(this);
                CharSequence text = "0";
                final Button btn = new Button(this);

                for(int k = 0; k < roster.playersList.get(i).playerStats.size();k++){
                    //Found the corresponding btn stat name
                    if(roster.playersList.get(i).playerStats.get(k).m_name.equals(template.getRealNames().get(j))){
                        text = (Integer.toString(roster.playersList.get(i).playerStats.get(k).m_value));
                    }
                }

                btn.setText(text);
                btn.setTextSize(12);
                if((i % 2) != 0) {
                    btn.setTextColor(Color.WHITE);
                }
                else {
                    btn.setTextColor(Color.MAGENTA);
                }

                btn.setLayoutParams(new LinearLayout.LayoutParams(screenWidth / (template.getNames().size() + 2), screenHeight / (template.getNames().size())));
                btn.setHeight(30);

                btn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        //int in = Integer.valueOf((String) btn.getText());
                        int in  = 0;

                        for(int k = 0; k < roster.playersList.get(x).playerStats.size();k++){
                            //Found the corresponding btn stat name
                            if(roster.playersList.get(x).playerStats.get(k).m_name.equals(template.getRealNames().get(y))){
                                in = roster.playersList.get(x).playerStats.get(k).m_value;
                            }
                        }

                        //Incrememnt stored value
                        in++;
                        CharSequence newText;
                        newText = (CharSequence) Integer.toString(in);
                        btn.setText(newText);

                        //Store Incremented value
                        for(int k = 0; k < roster.playersList.get(x).playerStats.size();k++){
                            //Found the corresponding btn stat name
                            if(roster.playersList.get(x).playerStats.get(k).m_name.equals(template.getRealNames().get(y))){
                                roster.playersList.get(x).playerStats.get(k).m_value = in;
                            }
                        }
                    }
                });

                info.addView(btn);

            }

            //layout = findViewById(R.id.playersGroup);
            layout.addView(info);

        }
    }

    public void exportToExcel(Cursor cursor) {
        final String fileName = "testFile.xls";

        //Saving file in external storage
        File sdCard = Environment.getExternalStorageDirectory();
        //File directory = new File(sdCard.getAbsolutePath() + "/javatechig.todo");
        File directory = new File(sdCard.getAbsolutePath() + "/EmmaFile");

        //create directory if not exist
        if(!directory.isDirectory()){
            directory.mkdirs();
        }

        //file path
        File file = new File(directory, fileName);

        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        WritableWorkbook workbook;

        try {
            workbook = Workbook.createWorkbook(file, wbSettings);
            //Excel sheet name. 0 represents first sheet
            WritableSheet sheet = workbook.createSheet("MyShoppingList", 0);

            try {
                sheet.addCell(new Label(0, 0, "Subject")); // column and row
                sheet.addCell(new Label(1, 0, "Description"));
                if (cursor.moveToFirst()) {
                    do {
                        String title = "title";//cursor.getString(cursor.getColumnIndex(DatabaseHelper.TODO_SUBJECT));
                        String desc = "description";//cursor.getString(cursor.getColumnIndex(DatabaseHelper.TODO_DESC));

                        int i = cursor.getPosition() + 1;
                        sheet.addCell(new Label(0, i, title));
                        sheet.addCell(new Label(1, i, desc));
                    } while (cursor.moveToNext());
                }
                //closing cursor
                cursor.close();
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
            workbook.write();
            try {
                workbook.close();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
