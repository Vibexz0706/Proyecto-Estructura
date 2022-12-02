/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect;

/**
 *
 * @author VIBEXZ
 */
public class LISTADOBLE {

    private NODED head;
    private NODED tail;

    public LISTADOBLE(NODED head, NODED tail) {
        this.head = head;
        this.tail = tail;
    }

    public LISTADOBLE() {
        ;
    }

    public void agregar(ALQUILER c) {

        if (head == null) {
            head = new NODED(c);
            tail = head;
            tail.setNext(head);
            head.setBack(tail);

        } else if (c.getId() < head.getDatos().getId()) {
            NODED aux = new NODED(c);
            aux.setNext(head);
            head = aux;
            tail.setNext(head);
            head.setBack(tail);

        } else if (tail.getDatos().getId() <= c.getId()) {

            tail.setNext(new NODED(c));
            tail = tail.getNext();
            tail.setNext(head);
            head.setBack(tail);

        } else {
            NODED aux = head;

            while (aux.getDatos().getId() < c.getId()) {
                aux = aux.getNext();
            }
            NODED tem = new NODED(c);
            tem.setNext(aux.getNext());
            tem.setBack(aux);
            aux.setNext(tem);
            tem.getNext().setBack(tem);
        }

    }

    public void mostrar() {

        NODED aux = head;
        if (head != null) {

            do {
                System.out.println(aux.getDatos().getId() + "" + aux.getDatos().getDias() + "" + aux.getDatos().getMarca() + "" + aux.getDatos().getPasajeros() + "" + aux.getDatos().getExtras());
                aux = aux.getNext();

            } while (aux != head);

        }

    }

}
