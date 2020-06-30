package basic;

import intermediate.Rubber;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class Concrete {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public Concrete(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if(alternateRecipes.get(4).getSelectedItem().toString() == "Default") {
            defaultConcrete();
        } else if(alternateRecipes.get(4).getSelectedItem().toString() == "Rubber") {
            rubberConcrete();
        } else if(alternateRecipes.get(4).getSelectedItem().toString() == "Wet") {
            wetConcrete();
        } else if(alternateRecipes.get(4).getSelectedItem().toString() == "Fine") {
            fineConcrete();
        }
    }

    public void defaultConcrete() {
        double Limestone = num * 3;
        output.append(ds.format(num) + " Concrete/Minute:  " + ds.format(Limestone) + " Limestone / minute. Requires  "
                + ds.format(num/15) + " Constructors\n\n");
    }

    public void rubberConcrete() {
        double Limestone = num * (10/9.0);
        double rubber = num * (2/9.0);
        output.append(ds.format(num) + " Rubber Concrete/Minute:  " + ds.format(Limestone) + " Limestone / minute |   " +
                ds.format(rubber) +" Rubber / minute. Requires   " + ds.format(num/45) + " Assemblers\n\n");
        new Rubber(rubber,alternateRecipes,output);
    }

    public void wetConcrete() {
        double Limestone = num * (6/4.0);
        double Water = num * (5/4.0);
        output.append(ds.format(num) + " Wet Concrete/Minute:  " + ds.format(Limestone) + " Limestone / minute |  " +
                ds.format(Water) +" Water(m3) / minute. Requires  " + ds.format(num/80) + " Refineries\n\n");
    }

    public void fineConcrete() {
        double Limestone = num * (12/10.0);
        double Silica = num * (3/10.0);
        output.append(ds.format(num) + " Fine Concrete/Minute:  " + ds.format(Limestone) + " Limestone / minute |  " +
                ds.format(Silica) +" Silica / minute. Requires  " + ds.format(num/25) + " Assemblers\n\n");
        new Silica(Silica,alternateRecipes,output);
    }



}
