/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pelukron.demo;

import java.util.Scanner;

/**
 *
 * @author Diego M.
 */
public class Lista {
    public static Nodo primerNodo = null;
    public static boolean salir = false;

    /**
     *
     * @param actualNodo
     */
    // recorrer lista, iniciando desde el primer Nodo

    public static boolean menu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("**************************");
        System.out.println("1.- Agregar Nodo al final");
        System.out.println("2.- Agregar Nodo al inicio");
        System.out.println("3.- Eliminar Nodo final");
        System.out.println("4.- Eliminar el primer Nodo");
        System.out.println("5.- Mostrar lista");
        System.out.println("6.- Salir");
        System.out.print("Seleccione una opcion: ");
        int opcion = teclado.nextInt();
        int numero;
        switch (opcion) {
            case 1:
                System.out.print("\nNÃºmero a Agregar a final: ");
                numero = teclado.nextInt();
                agregarNodoFinal(numero);
                break;
            case 2:
                System.out.print("\nNÃºmero a Agregar al inicio: ");
                numero = teclado.nextInt();
                primerNodo = agregarNodoInicio(numero);
                break;
            case 3:
                eliminarUltimoNodo();
                break;
            case 4:
                primerNodo = eliminarPrimerNodo();
                break;
            case 5:
                recorrerLista();
                break;
            case 6:
                return false;

            default:
                System.out.println("seleccione una opciÃ³n del 1 al 6");
                break;

        }
        return true;

    }

    public static void recorrerLista() {
        double media;
        int contador = 0;
        double acumulador = 0;
        double desviacion = 0;
        System.out.println("---Lista------");
        Nodo actualNodo = primerNodo;
        while (actualNodo != null) {
            contador++;
            acumulador = acumulador + actualNodo.dato;
            System.out.println(actualNodo.dato);
            actualNodo = actualNodo.liga;
        }
        media = acumulador / contador;
        System.out.println("----------------");
        System.out.println("media=" + media);
        actualNodo = primerNodo;
        while (actualNodo != null) {
            desviacion = desviacion + ((actualNodo.dato - media) * (actualNodo.dato - media));
            actualNodo = actualNodo.liga;
        }
        desviacion = Math.sqrt((desviacion) / (contador - 1));
        System.out.println("desviacion=" + desviacion);

    }

    // agregar Nodo al final de la lista, se busca el ultimo Nodo
    public static void agregarNodoFinal(long dato) {
        if (primerNodo == null) {
            primerNodo = new Nodo(dato);

        } else {
            Nodo actualNodo = primerNodo;
            while (actualNodo.liga != null) {
                actualNodo = actualNodo.liga;
            }
            actualNodo.liga = new Nodo(dato);
        }
    }

    public static Nodo agregarNodoInicio(long dato) {
        if (primerNodo == null) {
            primerNodo = new Nodo(dato);
            return primerNodo;
        } else {
            Nodo nuevoNodo;
            nuevoNodo = new Nodo(dato);
            nuevoNodo.liga = primerNodo;
            return nuevoNodo;
        }
    }

    public static void eliminarUltimoNodo() {
        Nodo actualNodo = primerNodo;
        Nodo anterior = null;
        while (actualNodo.liga != null) {
            anterior = actualNodo;
            actualNodo = actualNodo.liga;
        }
        anterior.liga = null;
    }

    public static Nodo eliminarPrimerNodo() {
        Nodo actualNodo = primerNodo;
        return actualNodo.liga;

    }
}
