package com.example.niceg.mysqlproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emma on 2/4/2018.
 */

public class Player {
    public String m_fname;
    public String m_lname;
    public String m_num;
    public ArrayList<Stat> playerStats = new ArrayList<Stat>();

    Player() {
        m_fname = "";
        m_lname = "";
        m_num = "";
        playerStats.add(new Stat("m_srv_rcv_0", 0));
        playerStats.add(new Stat("m_srv_rcv_m", 0));
        playerStats.add(new Stat("m_ace", 0));
        playerStats.add(new Stat("m_srv_p", 0));
        playerStats.add(new Stat("m_srv_m", 0));
        playerStats.add(new Stat("m_atk_kill", 0));
        playerStats.add(new Stat("m_atk_err", 0));
        playerStats.add(new Stat("m_atk_0", 0));
        playerStats.add(new Stat("m_ast", 0));
        playerStats.add(new Stat("m_blk_solo", 0));
        playerStats.add(new Stat("m_blk_ast", 0));
        playerStats.add(new Stat("m_dig", 0));
        playerStats.add(new Stat("m_net_vio", 0));
        playerStats.add(new Stat("m_ft_flt", 0));
        playerStats.add(new Stat("m_dbl_cntct", 0));
        playerStats.add(new Stat("m_lft", 0));
        playerStats.add(new Stat("m_out_rot", 0));
    }

    Player(String fname, String lname, String num) {
        m_fname = fname;
        m_lname = lname;
        m_num = num;
        playerStats.add(new Stat("m_srv_rcv_0", 0));
        playerStats.add(new Stat("m_srv_rcv_m", 0));
        playerStats.add(new Stat("m_ace", 0));
        playerStats.add(new Stat("m_srv_p", 0));
        playerStats.add(new Stat("m_srv_m", 0));
        playerStats.add(new Stat("m_atk_kill", 0));
        playerStats.add(new Stat("m_atk_err", 0));
        playerStats.add(new Stat("m_atk_0", 0));
        playerStats.add(new Stat("m_ast", 0));
        playerStats.add(new Stat("m_blk_solo", 0));
        playerStats.add(new Stat("m_blk_ast", 0));
        playerStats.add(new Stat("m_dig", 0));
        playerStats.add(new Stat("m_net_vio", 0));
        playerStats.add(new Stat("m_ft_flt", 0));
        playerStats.add(new Stat("m_dbl_cntct", 0));
        playerStats.add(new Stat("m_lft", 0));
        playerStats.add(new Stat("m_out_rot", 0));
    }

    public String getFname() {
        return m_fname;
    }

    public String getLname() {
        return m_lname;
    }

    public String getNum() {
        return m_num;
    }
}