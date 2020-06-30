package master;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;

public class textHighlighter {

    private String text;
    private Color color;
    private final Highlighter highlighter;
    private final JTextArea output;



    public textHighlighter(String text, Color color, JTextArea output) {
        this.highlighter = output.getHighlighter();
        this.text = text;
        this.output = output;
        this.color = color;
        highLight();
    }

    public void highLight() {
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(color);
        try {
            int po = output.getText().indexOf(text);
            highlighter.addHighlight(po,po + text.length(),painter);
        } catch(Exception a) {
            System.out.println("invalid location");
        }
    }



}
