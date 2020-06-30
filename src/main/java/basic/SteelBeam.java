/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class SteelBeam {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public SteelBeam(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;
        defaultSteelBeam();
    }

    public void defaultSteelBeam() {
        double SteelIngots = num * 4;
        output.append(ds.format(num) + " Steel Beams / Minute:  " + ds.format(SteelIngots) + " Steel Ingots / minute. Requires  " + ds.format(num/15) + " Constructors\n\n");
        new SteelIngot(SteelIngots,alternateRecipes,output);
    }

}
