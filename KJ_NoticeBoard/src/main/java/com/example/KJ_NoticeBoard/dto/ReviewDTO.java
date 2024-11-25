package com.example.KJ_NoticeBoard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewDTO {

    private int reviewid;
    private int bookid;
    private String username;
    private String comment;
}
