package advanced;

import intermediate.CircuitBoard;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class AdaptiveControlUnit {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public AdaptiveControlUnit(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;
        defaultControlUnit();
    }

    public void defaultControlUnit() {
        double automatedWiring = num * (15/2.0);
        double circuitBoard = num * 5;
        double heavyFrames = num;
        double computers = num;
        output.append(ds.format(num) + " Adaptive Control Units / Minute:  " + ds.format(automatedWiring) + " Automated Wiring / minute |  " +
                ds.format(circuitBoard) +" Circuit Boards / minute |  " + ds.format(heavyFrames) + " Heavy Frames / Minute |  " +
                ds.format(computers) + " Computers / minute" +
                ". Requires  " + ds.format(num/1) + " Manufacturers\n\n");



        output.append("v-Adaptive Control Unit Start-v\n\n");
        new textHighlighter("v-Adaptive Control Unit Start-v", new Color(19,111,203),output);

        new AutomatedWiring(automatedWiring,alternateRecipes,output);
        output.append("-----\n\n");
        new CircuitBoard(circuitBoard,alternateRecipes,output);
        output.append("-----\n\n");
        new HeavyModularFrame(heavyFrames,alternateRecipes,output);
        output.append("-----\n\n");
        new Computer(computers,alternateRecipes,output);

        output.append("^-Adaptive Control Unit End-^\n\n");
        new textHighlighter("^-Adaptive Control Unit End-^", new Color(19,111,203),output);



    }

}
