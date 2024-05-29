# Proyecto Final, Programación 3
**Integrantes:**

Victor Alfredo Macario Enriquez

Jose Leonel Salazar Tejeda

Marvin Geobany Reyna Ortega


## Descripcion de Proyecto



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

```

### ListaHash.java

```java

```

### MatrizOrtogonal.java

```java

```

### Nodo.java

```java

```

### NodoCoordenada.java

```java

```

### NodoHash.java

```java

```

### NodoLista.java

```java

```

### NodoListaOrtogonal.java

```java

```

### NodoOrtogonal.java

```java

```

### TablaHash.java

```java

```

