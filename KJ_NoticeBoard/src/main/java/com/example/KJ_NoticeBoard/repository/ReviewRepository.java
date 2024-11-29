package com.example.KJ_NoticeBoard.repository;

import com.example.KJ_NoticeBoard.dto.BoardDTO;
import com.example.KJ_NoticeBoard.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final SqlSessionTemplate sql;

    public List<ReviewDTO> getList(Integer id) {
        return sql.selectList("Review.getList", id);
    }

    public void save(Integer id, ReviewDTO reviewDTO) {
        reviewDTO.setBookid(id);
        sql.insert("Review.save", reviewDTO);
    }

    public void deleteReview(Integer reviewid) {
        sql.delete("Review.deleteReview", reviewid);
    }

    public void updateReview(ReviewDTO reviewDTO) {
        sql.update("Review.updateReview", reviewDTO);
    }

    public ReviewDTO getTuple(Integer reviewid) {
        return sql.selectOne("Review.getTuple", reviewid);
    }
}
