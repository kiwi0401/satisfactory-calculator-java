package master;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;

public class analyzeData {

    private JTextArea outputArea;

    public analyzeData(JTextArea outputArea) {
        this.outputArea = outputArea;
        jtextareaTest();
    }

    public void jtextareaTest(){

        String[] s = outputArea.getText().split("\\r?\\n");
        ArrayList<String> evaluatableText = new ArrayList<>(Arrays.asList(s));
        ArrayList<String> totals = new ArrayList<>();

        for (String extract : evaluatableText) {
            if (extract.contains(">")) {
                continue;
            }
            if (extract.contains("Iron Ore")) {
                String[] t = extract.split(" {2}");
                ArrayList<String> finder = new ArrayList<>(Arrays.asList(t));
                for (String item : finder) {
                    if (item.contains("Iron Ore")) {
                        Scanner raw = new Scanner(item);
                        double value = raw.nextDouble();
                        String toAdd = Double.toString(value).concat(" Iron Ore / Minute");
                        totals.add(toAdd);
                    }
                }
            }
            if (extract.contains("Caterium Ore")) {
                String[] t = extract.split(" {2}");
                ArrayList<String> finder = new ArrayList<>(Arrays.asList(t));
                for (String item : finder) {
                    if (item.contains("Caterium Ore")) {
                        Scanner raw = new Scanner(item);
                        double value = raw.nextDouble();
                        String toAdd = Double.toString(value).concat(" Caterium Ore / Minute");
                        totals.add(toAdd);
                    }
                }
            }
            if (extract.contains("Water(m3)")) {
                String[] t = extract.split(" {2}");
                ArrayList<String> finder = new ArrayList<>(Arrays.asList(t));
                for (String item : finder) {
                    if (item.contains("Water(m3)")) {
                        Scanner raw = new Scanner(item);
                        double value = raw.nextDouble();
                        String toAdd = Double.toString(value).concat(" Water(m3) / Minute");
                        totals.add(toAdd);
                    }
                }
            }
            if (extract.contains("Raw Coal")) {
                String[] t = extract.split(" {2}");
                ArrayList<String> finder = new ArrayList<>(Arrays.asList(t));
                for (String item : finder) {
                    if (item.contains("Raw Coal")) {
                        Scanner raw = new Scanner(item);
                        double value = raw.nextDouble();
                        String toAdd = Double.toString(value).concat(" Raw Coal / Minute");
                        totals.add(toAdd);
                    }
                }
            }
            if (extract.contains("Sulfur")) {
                String[] t = extract.split(" {2}");
                ArrayList<String> finder = new ArrayList<>(Arrays.asList(t));
                for (String item : finder) {
                    if (item.contains("Sulfur")) {
                        Scanner raw = new Scanner(item);
                        double value = raw.nextDouble();
                        String toAdd = Double.toString(value).concat(" Sulfur / Minute");
                        totals.add(toAdd);
                    }
                }
            }
            if (extract.contains("Limestone")) {
                String[] t = extract.split(" {2}");
                ArrayList<String> finder = new ArrayList<>(Arrays.asList(t));
                for (String item : finder) {
                    if (item.contains("Limestone")) {
                        Scanner raw = new Scanner(item);
                        double value = raw.nextDouble();
                        String toAdd = Double.toString(value).concat(" Limestone / Minute");
                        totals.add(toAdd);
                    }
                }
            }
            if (extract.contains("Copper Ore")) {
                String[] t = extract.split(" {2}");
                ArrayList<String> finder = new ArrayList<>(Arrays.asList(t));
                for (String item : finder) {
                    if (item.contains("Copper Ore")) {
                        Scanner raw = new Scanner(item);
                        double value = raw.nextDouble();
                        String toAdd = Double.toString(value).concat(" Copper Ore / Minute");
                        totals.add(toAdd);
                    }
                }
            }
            if (extract.contains("Raw Quartz")) {
                String[] t = extract.split(" {2}");
                ArrayList<String> finder = new ArrayList<>(Arrays.asList(t));
                for (String item : finder) {
                    if (item.contains("Raw Quartz")) {
                        Scanner raw = new Scanner(item);
                        double value = raw.nextDouble();
                        String toAdd = Double.toString(value).concat(" Raw Quartz / Minute");
                        totals.add(toAdd);
                    }
                }
            }
            if (extract.contains("Bauxite")) {
                String[] t = extract.split(" {2}");
                ArrayList<String> finder = new ArrayList<>(Arrays.asList(t));
                for (String item : finder) {
                    if (item.contains("Bauxite")) {
                        Scanner raw = new Scanner(item);
                        double value = raw.nextDouble();
                        String toAdd = Double.toString(value).concat(" Bauxite / Minute");
                        totals.add(toAdd);
                    }
                }
            }
            if (extract.contains("Raw Oil(m3)")) {
                String[] t = extract.split(" {2}");
                ArrayList<String> finder = new ArrayList<>(Arrays.asList(t));
                for (String item : finder) {
                    if (item.contains("Raw Oil(m3)")) {
                        Scanner raw = new Scanner(item);
                        double value = raw.nextDouble();
                        String toAdd = Double.toString(value).concat(" Raw Oil(m3) / Minute");
                        totals.add(toAdd);
                    }
                }
            }



            char[] chars = new char[extract.length()];
            extract.getChars(0, extract.length(), chars, 0);
            for (int b = 0; b < chars.length; b++) {
                try {
                    if (chars[b] == (':')) {
                        totals.add(extract.substring(0, b));
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException a) {
                    break;
                }
            }
        }
        ArrayList<String> finalValues = new ArrayList<>();

        for(int i = 0; i < totals.size(); i++) {

            String initial = totals.get(i).substring(totals.get(i).indexOf(' '));
            Scanner initialScanner = new Scanner(totals.get(i));
            double fullCost = 0;

            try{
                fullCost = initialScanner.nextDouble();
                if(fullCost == 0) {
                    totals.remove(i);
                    i--;
                }
            } catch(Exception e) {
                System.out.println(initial + " failed");
            }
            for(int b = i + 1; b < totals.size(); b++){
                String Comparison = totals.get(b).substring(totals.get(b).indexOf(' '));
                if(initial.equals(Comparison)) {
                    Scanner addon = new Scanner(totals.get(b));
                    fullCost += addon.nextDouble();
                    totals.remove(b);
                    b--;
                }
            }

            DecimalFormat ds = new DecimalFormat("#.##");
            String toAdd = ds.format(fullCost).concat(initial);
            finalValues.add(toAdd);
        }
        outputArea.append("\n\n\n---------------\n TOTALS \n---------------\n\n");
        finalValues.sort((a, b) -> (int) ((new Scanner(b).nextDouble()) - (new Scanner(a).nextDouble())));
        new textHighlighter("TOTALS", Color.GREEN,outputArea);
        for(int i = 0; i < totals.size(); i++) {
            outputArea.append(finalValues.get(i) + "\n");
        }
    }

}
