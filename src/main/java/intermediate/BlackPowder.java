/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import basic.*;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class BlackPowder {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public BlackPowder(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(41).getSelectedItem().toString() == "Default") {
            defaultBlackPowder();
        } else if(alternateRecipes.get(41).getSelectedItem().toString() == "Gun Powder") {
            gunPowder();
        }
    }

    public void defaultBlackPowder() {
        double coal = num;
        double sulfur = num * 2;
        output.append(ds.format(num) + " Black Powder / Minute:  " + ds.format(coal) + " Raw Coal / minute |  " +
                ds.format(sulfur) +" Sulfur / minute. Requires  " + ds.format(num/7.5) + " Assemblers\n\n");
    }

    public void gunPowder() {
        double sulfur = num / 2;
        double compactedCoal = num / 4;
        output.append(ds.format(num) + " Gun Powder / Minute:  " + ds.format(sulfur) + " Sulfur / minute |  " +
                ds.format(compactedCoal) +" Compacted Coal / minute. Requires  " + ds.format(num/15) + " Assemblers\n\n");
        new CompactedCoal(compactedCoal,alternateRecipes,output);

    }



}
