package com.cpifppiramide.prueba1.dao.prendas;

import com.cpifppiramide.prueba1.entidades.Prenda;

import java.util.List;

public interface DAOPrendas {

    //debemos rellenar todos los campos de las prendas obtenidas. No es necesario cargar los ejemplares de la prenda pero sí que debo rellenar con un nº el listado de ejemplares
    public List<Prenda> lista();
    public Prenda ver(String marca);
    public void inserta(Prenda prenda);

}
