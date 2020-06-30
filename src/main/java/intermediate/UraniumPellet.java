/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class UraniumPellet {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public UraniumPellet(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;
        defaultUraniumPellet();
    }

    public void defaultUraniumPellet() {
        double uranium = num;
        double sulfuricAcid = num * (6/5.0);
        output.append(ds.format(num) + " Uranium Pellets / Minute:  " + ds.format(uranium) + " Raw Uranium / minute |  " +
                ds.format(sulfuricAcid) +" Sulfuric Acid(m3) / minute (takes into account excess from output). Requires  " + ds.format(num/5) + " Refineries\n\n");
        new SulfuricAcid(sulfuricAcid,alternateRecipes,output);

    }

}
