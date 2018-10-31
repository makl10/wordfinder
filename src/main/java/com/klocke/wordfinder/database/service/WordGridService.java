package com.klocke.wordfinder.database.service;

import com.klocke.wordfinder.database.data.WordGrid;

public interface WordGridService
{
    WordGrid retriveWordGridById(int id);

    int saveWordGrid(WordGrid grid);
}
