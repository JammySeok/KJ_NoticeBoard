package com.example.KJ_NoticeBoard.controller;

import com.example.KJ_NoticeBoard.dto.BoardDTO;
import com.example.KJ_NoticeBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 도서 목록 조회
    @GetMapping("/list")
    public String getList(Model model) {
        List<BoardDTO> boardDTO = boardService.getList();
        model.addAttribute("bookList", boardDTO);
        return "bookList";
    }

    // 도서 추가
    @GetMapping("/addbook")
    public String addBook() {
        return "addBook";
    }
}
