/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VIBEXZ
 */
public class ListaSimple {

    private NodeCliente head;
    private NodeCliente tail;

    public ListaSimple(NodeCliente head, NodeCliente tail) {
        this.head = head;
        this.tail = tail;
    }

    public ListaSimple() {

    }

    public void insertar(Clientes c) {
        NodeCliente newNodo = new NodeCliente(c);
        if (head == null) {

            head = newNodo;

        } else if (head.getDatos().getCedula() > newNodo.getDatos().getCedula()) {
            newNodo.setNext(head);
            head = newNodo;

        } else if (head.getDatos().getCedula() < newNodo.getDatos().getCedula() && head.getNext() == null) {
            head.setNext(newNodo);

        } else {

            NodeCliente aux = head;
            while (aux.getNext() != null && aux.getNext().getDatos().getCedula() < newNodo.getDatos().getCedula()) {
                aux = aux.getNext();

            }
            newNodo.setNext(aux.getNext());
            aux.setNext(newNodo);

        }

    }

    public void imprimirLista() {
        NodeCliente aux = head;
        while (aux != null) {

            System.out.print(" " + String.valueOf(aux.getDatos().getCedula()) + "-" + aux.getDatos().getNombre() + "-" + aux.getDatos().getFechaNacimiento() + "-" + aux.getDatos().getCorreo() + "-" + String.valueOf(aux.getDatos().getCate())+"\n");
            AgrerCli i = new AgrerCli();

            aux = aux.getNext();

        }

    }

    private void modificar(Clientes c) {
        
        NodeCliente actual = new NodeCliente(c);
        actual = head;
        boolean encontrado = false;

        int buscar = c.getCedula();

        if (head != null) {
            while (actual != null) {
                if (actual.getDatos().getCedula() == buscar) {
                    encontrado = true;
                    System.out.print("nodo encontrado");
                    actual.getDatos().setNombre(c.getNombre());
                    actual.getDatos().setFechaNacimiento(c.getFechaNacimiento());
                    actual.getDatos().setNombre(c.getCorreo());

                    actual.getDatos().setCate(c.getCate());
                    System.out.print(c.getNombre());
                }
                actual = actual.getNext();
            }
            System.out.print("NO ENTRA");

        }

    }

   

    public void eliminar(int id) {

        if (head != null) {
            if (head.getDatos().getCedula() == id) {
                head = head.getNext();
            } else {
                NodeCliente aux = head;

                while (aux.getNext() != null && aux.getNext().getDatos().getCedula() < id) {
                    aux = aux.getNext();
                }

                if (aux.getNext() != null && aux.getNext().getDatos().getCedula() == id) {
                    aux.setNext(aux.getNext().getNext());
                }
            }

        }

    }

    public void f(int a, int h) {

        NodeCliente actual = new NodeCliente();
        
        actual = head;
        boolean encontrado = false;

        if (head != null) {
            while (actual != null) {
                if (actual.getDatos().getCedula() == h) {
                    encontrado = true;
                    System.out.print("nodo encontrado");
                    if (a > 30) {
                        System.out.print("entro deberia de subir rango");
                        actual.getDatos().setCate(actual.getDatos().getCate()+1);

                    }

                }
                actual = actual.getNext();
            }
            System.out.print("NO ENTRA");

        }

    }

}
