package advanced;


import basic.Cable;
import basic.Wire;
import intermediate.Stator;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class AutomatedWiring {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public AutomatedWiring(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if (alternateRecipes.get(25).getSelectedItem().toString() == "Default") {
            defaultWiring();
        } else if (alternateRecipes.get(25).getSelectedItem().toString() == "High-Speed") {
            highspeedWiring();
        }
    }

    public void defaultWiring() {
        double stator = num;
        double cable = num * 20;
        output.append(ds.format(num) + " Automated Wiring / Minute:  " + ds.format(stator) + " Stators / minute |  " +
                ds.format(cable) +" Cable / minute. Requires  " + ds.format(num/2.5) + " Assemblers\n\n");

        output.append("v-Automated Wiring Start-v\n\n");
        new textHighlighter("v-Automated Wiring Start-v", new Color(121,98,14),output);

        new Stator(stator,alternateRecipes,output);
        output.append("-----\n\n");
        new Cable(cable,alternateRecipes,output);

        output.append("^-Automated Wiring End-^\n\n");
        new textHighlighter("^-Automated Wiring End-^", new Color(121,98,14),output);
    }

    public void highspeedWiring() {
        double stator = num / 2;
        double wire = num * 10;
        double highspeedConnector = num / 4;
        output.append(ds.format(num) + " High-Speed Automated Wiring / Minute:  " + ds.format(stator) + " Stators / minute |  " +
                ds.format(wire) +" Wire / minute |  " + ds.format(highspeedConnector) + " High-Speed Connectors / Minute" +
                ". Requires  " + ds.format(num/7.5) + " Manufacturers\n\n");

        output.append("v-High-Speed Automated Wiring Start-v\n\n");
        new textHighlighter("v-High-Speed Automated Wiring Start-v", new Color(121,98,14),output);

        new Stator(stator,alternateRecipes,output);
        output.append("-----\n\n");
        new Wire(wire,alternateRecipes,output);;
        output.append("-----\n\n");
        new HighSpeedConnector(highspeedConnector,alternateRecipes,output);

        output.append("^-High-Speed Automated Wiring End-^\n\n");
        new textHighlighter("^-High-Speed Automated Wiring End-^", new Color(121,98,14),output);

    }

}
