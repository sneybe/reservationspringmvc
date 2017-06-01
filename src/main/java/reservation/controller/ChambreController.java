/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Chambre;
import reservation.entity.Hotel;
import reservation.service.ChambreServiceCrud;
import reservation.service.HotelServiceCrud;

/**
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/chambre")
public class ChambreController {

    @Autowired
    private ChambreServiceCrud csc;
    @Autowired
    private HotelServiceCrud hsc;

    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public String listerchambre(Model model) {

        List<Chambre> chambre = new ArrayList<>();

        model.addAttribute("chambres", csc.findAll());

        return "/chambre/lister.jsp";
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.GET)
    public String ajouterchambre(Model model) {
        Chambre chambre = new Chambre();
        model.addAttribute("chambres", chambre);
        model.addAttribute("hotel", hsc.findAll());
        return "/chambre/ajouter_chambre.jsp";

    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String ajouterPost(@ModelAttribute(value = "chambres") Chambre chambre) {
        

        csc.save(chambre);

        return "redirect:/chambre/lister";
    }
    
    @RequestMapping(value = "/supprimer/{idchambre}",method = RequestMethod.GET)
    public String supprimer(@PathVariable(value = "idchambre")long id){
         this.csc.delete(id);
         
         return "redirect:/chambre/lister";
    }
    @RequestMapping(value = "/modifier/{idchambre}",method = RequestMethod.GET)
    public String modifier(Model model ,@PathVariable(value ="idchambre")long id){
        Chambre chambre=csc.findOne(id);
        model.addAttribute("chamb", chambre);
        
        return "/chambre/modifier.jsp";
    }
    @RequestMapping(value = "/modifier",method = RequestMethod.POST)
    public String modifierPost(@ModelAttribute(value = "chambres")Chambre chambre){
        
        this.csc.save(chambre);
        
        return "redirect:/chambre/lister";
    }

}
