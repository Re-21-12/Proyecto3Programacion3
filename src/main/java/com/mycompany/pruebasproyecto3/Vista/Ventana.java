package com.mycompany.pruebasproyecto3.Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana {

    // Elementos gráficos de la interfaz
    public JFrame frame;  // Ventana principal
    private JTabbedPane tabbedPane;  // Panel con pestañas para diferentes hojas
    private ArrayList<DefaultTableModel> models;  // Lista de modelos de tabla para cada hoja
    private ArrayList<JPanel> hojas;  // Lista de paneles para cada hoja
    private JTextField funcionesField;  // Campo de texto para ingresar funciones
    public JButton aplicar;  // Botón para aplicar una función
    public JButton rechazar;  // Botón para rechazar una función
    public JMenuItem crearHoja, tablaHash, guardar, cargar;  // Elementos de menú
    private JLabel hojaActualLabel;  // Etiqueta para mostrar la hoja actual
    private DefaultTableModel modeloHojaSeleccionada;  // Modelo de la hoja seleccionada
    private JTable table;  // Tabla para mostrar los datos

    // Constructor
    public Ventana() {
        models = new ArrayList<>();  // Inicializa la lista de modelos de tabla
        hojas = new ArrayList<>();  // Inicializa la lista de hojas
        initialize();  // Llama al método para inicializar la interfaz
    }

    // Método para inicializar los componentes de la interfaz
    private void initialize() {
        frame = new JFrame("Hoja de Cálculo");  // Crea la ventana principal
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Configura la operación al cerrar la ventana
        frame.setSize(800, 600);  // Establece el tamaño de la ventana

        tabbedPane = new JTabbedPane();  // Crea el panel con pestañas

        JPanel funcionesPanel = new JPanel();  // Panel para las funciones
        funcionesField = new JTextField(20);  // Campo de texto para funciones
        funcionesPanel.add(new JLabel("F(x): "));  // Añade una etiqueta al panel de funciones
        funcionesPanel.add(funcionesField);  // Añade el campo de texto al panel de funciones

        aplicar = new JButton("Aplicar");  // Botón aplicar
        rechazar = new JButton("Rechazar");  // Botón rechazar

        funcionesPanel.add(aplicar);  // Añade el botón aplicar al panel de funciones
        funcionesPanel.add(rechazar);  // Añade el botón rechazar al panel de funciones

        frame.add(funcionesPanel, BorderLayout.NORTH);  // Añade el panel de funciones a la parte superior de la ventana

        JMenu menu;
        JMenuBar barra = new JMenuBar();  // Barra de menú
        menu = new JMenu("Menu");  // Menú principal
        crearHoja = new JMenuItem("Nueva Hoja");  // Opción de menú para crear una nueva hoja
        tablaHash = new JMenuItem("Tabla Hash");  // Opción de menú para mostrar la tabla hash
        guardar = new JMenuItem("Guardar");  // Opción de menú para guardar
        cargar = new JMenuItem("Cargar");  // Opción de menú para cargar

        menu.add(tablaHash);  // Añade las opciones al menú
        menu.add(crearHoja);
        menu.add(guardar);
        menu.add(cargar);

        barra.add(menu);  // Añade el menú a la barra de menú
        frame.setJMenuBar(barra);  // Establece la barra de menú en la ventana

        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);  // Añade el panel con pestañas al centro de la ventana

        hojaActualLabel = new JLabel("Hoja Actual: 1", SwingConstants.CENTER);  // Etiqueta para mostrar la hoja actual
        frame.getContentPane().add(hojaActualLabel, BorderLayout.PAGE_END);  // Añade la etiqueta a la parte inferior de la ventana

        frame.setVisible(true);  // Hace visible la ventana
    }

    // Método para agregar una nueva hoja al panel con pestañas
    public void agregarHoja(DefaultTableModel nuevoModelo, JTable nuevaTabla, JPanel nuevoPanel) {
        JScrollPane nuevoScrollPane = new JScrollPane(nuevaTabla);  // Crea un panel de desplazamiento para la nueva tabla
        nuevoPanel.add(nuevoScrollPane, BorderLayout.CENTER);  // Añade el panel de desplazamiento al nuevo panel
        hojas.add(nuevoPanel);  // Añade el nuevo panel a la lista de hojas
        //?????????????????
        //models.add(nuevoModelo);  // Añade el nuevo modelo a la lista de modelos (comentado)

        tabbedPane.addTab("Hoja " + hojas.size(), nuevoPanel);  // Añade una nueva pestaña para la nueva hoja

        tabbedPane.addChangeListener(e -> {
            int index = tabbedPane.getSelectedIndex();  // Obtiene el índice de la pestaña seleccionada
            hojaActualLabel.setText("Hoja Actual: " + (index + 1));  // Actualiza la etiqueta de la hoja actual
        });
    }

    // Método para establecer el controlador de eventos
    public void setControlador(ActionListener controlador) {
        aplicar.addActionListener(controlador);  // Añade el controlador al botón aplicar
        rechazar.addActionListener(controlador);  // Añade el controlador al botón rechazar
        crearHoja.addActionListener(controlador);  // Añade el controlador a la opción de crear hoja
        tablaHash.addActionListener(controlador);  // Añade el controlador a la opción de tabla hash
        guardar.addActionListener(controlador);  // Añade el controlador a la opción de guardar
        cargar.addActionListener(controlador);  // Añade el controlador a la opción de cargar
    }

    // Método para agregar un modelo de tabla a la lista de modelos
    public void agregarModelo(DefaultTableModel modelo) {
        models.add(modelo);
    }

    // Método para obtener el texto del campo de funciones
    public String getFuncion() {
        return funcionesField.getText();
    }

    // Método para limpiar el campo de funciones
    public void limpiarFuncion() {
        funcionesField.setText("");
    }

    // Método para obtener el índice de la hoja seleccionada
    public int getHojaSeleccionada() {
        return tabbedPane.getSelectedIndex();
    }

    // Método para establecer el modelo de la hoja seleccionada
    public void setModeloHojaSeleccionada(DefaultTableModel modelo) {
        modeloHojaSeleccionada = modelo;
    }

    // Método para obtener el modelo de la hoja seleccionada
    public DefaultTableModel getModeloHojaSeleccionada() {
        return models.get(tabbedPane.getSelectedIndex());
    }

    // Método para obtener el marco principal
    public JFrame getFrame() {
        return frame;
    }
}
