package advanced;

import basic.*;
import intermediate.*;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class Supercomputer {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public Supercomputer(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        defaultSupercomputer();

    }

    public void defaultSupercomputer() {
        double computers = num * 2;
        double aiLimiters = num * 2;
        double highspeedConnectors = num * 3;
        double plastic = num * 28;
        output.append(ds.format(num) + " Supercomputers / Minute:  " + ds.format(computers) + " Computers / minute |  " +
                ds.format(aiLimiters) +" AI Limiters / minute |  " + ds.format(highspeedConnectors) + " High-Speed Connectors / Minute |  " +
                ds.format(plastic) + " Plastic / minute" +
                ". Requires  " + ds.format(num/1.875) + " Manufacturers\n\n");


        output.append("v-Supercomputers Start-v\n\n");
        new textHighlighter("v-Supercomputers Start-v", Color.magenta,output);

        new Computer(computers,alternateRecipes,output);
        output.append("-----\n\n");
        new AILimiter(aiLimiters,alternateRecipes,output);
        output.append("-----\n\n");
        new HighSpeedConnector(highspeedConnectors,alternateRecipes,output);
        output.append("-----\n\n");
        new Plastic(plastic,alternateRecipes,output);

        output.append("^-Supercomputers End-^\n\n");
        new textHighlighter("^-Supercomputers End-^", Color.magenta,output);

    }

}
