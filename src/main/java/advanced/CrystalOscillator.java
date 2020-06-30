package advanced;

import basic.Cable;
import basic.QuartzCrystal;
import basic.ReinforcedIronPlate;
import intermediate.AILimiter;
import intermediate.Rubber;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class CrystalOscillator {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public CrystalOscillator(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if (alternateRecipes.get(23).getSelectedItem().toString() == "Default") {
            defaultCrystalOscillators();
        } else if (alternateRecipes.get(23).getSelectedItem().toString() == "Insulated") {
            insulatedCrystalOscillators();
        }
    }

    public void defaultCrystalOscillators() {
        double quartzCrystal = num * 18;
        double cable = num * 14;
        double reinforcedIronPlate = num * (5/2.0);
        output.append(ds.format(num) + " Crystal Oscillators / Minute:  " + ds.format(quartzCrystal) + " Quartz Crystal / minute |  " +
                ds.format(cable) +" Cable / minute |  " + ds.format(reinforcedIronPlate) + " R.I.P / Minute" +
                ". Requires  " + ds.format(num/1) + " Manufacturers\n\n");

        output.append("v-Crystal Oscillator Start-v\n\n");
        new textHighlighter("v-Crystal Oscillator Start-v", new Color(162,117,175),output);
        new QuartzCrystal(quartzCrystal,alternateRecipes,output);
        output.append("-----\n\n");
        new Cable(cable,alternateRecipes,output);
        output.append("-----\n\n");
        new ReinforcedIronPlate(reinforcedIronPlate,alternateRecipes,output);
        output.append("^-Crystal Oscillator End-^\n\n");
        new textHighlighter("^-Crystal Oscillator End-^", new Color(162,117,175),output);

    }

    public void insulatedCrystalOscillators() {
        double quartzCrystal = num * 10;
        double rubber = num * 7;
        double aiLimiter = num;
        output.append(ds.format(num) + " Insulated Crystal Oscillators / Minute:  " + ds.format(quartzCrystal) + " Quartz Crystal / minute |  " +
                ds.format(rubber) +" Rubber / minute |  " + ds.format(aiLimiter) + " AI Limiters / Minute" +
                ". Requires  " + ds.format(num/1.875) + " Manufacturers\n\n");

        output.append("v-Insulated Crystal Oscillator-v\n\n");
        new textHighlighter("v-Insulated Crystal Oscillator-v", new Color(162,117,175),output);

        new QuartzCrystal(quartzCrystal,alternateRecipes,output);
        output.append("-----\n\n");
        new Rubber(rubber,alternateRecipes,output);
        output.append("-----\n\n");
        new AILimiter(aiLimiter,alternateRecipes,output);

        output.append("^-Insulated Crystal Oscillator-^\n\n");
        new textHighlighter("^-Insulated Crystal Oscillator-^", new Color(162,117,175),output);


    }


}
