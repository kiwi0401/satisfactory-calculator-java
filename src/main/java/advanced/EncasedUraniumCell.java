package advanced;

import basic.*;
import intermediate.*;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class EncasedUraniumCell {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public EncasedUraniumCell(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if (alternateRecipes.get(28).getSelectedItem().toString() == "Default") {
            defaultUraniumCell();
        } else if (alternateRecipes.get(28).getSelectedItem().toString() == "Infused") {
            infusedUraniumCell();
        }
    }

    public void infusedUraniumCell() {
        double uraniumPellets = num * (40/35.0);
        double sulfur = num * (45/35.0);
        double silica = num * (45/35.0);
        double quickWire = num * (75/35.0);
        output.append(ds.format(num) + " Infused Uranium Cells / Minute:  " + ds.format(uraniumPellets) + " Uranium Pellets / minute |  " +
                ds.format(sulfur) +" Raw Sulfur / minute |  " + ds.format(silica) + " Silica / Minute |  " +
                ds.format(quickWire) + " Quickwire / minute" +
                ". Requires " + ds.format(num/17.5) + " Manufacturers\n\n");
        new UraniumPellet(uraniumPellets,alternateRecipes,output);
        new Silica(silica,alternateRecipes,output);
        new Quickwire(quickWire,alternateRecipes,output);
    }

    public void defaultUraniumCell() {
        double uraniumPellets = num * 4;
        double conrete = num * (9/10.0);
        output.append(ds.format(num) + " Uranium Cells / Minute:  " + ds.format(uraniumPellets) + " Uranium Pellets / minute |  " +
                ds.format(conrete) +" Concrete / minute. Requires  " + ds.format(num/10) + " Assemblers\n\n");
        new UraniumPellet(uraniumPellets,alternateRecipes,output);
        new Concrete(conrete,alternateRecipes,output);

    }

}
