package hs.sample.step1.v3.domain.article.service.ArticleInquiryService;

import hs.sample.step1.v3.data.DataFactory;
import hs.sample.step1.v3.domain.article.entity.ArticleEntity;
import hs.sample.step1.v3.domain.article.repository.ArticleRepository;
import hs.sample.step1.v3.model.Article;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@AllArgsConstructor
@Service
public class ArticleInquiryService {

    private final ArticleRepository articleRepository;

    public List<Article> inquiry() {
        try {
            ArticleEntity entity = articleRepository.select(1L);
            log.info(entity.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<Article> articles = IntStream.range(0, 10)
                .mapToObj(i -> generateArticle("Article Title " + i))
                .collect(Collectors.toList());

        return articles;
    }

    public List<Article> inquiryMock() {
        List<Article> articles = IntStream.range(0, 10)
                .mapToObj(i -> generateArticle("Article Title " + i))
                .collect(Collectors.toList());

        return articles;
    }


    private Article generateArticle(String title) {
        Article article = new Article();
        DataFactory factory = DataFactory.create();
        article.setTitle(title);
        article.setBody(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur faucibus tempor diam. In molestie arcu eget ante facilisis sodales. Maecenas porta tellus sapien, eget rutrum nisi blandit in. Mauris tempor auctor ante, ut blandit velit venenatis id. Ut varius, augue aliquet feugiat congue, arcu ipsum finibus purus, dapibus semper velit sapien venenatis magna. Nunc quam ex, aliquet at rutrum sed, vestibulum quis libero. In laoreet libero cursus maximus vulputate. Nullam in fermentum sem. Duis aliquam ullamcorper dui, et dictum justo placerat id. Aliquam pretium orci quis sapien convallis, non blandit est tempus.");
        article.setPublishDate(factory.getBirthDate().toString());
        article.setAuthor(factory.getName());
        return article;
    }
}
