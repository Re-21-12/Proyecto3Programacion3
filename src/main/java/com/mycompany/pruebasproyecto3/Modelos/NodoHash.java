/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebasproyecto3.Modelos;

/**
 *
 * @author victo
 */

//Loos nodos hash representan la lista de indices 
public class NodoHash extends Nodo{
    private ListaEnlazada lista;
//aqui le pasamos el dato osea su indice
    public NodoHash(int dato) {
        super(dato);
        this.lista = new ListaEnlazada();
    }

    public ListaEnlazada getLista() {
        return lista;
    }
    
   
}
