package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void mapToBoards() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1","listName", false));

        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        trelloBoardDto.add(new TrelloBoardDto("1","boardName", trelloListDto));

        //When
        List<TrelloBoard> mappedTrelloBoard = trelloMapper.mapToBoards(trelloBoardDto);

        //Then
        assertEquals(1, mappedTrelloBoard.size());
        assertEquals("1", mappedTrelloBoard.get(0).getId());
    }

    @Test
    public void mapAToBoardsDto() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1","listName", false));

        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("1","boardName", trelloList));

        //When
        List<TrelloBoardDto> mappedTrelloBoardDto = trelloMapper.mapAToBoardsDto(trelloBoard);

        //Then
        assertEquals(1, mappedTrelloBoardDto.size());
        assertEquals("1", mappedTrelloBoardDto.get(0).getId());
    }

    @Test
    public void mapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name","description","pos", "listId");

        //When
        TrelloCardDto mappedTrelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("name", mappedTrelloCardDto.getName());
    }

    @Test
    public void mapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name","description","pos", "listId");

        //When
        TrelloCard mappedTrelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("name", mappedTrelloCard.getName());
    }
}