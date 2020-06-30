/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import advanced.CrystalOscillator;
import basic.*;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class Motor {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public Motor(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(11).getSelectedItem().toString() == "Default") {
            defaultMotor();
        } else if(alternateRecipes.get(11).getSelectedItem().toString() == "Rigour") {
            rigourMotor();
        }
    }

    public void defaultMotor() {
        double rotor = num * 2;
        double stator = num * 2;
        output.append(ds.format(num) + " Motors / Minute:  " + ds.format(rotor) + " Rotors / minute |  " +
                ds.format(stator) +" Stators / minute. Requires  " + ds.format(num/5) + " Assemblers\n\n");

        output.append("v-Motor Start-v\n\n");
        new textHighlighter("v-Motor Start-v", new Color(255,108,0),output);
        new Rotor(rotor,alternateRecipes,output);
        output.append("-----\n\n");
        new Stator(stator,alternateRecipes,output);
        output.append("^-Motor End-^\n\n");
        new textHighlighter("^-Motor End-^", new Color(255,108,0),output);

    }

    public void rigourMotor() {
        double rotor = num / 2;
        double stator = num / 2;
        double crystalOscillator = num / 6;
        output.append(ds.format(num) + " Rigour Motors / Minute:  " + ds.format(rotor) + " Rotors / minute |  " +
                ds.format(stator) +" Stators / minute |  " + ds.format(crystalOscillator) + " Crystal Oscillators / Minute" +
                ". Requires  " + ds.format(num/5) + " Assemblers\n\n");

        output.append("v-Rigour Motor Start-v\n\n");
        new textHighlighter("v-Rigour Motor Start-v", new Color(255,108,0),output);
        new Rotor(rotor,alternateRecipes,output);
        output.append("-----\n\n");
        new Stator(stator,alternateRecipes,output);
        output.append("-----\n\n");
        new CrystalOscillator(crystalOscillator,alternateRecipes,output);
        output.append("^-Rigour Motor End-^\n\n");
        new textHighlighter("^-Rigour Motor End-^", new Color(255,108,0),output);

    }


}
