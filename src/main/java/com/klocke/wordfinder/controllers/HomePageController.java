package com.klocke.wordfinder.controllers;

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
public class HomePageController
{
    @Resource(name = "wordSearchFileReader")
    private WordSearchFileReader wordSearchFileReader;

    @RequestMapping("/home")
    public String getHome(Model model) {

        System.out.println("GOT HOME");
        System.out.println(model);


        return "home";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("word") String word, RedirectAttributes redirectAttributes)
    {
        System.out.println("File Name:" + file.getName());
        System.out.println("Word: " + word);

        char[][] uploadedTemplate = wordSearchFileReader.readFromInputFile(file);
        System.out.println(uploadedTemplate);

        redirectAttributes.addFlashAttribute("message", "You have succesfully uploaded file with name: <b>" +
                file.getOriginalFilename() + "</b> and the input word: <b>" + word + " </b>");

        return "redirect:/home";
    }
}


/*
    USAGE:

    public static void main(String[] args)
    {
        final String word = "RAIN";

        WordSearchFileReader reader = new DefaultWordSearchFileReader();
        char[][] test = reader.readWordSearchFromFile("test.txt");

        boolean matches = new HashMapWordSearchSolver().solveForWord(word, test);
        System.err.println("MATCHES: " + matches);
    }

 */