package hs.sample.step1.v3.domain.article.entity;

import hs.sample.step1.v3.domain.BaseEntity;
import lombok.Data;

//@Table(name = "article")
@Data
public class ArticleEntity extends BaseEntity {

    private String title;
    private String body;
    private String author;
    private String publishDate;

}

