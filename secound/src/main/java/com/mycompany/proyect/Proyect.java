/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.proyect;

/**
 *
 * @author VIBEXZ
 */
public class Proyect {

    public static void main(String[] args) {

        /*
        
        
        Cola l = new Cola();
        l.encolar("12", "toyota", "sdas", "ujjjm", "jmjhj", "sdsd", "sdsdsd", "asdasd", 0, "asdasd");
        l.verificar("12", "TOYOTA");
         */
        COLACARROS c = new COLACARROS();
        c.agregar(new NODOCARRO("11111111", "3.0", "", "", "", 12, 12, 12, "", "FFFF"));
        c.agregar(new NODOCARRO("12121", "8.0", "", "", "", 12, 12, 12, "", "ASD"));
        c.mostrar();
       

        /*
        
        
        
        ListaSimple l = new ListaSimple();
        
       
        
       
        
        l.insertar(new Clientes(120100,"a","d","q",2));
        l.insertar(new Clientes(18710008,"a","d","q",1));
        l.insertar(new Clientes(1871000,"a","d","q",3));
        l.insertar(new Clientes(12,"a","d","q",1));
         
        l.imprimirLista();
        l.f(40, 12);
        l.imprimirLista();
         */
 /*
       LISTADOBLE la = new LISTADOBLE();
       la.agregar(new ALQUILER(1,20,5,"asda","sasda"));
       la.agregar(new ALQUILER(2,20,5,"asda","sasda"));
       la.agregar(new ALQUILER(1,20,5,"asda","sasda"));
       la.mostrar();
         */
    }
}
