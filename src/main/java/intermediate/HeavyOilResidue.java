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
public class HeavyOilResidue {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");
    private double polymerResin = 0;

    public HeavyOilResidue(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;
        defaultHeavyOilResidue();
    }

    public void defaultHeavyOilResidue() {
        double RawOil = num * (3/4.0);
        double PolymerResin = num / 2;
        polymerResin += PolymerResin;
        output.append(ds.format(num) + " Heavy Oil Residue(m3) / Minute: and  " + ds.format(PolymerResin) +
                " Polymer Resin / Minute:  " + ds.format(RawOil) + " Raw Oil(m3) / minute. Requires  " +
                ds.format(num/40) + " Refineries\n\n");
    }

    public double getPolymerResin() {
        return polymerResin;
    }




}
