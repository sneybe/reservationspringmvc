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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Hotel;
import reservation.service.HotelCrudService;

/**
 *
 * @author formation
 *
 *
 */
@Controller
@RequestMapping(value="/hotel",method=RequestMethod.Get)
public class HotelController {

    @Autowired
    private HotelCrudService hcs;

    @RequestMapping(value = "/supprimer/{idhotel}", method = RequestMethod.GET)
    public String supprimer(@PathVariable(value = "idhotel") long id) {
        this.hcs.delete(id);

        return "redirect:/hotel/lister";
    }

    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public String listHotel(Model model) {
        List<Hotel> hotels = (List<Hotel>) hcs.findAll();
        model.addAttribute("listeHotels", hotels);
        return "hotel/lister.jsp";

    }

}
