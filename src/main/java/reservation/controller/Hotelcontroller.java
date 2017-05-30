/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Hotel;
import reservation.service.HotelServiceCrud;

/**
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/hotel")
public class Hotelcontroller {

    @Autowired
    private HotelServiceCrud hcs;

    @RequestMapping(value = "/supprimer/{idhotel}")
    public String supprimer(@PathVariable(value = "idhotel") long id) {
        this.hcs.delete(id);

        return "redirect:/hotel/lister";
    }

    @RequestMapping(value = "/lister")
    public String listHotel(Model model) {
        List<Hotel> hotels = (List<Hotel>) hcs.findAll();
        model.addAttribute("listeHotels", hotels);
        return "hotel/lister.jsp";
    }

    @RequestMapping(value = "/modifier/{idhotel}")
    public String modifier(Model model, @PathVariable(value = "idhotel") long id) {
        Hotel h = hcs.findOne(id);
        model.addAttribute("hotel", h);
        return "/hotel/modifier.jsp";

    }

    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public String modifierPost(@ModelAttribute("hotels") Hotel hotel) {
        hcs.save(hotel);
        return "redirect:/hotel/lister";
    }

    @RequestMapping(value = "/ajouter")
    public String ajouter(Model model) {
        Hotel hotel = new Hotel();
        model.addAttribute("hotels", hotel);

        return "/hotel/ajouter.jsp";

    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public String ajouterPost(@ModelAttribute(value = "hotels") Hotel hotel) {
        hcs.save(hotel);
        return "redirect:/hotel/lister";
    }
}
