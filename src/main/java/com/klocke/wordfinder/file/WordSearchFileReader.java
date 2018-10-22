package com.klocke.wordfinder.file;

import org.springframework.web.multipart.MultipartFile;

public interface WordSearchFileReader
{
    char[][] readWordSearchFromFile(String fileLocation);

    char[][] readFromInputFile(MultipartFile file);
}