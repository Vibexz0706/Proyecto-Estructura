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


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;



public class Cola {

    private Carro head;
    private Carro tail;

    public Cola(Carro head, Carro tail) {

        this.head = null;
        this.tail = null;
    }

    Cola() {

    }
    public void encolar(String placa, String marca, String modelo, String año, String color, String cilindraje, String combustible, String caácidad, int alquiler, String info) {

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
        
        if (head == null) {

            head = newNodo;
            tail = newNodo;
        } else {

            tail.setNext(newNodo);
            tail = newNodo;

        }
        
        
          try {
            
            FileWriter fw = new FileWriter("notas.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(" ( " + " "+ "PLACA: " + newNodo.getPlaca());
            pw.print(" - " + " "+ "MARCA: " + newNodo.getMarca());
            pw.print(" - " + " "+ "MODELO: " + newNodo.getModelo());
            pw.print(" - " + " "+ "AÑO: " + newNodo.getAño());
            pw.print(" - " + " "+ "COLOR: " + newNodo.getColor());
            pw.print(" - " + " "+ "CILINDRAJE: " + newNodo.getCilindraje());
            pw.print(" - " + " "+ "COMBUSTIBLE: " + newNodo.getCombustible());
            pw.print(" - " + " "+ "CAPACIDAD: " + newNodo.getCapacidad());
            pw.print(" - " + " "+ "PRECIO-AQLUILER: " + newNodo.getAlquiler());
            pw.print(" - " + " "+ "INFOR-EXTRA: " + newNodo.getInfo()+ " ) \n");
            pw.close();
            
        } catch (IOException e) {
            
            System.out.print("sss");
            
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

    public void eliminar(String placa) {

        Carro aux = new Carro();
        aux.setPlaca(placa);
        
        

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

    public void modificar( String b, String marca, String modelo, String año, String color, String cilindraje, String combustible, String caácidad, int alquiler, String info){
        
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
                    
                    

                    encontrado = true;
                
                }
                aux = aux.getNext();
            
            
            }
            
        
        }
        
        
    
       
        
        
        
    
    
    }

}

    
