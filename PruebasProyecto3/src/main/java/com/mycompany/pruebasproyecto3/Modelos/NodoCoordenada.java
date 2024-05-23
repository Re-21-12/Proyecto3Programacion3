/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebasproyecto3.Modelos;

/**
 *
 * @author victo
 */


//Este noodo es el que se encuentra de cabecera en x e y en las filas y columnas principales
public class NodoCoordenada {

    private int coordenada; // Declara una variable privada coordenada de tipo entero, representa la coordenada en coordenada
    private NodoCoordenada anterior; // Declara una variable privada anterior de tipo NodoCoordenada, representa el nodo ubicado anterior del nodo actual
    private NodoCoordenada siguiente; // Declara una variable privada siguiente de tipo NodoCoordenada, representa el nodo ubicado siguiente del nodo actual
    //cada nodo Columna contiene una lista de fila
    private NodoListaOrtogonal lista; // Declara una variable privada lista de tipo NodoLista, representa la lista horizontal asociada al nodo actual

    public NodoCoordenada(int coordenada) { // Constructor de la clase NodoCoordenada con parámetros
        this.coordenada = coordenada; // Inicializa la variable coordenada con el parámetro coordenada
        //creamos una columna por cada nodo fila
        this.lista = new NodoListaOrtogonal(); // Inicializa la variable lista como una nueva instancia de NodoLista
        this.anterior = this.siguiente = null; // Inicializa las variables anterior coordenada siguiente como nulas
    }

    public int getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(int coordenada) {
        this.coordenada = coordenada;
    }

    public NodoCoordenada getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCoordenada anterior) {
        this.anterior = anterior;
    }

    public NodoCoordenada getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCoordenada siguiente) {
        this.siguiente = siguiente;
    }

    public NodoListaOrtogonal getLista() {
        return lista;
    }

    public void setLista(NodoListaOrtogonal lista) {
        this.lista = lista;
    }

}