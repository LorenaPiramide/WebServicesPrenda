package com.cpifppiramide.prueba1.controller;

import com.cpifppiramide.prueba1.dao.DAOFactory;
import com.cpifppiramide.prueba1.entidades.Ejemplar;
import com.cpifppiramide.prueba1.entidades.Prenda;
import com.cpifppiramide.prueba1.entidades.TipoPrenda;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// todo Para poner la ruta del rest controller, hacemos un /api/prendas, y así con todo /api/prendas/{marca}

@Controller
public class PrendaController {

    @GetMapping("/prendas")
    String getPrendas(Model model) {
        List<Prenda> prendas = DAOFactory.getInstance().getDaoPrendas().lista();
        model.addAttribute("prendas", prendas);
        return "prendas";
    }

    @GetMapping("/prendas/{marca}")
    String getEjemplares(@PathVariable String marca, Model model) {
        Prenda prenda = DAOFactory.getInstance().getDaoPrendas().ver(marca);
        //model.addAttribute("prenda", prenda);
        List<Ejemplar> ejemplares = DAOFactory.getInstance().getDaoEjemplares().get(prenda);

        // todo esto es lo que hacía que no me funcionara, creo que hay que dejar model. al final
        prenda.setEjemplares(ejemplares);
        model.addAttribute("prenda", prenda);

        return "ejemplares";
    }

    @GetMapping("/prendas/nueva")
    String crearPrendaForm(Model model) {
//        Se puede hacer así también:
//        List<String> tiposDePrenda = new ArrayList<>();
//        for (TipoPrenda tipo : TipoPrenda.values()){
//            tiposDePrenda.add(tipo.toString());
//        }
//        model.addAttribute("tipos", tiposDePrenda);
        model.addAttribute("tipoPrendas", TipoPrenda.values());
        return "nueva_prenda";
    }

    @PostMapping("/prendas/nueva")
    // Había que poner tipoPrenda como String, yo lo pasaba como TipoPrenda, por eso no iba
    String guardarPrenda(@RequestParam String marca, @RequestParam String tipoPrenda) {
        Prenda prenda = new Prenda(marca, TipoPrenda.valueOf(tipoPrenda));
        DAOFactory.getInstance().getDaoPrendas().inserta(prenda);
        return "redirect:/prendas";
    }

}
