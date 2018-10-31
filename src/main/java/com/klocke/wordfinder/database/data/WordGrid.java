package com.klocke.wordfinder.database.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wordgrid")
public class WordGrid
{
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "character_grid")
    private char[][] characterGrid;

    public WordGrid(){}

    public WordGrid(char[][] characterGrid) {
        this.characterGrid = characterGrid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char[][] getCharacterGrid() {
        return characterGrid;
    }

    public void setCharacterGrid(char[][] characterGrid) {
        this.characterGrid = characterGrid;
    }

    @Override
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < characterGrid.length; i++)
        {
            for(int j = 0; j < characterGrid[i].length; j++)
            {
                buffer.append(characterGrid[i][j]);
            }

            buffer.append('\n');
        }

        return buffer.toString();
    }
}
