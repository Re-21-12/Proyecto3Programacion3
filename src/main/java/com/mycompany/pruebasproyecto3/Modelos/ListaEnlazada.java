/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebasproyecto3.Modelos;

/**
 *
 * @author victo
 */
public class ListaEnlazada {

    private Nodo cabeza;
    private Nodo cola;

    public ListaEnlazada() {
        this.cola = this.cabeza = null;
    }

    public void insertar(Nodo nodo) { // Método para insertar un nodo en la lista horizontal
        //si la cabeza esta vacia entonces podemos asignar un nuevo elemento
        if (cabeza == null) { // Verifica si la cabeza está vacía
            this.cabeza = this.cola = nodo; // Asigna el nuevo nodo como cabeza y cola
            //cocmo vamos aumentando segun se van ingresando al principio estaran los menores y de ultimo los mayores
            System.out.println("Se inserto: " + nodo.getDato());
        } else { // Si la cabeza no está vacía
            cabeza = insertarInicio(nodo); // Inserta el nuevo nodo al inicio de la lista
            System.out.println("Se inserto: " + nodo.getDato());
        }

    }

    private Nodo insertarInicio(Nodo nodo) {
        nodo.setSiguiente(cabeza);
        // creamos un nuevo nodo
        if (cabeza != null) { // si la cabeza no es nula
            cabeza.setAnterior(nodo); // la cabeza anterior apunta Anterior al nuevo nodo
        }
        cabeza = nodo; // el nuevo nodo se convierte en la cabeza
        return cabeza;
    }

    public int indicarColumna(Nodo nodo) {
        Nodo actual = cabeza; // creamos un nodo auxiliar Coordenada lo inicializamos con la cabeza
        int columnas = 0;
        while (actual != null) { // mientras no lleguemos al final de la lista
            if (actual.getDato() == nodo.getDato()) {
                return columnas;
            }
            actual = actual.getSiguiente(); // avanzamos al siguiente nodo
            columnas++;
        }
        System.out.println();
        throw new Error("no se encontro la columna del nodo");
    }
}
