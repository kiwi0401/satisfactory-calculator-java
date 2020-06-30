package master;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.util.List;

public class Calculator{

    private final String product;
    private final double amount;
    private final List<JComboBox<String>> alternateRecipes;
    private final JTextArea outputTextArea;
    private boolean advancedOil = false;
    Class<?> p;

    public Calculator(String product, double amount, List<JComboBox<String>> alternateRecipes, JTextArea outputTextArea){
        this.product = product;
        this.amount = Math.abs(amount);
        this.alternateRecipes = alternateRecipes;
        this.outputTextArea = outputTextArea;
        System.out.println(product);
        Calculate();
    }

    public void Calculate() {
        try {
            p = Class.forName("basic."+product);
            System.out.println(p.getName());
        } catch (ClassNotFoundException a) {
            System.out.println("Not a Basic Product");
            try {
                p = Class.forName("intermediate."+product);
            } catch (ClassNotFoundException b) {
                System.out.println("Not an intermediate Product");
                try {
                    p = Class.forName("advanced."+product);
                } catch (ClassNotFoundException c) {
                    System.out.println("Null");
                }
            }
        }
        if( p != null) {
            try {
                Constructor<?> cons = p.getConstructor(double.class, List.class, JTextArea.class);
                Object obj = cons.newInstance(amount,alternateRecipes,outputTextArea);

            } catch (Exception a) {
                System.out.println("No method found");
            }
        } else {
            System.out.println("uh oh null");
        }
        new analyzeData(outputTextArea);
    }

}
