package com.klocke.wordfinder.database.service;

import com.klocke.wordfinder.database.data.WordGrid;

import java.util.List;

public interface WordGridService
{
    WordGrid retriveWordGridById(int id);

    int saveWordGrid(WordGrid grid);

    List<WordGrid> getAllWordGrids();
}
