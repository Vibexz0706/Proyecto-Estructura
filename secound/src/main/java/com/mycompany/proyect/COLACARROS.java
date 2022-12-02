/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect;

/**
 *
 * @author Vibexz
 */
public class COLACARROS {
    
    private NODOCARRO head;
    private NODOCARRO tail;

    public COLACARROS(NODOCARRO head, NODOCARRO tail) {
        this.head = head;
        this.tail = tail;
    }
    
      public COLACARROS() {
      
    }
      
      
      public void agregar(NODOCARRO c){
          
          if(head == null){
              head = c;
              tail = c;
          }else{
              tail.setNext(c);
              tail = c;
          }
          
      }
      
      public void mostrar(){
          NODOCARRO aux = head;
          
          if(head != null){
              while(aux != null){
                  System.out.println(aux.getPLACA() + " " + aux.getExtras());
                   
                  aux = aux.getNext();
              }
              
          }
      }
      
      
      
      public void eliminar(String placa) {

        NODOCARRO aux = new NODOCARRO();
        
        aux.setPLACA(placa);
        
        if (head != null) {
            if (head == tail && placa.equalsIgnoreCase(head.getPLACA())) {

                head = tail = null;

            } else if (aux.getPLACA().equalsIgnoreCase(head.getPLACA())) {

                head = head.getNext();

            } else {
                NODOCARRO temporal = new NODOCARRO();
                NODOCARRO anterior = new NODOCARRO();
                anterior = head;
                temporal = head.getNext();
                while (temporal != null && !temporal.getPLACA().equalsIgnoreCase(aux.getPLACA())) {

                    anterior = anterior.getNext();
                    temporal = temporal.getNext();

                }
                if (temporal != null) {
                    anterior.setNext(temporal.getNext());

                    if (temporal == tail) {

                        tail = anterior;

                    }

                }

            }

        }

    }
      
      
      
      
   
      
      
    
}
