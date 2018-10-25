package com.klocke.wordfinder.file;

import org.springframework.web.multipart.MultipartFile;

public interface WordSearchFileReader
{
    /**
     * Read file from local mnachine
     * @param fileLocation
                path of file on local machine
     * @return
     *          two dimensional char array representing a grid of letters
     */
    char[][] readWordSearchFromFile(String fileLocation);

    /**
     * Read file uploaded via web front
     * @param multipartFile
     *      file uploaded
     * @return
     *      two dimensional char array representing a grid of letters
     */
    char[][] readFromInputFile(MultipartFile multipartFile);
}