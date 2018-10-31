package com.klocke.wordfinder.controllers;

import com.klocke.wordfinder.database.data.WordGrid;
import com.klocke.wordfinder.database.service.WordGridService;
import com.klocke.wordfinder.file.WordSearchFileReader;
import com.klocke.wordfinder.solver.WordSearchSolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HomePageController
{
//    @Resource(name = "wordSearchSolver")
//    private WordSearchSolver wordSearchSolver;

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
