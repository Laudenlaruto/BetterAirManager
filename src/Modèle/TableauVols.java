package Modèle;

import java.util.ArrayList;

/**
 * Created by ben_s on 29/11/2016.
 */
public class TableauVols {
    private ArrayList<Vol> tableauDeVols;
    private String Name;

    public TableauVols(String name) {
        Name = name;
        tableauDeVols = new ArrayList<Vol>();
    }
}
