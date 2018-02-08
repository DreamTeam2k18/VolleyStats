package com.example.niceg.mysqlproject;

import java.util.ArrayList;

/**
 * Created by Niceg on 2/7/2018.
 */

public class Roster {
    public static ArrayList<Player> playersList;

    Roster() {
        playersList = new ArrayList<Player>();
    }

    public static ArrayList<Player>getPlayersList() {
        return playersList;
    }
}
