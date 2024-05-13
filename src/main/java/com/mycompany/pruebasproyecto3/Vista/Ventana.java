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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class Ventana {

    private JFrame frame;
    private JTabbedPane tabbedPane;
    private ArrayList<DefaultTableModel> models;
    private ArrayList<JPanel> hojas;
    private ArrayList<MatrizOrtogonal> contenidoHojas = new ArrayList<>();

    public void mostrarVentana() {
        frame = new JFrame("Hoja de Cálculo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        tabbedPane = new JTabbedPane();
        models = new ArrayList<>();
        hojas = new ArrayList<>();

        // Crear y agregar la primera hoja
        agregarHoja();

        // Agregar un panel para escribir funciones
        JPanel funcionesPanel = new JPanel();
        JTextField funcionesField = new JTextField(20);
        funcionesPanel.add(new JLabel("F(x): "));
        funcionesPanel.add(funcionesField);

        JButton aplicar = new JButton("Aplicar");
        JButton rechazar = new JButton("Rechazar");
        aplicar.setBounds(530, 5, 95, 20);
        rechazar.setBounds(630, 5, 95, 20);
        aplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //funcion(Hoja #,(0,2),(2,6))

            }
        });
        rechazar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                funcionesField.setText("");
            }
        });
        frame.add(aplicar);
        frame.add(rechazar);
        JMenu menu;
        JMenuItem crearHoja, tablaHash, guardar;
        JMenuBar barra = new JMenuBar();
        menu = new JMenu("Menu");
        crearHoja = new JMenuItem("Nueva Hoja");
        tablaHash = new JMenuItem("Tabla Hash");
        guardar = new JMenuItem("Guardar");

        crearHoja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Agregar una nueva hoja
                agregarHoja();
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

        // Mostrar el marco
        frame.setVisible(true);
    }

    private void agregarHoja() {
        MatrizOrtogonal matrizOrtogonal = new MatrizOrtogonal(contenidoHojas.size());
        contenidoHojas.add(matrizOrtogonal);

        // Crear un modelo de tabla personalizado para la nueva hoja
        DefaultTableModel nuevoModelo = new DefaultTableModel(20, 20); // 20 filas y 20 columnas
        for (int i = 0; i < 20; i++) {
            nuevoModelo.setValueAt(i + 1, i, 0); // Añadir los números del 1 al 20 en la primera columna
        }
        models.add(nuevoModelo);

        // Crear y configurar la tabla con el modelo personalizado
        JTable nuevaTabla = new JTable(nuevoModelo);
        nuevaTabla.setPreferredScrollableViewportSize(new Dimension(800, 600));
        nuevaTabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

// Agregar un MouseListener a la tabla para detectar clics
        nuevaTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int fila = nuevaTabla.rowAtPoint(e.getPoint());
                    int columna = nuevaTabla.columnAtPoint(e.getPoint());

                    if (fila >= 0 && columna >= 0) {
                        // Lógica para manejar los clics en las celdas
                        Object[] options = {"Ingresar valor", "Actualizar valor", "Eliminar valor"};
                        int choice = JOptionPane.showOptionDialog(frame, "Seleccione una opción para la celda (" + fila + ", " + columna + "):",
                                "Opciones de Celda", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                        if (choice == 2) {
                            // Si el usuario elimina el valor de la celda
                            models.get(tabbedPane.getSelectedIndex()).setValueAt(null, fila, columna);
                            // Mostrar en la consola que se eliminó el valor de la celda
                            System.out.println("Se eliminó el valor de la celda (" + fila + ", " + columna + ")");
                            // Crear un NodoOrtogonal con los datos relevantes y enviarlo al método para manejar los cambios
                            Object dato = models.get(tabbedPane.getSelectedIndex()).getValueAt(fila, columna);
                            NodoOrtogonal nodoOrtogonal = new NodoOrtogonal(null, fila, columna);
                            System.out.println("Dato: " + nodoOrtogonal.getDato() + " |Y: " + nodoOrtogonal.getY() + " |X: " + nodoOrtogonal.getX() + "borrado");

                            mandarCambios(nodoOrtogonal, "eliminado", matrizOrtogonal);
                        } else if (choice == 1) {
                            // Si se actualiza el valor en la celda
                            String valorAnterior = (String) models.get(tabbedPane.getSelectedIndex()).getValueAt(fila, columna); // Valor anterior en la celda
                            String nuevoValor = JOptionPane.showInputDialog(frame, "Ingrese el valor para la celda (" + fila + ", " + columna + "):");
                            models.get(tabbedPane.getSelectedIndex()).setValueAt(nuevoValor, fila, columna);
                            // Mostrar en la consola la coordenada modificada y los valores antiguo y nuevo
                            System.out.println("Se ingresó un dato en la celda (" + fila + ", " + columna + ")");
                            System.out.println("El valor anterior en la celda (" + fila + ", " + columna + ") era: " + valorAnterior);
                            System.out.println("El nuevo valor en la celda (" + fila + ", " + columna + ") es: " + nuevoValor);
                            Object dato = models.get(tabbedPane.getSelectedIndex()).getValueAt(fila, columna);
                            NodoOrtogonal nodoOrtogonal = new NodoOrtogonal(dato.toString(), fila, columna);
                            System.out.println("Dato: " + nodoOrtogonal.getDato() + " |Y: " + nodoOrtogonal.getY() + " |X: " + nodoOrtogonal.getX() + "actualizado");
                            mandarCambios(nodoOrtogonal, "actualizado", matrizOrtogonal);
                        } else if (choice == 0) {
                            String nuevoValor = JOptionPane.showInputDialog(frame, "Ingrese el valor para la celda (" + fila + ", " + columna + "):");
                            models.get(tabbedPane.getSelectedIndex()).setValueAt(nuevoValor, fila, columna);
                            System.out.println("Se ingresó un nuevo dato en la celda (" + fila + ", " + columna + ")");
                            Object dato = models.get(tabbedPane.getSelectedIndex()).getValueAt(fila, columna);
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
        JScrollPane nuevoScrollPane = new JScrollPane(nuevaTabla);

        // Crear un nuevo panel de hoja y agregar la tabla
        JPanel nuevoPanel = new JPanel(new BorderLayout());
        nuevoPanel.add(nuevoScrollPane, BorderLayout.CENTER);

        // Agregar el nuevo panel a la lista de paneles de hojas y al JTabbedPane
        hojas.add(nuevoPanel);
        tabbedPane.addTab("Hoja " + hojas.size(), nuevoPanel);

        JLabel hojaActualLabel = new JLabel("Hoja Actual: 1", SwingConstants.CENTER);
        frame.getContentPane().add(hojaActualLabel, BorderLayout.PAGE_END);

        // Agregar un ChangeListener al JTabbedPane para actualizar el número de la hoja actual
        tabbedPane.addChangeListener(e -> {
            int index = tabbedPane.getSelectedIndex();
            hojaActualLabel.setText("Hoja Actual: " + (index + 1));
        });

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
        System.out.println("La hoja es: " + (matrizOrtogonal.getNumeroHoja() + 1));
        matrizOrtogonal.mostrarMatriz();
    }

}
