package com.example.niceg.mysqlproject;

/**
 * Created by Emma on 2/4/2018.
 */

public class Player {
    public String m_fname;
    public String m_lname;
    public String m_num;

    Player() {
        m_fname = "";
        m_lname = "";
        m_num = "";
    }

    Player(String fname, String lname, String num) {
        m_fname = fname;
        m_lname = lname;
        m_num = num;
    }

    public String getFname(){
        return  m_fname;
    }

    public String getLname() {
        return  m_lname;
    }

}
