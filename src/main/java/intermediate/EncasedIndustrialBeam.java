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
public class EncasedIndustrialBeam {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public EncasedIndustrialBeam(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if (alternateRecipes.get(21).getSelectedItem().toString() == "Default") {
            defaultEIB();
        } else if (alternateRecipes.get(21).getSelectedItem().toString() == "Pipe") {
            pipeEIB();
        }
    }

        public void defaultEIB() {
            double steelBeam = num * 4;
            double concrete = num * 5;
            output.append(ds.format(num) + " Encased Industrial Beam / Minute:  " + ds.format(steelBeam) + " Steel Beam / minute |  " +
                    ds.format(concrete) + " Concrete / minute. Requires  " + ds.format(num / 6) + " Assemblers\n\n");
            new SteelBeam(steelBeam,alternateRecipes,output);
            output.append("-\n\n");
            new Concrete(concrete,alternateRecipes,output);
        }

        public void pipeEIB () {
            double steelPipe = num * 7;
            double concrete = num * 5;
            output.append(ds.format(num) + " Encased Industrial Pipe / Minute:  " + ds.format(steelPipe) + " Steel Pipe / minute |  " +
                    ds.format(concrete) + " Concrete / minute. Requires  " + ds.format(num / 4) + " Assemblers\n\n");
            new SteelPipe(steelPipe, alternateRecipes, output);
            output.append("-\n\n");
            new Concrete(concrete, alternateRecipes, output);

        }

    }
