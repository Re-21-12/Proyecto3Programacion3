package com.mycompany.pruebasproyecto3.Controladores;

import com.mycompany.pruebasproyecto3.Modelos.MatrizOrtogonal;
import com.mycompany.pruebasproyecto3.Modelos.TablaHash;
import com.mycompany.pruebasproyecto3.Modelos.NodoOrtogonal;
import com.mycompany.pruebasproyecto3.Vista.Ventana;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;


public class VentanaController implements ActionListener {

    private Ventana vista;
    private ArrayList<MatrizOrtogonal> contenidoHojas = new ArrayList<>();

    public VentanaController(Ventana vista) {
        this.vista = vista;
        this.vista.setControlador(this);
        agregarHoja();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.crearHoja) {
            agregarHoja();
        } else if (e.getSource() == vista.aplicar) {
            String funcion = vista.getFuncion();

            if (!funcion.isEmpty()) {
                String[] coordenadas = funcion.split("[(),]+");

                if (coordenadas.length <= 8) {
                    NodoOrtogonal nodoRespuesta = aplicarFuncion(coordenadas[0], coordenadas[1].trim(), coordenadas[2].trim(), coordenadas[3].trim(), coordenadas[4].trim(), coordenadas[5].trim(), coordenadas[6].trim());

                    mandarCambios(nodoRespuesta, "insertar", obtenerMatrizOrtogonal());
                } else {
                    System.err.println("Error: Número incorrecto de coordenadas en la función.");
                }
            } else {
                System.err.println("Error: No se encontraron datos en la función.");
            }
        } else if (e.getSource() == vista.rechazar) {
            vista.limpiarFuncion();
        }

        if (e.getSource() == vista.tablaHash) {
            generarTablaHash();
        }
        if (e.getSource() == vista.guardar) {
            guardarDatos(rutaArchivo);
        }
        if(e.getSource() == vista.)
    }

private void generarTablaHash() {
    int numero_buckets = solicitarCantidadBuckets();
    if (numero_buckets > 0) {
        DefaultTableModel modelo = vista.getModeloHojaSeleccionada();
        TablaHash tablaHash = new TablaHash(numero_buckets);
        ArrayList<String> datos = obtenerDatosColumnaB();
        ArrayList<int[]> coordenadas = new ArrayList<>();
        tablaHash.llenarListaIndices();
        tablaHash.hashMethod(datos);
        coordenadas = tablaHash.mostrarListaIndices(datos);
        for (int[] coordenada : coordenadas) {
            modelo.setValueAt(coordenada[2], coordenada[0], (coordenada[1]+2));
            System.out.println("X: " + (coordenada[0]) + " Y: " + (coordenada[1]+1) + " Dato: " + coordenada[2]);
        }
    }
}


    private ArrayList<String> obtenerDatosColumnaB() {
        DefaultTableModel modelo = vista.getModeloHojaSeleccionada();
        int rowCount = modelo.getRowCount();
        ArrayList<String> datos_columnaB = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            Object valor = modelo.getValueAt(i, 1); // La columna B es el índice 1 (0 para la columna A, 1 para la columna B, etc.)

            if (valor != null) {
                datos_columnaB.add(valor.toString());
                //System.out.println("El contenido deberia asignarse a la fila: " + i);
            }
        }

        // Ahora puedes usar la lista columnaB para lo que necesites
        System.out.println("Datos de la columna B: " + datos_columnaB);
        return datos_columnaB;
    }

    private int solicitarCantidadBuckets() {
        String input = JOptionPane.showInputDialog(vista.getFrame(), "Ingrese la cantidad de buckets:", "Cantidad de Buckets", JOptionPane.PLAIN_MESSAGE);
        try {
            int numBuckets = Integer.parseInt(input);
            if (numBuckets <= 0) {
                throw new NumberFormatException("La cantidad de buckets debe ser mayor que cero.");
            }
            return numBuckets;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista.getFrame(), "Entrada no válida. Por favor, ingrese un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Indica que se ha producido un error
        }
    }

        public void cargarDatos(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            Vector dataVector = (Vector) ois.readObject();
            Vector columnIdentifiers = (Vector) ois.readObject();
            DefaultTableModel modelo = new DefaultTableModel(dataVector, columnIdentifiers);
            vista.setModeloHojaSeleccionada(modelo);
            System.out.println("Datos cargados correctamente desde " + rutaArchivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista.getFrame(), "Error al cargar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

      public void guardarDatos(String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            DefaultTableModel modelo = vista.getModeloHojaSeleccionada();
            oos.writeObject(modelo.getDataVector()); // Guarda los datos de la tabla
            System.out.println("Datos guardados correctamente en " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista.getFrame(), "Error al guardar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private MatrizOrtogonal obtenerMatrizOrtogonal() {
        int numeroHoja = vista.getHojaSeleccionada();
        for (MatrizOrtogonal matriz : contenidoHojas) {
            if (numeroHoja == matriz.getNumeroHoja()) {
                return matriz;
            }
        }
        throw new Error("No se encontro la matriz");
    }

    private NodoOrtogonal aplicarFuncion(String operacion, String dato1x, String dato1y, String dato2x, String dato2y, String x, String y) {
        String resultado = "";

        String dato1 = vista.getModeloHojaSeleccionada().getValueAt(Integer.parseInt(dato1x), Integer.parseInt(dato1y)).toString();
        String dato2 = vista.getModeloHojaSeleccionada().getValueAt(Integer.parseInt(dato2x), Integer.parseInt(dato2y)).toString();

        if (dato1.isEmpty() || dato2.isEmpty()) {
            System.err.println("Error: Una o ambas celdas contienen valores vacíos.");
            return null;
        }

        try {
            int rx = Integer.parseInt(x.trim());
            int ry = Integer.parseInt(y.trim());

            switch (operacion.toLowerCase()) {
                case "suma":
                    resultado = String.valueOf(Integer.parseInt(dato1) + Integer.parseInt(dato2));
                    break;
                case "resta":
                    resultado = String.valueOf(Integer.parseInt(dato1) - Integer.parseInt(dato2));
                    break;
                case "multiplicacion":
                    resultado = String.valueOf(Integer.parseInt(dato1) * Integer.parseInt(dato2));
                    break;
                case "division":
                    if (Integer.parseInt(dato2) != 0) {
                        resultado = String.valueOf(Integer.parseInt(dato1) / Integer.parseInt(dato2));
                    } else {
                        System.err.println("Error: División por cero.");
                        return null;
                    }
                    break;
                default:
                    System.err.println("Error: Operación no reconocida.");
                    return null;
            }
            NodoOrtogonal nodo_resultado = new NodoOrtogonal(resultado, rx, ry);
            vista.getModeloHojaSeleccionada().setValueAt(resultado, rx, ry);
            return nodo_resultado;
        } catch (NumberFormatException e) {
            System.err.println("Error: Formato de número inválido. " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void agregarHoja() {
        MatrizOrtogonal matrizOrtogonal = new MatrizOrtogonal(contenidoHojas.size());
        contenidoHojas.add(matrizOrtogonal);

        DefaultTableModel nuevoModelo = new DefaultTableModel(20, 20);
        for (int i = 0; i < 20; i++) {
            nuevoModelo.setValueAt(i + 1, i, 0);
        }
        vista.agregarModelo(nuevoModelo);

        JTable nuevaTabla = new JTable(nuevoModelo);
        nuevaTabla.setPreferredScrollableViewportSize(new Dimension(800, 600));
        nuevaTabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        nuevaTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    int fila = nuevaTabla.rowAtPoint(e.getPoint());
                    int columna = nuevaTabla.columnAtPoint(e.getPoint());

                    if (fila >= 0 && columna >= 0) {
                        Object[] options = {"Ingresar valor", "Actualizar valor", "Eliminar valor"};
                        int choice = JOptionPane.showOptionDialog(vista.getFrame(), "Seleccione una opción para la celda (" + fila + ", " + columna + "):",
                                "Opciones de Celda", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                        if (choice == 2) {
                            vista.getModeloHojaSeleccionada().setValueAt(null, fila, columna);
                            NodoOrtogonal nodoOrtogonal = new NodoOrtogonal(null, fila, columna);
                            mandarCambios(nodoOrtogonal, "eliminado", matrizOrtogonal);
                            System.out.println("Se eliminó el valor de la celda (" + fila + ", " + columna + ")");
                        } else if (choice == 1) {
                            String valorAnterior = (String) vista.getModeloHojaSeleccionada().getValueAt(fila, columna);
                            String nuevoValor = JOptionPane.showInputDialog(vista.getFrame(), "Ingrese el valor para la celda (" + fila + ", " + columna + "):");
                            vista.getModeloHojaSeleccionada().setValueAt(nuevoValor, fila, columna);
                            NodoOrtogonal nodoOrtogonal = new NodoOrtogonal(nuevoValor, fila, columna);
                            mandarCambios(nodoOrtogonal, "actualizado", matrizOrtogonal);
                            System.out.println("Se ingresó un dato en la celda (" + fila + ", " + columna + ")");
                        } else if (choice == 0) {
                            String nuevoValor = JOptionPane.showInputDialog(vista.getFrame(), "Ingrese el valor para la celda (" + fila + ", " + columna + "):");
                            vista.getModeloHojaSeleccionada().setValueAt(nuevoValor, fila, columna);
                            NodoOrtogonal nodoOrtogonal = new NodoOrtogonal(nuevoValor, fila, columna);
                            mandarCambios(nodoOrtogonal, "insertado", matrizOrtogonal);
                            System.out.println("Se ingresó un nuevo dato en la celda (" + fila + ", " + columna + ")");
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JPanel nuevoPanel = new JPanel(new BorderLayout());
        vista.agregarHoja(nuevoModelo, nuevaTabla, nuevoPanel);
    }

    private void mandarCambios(NodoOrtogonal nodoOrtogonal, String estado, MatrizOrtogonal matrizOrtogonal) {
        if (nodoOrtogonal == null) {
            System.err.println("Error: Nodo ortogonal nulo.");
            return;
        }

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
