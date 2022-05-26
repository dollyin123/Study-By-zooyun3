package com.study.zooyun3.springboot.domain.posts;

import com.study.zooyun3.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private String author;

    @Column
    private String board;

    @Builder
    public Posts(String title, String content, String author, String board) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.board = board;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
