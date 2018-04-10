package com.example.niceg.mysqlproject;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
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
    MatrixCursor matrixCursor;
    static String home_name;
    static String away_name;

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

        SchoolInfo schoolInfo = new SchoolInfo();
        home_name = (String)schoolInfo.getHome_name();
        away_name = (String)schoolInfo.getAway_name();

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

    public void drawStats() {
        ArrayList<String> list = template.getNames();
        LinearLayout stats = new LinearLayout(this);
        LinearLayout layout = (LinearLayout)findViewById(R.id.playersGroup);
        LinearLayout title = (LinearLayout)findViewById(R.id.titleRow);

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
                    stat.setMinWidth(150);
                    stat.setMaxWidth(150);
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
                player.setMinWidth(150);
                player.setMaxWidth(150);
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

                btn.setLayoutParams(new LinearLayout.LayoutParams(screenWidth / (template.getNames().size() + 2), 125));
                //btn.setHeight(30);

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

               btn.setOnLongClickListener(new View.OnLongClickListener() {
                   public boolean onLongClick(View v) {
                       //int in = Integer.valueOf((String) btn.getText());
                       int in  = 0;

                       for(int k = 0; k < roster.playersList.get(x).playerStats.size();k++){
                           //Found the corresponding btn stat name
                           if(roster.playersList.get(x).playerStats.get(k).m_name.equals(template.getRealNames().get(y))){
                               in = roster.playersList.get(x).playerStats.get(k).m_value;
                           }
                       }

                       if(in > 0) {
                           //Incrememnt stored value
                           --in;
                           CharSequence newText;
                           newText = (CharSequence) Integer.toString(in);
                           btn.setText(newText);

                           //Store Incremented value
                           for (int k = 0; k < roster.playersList.get(x).playerStats.size(); k++) {
                               //Found the corresponding btn stat name
                               if (roster.playersList.get(x).playerStats.get(k).m_name.equals(template.getRealNames().get(y))) {
                                   roster.playersList.get(x).playerStats.get(k).m_value = in;
                               }
                           }
                       }
                       return true;
                   }
               });

                info.addView(btn);

            }

            //layout = findViewById(R.id.playersGroup);
            layout.addView(info);

        }
    }

    public void onExportClick(View view) {
        String[] columns = new String[] { "_id", "item", "description" };

        matrixCursor = new MatrixCursor(columns);
        exportToExcel(matrixCursor);
    }

    public void exportToExcel(Cursor cursor) {

        final int PERMISSION_REQUEST_CODE = 1;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED) {

                Log.d("permission", "permission denied to WRITE_EXTERNAL_STORAGE - requesting it");
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

                requestPermissions(permissions, PERMISSION_REQUEST_CODE);

            }
        }

        final String fileName = "match0.xls";//home_name + "vs" + away_name + ".xls";

        //Saving file in external storage
        File sdCard = Environment.getExternalStorageDirectory();

        File directory = new File("sdcard/EmmaFile/");

        //File directory = new File(sdCard.getAbsolutePath() + "/EmmaFile/");

        //create directory if not exist
        if(!directory.exists()) {
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
            WritableSheet sheet = workbook.createSheet("Match0", 0);

            try {
                sheet.addCell(new Label(0, 0, "#")); // column and row
                sheet.addCell(new Label(1, 0, "Name"));
                for(int i = 2; i < template.getNames().size() + 2; i++) {
                    sheet.addCell(new Label(i, 0, template.getNames().get(i - 2)));
                }
                    for (int j = 1; j < roster.playersList.size() + 1; j++) {
                        sheet.addCell(new Label(0, j, roster.playersList.get(j - 1).m_num));
                        sheet.addCell(new Label(1, j, roster.playersList.get(j - 1).m_fname));

                        for(int i = 2; i < template.getNames().size() + 2; i++) {
                            CharSequence text = "0";
                            text = (Integer.toString(roster.playersList.get(j - 1).playerStats.get(i - 2).getStatValue()));
                            sheet.addCell(new Label(i, j, (String)text));
                        }
                    }
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

            //alertDialog("EXPORT FAILED", "Export failed. Please try again." + '\n' + e.getLocalizedMessage());
        }

//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//
//            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
//                    == PackageManager.PERMISSION_DENIED) {
//
//                Log.d("permission", "permission denied to WRITE_EXTERNAL_STORAGE - requesting it");
//                String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
//
//                requestPermissions(permissions, PERMISSION_REQUEST_CODE);
//
//            }
//        }

        //String fileLocation=file.getAbsolutePath();

        if (!file.exists()) {
            alertDialog("nope", "file doesn't exist");
        }

        File file2 = new File(file.toString());
        Uri uri = Uri.fromFile(file);
        //Uri uri = Uri.parse(file.toString());

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// set the type to 'email'
        emailIntent.setType("vnd.android.cursor.dir/email");
// add email(s) here to whom you want to send email
        String to[] = {"emma.thompson@oit.edu"};
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
// add the attachment
        emailIntent.putExtra(Intent.EXTRA_STREAM, uri);
// add mail subject
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Mail Subject");
// create mail service chooser
        startActivity(Intent.createChooser(emailIntent , "Send email..."));

    }

    public void alertDialog(String title, String msg) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle(title)
                .setMessage(msg)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })

                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}
