package com.klocke.wordfinder.controllers;

import com.klocke.wordfinder.database.data.WordGrid;
import com.klocke.wordfinder.database.service.WordGridService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/rest")
public class RestController
{
    @Resource(name = "wordGridService")
    private WordGridService wordGridService;

    @RequestMapping(value = "/allGrids", produces = "application/json")
    @ResponseBody
    public List<WordGrid> getAllGridsJSON()
//    public Map<Integer, WordGrid>getAllGridsJSON()
    {
        Map<Integer, WordGrid> test = new HashMap<>();
        List<WordGrid> myList = wordGridService.getAllWordGrids();

        myList.stream().forEach(wordgrid -> test.put(wordgrid.getId(), wordgrid));


        return wordGridService.getAllWordGrids();
//        return test;
    }
}
