package com.example.KJ_NoticeBoard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private int id_num;
    private String id;
    private String password;
    private int grade;
}
