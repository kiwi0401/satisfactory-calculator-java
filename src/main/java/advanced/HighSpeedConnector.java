package advanced;

import basic.*;
import intermediate.*;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class HighSpeedConnector {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public HighSpeedConnector(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if (alternateRecipes.get(9).getSelectedItem().toString() == "Default") {
            defaultConnector();
        } else if (alternateRecipes.get(9).getSelectedItem().toString() == "Silicone") {
            siliconeConnector();
        }
    }

    public void defaultConnector() {
        double quickWire = num * 56;
        double cable = num * 10;
        double circuits = num;
        output.append(ds.format(num) + " High Speed Connectors / Minute:  " + ds.format(quickWire) + " Quickwire / minute |  " +
                ds.format(cable) +" Cable / minute |  " + ds.format(circuits) + " Circuit Boards / Minute" +
                ". Requires  " + ds.format(num/3.75) + " Manufacturers\n\n");

        output.append("v-High-Speed Connector Start-v\n\n");
        new textHighlighter("v-High-Speed Connector Start-v", new Color(66,197,60),output);
        new Quickwire(quickWire,alternateRecipes,output);
        output.append("-----\n\n");
        new Cable(cable,alternateRecipes,output);
        output.append("-----\n\n");
        new CircuitBoard(circuits,alternateRecipes,output);
        output.append("^-High-Speed Connector End-^\n\n");
        new textHighlighter("^-High-Speed Connector End-^", new Color(66,197,60),output);
    }

    public void siliconeConnector() {
        double quickWire = num * 30;
        double silica = num * (25/2.0);
        double circuits = num;
        output.append(ds.format(num) + " Silicone High Speed Connectors / Minute: " + ds.format(quickWire) + " Quickwire / minute | " +
                ds.format(silica) +" Silica / minute | " + ds.format(circuits) + " Circuit Boards / Minute" +
                ". Requires " + ds.format(num/3) + " Manufacturers\n\n");
        output.append("v-Silicone High-Speed Connector Start-v\n\n");
        new textHighlighter("v-Silicone High-Speed Connector Start-v", new Color(66,197,60),output);
        new Quickwire(quickWire,alternateRecipes,output);
        output.append("-----\n\n");
        new Silica(silica,alternateRecipes,output);
        output.append("-----\n\n");
        new CircuitBoard(circuits,alternateRecipes,output);
        output.append("^-Silicone High-Speed Connector End-^\n\n");
        new textHighlighter("^-Silicone High-Speed Connector End-^", new Color(66,197,60),output);
    }


}
