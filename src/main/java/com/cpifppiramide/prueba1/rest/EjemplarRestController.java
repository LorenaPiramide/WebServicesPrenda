package com.cpifppiramide.prueba1.rest;

import com.cpifppiramide.prueba1.dao.DAOFactory;
import com.cpifppiramide.prueba1.dto.PrendaEjemplarDTO;
import com.cpifppiramide.prueba1.entidades.Color;
import com.cpifppiramide.prueba1.entidades.Ejemplar;
import com.cpifppiramide.prueba1.entidades.Prenda;
import com.cpifppiramide.prueba1.entidades.Talla;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EjemplarRestController {

    // Ejemplo básico
//    @PostMapping("/")
//    Usuario insertar(@RequestBody Usuario usuario) {
//        usuarios.add(usuario);
//        return usuario;
//    }

    @PostMapping("/api/ejemplares/nuevo")
    @ResponseBody
    Ejemplar insertar(@RequestBody PrendaEjemplarDTO prendaEjemplarDTO) {
        Prenda prendaElegida = DAOFactory.getInstance().getDaoPrendas().ver(prenda);
        Color colorEnum = Color.valueOf(color);
        Talla tallaEnum = Talla.valueOf(talla);

        Ejemplar ejemplar = new Ejemplar(prendaElegida, colorEnum, tallaEnum, stock);
        DAOFactory.getInstance().getDaoEjemplares().inserta(ejemplar);
        return ejemplar;
    }

}
