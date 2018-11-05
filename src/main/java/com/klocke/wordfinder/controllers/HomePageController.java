package com.klocke.wordfinder.controllers;

import com.klocke.wordfinder.database.data.WordGrid;
import com.klocke.wordfinder.database.service.WordGridService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HomePageController
{
    @Resource(name = "wordGridService")
    private WordGridService wordGridService;

    @RequestMapping("/home")
    public String getHome(Model model) {

        System.out.println("GOT HOME");
        System.out.println(model);

        List<WordGrid> allGrids = wordGridService.getAllWordGrids();
        System.out.println(allGrids);

        model.addAttribute("allGrids", allGrids);

        return "home";
    }


}
