package com.example.redwardpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by r.edward on {08/08/2023}
 */
@Controller
public class VetController {
/*multiplicity is for user friendly*/
    @RequestMapping({
            "/vets",
            "/vets/index",
            "/vets/index.html"})
    public String listVets(){
        return "vets/index";
    }
}
