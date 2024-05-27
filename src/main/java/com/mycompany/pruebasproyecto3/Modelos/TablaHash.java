/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebasproyecto3.Modelos;

/**
 *
 * @author victo
 */
import java.util.*;

public class TablaHash {

    private int numero_buckets;
    private ListaHash lista_de_listas;

    public TablaHash(int numero_buckets) {
        this.numero_buckets = numero_buckets;
        this.lista_de_listas = new ListaHash();
    }

    //aqui crea loos nodos segun el tamanio de buckets que se requiera
    public void llenarListaIndices() {
        int contadorIndices = 0;
        while (contadorIndices < this.numero_buckets) {
            lista_de_listas.insertar(new NodoHash(Integer.valueOf(contadorIndices)));
            contadorIndices++;
        }
    }

    private int hashing(int numero_buckets, Nodo nodo) {
        return nodo.getDato() % numero_buckets;
    }

    public void hashMethod(ArrayList<String> datos) {
        for (String dato : datos) {
            Nodo nodo = new Nodo(Integer.valueOf(dato));
            int clave = hashing(numero_buckets, nodo);
            lista_de_listas.insertarEnListaDelIndice(clave, nodo);
        }
    }
    //aqui crea loos nodos segun el tamanio de buckets que se requiera

    public ArrayList<int[]> mostrarListaIndices(ArrayList<String> datos) {
        ArrayList<int[]> coordenadas = new ArrayList<>();
        for (String dato : datos) {
            Nodo nodo = new Nodo(Integer.valueOf(dato));
            int clave = hashing(numero_buckets, nodo);
            int[] coordenada = lista_de_listas.mostrarFilayColumna(clave, nodo);
            coordenadas.add(coordenada);
        }
        return coordenadas;
    }
}
