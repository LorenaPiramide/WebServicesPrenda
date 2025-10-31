package com.cpifppiramide.prueba1.rest;

import com.cpifppiramide.prueba1.dao.DAOFactory;
import com.cpifppiramide.prueba1.entidades.Ejemplar;
import com.cpifppiramide.prueba1.entidades.Prenda;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrendasRestController {
    @GetMapping("/api/prendas")
    List<Prenda> getPrendas() {
        List<Prenda> prendas = DAOFactory.getInstance().getDaoPrendas().lista();
        return prendas;
    }

    @GetMapping("/api/prendas/{marca}")
    Prenda getPrendasMarca(@PathVariable String marca) {
        Prenda prenda = DAOFactory.getInstance().getDaoPrendas().ver(marca);
        List<Ejemplar> ejemplares = DAOFactory.getInstance().getDaoEjemplares().get(prenda);
        prenda.setEjemplares(ejemplares);
        return prenda;
    }
}
