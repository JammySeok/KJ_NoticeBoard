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

    public void save(BoardDTO boardDTO) {
        sql.insert("Board.save", boardDTO);
    }

    public BoardDTO detail(Integer id) {
        return sql.selectOne("Board.detail", id);
    }

    public void goDelete(Integer id) {
        sql.delete("Board.goDelete", id);
    }

    public void goUpdate(BoardDTO boardDTO) {
        sql.update("Board.goUpdate", boardDTO);
    }

    public List<BoardDTO> getSearch(String keyword) {
        return sql.selectList("Board.getSearch", keyword);
    }
}
