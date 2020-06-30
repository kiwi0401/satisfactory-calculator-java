package advanced;

import basic.*;
import intermediate.*;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class VersatileFramework {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public VersatileFramework(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if (alternateRecipes.get(15).getSelectedItem().toString() == "Default") {
            defaultFramework();
        } else if (alternateRecipes.get(15).getSelectedItem().toString() == "Flexible") {
            flexibleFramework();
        }
    }

    public void defaultFramework() {
        double modularFrames = num / 2;
        double steelBeams = num * 6;
        output.append(ds.format(num) + " Versatile Framework / Minute:  " + ds.format(modularFrames) + " Modular Frames / minute |  " +
                ds.format(steelBeams) +" Steel Beams / minute. Requires  " + ds.format(num/5) + " Assemblers\n\n");

        output.append("v-Versatile Framework Start-v\n\n");
        new textHighlighter("v-Versatile Framework Start-v", Color.magenta,output);
        new ModularFrame(modularFrames,alternateRecipes,output);
        output.append("-----\n\n");
        new SteelBeam(steelBeams,alternateRecipes,output);
        output.append("^-Versatile Framework End-^\n\n");
        new textHighlighter("^-Versatile Framework End-^", Color.magenta,output);
    }

    public void flexibleFramework() {
        double modularFrames = num / 2;
        double steelBeams = num * 3;
        double rubber = num * 4;
        output.append(ds.format(num) + " Flexible Versatile Framework / Minute:  " + ds.format(modularFrames) + " Modular Frames / minute |  " +
                ds.format(steelBeams) +" Steel Beams / minute |  " + ds.format(rubber) + " Rubber / Minute" +
                ". Requires  " + ds.format(num/7.5) + " Manufacturers\n\n");

        output.append("v-Flexible Versatile Framework Start-v\n\n");
        new textHighlighter("v-Flexible Versatile Framework Start-v", Color.magenta,output);
        new ModularFrame(modularFrames,alternateRecipes,output);
        output.append("-----\n\n");
        new SteelBeam(steelBeams,alternateRecipes,output);
        output.append("-----\n\n");
        new Rubber(rubber,alternateRecipes,output);
        output.append("^-Flexible Versatile Framework End-^\n\n");
        new textHighlighter("^-Flexible Versatile Framework End-^", Color.magenta,output);

    }

}
