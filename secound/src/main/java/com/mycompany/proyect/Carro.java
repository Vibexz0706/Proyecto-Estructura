/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyect;

/**
 *
 * @author VIBEXZ
 */
public class Carro {

    private String placa;
    private String marca;
    private String modelo;
    private String año;
    private String color;
    private String cilindraje;
    private String combustible;
    private String capacidad;
    private int alquiler;
    private String info;
    private Carro  next;
    private String eliminar;

    public Carro(String placa, String marca, String modelo, String año, String color, String cilindraje, String combustible, String capacidad, int alquiler, String info, Carro next,String eliminar) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.cilindraje = cilindraje;
        this.combustible = combustible;
        this.capacidad = capacidad;
        this.alquiler = alquiler;
        this.info = info;
        this.next = null;
        this.eliminar = eliminar;
    }

    public String getEliminar() {
        return eliminar;
    }

    public void setEliminar(String eliminar) {
        this.eliminar = eliminar;
    }

   

    

    public Carro() {

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public int getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Carro getNext() {
        return next;
    }

    public void setNext(Carro next) {
        this.next = next;
    }

    @Override
    public String toString() {

        return "Carro{" + "placa=" + placa + ",marca=" + marca + '}';

    }

}