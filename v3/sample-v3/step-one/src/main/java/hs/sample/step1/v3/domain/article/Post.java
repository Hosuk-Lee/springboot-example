package hs.sample.step1.v3.domain.post;


import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Post {

    private Long id;

    private String title;

    private String content;

    private String author;

    private LocalDateTime createdAt;
}
