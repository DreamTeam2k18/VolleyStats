package com.example.niceg.mysqlproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Niceg on 2/5/2018.
 */

public class VolleyStats implements Serializable{

    public static ArrayList<Template> templatesList;

    VolleyStats() {
        templatesList = new ArrayList<Template>();
    }

    public static ArrayList<Template> getTemplatesList() {
        return templatesList;
    }

    public void setTemplatesList(VolleyStats list) {
        templatesList = list.templatesList;
    }
}
