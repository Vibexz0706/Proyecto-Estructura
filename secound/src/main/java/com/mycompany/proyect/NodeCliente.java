/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect;

/**
 *
 * @author VIBEXZ
 */
public class NodeCliente {
    
    private Clientes datos;
    private NodeCliente next;
    private NodeCliente back;
    
    public String toString(){
        return "NodeCliente{" + "datos=" + datos + '}';
    }

    public NodeCliente(Clientes datos) {
        this.datos = datos;
    }
     public NodeCliente() {
        
    }

    public Clientes getDatos() {
        return datos;
    }

    public void setDatos(Clientes datos) {
        this.datos = datos;
    }

    public NodeCliente getNext() {
        return next;
    }

    public void setNext(NodeCliente next) {
        this.next = next;
    }

    public NodeCliente getBack() {
        return back;
    }

    public void setBack(NodeCliente back) {
        this.back = back;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
