package com.klocke.wordfinder.file.impl;


import com.klocke.wordfinder.file.WordSearchFileReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultWordSearchFileReader implements WordSearchFileReader
{
    @Override
    public char[][] readWordSearchFromFile(String fileLocation)
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileLocation));
            return readFile(br);

        }
        catch(IOException e){
            //Stuff

        }
        finally {

        }

        return null;
    }

    private void printArray(char[][] returnArray){
        for(int i = 0; i < returnArray.length; i++){
            System.out.println("");
            for(int j = 0; j < returnArray[i].length; j++){
                System.out.print(returnArray[i][j]);
            }
        }

        System.out.println("");
    }

    @Override
    public char[][] readFromInputFile(MultipartFile multipartFile)
    {
        File myFile = new File(multipartFile.getOriginalFilename());

        if(multipartFile != null){
            try
            {
                multipartFile.transferTo(myFile);
                BufferedReader br = new BufferedReader(new FileReader(myFile));
                return readFile(br);
            }
            catch (FileNotFoundException e){
                //handle
            }
            catch(IOException e){

            }
            finally {

            }
        }

        return null;
    }

    private char[][] readFile(BufferedReader br) throws IOException
    {
        String line = br.readLine();
        List<String> allStrings = new ArrayList<>();
        char[][] returnArray = null;

        while(line != null){
            allStrings.add(line);
            line = br.readLine();
        }

        //TODO - handle different sized grids
        if(!allStrings.isEmpty()){
            int xSize = allStrings.get(0).length();
            int ySize = allStrings.size();

            returnArray = new char[xSize][ySize];

            for(int i = 0; i < allStrings.size(); i++){
                for(int j = 0; j < allStrings.get(i).length(); j++){
                    returnArray[i][j] = allStrings.get(i).toCharArray()[j];
                }
            }
        }

        br.close();

        return returnArray;
    }
}
