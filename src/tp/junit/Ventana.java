package tp.junit;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.GridLayout;

public class Ventana {

    public Ventana(int cantidad, int satisfactorios, int fallidos) {
        JFrame ventana = new JFrame("Resultados");
        JTextField texto1 = new JTextField("Cantidad total de Test: " + Integer.toString(cantidad));
        JTextField texto2 = new JTextField("Cantidad de tests satisfactorios: " + Integer.toString(satisfactorios));
        texto2.setBackground(Color.GREEN);
        JTextField texto3 = new JTextField("Cantidad de tests fallidos: " + Integer.toString(fallidos));
        texto3.setBackground(Color.red);
        Dimension d = new Dimension();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocation((int) ((d.getWidth() / 2) + 290), 50);
        ventana.setSize(350, 350);
        ventana.setLayout(new GridLayout(3, 0));
        ventana.add(texto1);
        ventana.add(texto2);
        ventana.add(texto3);
        ventana.setVisible(true);      
    }
}
