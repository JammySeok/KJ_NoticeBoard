package com.example.KJ_NoticeBoard.service;

import com.example.KJ_NoticeBoard.dto.BoardDTO;
import com.example.KJ_NoticeBoard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 도서목록 조회
    public List<BoardDTO> getList() {
        return boardRepository.getList();
    }

    // 도서 저장(DB 저장)
    public void save(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
    }
}
