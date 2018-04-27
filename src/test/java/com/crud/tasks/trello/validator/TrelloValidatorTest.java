package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.sun.media.jfxmedia.logging.Logger;
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
public class TrelloValidatorTest {

    @Autowired
    TrelloValidator trelloValidator;

    @Test
    public void validateTrelloBoards() {
        //Given
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        List<TrelloList> trelloList = new ArrayList<>();

        trelloBoardList.add(new TrelloBoard("id_1","name", trelloList));
        trelloBoardList.add(new TrelloBoard("id_2","name", trelloList));
        trelloBoardList.add(new TrelloBoard("id_3","test", trelloList));

        //When
        List<TrelloBoard> validateTrelloBoards = trelloValidator.validateTrelloBoards(trelloBoardList);

        //Then
        assertEquals(2, validateTrelloBoards.size());
        assertEquals(0,validateTrelloBoards.get(0).getLists().size());
        assertEquals("name", validateTrelloBoards.get(0).getName());
        assertEquals("id_1", validateTrelloBoards.get(0).getId());
    }
}