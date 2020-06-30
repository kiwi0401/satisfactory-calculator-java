/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class AluminaSolution {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public AluminaSolution(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        defaultAluminaSolution();
    }

    public void defaultAluminaSolution() {
        double silica = num / 4;
        double bauxite = num * (7/8.0);
        double water = num * (10/8.0);
        output.append(ds.format(num) + " Alumina Solution(m3) / Minute: and  " + ds.format(silica) + " Silica / Minute" +
                ":  " + ds.format(bauxite) + " Bauxite / minute |  " +
                ds.format(water) +" Water(m3) / minute. Requires  " + ds.format(num/80) + " Refineries\n\n");
    }


}
