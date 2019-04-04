package com.klocke.wordfinder.solver.impl;



import com.klocke.wordfinder.application.DIRECTION;
import com.klocke.wordfinder.solver.WordSearchSolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapWordSearchSolver implements WordSearchSolver
{
    @Override
    public boolean solveForWord(String word, char[][] letterField)
    {
        return hashmapSolve(word.toCharArray(), letterField);
    }

    private boolean hashmapSolve(char[] word, char[][] letterfield)
    {
        Map<Pair<Integer, Integer>, Character> valueMap = new HashMap<>();

        for(int i = 0; i < letterfield.length; i++){
            for(int j = 0; j < letterfield[i].length; j++){
                valueMap.put(new Pair<>(j, i), letterfield[i][j]);
            }
        }

        int wordCounter = 0;
        List<Pair<Integer, Integer>> matches = new ArrayList<>();

        //Check the first letter against all matches
        for(Map.Entry<Pair<Integer, Integer>, Character> entry : valueMap.entrySet()){
            if(entry.getValue() == word[wordCounter]){
                matches.add(entry.getKey());
            }
        }

        return matchOnEntrySet(word, 0, matches, valueMap);


    }

    private boolean matchOnEntrySet(char[] word, int wordCounter, List<Pair<Integer, Integer>> matches, Map<Pair<Integer, Integer>, Character> valueMap){

        //Current character - initial determination of matches
        Character c = word[1];
        boolean actuallyContains = false;
        for(Pair<Integer, Integer> match : matches)
        {
            int x = match.getKey();
            int y = match.getValue();

            for(DIRECTION direction : DIRECTION.values()){
                if(!actuallyContains){
                    actuallyContains = solveWithDirection(direction, word, 1, x, y, valueMap);
                }
            }
        }

        return actuallyContains;
    }

    private boolean solveWithDirection(DIRECTION direction, char[] word, int wordCounter, int x, int y, Map<Pair<Integer, Integer>, Character> valueMap){

        boolean matched = false;
        Pair<Integer, Integer> key = null;
        int newX;
        int newY;
        switch (direction){
            //NORTH_WEST (x - 1, y - 1)
            // x--
            // y--
            case NORTH_WEST:
                newX = x - 1;
                newY = y - 1;
                key = new Pair<>(newX, newY);
                while(valueMap.containsKey(key) && wordCounter < word.length){
                    if(valueMap.get(key) == word[wordCounter]){
                        newX--;
                        newY--;

                        key = new Pair<>(newX, newY);
                        wordCounter++;
                        matched = true;
                    }
                    else
                    {
                        return false;
                    }
                }

                return matched;

            // NORTH (x, y - 1)
            // x = x
            // y--
            case NORTH:
                newX = x;
                newY = y - 1;
                key = new Pair<>(newX, newY);
                while(valueMap.containsKey(key) && wordCounter < word.length){
                    if(valueMap.get(key) == word[wordCounter]){
                        newX = x;
                        newY--;

                        key = new Pair<>(newX, newY);
                        wordCounter++;
                        matched = true;
                    }
                    else
                    {
                        return false;
                    }
                }

                return matched;

            //NORTH_EAST (x + 1, y - 1)
            //x++
            //y--
            case NORTH_EAST:
                newX = x + 1;
                newY = y - 1;
                key = new Pair<>(newX, newY);
                while(valueMap.containsKey(key) && wordCounter < word.length){
                    if(valueMap.get(key) == word[wordCounter]){
                        newX++;
                        newY--;

                        key = new Pair<>(newX, newY);
                        wordCounter++;
                        matched = true;
                    }
                    else
                    {
                        return false;
                    }
                }

                return matched;

            //EAST (x + 1, y)
            //x++
            //y
            case EAST:
                newX = x + 1;
                newY = y;
                key = new Pair<>(newX, newY);
                while(valueMap.containsKey(key) && wordCounter < word.length){
                    if(valueMap.get(key) == word[wordCounter]){
                        newX++;
                        newY = y;

                        key = new Pair<>(newX, newY);
                        wordCounter++;
                        matched = true;
                    }
                    else
                    {
                        return false;
                    }
                }

                return matched;

            //SOUTH_EAST (x + 1, y + 1)
            //x++
            //y++
            case SOUTH_EAST:
                newX = x + 1;
                newY = y + 1;
                key = new Pair<>(newX, newY);
                while(valueMap.containsKey(key) && wordCounter < word.length){
                    if(valueMap.get(key) == word[wordCounter]){
                        newX++;
                        newY++;

                        key = new Pair<>(newX, newY);
                        wordCounter++;
                        matched = true;
                    }
                    else
                    {
                        return false;
                    }
                }

                return matched;

            //SOUTH (x, y + 1)
            //x = x
            //y++
            case SOUTH:
                newX = x;
                newY = y + 1;
                key = new Pair<>(newX, newY);
                while(valueMap.containsKey(key) && wordCounter < word.length){
                    if(valueMap.get(key) == word[wordCounter]){
                        newX = x;
                        newY++;

                        key = new Pair<>(newX, newY);
                        wordCounter++;
                        matched = true;
                    }
                    else
                    {
                        return false;
                    }
                }

                return matched;

            //SOUTH_WEST (x - 1, y + 1)
            //x--
            //y++
            case SOUTH_WEST:
                newX = x - 1;
                newY = y + 1;
                key = new Pair<>(newX, newY);
                while(valueMap.containsKey(key) && wordCounter < word.length){
                    if(valueMap.get(key) == word[wordCounter]){
                        newX--;
                        newY++;

                        key = new Pair<>(newX, newY);
                        wordCounter++;
                        matched = true;
                    }
                    else
                    {
                        return false;
                    }
                }

                return matched;

            //WEST (x - 1, y)
            //x--
            //y = y
            case WEST:
                newX = x - 1;
                newY = y;
                key = new Pair<>(newX, newY);
                while(valueMap.containsKey(key) && wordCounter < word.length){
                    if(valueMap.get(key) == word[wordCounter]){
                        newX--;
                        newY = y;

                        key = new Pair<>(newX, newY);
                        wordCounter++;
                        matched = true;
                    }
                    else
                    {
                        return false;
                    }
                }

                return matched;

        }


        return matched;
    }
}


class Pair<T, Y>
{
    private T key;
    private Y value;

    public Pair(T key, Y value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Y getValue() {
        return value;
    }

    public void setValue(Y value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Pair){
            return this.getKey().equals(((Pair) obj).getKey()) && this.getValue().equals(((Pair) obj).getValue());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.getKey().hashCode();
    }
}