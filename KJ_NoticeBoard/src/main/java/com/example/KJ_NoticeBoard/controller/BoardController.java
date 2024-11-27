package com.example.KJ_NoticeBoard.controller;

import com.example.KJ_NoticeBoard.dto.BoardDTO;
import com.example.KJ_NoticeBoard.dto.ReviewDTO;
import com.example.KJ_NoticeBoard.service.BoardService;
import com.example.KJ_NoticeBoard.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Clock;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final ReviewService reviewService;

    // 도서 목록 조회
    @GetMapping("/list")
    public String getList(Model model) {
        List<BoardDTO> boardDTO = boardService.getList();
        model.addAttribute("bookList", boardDTO);
        return "bookList";
    }

    // 도서 추가 화면 호출
    @GetMapping("/addBook")
    public String addBook() {
        return "addBook";
    }

    // 도서 추가 (DB 저장)
    @PostMapping("/addBook")
    public void save(BoardDTO boardDTO) {
        boardService.save(boardDTO);
    }

    // 도서 상세정보 가져오기
    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        BoardDTO boardDTO = boardService.detail(id);
        model.addAttribute("bookDetail", boardDTO);

        List<ReviewDTO> reviewList = reviewService.getList(id);
        model.addAttribute("reviewList", reviewList);

        return "detailBook";
    }

    // 도서 정보 삭제하기
    @GetMapping("/goDelete/{id}")
    public String goDelete(@PathVariable("id") Integer id) {
       boardService.goDelete(id);
       return "redirect:/list";
    }

    // 도서정보 수정화면 호출
    @GetMapping("/goUpdate/{id}")
    public String goUpdate(@PathVariable("id") Integer id, Model model) {
        BoardDTO boardDTO = boardService.detail(id);
        model.addAttribute("bookDetail", boardDTO);
        return "updateBook";
    }

    // 도서정보 수정
    @PostMapping("/goUpdate/{id}")
    public String goUpdate(BoardDTO boardDTO, Model model) {
        boardService.goUpdate(boardDTO);   // update 작업 요청

        // update 완료 후, 수정된 내용을 다시조회
        BoardDTO dto = boardService.detail(boardDTO.getBookid());
        model.addAttribute("bookDetail", dto);
        return "detailBook";
    }

    @GetMapping("/{id}/addReview")
    public String addReview(@PathVariable("id") Integer id, Model model, BoardDTO boardDTO) {
        boardDTO.setBookid(id);
        model.addAttribute("bookDetail", boardDTO);
        return "addReview";
    }

    @PostMapping("/{id}/addReview")
    public void save(@PathVariable("id") Integer id, ReviewDTO reviewDTO) {
        reviewService.save(id, reviewDTO);
    }
}
