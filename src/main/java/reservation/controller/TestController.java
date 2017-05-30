/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/test", method = RequestMethod.GET)
public class TestController {

    @RequestMapping(value = "/hello/{numSerie]")
    public String helloter(@PathVariable("numSerie") long num) {

        System.out.println("***" + num);

        return "nada.jsp";
    }

}
