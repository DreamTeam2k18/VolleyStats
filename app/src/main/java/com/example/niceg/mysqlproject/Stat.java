package com.example.niceg.mysqlproject;

/**
 * Created by Emma on 3/13/2018.
 */

public class Stat {
    public String m_name = "";
    public int m_value = 0;

    public Stat() {
        m_name = "";
        m_value = 0;
    }

    public Stat(String name, int val) {
        m_name = name;
        m_value = val;
    }

    public String getStatName() {
        return m_name;
    }

    public int getStatValue() {
        return m_value;
    }

    public void setStatName(String name) {
        m_name = name;
    }

    public void setStatValue(int val) {
        m_value = val;
    }
}
