package com.mycompany.pruebasproyecto3.Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana {

    public JFrame frame;
    private JTabbedPane tabbedPane;
    private ArrayList<DefaultTableModel> models;
    private ArrayList<JPanel> hojas;
    private JTextField funcionesField;
    public JButton aplicar;
    public JButton rechazar;
    public JMenuItem crearHoja, tablaHash, guardar;
    private JLabel hojaActualLabel;

    public Ventana() {
        models = new ArrayList<>();
        hojas = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Hoja de Cálculo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        tabbedPane = new JTabbedPane();

        JPanel funcionesPanel = new JPanel();
        funcionesField = new JTextField(20);
        funcionesPanel.add(new JLabel("F(x): "));
        funcionesPanel.add(funcionesField);

        aplicar = new JButton("Aplicar");
        rechazar = new JButton("Rechazar");

        funcionesPanel.add(aplicar);
        funcionesPanel.add(rechazar);

        frame.add(funcionesPanel, BorderLayout.NORTH);

        JMenu menu;
        JMenuBar barra = new JMenuBar();
        menu = new JMenu("Menu");
        crearHoja = new JMenuItem("Nueva Hoja");
        tablaHash = new JMenuItem("Tabla Hash");
        guardar = new JMenuItem("Guardar");

        menu.add(tablaHash);
        menu.add(crearHoja);
        menu.add(guardar);
        barra.add(menu);
        frame.setJMenuBar(barra);

        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        hojaActualLabel = new JLabel("Hoja Actual: 1", SwingConstants.CENTER);
        frame.getContentPane().add(hojaActualLabel, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }

    public void agregarHoja(DefaultTableModel nuevoModelo, JTable nuevaTabla, JPanel nuevoPanel) {
        JScrollPane nuevoScrollPane = new JScrollPane(nuevaTabla);
        nuevoPanel.add(nuevoScrollPane, BorderLayout.CENTER);
        hojas.add(nuevoPanel);
        //?????????????????
//        models.add(nuevoModelo);
        tabbedPane.addTab("Hoja " + hojas.size(), nuevoPanel);

        tabbedPane.addChangeListener(e -> {
            int index = tabbedPane.getSelectedIndex();
            hojaActualLabel.setText("Hoja Actual: " + (index + 1));
        });
    }

    public void setControlador(ActionListener controlador) {
        aplicar.addActionListener(controlador);
        rechazar.addActionListener(controlador);
        crearHoja.addActionListener(controlador);
        tablaHash.addActionListener(controlador);
        guardar.addActionListener(controlador);
    }

    public void agregarModelo(DefaultTableModel modelo) {
        models.add(modelo);
    }

    //me trae el contenidoo de la funcioon 
    public String getFuncion() {
        return funcionesField.getText();
    }

    public void limpiarFuncion() {
        funcionesField.setText("");
    }

    public int getHojaSeleccionada() {
        return tabbedPane.getSelectedIndex();
    }

    public DefaultTableModel getModeloHojaSeleccionada() {
        return models.get(tabbedPane.getSelectedIndex());
    }

    public JFrame getFrame() {
        return frame;
    }
}
