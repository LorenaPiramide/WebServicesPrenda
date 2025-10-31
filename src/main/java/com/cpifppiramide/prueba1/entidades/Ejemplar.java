package com.cpifppiramide.prueba1.entidades;

public class Ejemplar {

    private Prenda prenda;
    private Color color;
    private Talla talla;
    private Integer stock;

    public Ejemplar(){}

    public Ejemplar(Prenda prenda, Color color, Talla talla, Integer stock) {
        this.prenda = prenda;
        this.color = color;
        this.talla = talla;
        this.stock = stock;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public Color getColor() {
        return color;
    }

    public Talla getTalla() {
        return talla;
    }

    public Integer getStock() {
        return stock;
    }
}
