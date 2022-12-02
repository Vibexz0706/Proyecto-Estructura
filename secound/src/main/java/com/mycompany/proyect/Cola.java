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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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

            FileWriter fw = new FileWriter("carros.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(newNodo.getPlaca());
            pw.print("-" + newNodo.getMarca());
            pw.print("-" + newNodo.getModelo());
            pw.print("-" + newNodo.getAño());
            pw.print("-" + newNodo.getColor());
            pw.print("-" + newNodo.getCilindraje());
            pw.print("-" + newNodo.getCombustible());
            pw.print("-" + newNodo.getCapacidad());
            pw.print("-" + newNodo.getAlquiler());
            pw.print("-" + newNodo.getInfo() + "\n");
            pw.close();

        } catch (IOException e) {

            System.out.print("sss");
        }

    }

    public void llenarCola() {
        Carro newNodo = new Carro();

        String linea = "";

        String delimitante = "\n";
        FileReader fw;
        BufferedReader bw;
        try {
            //File file = new File("carros.txt");
            fw = new FileReader("carros.txt");
            bw = new BufferedReader(fw);
            String l = "";
            while ((linea = bw.readLine()) != null) {
                l += linea + "\n";

            }

            String[] campo = l.split(delimitante);
            String Carros[][] = new String[campo.length][10];
            for (int i = 0; i < campo.length; i++) {

                String[] carro = campo[i].split("-");

                for (int b = 0; b < 10; b++) {
                    Carros[i][b] = carro[b];

                }

                Carro aux = new Carro();
                aux.setPlaca(Carros[i][0]);
                aux.setMarca(Carros[i][1]);
                aux.setModelo(Carros[i][2]);
                aux.setAño(Carros[i][3]);
                aux.setColor(Carros[i][4]);
                aux.setCilindraje(Carros[i][5]);
                aux.setCombustible(Carros[i][6]);
                aux.setCapacidad(Carros[i][7]);
                //newNodo.setAlquiler(Integer.parseInt(Carros[i][8]));
                aux.setInfo(Carros[i][9]);

                if (head == null) {

                    head = aux;
                    tail = aux;

                } else {

                    tail.setNext(aux);
                    tail = aux;

                }

            }

        } catch (FileNotFoundException e) {
            System.out.print("ERROR" + e.getMessage());

        } catch (IOException ex) {
            Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    

    public void Mostrar() {
        consu n = new consu();
        Carro aux = head;
        aux = head;
        if (head != null) {

            while (aux != null) {

                System.out.print("(" + aux.getPlaca() + "-" + aux.getMarca() + "-" + aux.getModelo() + "-" + aux.getAño() + "-" + aux.getColor() + "-" + aux.getCilindraje() + "-" + aux.getCombustible() + "-" + aux.getCapacidad() + "-" + aux.getAlquiler() + "-" + aux.getInfo() + ")");
                
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

    public void modificar(String b, String marca, String modelo, String año, String color, String cilindraje, String combustible, String caácidad, int alquiler, String info) {

        Carro aux = new Carro();

        aux = head;
        boolean encontrado = false;

        if (head != null) {

            while (aux != null && encontrado != true) {

                if (aux.getPlaca().equals(b)) {
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
    
    
      public void verificar(String b, String marca) {
        
        Carro aux = new Carro();

        aux = head;
        boolean encontrado = false;

        if (head != null) {

            while (aux != null && encontrado != true) {

                if (aux.getPlaca().equals(b) && aux.getMarca().equalsIgnoreCase(marca)) {
                    JOptionPane.showMessageDialog(null, "REGISTRO ENCONTRADO, SE ASIGNO AL CLIENTE");
                    
                    encontrado = true;

                }
                aux = aux.getNext();

            }

        }
        

    }
      
   
    
    
}



