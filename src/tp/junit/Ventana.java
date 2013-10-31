package tp.junit;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.GridLayout;

public class Ventana {

    JFrame ventana;

    public Ventana(int cantidad, int satisfactorios, int fallidos) {
        ventana = new JFrame("Resultados");
        JTextField texto1 = new JTextField("Cantidad total de Test: " + Integer.toString(cantidad));
        JTextField texto2 = new JTextField("Cantidad de tests satisfactorios: " + Integer.toString(satisfactorios));
        texto2.setBackground(Color.GREEN);
        JTextField texto3 = new JTextField("Cantidad de tests fallidos: " + Integer.toString(fallidos));
        texto3.setBackground(Color.red);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        Dimension d = new Dimension();
        ventana.setLocation((int) ((d.getWidth() / 2) + 250), 250);
        ventana.setSize(350, 350);
        ventana.setLayout(new GridLayout(3 + fallidos, 0));
        ventana.add(texto1);
        ventana.add(texto2);
        ventana.add(texto3);
    }

    public void agregarMetodosErroneos(String nombre) {
        JTextField error = new JTextField(nombre);
        error.setBackground(Color.red);
        ventana.add(error);
    }

    public void mostrar() {
        ventana.setVisible(true);

    }
}
