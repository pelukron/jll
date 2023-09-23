package com.pelukron;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaTest {

    Lista list;
    @BeforeEach void beforeEach(){
        list = new Lista();
        list.setPrimerNodo(new Nodo(1L));
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
        list.getPrimerNodo().liga = new Nodo(2L);
        assertNotNull(list.eliminarPrimerNodo());
    }
}
