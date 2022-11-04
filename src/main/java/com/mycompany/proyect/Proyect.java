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
        
            Cola c = new Cola();
            c.encolar("P", "A","A","2020","A","A","A","A",1,"A","a");
            c.encolar("A", "A","A","2020","A","A","A","A",1,"A","a");
            c.encolar("Y", "A","A","2020","A","A","A","A",1,"A","a");
            c.Mostrar();
           
            
            c.modificar("Y","5050", "1","2","2020","3","4","5",100,"9","562" );
            c.Mostrar();
    }
}
