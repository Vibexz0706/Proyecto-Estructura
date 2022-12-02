/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect;

/**
 *
 * @author VIBEXZ
 */
public class Clientes {
    
    private int cedula;
    private String nombre;
    private String fechaNacimiento;
    private String correo;
    private int cate;

    public Clientes(int cedula, String nombre, String fechaNacimiento, String correo, int cate) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.cate = cate;
    }

  
   
 public Clientes() {
        
     
    }

    public int getCate() {
        return cate;
    }

    public void setCate(int cate) {
        this.cate = cate;
    }

    

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

   
 
   
    public String toString(){
        return "Clientes{" + "cedula=" + cedula + '}';
    }
    
    
    
    
    
    
    
    
}
