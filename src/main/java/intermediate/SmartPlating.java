/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import basic.ReinforcedIronPlate;
import basic.Rotor;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class SmartPlating {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public SmartPlating(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;
        if(alternateRecipes.get(16).getSelectedItem().toString() == "Default") {
            defaultSmartPlate();
        } else if(alternateRecipes.get(16).getSelectedItem().toString() == "Plastic") {
            plasticSmartPlate();
        }
    }

    public void defaultSmartPlate() {
        double reinforcedIronPlate = num;
        double rotor = num;
        output.append(ds.format(num) + " Smart Plates / Minute:  " + ds.format(reinforcedIronPlate) + " R.I.P / minute |  " +
                ds.format(rotor) +" Rotors / minute. Requires  " + ds.format(num/2) + " Assemblers\n\n");
        new ReinforcedIronPlate(reinforcedIronPlate,alternateRecipes,output);
        output.append("-\n\n");
        new Rotor(rotor,alternateRecipes,output);
    }
    public void plasticSmartPlate() {
        double reinforcedIronPlate = num / 2;
        double rotor = num / 2;
        double plastic = num * (3/2.0);
        output.append(ds.format(num) + " Plastic Smart Plates / Minute:  " + ds.format(reinforcedIronPlate) + " R.I.P / minute |  " +
                ds.format(rotor) +" Rotors / minute |  " + ds.format(plastic) + " Plastic / Minute" +
                ". Requires  " + ds.format(num/5) + " Manufacturers\n\n");
        new ReinforcedIronPlate(reinforcedIronPlate,alternateRecipes,output);
        output.append("-\n\n");
        new Rotor(rotor,alternateRecipes,output);
        output.append("-\n\n");
        new Plastic(plastic,alternateRecipes,output);
    }

}
