package com.example.niceg.mysqlproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class NewTemplate extends AppCompatActivity {

    CharSequence templateName = "";
    static VolleyStats vol;
    static Template newTemplate;
    static final int FROM_NEW_TEMPLATE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TemplatesMenu templatesMenu = new TemplatesMenu();
        vol = templatesMenu.getVolTemplatesMenu();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_template);

        TextView name;
        name = (TextView) findViewById(R.id.name);
        name.setText(getTemplateName());
    }

    public CharSequence getTemplateName() {
        return templateName;
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
        TextView name;
        CharSequence nameText;
        String finalName;
        name = (TextView) findViewById(R.id.name);
        nameText = name.getText();
        finalName = nameText.toString();
        templateName = finalName;

        boolean m_srv_rcv_0 = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.srv_rcv_0)).isChecked();
        boolean m_srv_rcv_m = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.srv_rcv_m)).isChecked();
        boolean m_ace = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.ace)).isChecked();
        boolean m_srv_p = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.srv_p)).isChecked();
        boolean m_srv_m = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.srv_m)).isChecked();
        boolean m_atk_kill = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.atk_kill)).isChecked();
        boolean m_atk_err = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.atk_err)).isChecked();
        boolean m_atk_0 = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.atk_0)).isChecked();
        boolean m_ast = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.ast)).isChecked();
        boolean m_blk_solo = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.blk_solo)).isChecked();
        boolean m_blk_ast = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.blk_ast)).isChecked();
        boolean m_dig = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.dig)).isChecked();
        boolean m_net_vio = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.net_vio)).isChecked();
        boolean m_ft_flt = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.ft_flt)).isChecked();
        boolean m_dbl_cntct = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.dbl_cntct)).isChecked();
        boolean m_lft = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.lft)).isChecked();
        boolean m_out_rot = ((CheckBox)findViewById(R.id.scrollable).findViewById(R.id.out_rot)).isChecked();

        newTemplate = new Template(finalName, m_srv_rcv_0, m_srv_rcv_m, m_ace,
                m_srv_p, m_srv_m, m_atk_kill, m_atk_err, m_atk_0, m_ast, m_dig,
                m_blk_solo, m_blk_ast, m_net_vio, m_ft_flt, m_dbl_cntct, m_lft, m_out_rot, false);

        Intent intent = new Intent(this, TemplatesMenu.class);

        startActivityForResult(intent, FROM_NEW_TEMPLATE);
    }

    public static Template getVolNewTemplate() {
        return newTemplate;
    }
}
