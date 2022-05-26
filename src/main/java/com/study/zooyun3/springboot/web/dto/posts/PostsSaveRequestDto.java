package com.study.zooyun3.springboot.web.dto.posts;

import com.study.zooyun3.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String board;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author, String board) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.board = board;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .board(board)
                .build();
    }
}
