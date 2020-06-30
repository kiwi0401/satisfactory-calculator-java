package basic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class CompactedCoal {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public CompactedCoal(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;
        defaultCompactedCoal();
    }

    public void defaultCompactedCoal() {
        double RawCoal = num;
        double Sulfur = num;
        output.append(ds.format(num) + " Compacted Coal/Minute:  " + ds.format(RawCoal) + " Raw Coal / minute. Requires |  " +
                ds.format(Sulfur) +" Sulfur / minute. Requires  " + ds.format(num/25) + " Foundries\n\n");
    }


}
