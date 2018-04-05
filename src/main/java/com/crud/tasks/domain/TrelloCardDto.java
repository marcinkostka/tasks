package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TrelloCardDto {
    private String name;
    private String descrition;
    private String pos;
    private String listId;
}
