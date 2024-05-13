/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebasproyecto3.Modelos;

/**
 *
 * @author victo
 */
public class NodoOrtogonal {
    private int x; // Declara una variable privada x de tipo entero
    private int y; // Declara una variable privada y de tipo entero
    private String dato; // Declara una variable privada vehiculo de tipo Vehiculo
    private NodoOrtogonal arriba; // Declara una variable privada arriba de tipo NodoOrtogonal
    private NodoOrtogonal abajo; // Declara una variable privada abajo de tipo NodoOrtogonal
    private NodoOrtogonal izquierda; // Declara una variable privada izquierda de tipo NodoOrtogonal
    private NodoOrtogonal derecha; // Declara una variable privada derecha de tipo NodoOrtogonal

    public NodoOrtogonal() { // Constructor vacío de la clase NodoOrtogonal

    }

    public NodoOrtogonal(String dato, int x , int y) { // Constructor de la clase NodoOrtogonal con parámetros
        this.dato = dato; // Inicializa la variable vehiculo con el parámetro vehiculo
        this.x = x; // Inicializa la variable x con el parámetro x
        this.y = y; // Inicializa la variable y con el parámetro y
        //inicalmente deben apuntar a nulo
        this.arriba = null; // Inicializa la variable arriba como nula
        this.abajo = null; // Inicializa la variable abajo como nula
        this.izquierda = null; // Inicializa la variable izquierda como nula
        this.derecha = null; // Inicializa la variable derecha como nula
    }

    public int getX() { // Método para obtener el valor de x
        return x; // Retorna el valor de x
    }

    public void setX(int x) { // Método para establecer el valor de x
        this.x = x; // Asigna el valor de x con el parámetro x
    }

    public int getY() { // Método para obtener el valor de y
        return y; // Retorna el valor de y
    }

    public void setY(int y) { // Método para establecer el valor de y
        this.y = y; // Asigna el valor de y con el parámetro y
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }


    public NodoOrtogonal getArriba() { // Método para obtener el nodo ubicado arriba del nodo actual
        return arriba; // Retorna el nodo ubicado arriba del nodo actual
    }

    public void setArriba(NodoOrtogonal arriba) { // Método para establecer el nodo ubicado arriba del nodo actual
        this.arriba = arriba; // Asigna el nodo ubicado arriba del nodo actual
    }

    public NodoOrtogonal getAbajo() { // Método para obtener el nodo ubicado abajo del nodo actual
        return abajo; // Retorna el nodo ubicado abajo del nodo actual
    }

    public void setAbajo(NodoOrtogonal abajo) { // Método para establecer el nodo ubicado abajo del nodo actual
        this.abajo = abajo; // Asigna el nodo ubicado abajo del nodo actual
    }

    public NodoOrtogonal getIzquierda() { // Método para obtener el nodo ubicado a la izquierda del nodo actual
        return izquierda; // Retorna el nodo ubicado a la izquierda del nodo actual
    }

    public void setIzquierda(NodoOrtogonal izquierda) { // Método para establecer el nodo ubicado a la izquierda del nodo actual
        this.izquierda = izquierda; // Asigna el nodo ubicado a la izquierda del nodo actual
    }

    public NodoOrtogonal getDerecha() { // Método para obtener el nodo ubicado a la derecha del nodo actual
        return derecha; // Retorna el nodo ubicado a la derecha del nodo actual
    }

    public void setDerecha(NodoOrtogonal derecha) { // Método para establecer el nodo ubicado a la derecha del nodo actual
        this.derecha = derecha; // Asigna el nodo ubicado a la derecha del nodo actual
    }

}