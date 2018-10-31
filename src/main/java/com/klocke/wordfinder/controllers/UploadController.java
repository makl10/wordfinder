package com.klocke.wordfinder.controllers;

import com.klocke.wordfinder.database.data.WordGrid;
import com.klocke.wordfinder.database.service.WordGridService;
import com.klocke.wordfinder.file.WordSearchFileReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Controller
public class UploadController
{
    @Resource(name = "wordSearchFileReader")
    private WordSearchFileReader wordSearchFileReader;

    @Resource(name = "wordGridService")
    private WordGridService wordGridService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String upload(Model model)
    {
        return "upload";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, RedirectAttributes redirectAttributes)
    {
        System.out.println("File Name:" + file.getName());
        System.out.println("Name: " + name);

        char[][] uploadedTemplate = wordSearchFileReader.readFromInputFile(file);
        WordGrid newGrid = new WordGrid(uploadedTemplate, name);

        //Save in DB
        int savedId = wordGridService.saveWordGrid(newGrid);

        System.out.println("Succesfully saved new grid with id: " + savedId);

        //TODO - pass in word to solve
//        boolean contains = wordSearchSolver.solveForWord(word, uploadedTemplate);
//
//
//        redirectAttributes.addFlashAttribute("message", "You have succesfully uploaded file with name: <b>" +
//                file.getOriginalFilename() + "</b> and the input word: <b>" + word + " </b>");
//
//        if(contains){
//            redirectAttributes.addFlashAttribute("result", "The word: <b>" + word + "</b> is in the grid!");
//        }else{
//            redirectAttributes.addFlashAttribute("result", "The word: <b>" + word + "</b> is NOT in the grid!");
//        }

        return "redirect:/uploadFile";
    }
}
