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
public class SulfuricAcid {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public SulfuricAcid(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;
        defaultSulfuricAcid();
    }

    public void defaultSulfuricAcid() {
        double sulfur = num / 2;
        double water = num / 2;
        output.append(ds.format(num) + " Sulfuric Acid(m3) / Minute:  " + ds.format(sulfur) + " Sulfur / minute |  " +
                ds.format(water) +" Water(m3) / minute. Requires  " + ds.format(num/100) + " Refineries\n\n");
    }

}
