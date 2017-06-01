/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Utilisateur;
import reservation.service.UtilisateurServiceCrud;

/**
 *
 * @author formation
 */
@Controller
public class UtilisateurController {

    @Autowired
    private UtilisateurServiceCrud usc;

    @RequestMapping(value = "/identification", method = RequestMethod.POST)
    public String identificationPOST(@ModelAttribute("util") Utilisateur dto,  HttpSession session) {

        // Renvoie vers écran connexion si util existe pas
        Utilisateur u = usc.findByMotDePasseAndIdentifiants(dto.getMotDePasse(), dto.getIdentifiants());
        if (u == null)
            return "redirect:/identification";

        // Util existe
        
        // Le met en session
        session.setAttribute("utilisateurConnecte", true);
        session.setAttribute("typeUtilConnecte", u.getTypeUtil().toString());

        return "redirect:/hotel/lister";

        // Redirection vers liste hotels
    }

    @RequestMapping(value = "/identification", method = RequestMethod.GET)
    public String identificationGET(Model model) {

        model.addAttribute("util", new Utilisateur());
        return "/identification.jsp";
    }

    @RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
    public String deconnexion(HttpSession session) {

        session.invalidate();
        return "redirect:/identification";

    }

}
