package com.klocke.wordfinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomePageController
{
    @RequestMapping("/home")
    public String getHome(Model model) {

        System.out.println("GOT HOME");
        model.addAttribute("display", true);

        System.out.println("Model: " + model);
        return "home";
    }

    @RequestMapping("/uploadFile")
    public Boolean uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("word") String word)
    {
        return true;
    }
}
