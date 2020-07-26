package advanced;

import basic.*;
import intermediate.*;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class NuclearFuelRod {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public NuclearFuelRod(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if (alternateRecipes.get(30).getSelectedItem().toString() == "Default") {
            defaultNuclearFuel();
        } else if (alternateRecipes.get(30).getSelectedItem().toString() == "Unit") {
            unitNuclearFuel();
        }
    }

    public void unitNuclearFuel() {
        double encasedUranium = num * (50/3.0);
        double electromagneticControlRods = num * (10/3.0);
        double crystalOscillators = num;
        double beacons = num * 2;
        output.append(ds.format(num) + " Nuclear Fuel Units / Minute:  " + ds.format(encasedUranium) + " Encased Uranium Cells / minute |  " +
                ds.format(electromagneticControlRods) +" Electromagnetic Control Rods / minute |  " + ds.format(crystalOscillators) + " Crystal Oscillators / Minute |  " +
                ds.format(beacons) + " Beacons / minute" +
                ". Requires  " + ds.format(num/7.5) + " Manufacturers\n\n");

        output.append("v-Nuclear Fuel Units Start-v\n\n");
        new textHighlighter("v-Nuclear Fuel Units Start-v", Color.ORANGE,output);

        new EncasedUraniumCell(encasedUranium,alternateRecipes,output);
        output.append("-----\n\n");
        new ElectromagneticControlRod(electromagneticControlRods,alternateRecipes,output);
        output.append("-----\n\n");
        new CrystalOscillator(crystalOscillators,alternateRecipes,output);
        output.append("-----\n\n");
        new Beacon(beacons,alternateRecipes,output);

        output.append("^-Nuclear Fuel Units End-^\n\n");
        new textHighlighter("^-Nuclear Fuel Units End-^", Color.ORANGE,output);

    }

    public void defaultNuclearFuel() {
        double encasedUranium = num * 25;
        double electromagneticControlRod = num * 5;
        double encasedBeam = num * 3;
        output.append(ds.format(num) + " Nuclear Fuel Rods / Minute:  " + ds.format(encasedUranium) + " Encased Uranium Cells / minute |  " +
                ds.format(electromagneticControlRod) +" Electromagnetic Control Rods / minute |  " + ds.format(encasedBeam) + " Encased Industrial Beams / Minute" +
                ". Requires  " + ds.format(num/10) + " Manufacturers\n\n");

        output.append("v-Nuclear Fuel Rod Start-v\n\n");
        new textHighlighter("v-Nuclear Fuel Rod Start-v", Color.ORANGE,output);
        new EncasedUraniumCell(encasedUranium,alternateRecipes,output);
        output.append("-----\n\n");
        new ElectromagneticControlRod(electromagneticControlRod,alternateRecipes,output);
        output.append("-----\n\n");
        new EncasedIndustrialBeam(encasedBeam,alternateRecipes,output);
        output.append("^-Nuclear Fuel Rod End-^\n\n");
        new textHighlighter("^-Nuclear Fuel Rod End-^", Color.ORANGE,output);
    }


}
