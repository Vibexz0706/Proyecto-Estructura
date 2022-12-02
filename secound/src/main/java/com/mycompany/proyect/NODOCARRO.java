/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect;

/**
 *
 * @author Vibexz
 */
public class NODOCARRO {

    private String PLACA;
    private String cilindraje;
    private String marca;
    private String combustion;
    private String modelo;
    private int capacidad;
    private int ano;
    private int alquiler;
    private String color;
    private String extras;
    private NODOCARRO next;

    public NODOCARRO(String PLACA, String cilindraje, String marca, String combustion, String modelo, int capacidad, int ano, int alquiler, String color, String extras) {
        this.PLACA = PLACA;
        this.cilindraje = cilindraje;
        this.marca = marca;
        this.combustion = combustion;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.ano = ano;
        this.alquiler = alquiler;
        this.color = color;
        this.extras = extras;
    }

    
    
    public NODOCARRO() {
        
    }

    

    public String getPLACA() {
        return PLACA;
    }

    public void setPLACA(String PLACA) {
        this.PLACA = PLACA;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCombustion() {
        return combustion;
    }

    public void setCombustion(String combustion) {
        this.combustion = combustion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public NODOCARRO getNext() {
        return next;
    }

    public void setNext(NODOCARRO next) {
        this.next = next;
    }

  

}
