package com.study.zooyun3.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query(value = "select R1.* FROM (SELECT p.* FROM Posts p where p.board = :board) R1 ORDER BY R1.id DESC LIMIT :page,25"
            , nativeQuery = true)
    List<Posts> findAllDesc(@Param("board") String board, @Param("page") int page);

    @Query(value = "select COUNT(case when p.board = :board then 1 END) FROM posts p", nativeQuery = true)
    int findRows(@Param("board") String board);
}
