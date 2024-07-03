package hs.sample.step1.v3.domain.article.repository;


import hs.sample.step1.v3.domain.article.entity.ArticleEntity;
import hs.sample.step1.v3.global.config.AbstractMapper;
import org.springframework.stereotype.Repository;

/**
 * @author 이호석
 * @version 1.0
 * <br>수정일         수정자      수정내용
 * <br>----------   --------  ---------------------------
 * <br>2021.05.04   이호석      최초 생성
 * <br>
 * @Description
 * @since 2021.05.04
 */
@Repository("articleRepository")
public class ArticleRepository extends AbstractMapper {

    //    @Autowired
//    private SqlSessionTemplate sessionTemplate;
    private static String namespace
            = "step1.mapper.ArticleMapper.";

    public ArticleEntity select(Long id) {
        return getSqlSessionTemplate().selectOne(namespace + "findPostById", id);
    }

}
