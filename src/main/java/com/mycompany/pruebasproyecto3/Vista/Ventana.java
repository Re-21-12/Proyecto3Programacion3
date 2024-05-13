package com.mycompany.pruebasproyecto3.Vista;
import com.mycompany.pruebasproyecto3.Modelos.MatrizOrtogonal;
import com.mycompany.pruebasproyecto3.Modelos.NodoOrtogonal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Ventana {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JPanel[] hojas;
    private DefaultTableModel[] models;
    private ArrayList<MatrizOrtogonal> contenidoHojas = new ArrayList<>();

    public void mostrarVentana(MatrizOrtogonal matrizOrtogonal) {
        frame = new JFrame("Hoja de Cálculo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        tabbedPane = new JTabbedPane();
        contenidoHojas.add(matrizOrtogonal);
        hojas = new JPanel[contenidoHojas.size()]; // Número de hojas
        models = new DefaultTableModel[contenidoHojas.size()]; // Número de hojas

        for (int i = 0; i < hojas.length; i++) {
            hojas[i] = new JPanel(new BorderLayout());

            // Crear un modelo de tabla personalizado para cada hoja
            models[i] = new DefaultTableModel(20, 20); // 20 filas y 20 columnas
            for (int j = 0; j < 20; j++) {
                models[i].setValueAt(j + 1, j, 0); // Añadir los números del 1 al 20 en la primera columna
            }

            // Crear y configurar la tabla con el modelo personalizado
            JTable table = new JTable(models[i]);
            table.setPreferredScrollableViewportSize(new Dimension(800, 600));
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            // Agregar un MouseListener a la tabla para detectar clics
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        int fila = table.rowAtPoint(e.getPoint());
                        int columna = table.columnAtPoint(e.getPoint());
                        if (fila >= 0 && columna >= 0) {
                            // Lógica para manejar los clics en las celdas
                            Object[] options = {"Ingresar valor", "Actualizar valor", "Eliminar valor"};
                            int choice = JOptionPane.showOptionDialog(frame, "Seleccione una opción para la celda (" + fila + ", " + columna + "):",
                                    "Opciones de Celda", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                            if (choice == 2) {
                                // Si el usuario elimina el valor de la celda
                                models[tabbedPane.getSelectedIndex()].setValueAt(null, fila, columna);
                                // Mostrar en la consola que se eliminó el valor de la celda
                                System.out.println("Se eliminó el valor de la celda (" + fila + ", " + columna + ")");
                                // Crear un NodoOrtogonal con los datos relevantes y enviarlo al método para manejar los cambios
                                Object dato = models[tabbedPane.getSelectedIndex()].getValueAt(fila, columna);
                                NodoOrtogonal nodoOrtogonal = new NodoOrtogonal(null, fila, columna);
                                System.out.println("Dato: " + nodoOrtogonal.getDato() + " |Y: " + nodoOrtogonal.getY() + " |X: " + nodoOrtogonal.getX() + "borrado");

                                mandarCambios(nodoOrtogonal, "eliminado", matrizOrtogonal);
                            } else if (choice == 1) {
                                // Si se actualiza el valor en la celda
                                String valorAnterior = (String) models[tabbedPane.getSelectedIndex()].getValueAt(fila, columna); // Valor anterior en la celda
                                String nuevoValor = JOptionPane.showInputDialog(frame, "Ingrese el valor para la celda (" + fila + ", " + columna + "):");
                                models[tabbedPane.getSelectedIndex()].setValueAt(nuevoValor, fila, columna);
                                // Mostrar en la consola la coordenada modificada y los valores antiguo y nuevo
                                System.out.println("Se ingresó un dato en la celda (" + fila + ", " + columna + ")");
                                System.out.println("El valor anterior en la celda (" + fila + ", " + columna + ") era: " + valorAnterior);
                                System.out.println("El nuevo valor en la celda (" + fila + ", " + columna + ") es: " + nuevoValor);
                                Object dato = models[tabbedPane.getSelectedIndex()].getValueAt(fila, columna);
                                NodoOrtogonal nodoOrtogonal = new NodoOrtogonal(dato.toString(), fila, columna);
                                System.out.println("Dato: " + nodoOrtogonal.getDato() + " |Y: " + nodoOrtogonal.getY() + " |X: " + nodoOrtogonal.getX() + "actualizado");
                                mandarCambios(nodoOrtogonal, "actualizado", matrizOrtogonal);
                            } else if (choice == 0) {
                                String nuevoValor = JOptionPane.showInputDialog(frame, "Ingrese el valor para la celda (" + fila + ", " + columna + "):");
                                models[tabbedPane.getSelectedIndex()].setValueAt(nuevoValor, fila, columna);
                                System.out.println("Se ingresó un nuevo dato en la celda (" + fila + ", " + columna + ")");
                                Object dato = models[tabbedPane.getSelectedIndex()].getValueAt(fila, columna);
                                NodoOrtogonal nodoOrtogonal = new NodoOrtogonal(dato.toString(), fila, columna);
                                System.out.println("Dato: " + nodoOrtogonal.getDato() + " |Y: " + nodoOrtogonal.getY() + " |X: " + nodoOrtogonal.getX() + "insertado");

                                mandarCambios(nodoOrtogonal, "insertado", matrizOrtogonal);// Aquí puedes realizar cualquier operación adicional para manejar la inserción
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace(); // Imprimir la excepción en la consola
                    }
                }
            });

            // Agregar la tabla a un JScrollPane
            JScrollPane scrollPane = new JScrollPane(table);

            // Agregar el JScrollPane al panel de la hoja
            hojas[i].add(scrollPane, BorderLayout.CENTER);
            tabbedPane.add("Hoja " + (i + 1), hojas[i]);
        }

        // Agregar un panel para escribir funciones
        JPanel funcionesPanel = new JPanel();
        JTextField funcionesField = new JTextField(20);
        funcionesPanel.add(new JLabel("Funciones: "));
        funcionesPanel.add(funcionesField);

        JMenu menu;
        JMenuItem crearHoja, tablaHash, guardar;
        JMenuBar barra = new JMenuBar();
        menu = new JMenu("Menu");
        crearHoja = new JMenuItem("Nueva Hoja");
        tablaHash = new JMenuItem("Tabla Hash");
        guardar = new JMenuItem("Guardar");

        crearHoja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Agregar código para crear una nueva hoja
                contenidoHojas.add(new MatrizOrtogonal());
                // Crear un nuevo panel para la nueva hoja
                JPanel newPanel = new JPanel(new BorderLayout());
                JTable newTable = new JTable(new DefaultTableModel(20, 20));
                JScrollPane newScrollPane = new JScrollPane(newTable);
                newPanel.add(newScrollPane, BorderLayout.CENTER);
                tabbedPane.add("Hoja " + contenidoHojas.size(), newPanel);
            }
        });

        menu.add(tablaHash);
        menu.add(crearHoja);
        menu.add(guardar);
        barra.add(menu);
        frame.setJMenuBar(barra);
        // Agregar el panel de funciones al marco
        frame.getContentPane().add(funcionesPanel, BorderLayout.NORTH);

        // Agregar el panel de pestañas al marco
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        // Agregar un JLabel para mostrar el número de hoja actual
        JLabel hojaActualLabel = new JLabel("Hoja Actual: 1", SwingConstants.CENTER);
        frame.getContentPane().add(hojaActualLabel, BorderLayout.SOUTH);

        // Agregar un ChangeListener al JTabbedPane para actualizar el número de la hoja actual
        tabbedPane.addChangeListener(e -> {
            int index = tabbedPane.getSelectedIndex();
            hojaActualLabel.setText("Hoja Actual: " + (index + 1));
        });

        // Mostrar el marco
        frame.setVisible(true);
    }

    private void mandarCambios(NodoOrtogonal nodoOrtogonal, String estado, MatrizOrtogonal matrizOrtogonal) {
        // Aquí puedes enviar el nodoOrtogonal a la matriz ortogonal o realizar cualquier otra operación necesaria
        switch (estado) {
            case "insertado":
                matrizOrtogonal.insertarEnMatriz(nodoOrtogonal.getX(), nodoOrtogonal.getY(), nodoOrtogonal.getDato());
                break;
            case "actualizado":
                matrizOrtogonal.eliminarEnMatriz(nodoOrtogonal.getX(), nodoOrtogonal.getY());
                matrizOrtogonal.insertarEnMatriz(nodoOrtogonal.getX(), nodoOrtogonal.getY(), nodoOrtogonal.getDato());
                break;
            case "eliminado":
                matrizOrtogonal.eliminarEnMatriz(nodoOrtogonal.getX(), nodoOrtogonal.getY());
                break;
        }
        matrizOrtogonal.mostrarMatriz();
    }
}