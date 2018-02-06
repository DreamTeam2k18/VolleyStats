package com.example.niceg.mysqlproject;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Emma on 2/2/2018.
 */

public class Template {

    public String m_name;
    public boolean m_srv_rec = false;
    public boolean m_srv_p = false;

    public Template(String name, boolean srv_rec, boolean srv_p) {
        m_name = name;
        m_srv_rec = srv_rec;
        m_srv_p = srv_p;
    }

    public Template(Template copy) {
        m_name = copy.m_name;
        m_srv_p = copy.m_srv_p;
        m_srv_rec = copy.m_srv_rec;
    }

    public Template(View viewById, View viewById1, View viewById2) {
        TextView name = (TextView) viewById;
        CharSequence nameText = name.getText();
        m_name = (String)nameText;
    }

    public String getNameEmma(){
        return m_name;
    }
}
