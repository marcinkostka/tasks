package com.crud.tasks.service;


import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @InjectMocks
    TrelloService trelloService;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @Test
    public void fetchTrelloBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("idList","nameList", false));
        trelloBoardDtoList.add(new TrelloBoardDto("idBoard", "nameBoard", trelloListDto));

        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtoList);

        //When
        List<TrelloBoardDto> fetchedTrelloBoards = trelloService.fetchTrelloBoards();

        //Then
        assertEquals("idBoard", fetchedTrelloBoards.get(0).getId());
        assertEquals("nameBoard", fetchedTrelloBoards.get(0).getName());
        assertEquals("idList", fetchedTrelloBoards.get(0).getLists().get(0).getId());
        assertEquals("nameList", fetchedTrelloBoards.get(0).getLists().get(0).getName());
        assertEquals(false, fetchedTrelloBoards.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void createTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "desc", "pos","listId");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("id", "name", "url");

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto fetchedCreatedTrelloCardDto = trelloService.createTrelloCard(trelloCardDto);

        //Then
        assertEquals("id", fetchedCreatedTrelloCardDto.getId());
        assertEquals("name", fetchedCreatedTrelloCardDto.getName());
        assertEquals("url", fetchedCreatedTrelloCardDto.getShortUrl());
    }
}