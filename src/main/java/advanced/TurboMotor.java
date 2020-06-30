package advanced;

import basic.*;
import intermediate.*;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class TurboMotor {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public TurboMotor(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if (alternateRecipes.get(27).getSelectedItem().toString() == "Default") {
            defaultTurboMotor();
        } else if (alternateRecipes.get(27).getSelectedItem().toString() == "Rigour") {
            rigourTurboMotor();
        }

    }

    public void defaultTurboMotor() {
        double heatSinks = num * 4;
        double radioControlUnits = num * 2;
        double motors = num * 4;
        double rubber = num * 24;
        output.append(ds.format(num) + " Turbo Motors / Minute:  " + ds.format(heatSinks) + " Heat Sinks / minute |  " +
                ds.format(radioControlUnits) +" Radio Control Units / minute |  " + ds.format(motors) + " Motors / Minute |  " +
                ds.format(rubber) + " Rubber / minute" +
                ". Requires  " + ds.format(num/1.875) + " Manufacturers\n");

        output.append("{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}\n");
        new HeatSink(heatSinks,alternateRecipes,output);
        output.append("{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}\n");
        new RadioControlUnit(radioControlUnits,alternateRecipes,output);
        output.append("{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}\n");
        new Motor(motors,alternateRecipes,output);
        output.append("{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}\n");
        new Rubber(rubber,alternateRecipes,output);
    }

    public void rigourTurboMotor() {
        double motors = num * (7/3.0);
        double radioControlUnits = num * (5/3.0);
        double aiLimiters = num * 3;
        double stators = num * (7/3.0);
        output.append(ds.format(num) + " Turbomotors / Minute:  " + ds.format(motors) + " Motors / minute |  " +
                ds.format(radioControlUnits) +" Radio Control Units / minute |  " + ds.format(aiLimiters) + " AI Limiters / Minute |  " +
                ds.format(stators) + " Stators / minute" +
                ". Requires  " + ds.format(num/2.8125) + " Manufacturers\n");

        output.append("{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}\n\n");
        new Motor(motors,alternateRecipes,output);
        output.append("{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}\n\n");
        new RadioControlUnit(aiLimiters,alternateRecipes,output);
        output.append("{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}\n\n");
        new AILimiter(aiLimiters,alternateRecipes,output);
        output.append("{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}\n\n");
        new Stator(stators,alternateRecipes,output);
    }

}
