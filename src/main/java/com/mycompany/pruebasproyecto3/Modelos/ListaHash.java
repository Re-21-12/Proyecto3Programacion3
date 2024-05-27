/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebasproyecto3.Modelos;

/**
 *
 * @author victo
 */
// Esta lista contiene nodos hash osea los indices que contienen listas donde se almacenan finalmente los datos
public class ListaHash {

    private NodoHash cabeza;
    private NodoHash cola;

    public ListaHash() {
        this.cola = this.cabeza = null;
    }

    public void insertar(NodoHash nodo_hash) { // Método para insertar un nodo en la lista horizontal
        //si la cabeza esta vacia entonces podemos asignar un nuevo elemento
        if (cabeza == null) { // Verifica si la cabeza está vacía
            this.cabeza = this.cola = nodo_hash; // Asigna el nuevo nodo como cabeza y cola
            //cocmo vamos aumentando segun se van ingresando al principio estaran los menores y de ultimo los mayores
        } else { // Si la cabeza no está vacía
            cabeza = insertarInicio(nodo_hash); // Inserta el nuevo nodo al inicio de la lista
        }

    }

    private NodoHash insertarInicio(NodoHash nodo_hash) {
        nodo_hash.setSiguiente(cabeza);
        // creamos un nuevo nodo
        if (cabeza != null) { // si la cabeza no es nula
            cabeza.setAnterior(nodo_hash); // la cabeza anterior apunta Anterior al nuevo nodo
        }
        cabeza = nodo_hash; // el nuevo nodo se convierte en la cabeza
        return cabeza;
    }

    public void insertarEnListaDelIndice(int indice, Nodo nodo) {
        NodoHash actual = cabeza;
        while (actual != null) {
            if (actual.getDato() == indice) {
                actual.getLista().insertar(nodo);
                System.out.println("Se insertó: " + nodo.getDato() + " en el índice: " + indice);
                return;
            }
            actual = (NodoHash) actual.getSiguiente();
        }
        throw new Error("No se encontró el índice: " + indice);
    }

    public int[] mostrarFilayColumna(int indice, Nodo nodo) {
        NodoHash actual = cabeza;
        while (actual != null) {
            if (actual.getDato() == indice) {
                int columna = actual.getLista().indicarColumna(nodo);
                return new int[]{indice, columna, nodo.getDato()};
            }
            actual = (NodoHash) actual.getSiguiente();
        }
        throw new Error("No se encontraron las coordenadas para el índice: " + indice);
    }
}