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
import reservation.entity.Client;
import reservation.service.ClientServiceCrud;

/**
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    private ClientServiceCrud clsc;
    
    @RequestMapping(value = "/lister",method = RequestMethod.GET)
    public String lister(Model model){
      List<Client> client= (List<Client>) clsc.findAll();
      model.addAttribute("monclient", client);
      
      return "/client/lister.jsp";
      
      
    }
    @RequestMapping(value = "/ajouter",method = RequestMethod.GET)
    public String ajouter(Model model){
       Client cl = new Client();
       model.addAttribute("client", cl);
       
       return "/client/ajouter.jsp";
    }
   
    @RequestMapping(value = "/ajouter",method = RequestMethod.POST)
    public String ajouterPost(@ModelAttribute(value = "client")Client client){
        clsc.save(client);
        return "redirect:/client/lister";
    }
    
    @RequestMapping(value = "/supprimer/{client}",method = RequestMethod.GET)
    public String supprimer(@PathVariable(value = "client")Long id){
        
        clsc.delete(id);
        return"redirect:/client/lister";
        
    }
    @RequestMapping(value = "/modifier/{client}",method = RequestMethod.GET)
    public String modifier(Model model ,@PathVariable(value = "client")long id){
        Client client = clsc.findOne(id);
        model.addAttribute("monclient", client);
        
        return "/client/modifier.jsp";
    }
    @RequestMapping(value = "/modifier",method = RequestMethod.POST)
    public String modifierPost(@ModelAttribute(value = "monclient")Client client ){
        clsc.save(client);
        return"redirect:/client/lister";
    }
}


