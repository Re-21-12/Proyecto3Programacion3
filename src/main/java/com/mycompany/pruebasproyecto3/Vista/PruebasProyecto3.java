/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pruebasproyecto3.Vista;
import com.mycompany.pruebasproyecto3.Controladores.VentanaController;


import com.mycompany.pruebasproyecto3.Modelos.MatrizOrtogonal;

/**
 *
 * @author victo
 */
public class PruebasProyecto3 {

    public static void main(String[] args) {
        //MatrizOrtogonal matrizOrtogonal = new MatrizOrtogonal();
        //atrizOrtogonal.insertarEnMatriz(0, 100, "1");
        //matrizOrtogonal.mostrarMatriz();
        Ventana ventana = new Ventana();
        new VentanaController(ventana);

    }
}
