package com.example.redwardpetclinic.controllers;

import com.example.redwardpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by r.edward on {08/08/2023}
 */
@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    /*multiplicity is for user friendly*/
    @RequestMapping({
            "/vets",
            "/vets/index",
            "/vets/index.html"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        //note we simply inject the model and return the template name
        return "vets/index";
    }
}
