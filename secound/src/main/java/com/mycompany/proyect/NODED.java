/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect;

/**
 *
 * @author VIBEXZ
 */
public class NODED {
    
    private ALQUILER datos;
    private NODED next;
    private NODED back;

    public NODED(ALQUILER datos) {
        this.datos = datos;
    }

    public ALQUILER getDatos() {
        return datos;
    }

    public void setDatos(ALQUILER datos) {
        this.datos = datos;
    }

    public NODED getNext() {
        return next;
    }

    public void setNext(NODED next) {
        this.next = next;
    }

    public NODED getBack() {
        return back;
    }

    public void setBack(NODED back) {
        this.back = back;
    }
    
    
    
    
}
