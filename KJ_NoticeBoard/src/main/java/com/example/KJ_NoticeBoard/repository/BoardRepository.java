package com.example.KJ_NoticeBoard.repository;

import com.example.KJ_NoticeBoard.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;

    public List<BoardDTO> getList() {
        return sql.selectList("Board.getList");
    }
}
