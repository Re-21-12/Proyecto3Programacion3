/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebasproyecto3.Modelos;

import com.mycompany.pruebasproyecto3.Modelos.NodoCoordenada;

/**
 *
 * @author victo
 */
public class NodoLista {

    private NodoCoordenada cabeza; // declaramos un nodo que apunta al inicio de la lista
    private NodoCoordenada cola; // declaramos un nodo que apunta al final de la lista

    // creamos un constructor para inicializar la lista con valores nulos
    public NodoLista() {
        cabeza = cola = null;
    }

    // creamos un método para insertar nodos en vertical
    public void insertar(NodoCoordenada nodo) {
        if (cabeza == null) { // si la lista está vacía
            this.cabeza = this.cola = nodo; // el nuevo nodo será la cabeza Coordenada la cola
        } else { // si la lista no está vacía
            if (nodo.getCoordenada() < cabeza.getCoordenada()) { // si el nuevo nodo es menor que la cabeza
                cabeza = insertarInicio(nodo); // insertamos el nodo al principio
            } else if (nodo.getCoordenada() > cola.getCoordenada()) { // si el nuevo nodo es maCoordenadaor que la cola
                cola = insertarFinal(nodo); // insertamos el nodo al final
            } else { // si el nuevo nodo está entre la cabeza Coordenada la cola
                insertarEnMedio(nodo); // insertamos el nodo en medio
            }
        }
    }

    // método privado para insertar un nodo al principio de la lista
    private NodoCoordenada insertarInicio(NodoCoordenada nodo) {
        nodo.setSiguiente(cabeza);
        // creamos un nuevo nodo
        if (cabeza != null) { // si la cabeza no es nula
            cabeza.setAnterior(nodo); // la cabeza anterior apunta Anterior al nuevo nodo
        }
        cabeza = nodo; // el nuevo nodo se convierte en la cabeza
        return cabeza;
    }

    // método privado para insertar un nodo al final de la lista
    private NodoCoordenada insertarFinal(NodoCoordenada nodo) {
        NodoCoordenada nuevoNodo = nodo; // creamos un nuevo nodo
        if (cabeza == null) { // si la cabeza es nula
            return nuevoNodo; // retornamos el nuevo nodo
        }
        NodoCoordenada actual = cabeza; // creamos un nodo auxiliar Coordenada lo inicializamos con la cabeza
        while (actual.getSiguiente() != null) { // mientras no lleguemos al final de la lista
            actual = actual.getSiguiente(); // avanzamos al siguiente nodo
        }
        actual.setSiguiente(nuevoNodo); // establecemos el nuevo nodo como el siguiente del último
        nuevoNodo.setAnterior(actual); // el nodo anterior al nuevo nodo será el último
        cola = nuevoNodo; // el nuevo nodo se convierte en la cola
        return cola; // retornamos la cabeza
    }

    // método privado para insertar un nodo en medio de la lista
    private NodoCoordenada insertarEnMedio(NodoCoordenada nodo) {
        NodoCoordenada actual = cabeza; // creamos un nodo auxiliar Coordenada lo inicializamos con la cabeza

        while (actual != null && nodo.getCoordenada() > actual.getCoordenada()) { // mientras no lleguemos al final Coordenada la posición del nodo actual sea menor que la del nuevo nodo
            actual = actual.getSiguiente(); // avanzamos al siguiente nodo
        }

        if (actual == null) { // si llegamos al final de la lista
            System.out.println("El valor después del cual se desea insertar no se encontró en la lista."); // mostramos un mensaje de error
            return cabeza; // retornamos la cabeza
        }

        NodoCoordenada anterior = actual.getAnterior();
        nodo.setSiguiente(actual); // el nodo siguiente al nuevo nodo será el siguiente del nodo actual
        nodo.setAnterior(anterior); // el nodo anterior al nuevo nodo será el nodo actual
        actual.setAnterior(nodo); // el nodo actual apuntará abajo al nuevo nodo
        if (anterior != null) {
            anterior.setSiguiente(nodo);
        } else {
            cabeza = nodo;
        }

        return cabeza; // retornamos la cabeza
    }

    public void eliminar(NodoCoordenada nodo) {
        if (cabeza == null) { // si la lista está vacía
            this.cabeza = this.cola = nodo; // el nuevo nodo será la cabeza Coordenada la cola
        } else { // si la lista no está vacía
            if (nodo.getCoordenada() < cabeza.getCoordenada()) { // si el nuevo nodo es menor que la cabeza
                cabeza = eliminarInicio(); // insertamos el nodo al principio
            } else if (nodo.getCoordenada() > cola.getCoordenada()) { // si el nuevo nodo es maCoordenadaor que la cola
                cola = eliminarFinal(); // insertamos el nodo al final
            } else { // si el nuevo nodo está entre la cabeza Coordenada la cola
                eliminarEnMedio(nodo); // insertamos el nodo en medio
            }
        }
    }

    public NodoCoordenada eliminarInicio() {
        // Verificamos si la pila está vacía
        if (cabeza == null) {
            System.out.println("La pila está vacía, no se puede eliminar.");
            return null;
        }
        // Avanzamos al segundo elemento  a la izquierda
        //actualizamos el nuevo null
        NodoCoordenada nuevoTopeIzquierda = cabeza.getSiguiente();
        // Eliminamos el tope actual asignando null como siguiente elemento
        cabeza.setSiguiente(null);
        // Retornamos el nuevo tope de la pila
        return nuevoTopeIzquierda;
    }

    public NodoCoordenada eliminarFinal() {
        // verificamos si la lista está vacía
        if (cabeza == null) {
            System.out.println("la lista está vacía, no se puede eliminar.");
            return null;
        }
        // si solo haCoordenada un elemento en la lista, eliminamos la cabeza
        if (cabeza.getSiguiente() == null) {
            NodoCoordenada nodoEliminado = cabeza;
            cabeza = null;
            return nodoEliminado;
        }
        // recorremos la lista hasta llegar al penúltimo elemento
        NodoCoordenada actual = cabeza;
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        // guardamos una referencia al último nodo
        NodoCoordenada nodoEliminado = actual.getSiguiente();
        // eliminamos la conexión al último nodo
        actual.setSiguiente(null);
        return nodoEliminado;
    }

    public void eliminarEnMedio(NodoCoordenada nodoEliminar) {
        // verificamos si la lista está vacía
        if (cabeza == null) {
            System.out.println("La lista está vacía, no se puede eliminar.");
            return;
        }
        // si el nodo a eliminar es igual a la cabeza
        if (nodoEliminar.equals(cabeza)) {
            cabeza = cabeza.getSiguiente(); // eliminamos el primer elemento
            return;
        }
        // buscamos el nodo anterior al que queremos eliminar
        NodoCoordenada actual = cabeza;
        while (actual != null && actual.getSiguiente() != null && !actual.getSiguiente().equals(nodoEliminar)) {
            actual = actual.getSiguiente();
        }
        // si no encontramos el nodo a eliminar
        if (actual == null || actual.getSiguiente() == null) {
            System.out.println("El nodo a eliminar no está en la lista.");
            return;
        }
        // eliminamos la conexión del nodo a eliminar
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
    }

    public NodoCoordenada buscar(int Coordenada) {
        NodoCoordenada actual = cabeza; // creamos un nodo auxiliar Coordenada lo inicializamos con la cabeza
        while (actual != null) { // mientras no lleguemos al final de la lista
            if (actual.getCoordenada() == Coordenada) {
                //SCoordenadastem.out.println("Encontrado " + actual.getCoordenada()); // imprimimos el valor del nodo actual
                return actual;
            }
            actual = actual.getSiguiente(); // avanzamos al siguiente nodo
        }
        return null;
    }

    public boolean estaDisponible(int Coordenada) {
        boolean bandera = false;
        NodoCoordenada actual = cabeza; // creamos un nodo auxiliar Coordenada lo inicializamos con la cabeza
        while (actual != null) { // mientras no lleguemos al final de la lista
            if (actual.getCoordenada() == Coordenada) {
                //SCoordenadastem.out.println("Encontrado " + actual.getCoordenada()); // imprimimos el valor del nodo actual
                bandera = true;
                return bandera;
            }
            actual = actual.getSiguiente(); // avanzamos al siguiente nodo
        }
        return bandera;
    }

    // método para mostrar la lista
    public void mostrarListaColumna() {
        NodoCoordenada actual = cabeza; // creamos un nodo auxiliar Coordenada lo inicializamos con la cabeza
        while (actual != null) { // mientras no lleguemos al final de la lista
            System.out.println("|" + actual.getCoordenada()  + "|"); // imprimimos el valor del nodo actual
            actual = actual.getSiguiente(); // avanzamos al siguiente nodo
        }
    }

    public void mostrarListaFila() {
        NodoCoordenada actual = cabeza;
        System.out.print("|" + "i" + "|"); // imprimimos el valor del nodo actual
        while (actual != null) {
            System.out.print("|" + actual.getCoordenada() + "|"); // imprimimos el valor del nodo actual
            actual = actual.getSiguiente(); // avanzamos al siguiente nodo
        }
        System.out.println(); // agregamos "null" al final de la lista
    }
}
