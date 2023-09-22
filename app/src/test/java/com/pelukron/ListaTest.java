package com.pelukron;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaTest {

    Lista list;
    @BeforeEach void beforeEach(){
        list = new Lista();
        list.primerNodo = new Nodo(1L);
    }

    /**
     * Validate when there aren't more node linked
     */
    @Test void eliminarPrimerNodo1() {
        assertNull(list.eliminarPrimerNodo());
    }

    /**
     * Validate when there are node linked
     */
    @Test void eliminarPrimerNodo2() {
        list.primerNodo.liga = new Nodo(2L);
        assertNotNull(list.eliminarPrimerNodo());
    }
}
