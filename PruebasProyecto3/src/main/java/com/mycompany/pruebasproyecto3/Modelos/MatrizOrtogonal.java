/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebasproyecto3.Modelos;

/**
 *
 * @author victo
    */
public class MatrizOrtogonal {

    private int numeroHoja;
    private NodoLista filas; // Declara una variable privada filas del tipo NodoLista
    private NodoLista columnas; // Declara una variable privada columnas del tipo NodoLista

    public MatrizOrtogonal(int numeroHoja) { // Constructor de la clase MatrizOrtogonal
        this.filas = new NodoLista(); // Inicializa la variable filas con una nueva instancia de NodoLista
        this.columnas = new NodoLista(); // Inicializa la variable columnas con una nueva instancia de NodoLista
        this.numeroHoja = numeroHoja;
    }

    public void insertarEnMatriz(int x, int y, String dato) { // Método para insertar un vehículo en la matriz ortogonal
        NodoCoordenada tempFila; // Declara una variable tempFila del tipo NodoCoordenada
        NodoCoordenada tempColumna; // Declara una variable tempColumna del tipo NodoCoordenada
        NodoOrtogonal _nodoOrtogonal = new NodoOrtogonal(dato, x, y); // Crea un nuevo NodoOrtogonal con el vehículo y las coordenadas especificadas
        if (filas.estaDisponible(y) == false) { // Verifica si la fila en la posición y está disponible
            NodoCoordenada nodo = new NodoCoordenada(y); // Crea un nuevo NodoCoordenada con la coordenada y y el vehículo especificados
            filas.insertar(nodo); // Inserta el nuevo NodoCoordenada en la lista vertical de filas
        }
        if (columnas.estaDisponible(x) == false) { // Verifica si la columna en la posición x está disponible
            NodoCoordenada nodo = new NodoCoordenada(x); // Crea un nuevo NodoCoordenada con la coordenada x y el vehículo especificados
            columnas.insertar(nodo); // Inserta el nuevo NodoCoordenada en la lista horizontal de columnas
        }
        tempFila = filas.buscar(y); // Busca el NodoCoordenada correspondiente a la coordenada y
        tempColumna = columnas.buscar(x); // Busca el NodoCoordenada correspondiente a la coordenada x

        tempFila.getLista().insertar(_nodoOrtogonal); // Inserta el nuevo NodoOrtogonal en la lista horizontal del NodoCoordenada encontrado
        tempColumna.getLista().insertar(_nodoOrtogonal); // Inserta el nuevo NodoOrtogonal en la lista vertical del NodoCoordenada encontrado
        tempFila.getLista().mostrarLista();
        tempColumna.getLista().mostrarLista();
    }

    //falta implementar
    public void eliminarEnMatriz(int x, int y) { // Método para eliminar un vehículo de la matriz ortogonal
        NodoCoordenada tempFila; // Declara una variable tempFila del tipo NodoCoordenada
        NodoCoordenada tempColumna; // Declara una variable tempColumna del tipo NodoCoordenada
        tempFila = filas.buscar(y); // Busca el NodoCoordenada correspondiente a la coordenada y
        tempColumna = columnas.buscar(x); // Busca el NodoCoordenada correspondiente a la coordenada x
        if (tempFila == null || tempColumna == null) { // Verifica si no se encontró el vehículo en las coordenadas especificadas
            System.out.println("No se ha encontrado el dato"); // Imprime un mensaje indicando que no se encontró el dato
        } else {
            System.out.println("Se ha eliminado el String"); // Imprime un mensaje indicando que se ha eliminado el vehículo
        }
        filas.eliminar(tempFila); // Elimina el NodoCoordenada correspondiente de la lista vertical de filas
        columnas.eliminar(tempColumna); // Elimina el NodoCoordenada correspondiente de la lista horizontal de columnas
    }

    public void buscarEnMatriz(int x, int y) { // Método para buscar un vehículo en la matriz ortogonal por sus coordenadas
        NodoCoordenada datoEnX = filas.buscar(y); // Busca el NodoCoordenada correspondiente a la coordenada y
        NodoCoordenada datoEnY = columnas.buscar(x); // Busca el NodoCoordenada correspondiente a la coordenada x

        if (datoEnX != null && datoEnY != null) { // Verifica si se encontró el vehículo en las coordenadas especificadas
            System.out.println("Se ha encontrado el String"); // Imprime un mensaje indicando que se ha encontrado el vehículo
        } else {
            System.out.println("No se ha encontrado el String"); // Imprime un mensaje indicando que no se ha encontrado el vehículo
        }
    }


    public void mostrarMatriz() { // Método para mostrar la matriz ortogonal
        filas.mostrarListaFila(); // Muestra la lista vertical de filas
        columnas.mostrarListaColumna(); // Muestra la lista horizontal de columnas
    }

    public int getNumeroHoja() {
        return numeroHoja;
    }

    public void setNumeroHoja(int numeroHoja) {
        this.numeroHoja = numeroHoja;
    }

    
}