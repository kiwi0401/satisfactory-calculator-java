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
public class AILimiter {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public AILimiter(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        defaultAILimiter();
    }

    public void defaultAILimiter() {
        double copperSheet = num * 5;
        double quickWire = num * 20;
        output.append(ds.format(num) + " A.I. Limiters / Minute:  " + ds.format(copperSheet) + " Copper Sheets / minute |  " +
                ds.format(quickWire) +" Quickwire / minute. Requires  " + ds.format(num/5) + " Assemblers\n");
        output.append("v\n-\n");
        new CopperSheet(copperSheet,alternateRecipes,output);
        output.append("-\n\n");
        new Quickwire(quickWire,alternateRecipes,output);

    }

}
