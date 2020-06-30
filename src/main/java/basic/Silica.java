package basic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class Silica {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public Silica(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if(alternateRecipes.get(5).getSelectedItem().toString() == "Default") {
            defaultSilica();
        } else if(alternateRecipes.get(5).getSelectedItem().toString() == "Cheap") {
            cheapSilica();
        }
    }

    public void defaultSilica() {
        double RawQuartz = num * (3/5.0);
        output.append(ds.format(num) + " Silica / Minute:  " + ds.format(RawQuartz) + " Raw Quartz / minute.  " +
                "Requires " + ds.format(num/37.5) + " Constructors\n\n");
    }

    public void cheapSilica() {
        double RawQuartz = num * (3/7.0);
        double Limestone = num * (5/7.0);
        output.append(ds.format(num) + " Cheap Silica / Minute:  " + ds.format(RawQuartz) + " Raw Quartz / minute |  " +
                ds.format(Limestone) +" Limestone / minute. Requires  " + ds.format(num/26.25) + " Assemblers\n\n");
    }

}
