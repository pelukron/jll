/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pelukron;

import java.util.Scanner;

/**
 *
 * @author Diego M.
 */
public class Lista {
    private Nodo primerNodo;

    public Lista() {
        this.primerNodo = null;
    }

    /**
     * recorrer lista, iniciando desde el primer Nodo
     */
    public boolean menu() {
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
                setPrimerNodo(agregarNodoInicio(numero));
                break;
            case 3:
                eliminarUltimoNodo();
                break;
            case 4:
                setPrimerNodo(eliminarPrimerNodo());
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

    public void recorrerLista() {
        double media;
        int contador = 0;
        double acumulador = 0;
        double desviacion = 0;
        System.out.println("---Lista------");
        Nodo actualNodo = getPrimerNodo();
        while (actualNodo != null) {
            contador++;
            acumulador = acumulador + actualNodo.dato;
            System.out.println(actualNodo.dato);
            actualNodo = actualNodo.liga;
        }
        double actualValue = (acumulador / contador);
        media = Double.isNaN(actualValue) ? 0 : actualValue;
        System.out.println("----------------");
        System.out.println("media=" + media);
        actualNodo = getPrimerNodo();
        while (actualNodo != null) {
            desviacion = desviacion + ((actualNodo.dato - media) * (actualNodo.dato - media));
            actualNodo = actualNodo.liga;
        }
        desviacion = Math.abs(Math.sqrt((desviacion) / (contador - 1)));
        System.out.println("desviacion=" + desviacion);

    }

    // agregar Nodo al final de la lista, se busca el ultimo Nodo
    public void agregarNodoFinal(long dato) {
        if (getPrimerNodo() == null) {
            setPrimerNodo(new Nodo(dato));

        } else {
            Nodo actualNodo = getPrimerNodo();
            while (actualNodo.liga != null) {
                actualNodo = actualNodo.liga;
            }
            actualNodo.liga = new Nodo(dato);
        }
    }

    public Nodo agregarNodoInicio(long dato) {
        if (getPrimerNodo() == null) {
            setPrimerNodo(new Nodo(dato));
            return getPrimerNodo();
        } else {
            Nodo nuevoNodo;
            nuevoNodo = new Nodo(dato);
            nuevoNodo.liga = getPrimerNodo();
            return nuevoNodo;
        }
    }

    public void eliminarUltimoNodo() {
        Nodo actualNodo = getPrimerNodo();
        Nodo anterior = null;
        while (actualNodo.liga != null) {
            anterior = actualNodo;
            actualNodo = actualNodo.liga;
        }
        anterior.liga = null;
    }

    public Nodo eliminarPrimerNodo() {
        Nodo actualNodo = getPrimerNodo();
        return actualNodo.liga;
    }

    public Nodo getPrimerNodo() {
        return primerNodo;
    }

    public void setPrimerNodo(Nodo primerNodo) {
        this.primerNodo = primerNodo;
    }
}
