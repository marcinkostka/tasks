package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrelloBadgesTest {

    @Test
    public void getAllAttributes() {
        //Given
        Trello trello = new Trello(1,1);
        TrelloAttachmentsByType trelloAttachmentsByType =
                new TrelloAttachmentsByType(trello);

        //When
        TrelloBadges trelloBadges = new TrelloBadges(1, trelloAttachmentsByType);

        //Then
        assertEquals(1, trelloBadges.getTrelloAttachmentsByType().getTrello().getBoard());
        assertEquals(1, trelloBadges.getTrelloAttachmentsByType().getTrello().getCard());
        assertEquals(trelloAttachmentsByType, trelloBadges.getTrelloAttachmentsByType());
        assertEquals(1, trelloBadges.getVotes());
    }
}