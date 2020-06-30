/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced;

import intermediate.AILimiter;
import intermediate.Stator;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class ElectromagneticControlRod {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public ElectromagneticControlRod(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(29).getSelectedItem().toString() == "Default") {
            defaultControlRod();
        } else if(alternateRecipes.get(29).getSelectedItem().toString() == "Connection") {
            connectionControlRod();
        }
    }

    public void defaultControlRod() {
        double stators = num * (3/2.0);
        double aiLimiters = num;
        output.append(ds.format(num) + " Electromagnetic Control Rods / Minute:  " + ds.format(stators) + " Stators / minute |  " +
                ds.format(aiLimiters) +" AI Limiters / minute. Requires  " + ds.format(num/4) + " Assemblers\n\n");

        output.append("v-Control Rod Start-v\n\n");
        new textHighlighter("v-Control Rod Start-v", new Color(147,10,45),output);
        new Stator(stators,alternateRecipes,output);
        output.append("-----\n\n");
        new AILimiter(aiLimiters,alternateRecipes,output);
        output.append("^-Control Rod End-^\n\n");
        new textHighlighter("^-Control Rod End-^", new Color(147,10,45),output);

    }

    public void connectionControlRod() {
        double stators = num;
        double highspeedConnectors = num * (1/2.0);
        output.append(ds.format(num) + " Electromagnetic Connection Rods / Minute:  " + ds.format(stators) + " Stators / minute |  " +
                ds.format(highspeedConnectors) +" High-Speed Connectors / minute. Requires  " + ds.format(num/10) + " Assemblers\n\n");

        output.append("v-Connection Control Rod Start-v\n\n");
        new textHighlighter("v-Connection Control Rod Start-v", new Color(147,10,45),output);
        new Stator(stators,alternateRecipes,output);
        output.append("-----\n\n");
        new HighSpeedConnector(highspeedConnectors,alternateRecipes,output);
        output.append("^-Connection Control Rod End-^\n\n");
        new textHighlighter("^-Connection Control Rod End-^", new Color(147,10,45),output);
    }

}
