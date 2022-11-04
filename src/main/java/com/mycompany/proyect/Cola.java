/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect;

import javax.swing.JOptionPane;

/**
 *
 * @author VIBEXZ
 */
public class Cola {

    private Carro head;
    private Carro tail;

    public Cola(Carro head, Carro tail) {

        this.head = null;
        this.tail = null;
    }

    Cola() {

    }

    public void encolar(String placa, String marca, String modelo, String año, String color, String cilindraje, String combustible, String caácidad, int alquiler, String info, String eliminar) {

        Carro newNodo = new Carro();
        newNodo.setPlaca(placa);
        newNodo.setMarca(marca);
        newNodo.setModelo(modelo);
        newNodo.setAño(año);
        newNodo.setColor(color);
        newNodo.setCilindraje(cilindraje);
        newNodo.setCombustible(combustible);
        newNodo.setCapacidad(caácidad);
        newNodo.setAlquiler(alquiler);
        newNodo.setInfo(info);
        newNodo.setEliminar(eliminar);
        if (head == null) {

            head = newNodo;
            tail = newNodo;
        } else {

            tail.setNext(newNodo);
            tail = newNodo;

        }

    }

    public void Mostrar() {

        Carro aux = head;
        aux = head;
        if (head != null) {

            while (aux != null) {

                System.out.print("/" + aux.getPlaca() + "-" + aux.getMarca() + "-" + aux.getModelo() + "-" + aux.getAño() + "-" + aux.getColor() + "-" + aux.getCilindraje() + "-" + aux.getCombustible() + "-" + aux.getCapacidad() + "-" + aux.getAlquiler() + "-" + aux.getInfo() + "-" + aux.getEliminar());

                aux = aux.getNext();

            }

        } else {

            System.out.print("\n la cola esta vacia\n ");

        }

    }

    public void eliminar(String placa, String e) {

        Carro aux = new Carro();
        aux.setPlaca(placa);
        aux.setEliminar(e);
        if ("Alquilado".equalsIgnoreCase(aux.getEliminar())) {
            JOptionPane.showMessageDialog(null, "No se puede elimiar esta alquilado");
           

        } else {

            if (head != null) {
                if (head == tail && placa.equalsIgnoreCase(head.getPlaca())) {

                    head = tail = null;

                } else if (aux.getPlaca().equalsIgnoreCase(head.getPlaca())) {

                    head = head.getNext();

                } else {
                    Carro temporal = new Carro();
                    Carro anterior = new Carro();
                    anterior = head;
                    temporal = head.getNext();
                    while (temporal != null && !temporal.getPlaca().equalsIgnoreCase(aux.getPlaca())) {

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
    
    
    
    public void modificar( String b, String marca, String modelo, String año, String color, String cilindraje, String combustible, String caácidad, int alquiler, String info, String eliminar){
        
        Carro aux = new Carro();
        
        aux = head;
        boolean encontrado = false;
        
        if(head != null){
            
            while(aux != null && encontrado != true){
                
                if(aux.getPlaca().equals(b)){
                    JOptionPane.showMessageDialog(null, "REGISTRO ENCONTRADO");
                    aux.setMarca(marca);
                    aux.setModelo(modelo);
                    aux.setAño(año);
                    aux.setColor(color);
                    aux.setCilindraje(cilindraje);
                    aux.setCombustible(combustible);
                    aux.setCapacidad(caácidad);
                    aux.setAlquiler(alquiler);
                    aux.setInfo(info);
                    aux.setEliminar(eliminar);
                    

                    encontrado = true;
                
                }
                aux = aux.getNext();
            
            
            }
            
        
        }
        
        
    
       
        
        
        
    
    
    }

}
