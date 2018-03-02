package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewUser extends AppCompatActivity {

    static CharSequence m_email = "";
    static CharSequence m_pass = "";
    static CharSequence m_confirm_pass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onDoneClick(View view) {
        TextView email;
        TextView pass;
        TextView confirm_pass;
        CharSequence emailText;
        CharSequence passText;
        CharSequence confirmText;

        email = (TextView) findViewById(R.id.et_email);
        emailText = email.getText();
        m_email = emailText;

        pass = (TextView) findViewById(R.id.et_pass);
        passText = pass.getText();
        m_pass = passText;

        confirm_pass = (TextView) findViewById(R.id.et_confirm_pass);
        confirmText = pass.getText();
        m_confirm_pass = confirmText;

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void onClearClick(View view) {
        TextView email;
        TextView pass;
        TextView confirm_pass;

        email = (TextView) findViewById(R.id.et_email);
        email.setText("");
        pass = (TextView) findViewById(R.id.et_pass);
        pass.setText("");
        confirm_pass = (TextView) findViewById(R.id.et_confirm_pass);
        confirm_pass.setText("");
    }
}
