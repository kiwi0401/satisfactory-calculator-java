package advanced;

import basic.*;
import intermediate.EncasedIndustrialBeam;
import intermediate.ModularFrame;
import intermediate.Rubber;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class HeavyModularFrame {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public HeavyModularFrame(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if (alternateRecipes.get(12).getSelectedItem().toString() == "Default") {
            defaultHeavyFrame();
        } else if (alternateRecipes.get(12).getSelectedItem().toString() == "Flexible") {
            flexibleHeavyFrame();
        } else if (alternateRecipes.get(12).getSelectedItem().toString() == "Encased") {
            encasedHeavyFrame();
        }
    }

    public void defaultHeavyFrame() {
        double modularFrame = num * 5;
        double steelPipe = num * 15;
        double encasedIndustrialBeam = num *5;
        double screw = num * 100;
        output.append(ds.format(num) + " Heavy Modular Frames / Minute:  " + ds.format(modularFrame) + " Modular Frames / minute  | " +
                ds.format(steelPipe) +" Steel Pipes / minute |  " + ds.format(encasedIndustrialBeam) + " Encased Industrial Beams / Minute |  " +
                ds.format(screw) + " Screws / minute" +
                ". Requires  " + ds.format(num/2) + " Manufacturers\n\n");

        output.append("v-Heavy Modular Frame Start-v\n\n");
        new textHighlighter("v-Heavy Modular Frame Start-v", new Color(38,136,57),output);

        new ModularFrame(modularFrame,alternateRecipes,output);
        output.append("-----\n\n");
        new SteelPipe(steelPipe,alternateRecipes,output);
        output.append("-----\n\n");
        new EncasedIndustrialBeam(encasedIndustrialBeam,alternateRecipes,output);
        output.append("-----\n\n");
        new Screw(screw,alternateRecipes,output);

        output.append("^-Heavy Modular Frame End-^\n\n");
        new textHighlighter("^-Heavy Modular Frame End-^", new Color(38,136,57),output);
    }

    public void flexibleHeavyFrame() {
        double modularFrame = num * 5;
        double rubber = num * 20;
        double encasedIndustrialBeam = num * 3;
        double screw = num * 104;
        output.append(ds.format(num) + " Flexible Heavy Modular Frames / Minute:  " + ds.format(modularFrame) + " Modular Frames / minute |  " +
                ds.format(rubber) +" Rubber / minute |  " + ds.format(encasedIndustrialBeam) + " Encased Industrial Beams / Minute |  " +
                ds.format(screw) + " Screws / minute" +
                ". Requires  " + ds.format(num/3.75) + " Manufacturers\n\n");

        output.append("v-Flexible Heavy Frame Start-v\n\n");
        new textHighlighter("v-Flexible Heavy Frame Start-v", new Color(38,136,57),output);

        new ModularFrame(modularFrame,alternateRecipes,output);
        output.append("-----\n\n");
        new Rubber(rubber,alternateRecipes,output);
        output.append("-----\n\n");
        new EncasedIndustrialBeam(encasedIndustrialBeam,alternateRecipes,output);
        output.append("-----\n\n");
        new Screw(screw,alternateRecipes,output);

        output.append("^-Flexible Heavy Frame End-^\n\n");
        new textHighlighter("^-Flexible Heavy Frame End-^", new Color(38,136,57),output);

    }

    public void encasedHeavyFrame() {
        double modularFrame = num * (8/3.0);
        double steelPipe = num * 12;
        double encasedIndustrialBeam = num * (10/3.0);
        double concrete = num * (22/3.0);
        output.append(ds.format(num) + " Encased Heavy Modular Frames / Minute:  " + ds.format(modularFrame) + " Modular Frames / minute |  " +
                ds.format(steelPipe) +" Steel Pipes / minute |  " + ds.format(encasedIndustrialBeam) + " Encased Industrial Beams / Minute |  " +
                ds.format(concrete) + " Concrete / minute" +
                ". Requires " + ds.format(num/2.8125) + " Manufacturers\n\n");

        output.append("v-Encased Heavy Frame Start-v\n\n");
        new textHighlighter("v-Encased Heavy Frame Start-v", new Color(38,136,57),output);

        new ModularFrame(modularFrame,alternateRecipes,output);
        output.append("-----\n\n");
        new SteelPipe(steelPipe,alternateRecipes,output);
        output.append("-----\n\n");
        new EncasedIndustrialBeam(encasedIndustrialBeam,alternateRecipes,output);
        output.append("-----\n\n");
        new Concrete(concrete,alternateRecipes,output);

        output.append("^-Encased Heavy Frame End-^\n\n");
        new textHighlighter("^-Encased Heavy Frame End-^", new Color(38,136,57),output);
    }


}
