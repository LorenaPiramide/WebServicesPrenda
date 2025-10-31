package com.cpifppiramide.prueba1.dao.ejemplares;

import com.cpifppiramide.prueba1.entidades.Ejemplar;
import com.cpifppiramide.prueba1.entidades.Prenda;

import java.util.List;

public interface DAOEjemplares {

    public List<Ejemplar> get(Prenda prenda);
    public void inserta(Ejemplar ejemplar);

}
