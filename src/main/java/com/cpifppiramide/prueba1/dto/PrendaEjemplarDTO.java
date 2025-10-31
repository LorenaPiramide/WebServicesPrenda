package com.cpifppiramide.prueba1.dto;

import com.cpifppiramide.prueba1.entidades.Color;
import com.cpifppiramide.prueba1.entidades.Talla;

public class PrendaEjemplarDTO {
    private String marca;
    private Color color;
    private Talla talla;
    private Integer stock;

    public PrendaEjemplarDTO(String marca, Color color, Talla talla, Integer stock) {
        this.marca = marca;
        this.color = color;
        this.talla = talla;
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
