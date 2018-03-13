package com.example.niceg.mysqlproject;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emma on 2/2/2018.
 */

public class Template {

    public String m_name;
    public boolean m_srv_rcv_0 = false;
    public boolean m_srv_rcv_m = false;
    public boolean m_ace = false;
    public boolean m_srv_p = false;
    public boolean m_srv_m = false;
    public boolean m_atk_kill = false;
    public boolean m_atk_err = false;
    public boolean m_atk_0 = false;
    public boolean m_ast = false;
    public boolean m_blk_solo = false;
    public boolean m_blk_ast = false;
    public boolean m_dig = false;
    public boolean m_net_vio = false;
    public boolean m_ft_flt = false;
    public boolean m_dbl_cntct = false;
    public boolean m_lft = false;
    public boolean m_out_rot = false;
    public boolean m_selected = false;

    public Template() {
        m_name = "";
        m_selected = false;
        m_srv_rcv_0 = false;
        m_srv_rcv_m = false;
        m_ace = false;
        m_srv_p = false;
        m_srv_m = false;
        m_atk_kill = false;
        m_atk_err = false;
        m_atk_0 = false;
        m_ast = false;
        m_blk_solo = false;
        m_blk_ast = false;
        m_dig = false;
        m_net_vio = false;
        m_ft_flt = false;
        m_dbl_cntct = false;
        m_lft = false;
        m_out_rot = false;
    }

    public Template(String name) {
        m_name = name;
        m_selected = false;
        m_srv_rcv_0 = false;
        m_srv_rcv_m = false;
        m_ace = false;
        m_srv_p = false;
        m_srv_m = false;
        m_atk_kill = false;
        m_atk_err = false;
        m_atk_0 = false;
        m_ast = false;
        m_blk_solo = false;
        m_blk_ast = false;
        m_dig = false;
        m_net_vio = false;
        m_ft_flt = false;
        m_dbl_cntct = false;
        m_lft = false;
        m_out_rot = false;
    }

    public Template(String name, boolean srv_rcv_0, boolean srv_rcv_m, boolean ace,
                    boolean srv_p, boolean srv_m, boolean atk_kill, boolean atk_err,
                    boolean atk_0, boolean ast, boolean dig, boolean blk_solo,
                    boolean blk_ast, boolean net_vio, boolean ft_flt, boolean dbl_cntct,
                    boolean lft, boolean out_rot, boolean selected) {
        m_name = name;
        m_selected = selected;
        m_srv_rcv_0 = srv_rcv_0;
        m_srv_rcv_m = srv_rcv_m;
        m_ace = ace;
        m_srv_p = srv_p;
        m_srv_m = srv_m;
        m_atk_kill = atk_kill;
        m_atk_err = atk_err;
        m_atk_0 = atk_0;
        m_ast = ast;
        m_blk_solo = blk_solo;
        m_blk_ast = blk_ast;
        m_dig = dig;
        m_net_vio = net_vio;
        m_ft_flt = ft_flt;
        m_dbl_cntct = dbl_cntct;
        m_lft = lft;
        m_out_rot = out_rot;
    }

    public Template(Template copy) {
        m_name = copy.m_name;
        m_selected = copy.m_selected;
        m_srv_rcv_0 = copy.m_srv_rcv_0;
        m_srv_rcv_m = copy.m_srv_rcv_m;
        m_ace = copy.m_ace;
        m_srv_p = copy.m_srv_p;
        m_srv_m = copy.m_srv_m;
        m_atk_kill = copy.m_atk_kill;
        m_atk_err = copy.m_atk_err;
        m_atk_0 = copy.m_atk_0;
        m_ast = copy.m_ast;
        m_blk_solo = copy.m_blk_solo;
        m_blk_ast = copy.m_blk_ast;
        m_dig = copy.m_dig;
        m_net_vio = copy.m_net_vio;
        m_ft_flt = copy.m_ft_flt;
        m_dbl_cntct = copy.m_dbl_cntct;
        m_lft = copy.m_lft;
        m_out_rot = copy.m_out_rot;
    }

    public Template(View viewById, View viewById1, View viewById2) {
        TextView name = (TextView) viewById;
        CharSequence nameText = name.getText();
        m_name = (String)nameText;
    }

    public String getNameEmma(){
        return m_name;
    }

    public int getSize() {
        int count = 0;
        if(m_srv_rcv_0 == true) {count++;}
        if(m_srv_rcv_m == true) {count++;}
        if(m_ace == true) {count++;}
        if(m_srv_p == true) {count++;}
        if(m_srv_m == true) {count++;}
        if(m_atk_kill == true) {count++;}
        if(m_atk_err == true) {count++;}
        if(m_atk_0 == true) {count++;}
        if(m_ast == true) {count++;}
        if(m_blk_solo == true) {count++;}
        if(m_blk_ast == true) {count++;}
        if(m_dig == true) {count++;}
        if(m_net_vio == true) {count++;}
        if(m_ft_flt == true) {count++;}
        if(m_dbl_cntct == true) {count++;}
        if(m_lft == true) {count++;}
        if(m_out_rot == true) {count++;}
        return count;
    }
    public ArrayList<String> getNames() {
        ArrayList<String> list = new ArrayList<String>();

        if(m_srv_rcv_0 == true) {list.add("SR0");}
        if(m_srv_rcv_m == true) {list.add("SR-");}
        if(m_ace == true) {list.add("ACE");}
        if(m_srv_p == true) {list.add("S+");}
        if(m_srv_m == true) {list.add("S-");}
        if(m_atk_kill == true) {list.add("A+");}
        if(m_atk_err == true) {list.add("A-");}
        if(m_atk_0 == true) {list.add("A0");}
        if(m_ast == true) {list.add("AST");}
        if(m_blk_solo == true) {list.add("BS");}
        if(m_blk_ast == true) {list.add("BA");}
        if(m_dig == true) {list.add("DIG");}
        if(m_net_vio == true) {list.add("NV");}
        if(m_ft_flt == true) {list.add("FF");}
        if(m_dbl_cntct == true) {list.add("DC");}
        if(m_lft == true) {list.add("LFT");}
        if(m_out_rot == true) {list.add("OR");}

        return list;
    }

}
