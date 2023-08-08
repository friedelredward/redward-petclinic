package com.example.redwardpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by r.edward on {08/08/2023}
 */
@Controller
public class IndexController {

    @RequestMapping({"",
            "/",
            "index",
            "index.html"})
    public String index(){
        return "index";
    }
}
