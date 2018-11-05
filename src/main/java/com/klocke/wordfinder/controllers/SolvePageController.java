package com.klocke.wordfinder.controllers;

import com.klocke.wordfinder.database.data.WordGrid;
import com.klocke.wordfinder.database.service.WordGridService;
import com.klocke.wordfinder.solver.WordSearchSolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SolvePageController
{
    @Resource(name = "wordGridService")
    private WordGridService wordGridService;

    @Resource(name = "wordSearchSolver")
    private WordSearchSolver wordSearchSolver;

    @RequestMapping(value = "/solve", method = RequestMethod.GET)
    public String upload(Model model)
    {
        List<WordGrid> allGrids = wordGridService.getAllWordGrids();
        model.addAttribute("allGrids", allGrids);

        return "solvePage";
    }

    @RequestMapping(value = "/solve", method = RequestMethod.POST)
    public String uploadPost(Model model, RedirectAttributes redirectAttributes,
                             @RequestParam(name = "word") String wordToCheck, @RequestParam(name = "id") int id)
    {
        WordGrid wordGrid = wordGridService.retriveWordGridById(id);
        if(wordGrid != null)
        {
            boolean contains = wordSearchSolver.solveForWord(wordToCheck, wordGrid.getCharacterGrid());

            if(contains){
                redirectAttributes.addFlashAttribute("result", "The word: <b>" + wordToCheck + "</b> is in the grid: " + wordGrid.getName());
            }else{
                redirectAttributes.addFlashAttribute("result", "The word: <b>" + wordToCheck + "</b> is NOT in the grid: " + wordGrid.getName());
            }
        }

        return "redirect:/solve";
    }
}
