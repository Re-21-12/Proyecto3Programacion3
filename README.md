# Proyecto Final, Programación 3
**Integrantes:**

Victor Alfredo Macario Enriquez

Jose Leonel Salazar Tejeda

Marvin Geobany Reyna Ortega


## Descripcion de Proyecto
Hoja electrónica
El proyecto consiste en desarrollar una hoja de cálculo (ej.: Excel). Haciendo uso de matriz ortogonal para representar las celdas y almacenar sus datos, utilizando patrones de diseño MVC. La hoja debe ser capaz de resolver operaciones (al menos) suma y multiplicación. Así mismo la hoja electrónica permitirá la creación de n hojas internas.
El proyecto tendrá más valor si es capaz de generar y almacenar tablas Hash, para efectos del mismo se debe hacer un algoritmo Hash y no utilizar las librerías que ya existen. Para ello el menú “Archivo” se debe incluir una opción llamada “Tabla hash” que muestre una interfaz similar a la de hoja electrónica, donde, en la columna A se pueda agregar datos y este genere la tabla hash según esos datos. E ir mostrando los índices generados en la (s) columna (s) de la derecha.


### Clases del Proyecto en Java

El proyecto esta agrupado en tres fases cada una con sus respectivas clases para su correcto uso de las mismas.

### Controladores
* MatrizOrtogonalController.java
* VentanaController.java

### MatrizOrtogonalController.java

```java
/**
 * Controlador para manejar las operaciones relacionadas con matrices ortogonales.
 * Esta clase proporciona los métodos necesarios para la creación, manipulación 
 * y otras operaciones que se pueden realizar con matrices ortogonales.
 * 

public class MatrizOrtogonalController {
    
    /**
     * Crea una nueva instancia del controlador de matrices ortogonales.
     * Inicializa los recursos necesarios para manejar las operaciones de matrices ortogonales.
     */
    public MatrizOrtogonalController() {
        // Constructor por defecto
    }
```

### VentanaController.java

```java
/**
 * Controlador para manejar las acciones y eventos en la interfaz de usuario de la ventana.
 * Esta clase implementa la interfaz ActionListener para responder a eventos de acción
 * generados por componentes de la GUI.

/**
     * Maneja los eventos de acción generados por los componentes de la vista.
     * Este método es llamado automáticamente cuando se produce un evento de acción.
     * 
     * @param e El evento de acción generado.
     */
    @Override
    public void actionPerformed(ActionEvent e) {


/**
     * Genera una tabla hash basada en los datos de la columna B de la hoja seleccionada.
     */
    private void generarTablaHash() {      


/**
     * Obtiene los datos de la columna B de la hoja seleccionada.
     * 
     * @return Una lista de cadenas con los datos de la columna B.
     */
    private ArrayList<String> obtenerDatosColumnaB() {

/**
     * Solicita al usuario la cantidad de buckets para la tabla hash.
     * 
     * @return La cantidad de buckets especificada por el usuario.
     */
    private int solicitarCantidadBuckets() {

 /**
     * Carga los datos desde un archivo especificado por la ruta.
     * 
     * @param rutaArchivo La ruta del archivo desde el cual cargar los datos.
     */
    public void cargarDatos(String rutaArchivo) {

/**
     * Guarda los datos en un archivo especificado por la ruta.
     * 
     * @param rutaArchivo La ruta del archivo donde se guardarán los datos.
     */
    public void guardarDatos(String rutaArchivo) {  

/**
     * Abre un diálogo para guardar los datos en un archivo seleccionado por el usuario.
     */
    public void guardarDatosConDialogo() {

/**
     * Abre un diálogo para cargar los datos desde un archivo seleccionado por el usuario.
     */
    public void cargarDatosConDialogo() {

/**
     * Obtiene la matriz ortogonal correspondiente a la hoja seleccionada.
     * 
     * @return La matriz ortogonal de la hoja seleccionada.
     * @throws Error si no se encuentra la matriz ortogonal correspondiente.
     */
    private MatrizOrtogonal obtenerMatrizOrtogonal() {

/**
     * Aplica una función a los datos de dos celdas y coloca el resultado en otra celda.
     * 
     * @param operacion El tipo de operación a aplicar (suma, resta, multiplicación, división).
     * @param dato1x Coordenada x del primer dato.
     * @param dato1y Coordenada y del primer dato.
     * @param dato2x Coordenada x del segundo dato.
     * @param dato2y Coordenada y del segundo dato.
     * @param x Coordenada x de la celda de destino.
     * @param y Coordenada y de la celda de destino.
     * @return Un nodo ortogonal con el resultado de la operación.
     */
    private NodoOrtogonal aplicarFuncion(String operacion, String dato1x, String dato1y, String dato2x, String dato2y, String x, String y) {
        String resultado = "";

/**
     * Agrega una nueva hoja a la vista y la inicializa con valores predeterminados.
     */
    private void agregarHoja() {

/**
     * Envía los cambios realizados a una celda de la matriz ortogonal.
     * 
     * @param nodoOrtogonal El nodo ortogonal con los cambios.
     * @param estado El estado del cambio (insertado, actualizado, eliminado).
     * @param matrizOrtogonal La matriz ortogonal donde se realizará el cambio.
     */
    private void mandarCambios(NodoOrtogonal nodoOrtogonal, String estado, MatrizOrtogonal matrizOrtogonal) {
        if (nodoOrtogonal == null) {
            System.err.println("Error: Nodo ortogonal nulo.");
            return;
        }

```

### Modelos
*   ListaEnlazada.java
*   ListaHash.java
*   MatrizOrtogonal.java
*   Nodo.java
*   NodoCoordenada.java
*   NodoHash.java
*   NodoLista.java
*   NodoListaOrtogonal.java
*   NodoOrtogonal.java
*   TablaHash.java

### ListaEnlazada.java

```java
/**
 * Esta clase representa una lista enlazada doble.
 * 
 * @version 1.0
 * @since 2024
 */
public class ListaEnlazada {

    private Nodo cabeza;
    private Nodo cola;

    /**
     * Constructor que inicializa una lista vacía.
     */
    public ListaEnlazada() {
        // Inicializa la cabeza y la cola como nulas.
    }

    /**
     * Inserta un nodo al inicio de la lista.
     * 
     * @param nodo Nodo a insertar.
     */
    public void insertar(Nodo nodo) {
        // Si la lista está vacía, el nodo se convierte en la cabeza y la cola.
        // Si no está vacía, inserta el nodo al inicio.
    }

    /**
     * Inserta un nodo como nuevo nodo inicial.
     * 
     * @param nodo Nodo a insertar.
     * @return El nuevo nodo cabeza.
     */
    private Nodo insertarInicio(Nodo nodo) {
        // Establece el nuevo nodo como cabeza y ajusta los enlaces.
    }

    /**
     * Indica la posición de la columna de un nodo.
     * 
     * @param nodo Nodo a buscar.
     * @return La posición de la columna del nodo.
     * @throws Error si el nodo no se encuentra.
     */
    public int indicarColumna(Nodo nodo) {
        // Recorre la lista buscando el nodo especificado y devuelve su posición.
        // Lanza un error si el nodo no se encuentra.
    }
}

```

### ListaHash.java

```java
/**
 * Esta clase representa una lista de nodos hash, donde cada nodo contiene una lista 
 * para almacenar datos.
 */
public class ListaHash {

    private NodoHash cabeza;
    private NodoHash cola;

    /**
     * Constructor que inicializa una lista hash vacía.
     */
    public ListaHash() {
        // Inicializa la cabeza y la cola como nulas.
    }

    /**
     * Inserta un nodo hash en la lista.
     * 
     * @param nodo_hash Nodo hash a insertar.
     */
    public void insertar(NodoHash nodo_hash) {
        // Inserta el nodo como cabeza si la lista está vacía o al inicio si no lo está.
    }

    /**
     * Inserta un nodo hash como nuevo nodo inicial.
     * 
     * @param nodo_hash Nodo hash a insertar.
     * @return El nuevo nodo cabeza.
     */
    private NodoHash insertarInicio(NodoHash nodo_hash) {
        // Establece el nuevo nodo como cabeza y ajusta los enlaces.
    }

    /**
     * Inserta un nodo en la lista del índice especificado.
     * 
     * @param indice Índice donde insertar el nodo.
     * @param nodo Nodo a insertar.
     */
    public void insertarEnListaDelIndice(int indice, Nodo nodo) {
        // Inserta el nodo en la lista correspondiente al índice dado.
    }

    /**
     * Muestra la fila y columna del nodo en el índice especificado.
     * 
     * @param indice Índice donde buscar el nodo.
     * @param nodo Nodo a buscar.
     * @return Arreglo con el índice, la columna y el dato del nodo.
     * @throws Error si no se encuentran las coordenadas para el índice dado.
     */
    public int[] mostrarFilayColumna(int indice, Nodo nodo) {
        // Devuelve las coordenadas del nodo en el índice dado.
    }
}

```

### MatrizOrtogonal.java

```java
/**
 * Clase que representa una matriz ortogonal, donde se almacenan datos en coordenadas específicas.
 */
public class MatrizOrtogonal {

    private int numeroHoja;
    private NodoLista filas; // Lista de filas de la matriz
    private NodoLista columnas; // Lista de columnas de la matriz

    /**
     * Constructor que inicializa la matriz ortogonal con un número de hoja específico.
     */
    public MatrizOrtogonal(int numeroHoja) {
        // Inicializa las listas de filas y columnas.
    }

    /**
     * Inserta un dato en la matriz ortogonal en las coordenadas especificadas.
     * 
     * @param x Coordenada x.
     * @param y Coordenada y.
     * @param dato Dato a insertar.
     */
    public void insertarEnMatriz(int x, int y, String dato) {
        // Verifica y crea filas y columnas si no existen, e inserta el dato en las listas correspondientes.
    }

    /**
     * Elimina un dato de la matriz ortogonal en las coordenadas especificadas.
     * 
     * @param x Coordenada x.
     * @param y Coordenada y.
     */
    public void eliminarEnMatriz(int x, int y) {
        // Busca y elimina el dato en las coordenadas especificadas, ajustando las listas de filas y columnas.
    }

    /**
     * Busca un dato en la matriz ortogonal en las coordenadas especificadas.
     * 
     * @param x Coordenada x.
     * @param y Coordenada y.
     */
    public void buscarEnMatriz(int x, int y) {
        // Busca y verifica si el dato existe en las coordenadas especificadas.
    }

    /**
     * Muestra la matriz ortogonal, incluyendo las listas de filas y columnas.
     */
    public void mostrarMatriz() {
        // Muestra las listas de filas y columnas de la matriz.
    }

    public int getNumeroHoja() {
        return numeroHoja;
    }

    public void setNumeroHoja(int numeroHoja) {
        this.numeroHoja = numeroHoja;
    }
}

```

### Nodo.java

```java
/**
 * Clase que representa un nodo en una lista doblemente enlazada.
 */
public class Nodo {
    private int dato; // Dato almacenado en el nodo
    private Nodo siguiente; // Referencia al nodo siguiente
    private Nodo anterior; // Referencia al nodo anterior

    /**
     * Constructor que inicializa un nodo con un dato específico.
     * 
     * @param dato Dato a almacenar en el nodo.
     */
    public Nodo(int dato) {
        // Inicializa el nodo con el dato proporcionado y referencias nulas.
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     * 
     * @return Dato del nodo.
     */
    public int getDato() {
        return dato;
    }

    /**
     * Establece el dato del nodo.
     * 
     * @param dato Dato a establecer.
     */
    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la referencia al nodo siguiente.
     * 
     * @return Nodo siguiente.
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al nodo siguiente.
     * 
     * @param siguiente Nodo siguiente a establecer.
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Obtiene la referencia al nodo anterior.
     * 
     * @return Nodo anterior.
     */
    public Nodo getAnterior() {
        return anterior;
    }

    /**
     * Establece la referencia al nodo anterior.
     * 
     * @param anterior Nodo anterior a establecer.
     */
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}

```

### NodoCoordenada.java

```java
/**
 * Nodo que actúa como cabecera en las filas y columnas principales.
 */
public class NodoCoordenada {
    private int coordenada; // Coordenada del nodo
    private NodoCoordenada anterior; // Nodo anterior en la lista
    private NodoCoordenada siguiente; // Nodo siguiente en la lista
    private NodoListaOrtogonal lista; // Lista ortogonal asociada al nodo

    /**
     * Constructor que inicializa un nodo con una coordenada específica.
     * 
     * @param coordenada Coordenada del nodo.
     */
    public NodoCoordenada(int coordenada) {
        // Inicializa la coordenada y la lista ortogonal asociada.
    }

    /**
     * Obtiene la coordenada del nodo.
     * 
     * @return Coordenada del nodo.
     */
    public int getCoordenada() {
        return coordenada;
    }

    /**
     * Establece la coordenada del nodo.
     * 
     * @param coordenada Coordenada a establecer.
     */
    public void setCoordenada(int coordenada) {
        this.coordenada = coordenada;
    }

    /**
     * Obtiene el nodo anterior.
     * 
     * @return Nodo anterior.
     */
    public NodoCoordenada getAnterior() {
        return anterior;
    }

    /**
     * Establece el nodo anterior.
     * 
     * @param anterior Nodo anterior a establecer.
     */
    public void setAnterior(NodoCoordenada anterior) {
        this.anterior = anterior;
    }

    /**
     * Obtiene el nodo siguiente.
     * 
     * @return Nodo siguiente.
     */
    public NodoCoordenada getSiguiente() {
        return siguiente;
    }

    /**
     * Establece el nodo siguiente.
     * 
     * @param siguiente Nodo siguiente a establecer.
     */
    public void setSiguiente(NodoCoordenada siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Obtiene la lista ortogonal asociada al nodo.
     * 
     * @return Lista ortogonal.
     */
    public NodoListaOrtogonal getLista() {
        return lista;
    }

    /**
     * Establece la lista ortogonal asociada al nodo.
     * 
     * @param lista Lista ortogonal a establecer.
     */
    public void setLista(NodoListaOrtogonal lista) {
        this.lista = lista;
    }
}

```

### NodoHash.java

```java
/**
 * Los nodos hash representan la lista de índices.
 */
public class NodoHash extends Nodo {
    private ListaEnlazada lista; // Lista enlazada asociada al nodo hash

    /**
     * Constructor que inicializa un nodo hash con un dato (índice).
     * 
     * @param dato Índice del nodo hash.
     */
    public NodoHash(int dato) {
        super(dato);
        this.lista = new ListaEnlazada();
    }

    /**
     * Obtiene la lista enlazada asociada al nodo hash.
     * 
     * @return Lista enlazada.
     */
    public ListaEnlazada getLista() {
        return lista;
    }
}

```

### NodoLista.java

```java
public class NodoLista {

    private NodoCoordenada cabeza; // Nodo que apunta al inicio de la lista
    private NodoCoordenada cola; // Nodo que apunta al final de la lista

    // Constructor que inicializa la lista con valores nulos
    public NodoLista() {
        cabeza = cola = null;
    }

    // Método para insertar nodos en vertical
    public void insertar(NodoCoordenada nodo) {
        if (cabeza == null) {
            this.cabeza = this.cola = nodo; // Si la lista está vacía, el nuevo nodo será la cabeza y la cola
        } else {
            if (nodo.getCoordenada() < cabeza.getCoordenada()) {
                cabeza = insertarInicio(nodo); // Insertar al principio si el nuevo nodo es menor que la cabeza
            } else if (nodo.getCoordenada() > cola.getCoordenada()) {
                cola = insertarFinal(nodo); // Insertar al final si el nuevo nodo es mayor que la cola
            } else {
                insertarEnMedio(nodo); // Insertar en medio si el nuevo nodo está entre la cabeza y la cola
            }
        }
    }

    // Método privado para insertar un nodo al principio de la lista
    private NodoCoordenada insertarInicio(NodoCoordenada nodo) {
        nodo.setSiguiente(cabeza);
        if (cabeza != null) {
            cabeza.setAnterior(nodo);
        }
        cabeza = nodo; // El nuevo nodo se convierte en la cabeza
        return cabeza;
    }

    // Método privado para insertar un nodo al final de la lista
    private NodoCoordenada insertarFinal(NodoCoordenada nodo) {
        NodoCoordenada actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nodo);
        nodo.setAnterior(actual);
        cola = nodo; // El nuevo nodo se convierte en la cola
        return cola;
    }

    // Método privado para insertar un nodo en medio de la lista
    private NodoCoordenada insertarEnMedio(NodoCoordenada nodo) {
        NodoCoordenada actual = cabeza;
        while (actual != null && nodo.getCoordenada() > actual.getCoordenada()) {
            actual = actual.getSiguiente();
        }
        NodoCoordenada anterior = actual.getAnterior();
        nodo.setSiguiente(actual);
        nodo.setAnterior(anterior);
        actual.setAnterior(nodo);
        if (anterior != null) {
            anterior.setSiguiente(nodo);
        } else {
            cabeza = nodo;
        }
        return cabeza;
    }

    // Método para eliminar un nodo de la lista
    public void eliminar(NodoCoordenada nodo) {
        if (cabeza == null) {
            return; // Si la lista está vacía, no hay nada que eliminar
        } else if (nodo.getCoordenada() < cabeza.getCoordenada()) {
            cabeza = eliminarInicio(); // Eliminar al principio
        } else if (nodo.getCoordenada() > cola.getCoordenada()) {
            cola = eliminarFinal(); // Eliminar al final
        } else {
            eliminarEnMedio(nodo); // Eliminar en medio
        }
    }

    // Método privado para eliminar el nodo al principio de la lista
    private NodoCoordenada eliminarInicio() {
        if (cabeza == null) {
            return null; // Si la lista está vacía, no se puede eliminar
        }
        NodoCoordenada nuevoTopeIzquierda = cabeza.getSiguiente();
        cabeza.setSiguiente(null);
        return nuevoTopeIzquierda;
    }

    // Método privado para eliminar el nodo al final de la lista
    private NodoCoordenada eliminarFinal() {
        if (cabeza == null) {
            return null; // Si la lista está vacía, no se puede eliminar
        }
        if (cabeza.getSiguiente() == null) {
            NodoCoordenada nodoEliminado = cabeza;
            cabeza = null;
            return nodoEliminado;
        }
        NodoCoordenada actual = cabeza;
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        NodoCoordenada nodoEliminado = actual.getSiguiente();
        actual.setSiguiente(null);
        return nodoEliminado;
    }

    // Método privado para eliminar un nodo en medio de la lista
    private void eliminarEnMedio(NodoCoordenada nodoEliminar) {
        if (cabeza == null) {
            return; // Si la lista está vacía, no se puede eliminar
        }
        if (nodoEliminar.equals(cabeza)) {
            cabeza = cabeza.getSiguiente();
            return;
        }
        NodoCoordenada actual = cabeza;
        while (actual != null && actual.getSiguiente() != null && !actual.getSiguiente().equals(nodoEliminar)) {
            actual = actual.getSiguiente();
        }
        if (actual == null || actual.getSiguiente() == null) {
            return; // Si no encontramos el nodo a eliminar
        }
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
    }

    // Método para buscar un nodo por su coordenada
    public NodoCoordenada buscar(int coordenada) {
        NodoCoordenada actual = cabeza;
        while (actual != null) {
            if (actual.getCoordenada() == coordenada) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // Método para verificar si una coordenada está disponible
    public boolean estaDisponible(int coordenada) {
        NodoCoordenada actual = cabeza;
        while (actual != null) {
            if (actual.getCoordenada() == coordenada) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Método para mostrar la lista de columnas
    public void mostrarListaColumna() {
        NodoCoordenada actual = cabeza;
        while (actual != null) {
            System.out.println("|" + actual.getCoordenada() + "|");
            actual = actual.getSiguiente();
        }
    }

    // Método para mostrar la lista de filas
    public void mostrarListaFila() {
        NodoCoordenada actual = cabeza;
        System.out.print("|i|");
        while (actual != null) {
            System.out.print("|" + actual.getCoordenada() + "|");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
}

```

### NodoListaOrtogonal.java

```java
/**
 * Clase que representa un nodo de una lista ortogonal.
 */
public class NodoListaOrtogonal {

    private NodoOrtogonal cabeza; // Nodo inicial de la lista
    private NodoOrtogonal cola; // Nodo final de la lista

    /**
     * Constructor de la clase.
     * Inicializa la cabeza y la cola como nulas.
     */
    public NodoListaOrtogonal() {
        this.cabeza = this.cola = null;
    }

    /**
     * Método para insertar un nodo en la lista ortogonal.
     * @param nodoHorizontal Nodo a insertar en la lista
     */
    public void insertar(NodoOrtogonal nodoHorizontal) {
        // Implementación omitida para insertar nodos en la lista
    }

    /**
     * Método privado para insertar un nodo al inicio de la lista.
     * @param nodoHorizontal Nodo a insertar al inicio
     * @return El nodo insertado como nueva cabeza
     */
    private NodoOrtogonal insertarInicio(NodoOrtogonal nodoHorizontal) {
        // Implementación omitida para insertar al inicio de la lista
    }

    /**
     * Método privado para insertar un nodo al final de la lista.
     * @param nodoHorizontal Nodo a insertar al final
     * @return El nodo insertado como nueva cola
     */
    private NodoOrtogonal insertarFinal(NodoOrtogonal nodoHorizontal) {
        // Implementación omitida para insertar al final de la lista
    }

    /**
     * Método privado para insertar un nodo en medio de la lista.
     * @param nodoHorizontal Nodo a insertar en medio de la lista
     * @return La cabeza de la lista actualizada
     */
    private NodoOrtogonal insertarEnMedio(NodoOrtogonal nodoHorizontal) {
        // Implementación omitida para insertar en medio de la lista
    }

    /**
     * Método para mostrar la lista ortogonal por columnas.
     */
    public void mostrarListaColumnaOrtogonal() {
        // Implementación omitida para mostrar la lista por columnas
    }

    /**
     * Método para mostrar la lista ortogonal por filas.
     */
    public void mostrarListaFilaOrtogonal() {
        // Implementación omitida para mostrar la lista por filas
    }
}

```

### NodoOrtogonal.java

```java
/**
 * Clase que representa un nodo en una estructura de datos ortogonal.
 */
public class NodoOrtogonal {

    private int x; // Coordenada x del nodo
    private int y; // Coordenada y del nodo
    private String dato; // Dato almacenado en el nodo
    private NodoOrtogonal arriba; // Nodo ubicado arriba del nodo actual
    private NodoOrtogonal abajo; // Nodo ubicado abajo del nodo actual
    private NodoOrtogonal izquierda; // Nodo ubicado a la izquierda del nodo actual
    private NodoOrtogonal derecha; // Nodo ubicado a la derecha del nodo actual

    /**
     * Constructor vacío de la clase NodoOrtogonal.
     */
    public NodoOrtogonal() {
        // No realiza ninguna inicialización especial
    }

    /**
     * Constructor de la clase NodoOrtogonal con parámetros.
     * @param dato Dato a almacenar en el nodo
     * @param x Coordenada x del nodo
     * @param y Coordenada y del nodo
     */
    public NodoOrtogonal(String dato, int x, int y) {
        this.dato = dato;
        this.x = x;
        this.y = y;
        this.arriba = null;
        this.abajo = null;
        this.izquierda = null;
        this.derecha = null;
    }

    // Métodos getter y setter para los campos x, y y dato

    // Métodos getter y setter para los nodos arriba, abajo, izquierda y derecha
}

```

### TablaHash.java

```java
import java.util.ArrayList;

/**
 * Clase que representa una tabla de dispersión (hash table).
 */
public class TablaHash {

    private int numero_buckets; // Número de buckets en la tabla de dispersión
    private ListaHash lista_de_listas; // Lista de listas para almacenar los elementos

    /**
     * Constructor de la clase TablaHash.
     * @param numero_buckets Número de buckets de la tabla
     */
    public TablaHash(int numero_buckets) {
        this.numero_buckets = numero_buckets;
        this.lista_de_listas = new ListaHash();
    }

    /**
     * Método para llenar la lista de índices con nodos.
     */
    public void llenarListaIndices() {
        // Implementación omitida para llenar la lista de índices con nodos
    }

    /**
     * Función de hashing para calcular el índice de un nodo en la tabla.
     * @param numero_buckets Número de buckets en la tabla
     * @param nodo Nodo a insertar en la tabla
     * @return Índice calculado para el nodo
     */
    private int hashing(int numero_buckets, Nodo nodo) {
        // Implementación omitida para la función de hashing
    }

    /**
     * Método para aplicar el método de hashing a un conjunto de datos.
     * @param datos Conjunto de datos a insertar en la tabla
     */
    public void hashMethod(ArrayList<String> datos) {
        // Implementación omitida para aplicar el método de hashing a los datos
    }

    /**
     * Método para mostrar la lista de índices de la tabla.
     * @param datos Conjunto de datos a mostrar en la tabla
     * @return Lista de coordenadas de los datos en la tabla
     */
    public ArrayList<int[]> mostrarListaIndices(ArrayList<String> datos) {
        // Implementación omitida para mostrar la lista de índices de la tabla
    }
}

```
### Modelos
*   PruebasProyecto3.java
*   Ventana.java

### PruebasProyecto3.java

```java
import com.mycompany.pruebasproyecto3.Modelos.MatrizOrtogonal;

/**
 * Clase de prueba para el proyecto 3.
 */
public class PruebasProyecto3 {

    /**
     * Método principal para ejecutar las pruebas del proyecto.
     * @param args Argumentos de la línea de comandos (no utilizado)
     */
    public static void main(String[] args) {
        // Crear una instancia de la ventana y su controlador
        Ventana ventana = new Ventana();
        new VentanaController(ventana);
        
        // Ejemplo de uso de la clase MatrizOrtogonal (comentado para evitar ejecución)
        // MatrizOrtogonal matrizOrtogonal = new MatrizOrtogonal();
        // matrizOrtogonal.insertarEnMatriz(0, 100, "1");
        // matrizOrtogonal.mostrarMatriz();
    }
}

```

### Ventana.java

```java
/**
 * Clase que representa la interfaz gráfica de la aplicación.
 */
public class Ventana {

    public JFrame frame;  // Ventana principal
    public JButton aplicar;  // Botón para aplicar una función
    public JButton rechazar;  // Botón para rechazar una función
    public JMenuItem crearHoja, tablaHash, guardar, cargar;  // Elementos de menú
    private JTabbedPane tabbedPane;  // Panel con pestañas para diferentes hojas
    private JTextField funcionesField;  // Campo de texto para ingresar funciones
    private JLabel hojaActualLabel;  // Etiqueta para mostrar la hoja actual

    /**
     * Constructor de la clase Ventana.
     */
    public Ventana() {
        initialize();  // Inicializa la interfaz gráfica
    }

    /**
     * Método para inicializar los componentes de la interfaz.
     */
    private void initialize() {
        // Implementación omitida para la inicialización de la interfaz gráfica
    }

    // Métodos para agregar una nueva hoja, establecer controlador de eventos,
    // obtener el texto del campo de funciones, limpiar el campo de funciones,
    // obtener el índice de la hoja seleccionada, establecer el modelo de la
    // hoja seleccionada, obtener el modelo de la hoja seleccionada y obtener
    // el marco principal. 
}

```
