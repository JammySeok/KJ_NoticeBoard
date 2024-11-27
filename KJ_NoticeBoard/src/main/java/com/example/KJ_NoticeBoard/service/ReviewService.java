package com.example.KJ_NoticeBoard.service;


import com.example.KJ_NoticeBoard.dto.BoardDTO;
import com.example.KJ_NoticeBoard.dto.ReviewDTO;
import com.example.KJ_NoticeBoard.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewDTO> getList(Integer id) {
        return reviewRepository.getList(id);
    }

    public void save(Integer id, ReviewDTO reviewDto) {
        reviewRepository.save(id, reviewDto);
    }
}
