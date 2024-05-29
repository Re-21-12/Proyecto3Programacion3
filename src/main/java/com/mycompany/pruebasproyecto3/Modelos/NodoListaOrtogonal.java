/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebasproyecto3.Modelos;


public class NodoListaOrtogonal {

    private NodoOrtogonal cabeza; // Declara una variable privada cabeza del tipo NodoOrtogonal
    private NodoOrtogonal cola; // Declara una variable privada cola del tipo NodoOrtogonal

    //utilizamos listas doblemente enlazadas por lo cual deben apuntar a nulo
    public NodoListaOrtogonal() { // Constructor de la clase NodoListaHorizontal
        this.cabeza = this.cola = null; // Inicializa cabeza y cola como nulos
    }

    public void insertar(NodoOrtogonal nodoHorizontal) { // Método para insertar un nodo en la lista horizontal
        //si la cabeza esta vacia entonces podemos asignar un nuevo elemento
        if (cabeza == null) { // Verifica si la cabeza está vacía
            this.cabeza = this.cola = nodoHorizontal; // Asigna el nuevo nodo como cabeza y cola
            //cocmo vamos aumentando segun se van ingresando al principio estaran los menores y de ultimo los mayores
        } else { // Si la cabeza no está vacía
            if (nodoHorizontal.getX() < cabeza.getX()) { // Verifica si el nuevo nodo tiene un valor menor que el de la cabeza
                cabeza = insertarInicio(nodoHorizontal); // Inserta el nuevo nodo al inicio de la lista
            } else if (nodoHorizontal.getX() > cola.getX()) { // Verifica si el nuevo nodo tiene un valor mayor que el de la cola
                cola = insertarFinal(nodoHorizontal); // Inserta el nuevo nodo al final de la lista
            } else { // Si el nuevo nodo tiene un valor entre la cabeza y la cola
                insertarEnMedio(nodoHorizontal); // Inserta el nuevo nodo en medio de la lista
            }

        }

    }

    //aqui los valores se van empujando de izquierda a derecha hasta llegar a null
    // 1 <- 2 <- null
    private NodoOrtogonal insertarInicio(NodoOrtogonal nodoHorizontal) { // Método para insertar un nodo al inicio de la lista
        // establecemos los enlaces del nuevo nodo hacia la cabeza y viceversa
        nodoHorizontal.setDerecha(cabeza); // Establece el enlace hacia la cabeza
        if (cabeza != null) { // Verifica si la cabeza no es nula
            cabeza.setIzquierda(nodoHorizontal); // Establece el enlace hacia el nuevo nodo
        }
        // colocamos el nuevo nodo como cabeza de la lista
        cabeza = nodoHorizontal; // Asigna el nuevo nodo como cabeza
        return cabeza; // Devuelve la cabeza actualizada
    }

    //aqui los valores se van empujando de derecha a izquierda inicando con null
    // nuull -> 2 -> 1 
    private NodoOrtogonal insertarFinal(NodoOrtogonal nodoHorizontal) { // Método para insertar un nodo al final de la lista
        // si la cabeza está vacía, asignamos el nuevo nodo como cola
        if (cabeza == null) { // Verifica si la cabeza es nula
            return nodoHorizontal; // Devuelve el nuevo nodo como cola
        }
        // si no está vacía, recorremos la lista hasta llegar al último nodo
        NodoOrtogonal actual = cabeza; // Inicializa actual como la cabeza
        while (actual.getDerecha() != null) { // Itera hasta llegar al último nodo
            actual = actual.getDerecha(); // Avanza al siguiente nodo
        }
        // establecemos los enlaces del último nodo hacia el nuevo nodo y viceversa
        actual.setDerecha(nodoHorizontal); // Establece el enlace hacia el nuevo nodo
        nodoHorizontal.setIzquierda(actual); // Establece el enlace hacia el nodo anterior
        // colocamos el nuevo nodo como cola de la lista
        cola = nodoHorizontal; // Asigna el nuevo nodo como cola
        return cola; // Devuelve la cola actualizada
    }

    private NodoOrtogonal insertarEnMedio(NodoOrtogonal nodoHorizontal) { // Método para insertar un nodo en medio de la lista
        // buscamos el nodo después del cual se insertará el nuevo nodo
        NodoOrtogonal actual = cabeza; // Inicializa actual como la cabeza
        while (actual != null && nodoHorizontal.getX() > actual.getX()) { // Itera hasta encontrar el nodo adecuado
            actual = actual.getDerecha(); // Avanza al siguiente nodo
        }
        // si no se encuentra el nodo después del cual se insertará el nuevo nodo, no hacemos nada
        if (actual == null) { // Verifica si no se encontró el nodo
            System.out.println("El valor después del cual se desea insertar no se encontró en la lista."); // Imprime un mensaje de error
            return cabeza; // Devuelve la cabeza sin cambios
        }
        // insertamos el nuevo nodo después del nodo actual
        NodoOrtogonal anterior = actual.getIzquierda(); // Obtiene el nodo anterior al nodo actual
        nodoHorizontal.setDerecha(actual); // Establece el enlace hacia el nodo actual
        nodoHorizontal.setIzquierda(anterior); // Establece el enlace hacia el nodo anterior
        actual.setIzquierda(nodoHorizontal); // Establece el enlace desde el nodo actual hacia el nuevo nodo
        if (anterior != null) { // Verifica si el nodo anterior no es nulo
            anterior.setDerecha(nodoHorizontal); // Establece el enlace desde el nodo anterior hacia el nuevo nodo
        } else { // Si el nodo anterior es nulo, significa que el nuevo nodo es la nueva cabeza
            cabeza = nodoHorizontal; // Asigna el nuevo nodo como cabeza
        }
        return cabeza; // Devuelve la cabeza actualizada
    }

    public void mostrarListaColumnaOrtogonal() {
        NodoOrtogonal actual = cabeza; // creamos un nodo auxiliar Coordenada lo inicializamos con la cabeza
        System.out.print("|" + "i" + "|"); // imprimimos el valor del nodo actual
        while (actual != null) { // mientras no lleguemos al final de la lista
            System.out.println("|" + actual.getDato()+ "|"); // imprimimos el valor del nodo actual
            actual = actual.getAbajo(); // avanzamos al siguiente nodo
        }
    }

    public void mostrarListaFilaOrtogonal() { // Método para mostrar la lista horizontal
        NodoOrtogonal actual = cabeza; // Inicializa actual como la cabeza
        while (actual != null) { // Itera hasta llegar al final de la lista
            System.out.print("|" + actual.getDato()+ "|"); // Imprime el valor del nodo actual
            actual = actual.getDerecha(); // Avanza al siguiente nodo
        }
        System.out.println(); // Imprime un salto de línea al final de la lista
    }
}
