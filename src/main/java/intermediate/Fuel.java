package intermediate;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class Fuel {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");
    private double polymerResin = 0;

    public Fuel(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if(alternateRecipes.get(36).getSelectedItem().toString() == "Default") {
            defaultFuel();
        } else if(alternateRecipes.get(36).getSelectedItem().toString() == "Residual") {
            residualFuel();
        } else if(alternateRecipes.get(36).getSelectedItem().toString() == "Diluted") {
            dilutedFuel();
        }
    }

    public void defaultFuel() {
        double RawOil = num * (6/4.0);
        double PolymerResin = num * (3/4.0);
        polymerResin += PolymerResin;
        output.append(ds.format(num) + " Fuel(m3) / Minute: and "+ ds.format(PolymerResin) + " Polymer Resin" +
                " / minute:  " + ds.format(RawOil) + " Raw Oil(m3) / minute. Requires  " + ds.format(num/40) + " Refineries\n\n");
    }

    public void residualFuel() {
        double HeavyOilResidue = num * (6/4.0);
        output.append(ds.format(num) + " Residual Fuel(m3) / Minute:  " + ds.format(HeavyOilResidue) + " Heavy Oil Residue(m3) / minute. " +
                "Requires  " + ds.format(num/40) + " Refineries\n\n");
        HeavyOilResidue residue = new HeavyOilResidue(HeavyOilResidue,alternateRecipes,output);
        polymerResin += residue.getPolymerResin();
    }

    public void dilutedFuel() {
        double heavyOilResidue = num / 2;
        double Water = num;
        output.append(ds.format(num) + " Packaged Fuel(m3) / Minute:  " + ds.format(heavyOilResidue) + " Heavy Oil Residue / minute |  " +
                ds.format(Water) +" Packaged Water / minute. Requires  " + ds.format(num/60) + " Refineries\n\n");

        output.append(ds.format(Water) + " Packaged Water / Minute:  "+ ds.format(Water) + " Water(m3) / Minute. Requires  " + ds.format(Water/60)
                + " Refineries for packaging" + " water and " + ds.format(Water/60) + " for unpacking fuel\n\n");

        HeavyOilResidue residue = new HeavyOilResidue(heavyOilResidue,alternateRecipes,output);
        polymerResin += residue.getPolymerResin();
    }

    public double getPolymerResin() {
        return polymerResin;
    }




}
