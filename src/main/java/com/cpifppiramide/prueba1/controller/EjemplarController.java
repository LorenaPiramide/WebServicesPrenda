package com.cpifppiramide.prueba1.controller;

import com.cpifppiramide.prueba1.dao.DAOFactory;
import com.cpifppiramide.prueba1.entidades.Color;
import com.cpifppiramide.prueba1.entidades.Ejemplar;
import com.cpifppiramide.prueba1.entidades.Prenda;
import com.cpifppiramide.prueba1.entidades.Talla;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EjemplarController {
    @GetMapping("/ejemplares/nuevo")
    String nuevo(Model model) {
        List<Prenda> prendas = DAOFactory.getInstance().getDaoPrendas().lista();
        List<String> colores = new ArrayList<>();
        List<String> tallas = new ArrayList<>();

        for (Color color : Color.values()) {
            colores.add(color.toString());
        }

        for (Talla talla : Talla.values()) {
            tallas.add(talla.toString());
        }

        model.addAttribute("prendas", prendas);
        model.addAttribute("colores", colores);
        model.addAttribute("tallas", tallas);

        return "nuevo_ejemplar";
    }

    @PostMapping("/ejemplares/nuevo")
    public String guardar(
            @RequestParam String prenda,
            @RequestParam String color,
            @RequestParam String talla,
            @RequestParam int stock
    ) {
        Prenda prendaElegida = DAOFactory.getInstance().getDaoPrendas().ver(prenda);
        Color colorEnum = Color.valueOf(color);
        Talla tallaEnum = Talla.valueOf(talla);

        Ejemplar ejemplar = new Ejemplar(prendaElegida, colorEnum, tallaEnum, stock);
        DAOFactory.getInstance().getDaoEjemplares().inserta(ejemplar);
        return "redirect:/prendas/" + prenda;
    }
}
