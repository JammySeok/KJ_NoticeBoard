package com.example.KJ_NoticeBoard.repository;

import com.example.KJ_NoticeBoard.dto.ReviewDTO;
import com.example.KJ_NoticeBoard.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LoginRepository {

    private final SqlSessionTemplate sql;

    public UserDTO getList(String id) {
        return sql.selectOne("Login.getList", id);
    }

    public void save(UserDTO userDTO) {
        sql.insert("Login.save", userDTO);
    }
}
