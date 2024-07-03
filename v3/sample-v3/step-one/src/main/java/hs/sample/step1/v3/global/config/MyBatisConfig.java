package hs.sample.step1.v3.global.config;

import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Configuration
@EnableTransactionManagement

//@MapperScan(basePackages = )
public class MyBatisConfig {

    @Autowired
    private DataSource dataSource;

//    private ApplicationContext applicationContext;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        log.info("[DEBUG] sqlSessionFactory {}", dataSource);
//        Resource[] resources = null;
//        try {
//            resources = new PathMatchingResourcePatternResolver().getResources("classpath:sqlmap/**/*.sqlmap.xml");
//        } catch (FileNotFoundException e) {
//            return null;
//        }
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        sessionFactory.setMapperLocations(resources);
//        return sessionFactory.getObject();
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        sessionFactory.setConfigLocation(
                new PathMatchingResourcePatternResolver().getResource(
                        "classpath:mybatis-config.xml"));

        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:sqlmap/**/*.sqlmap.xml");
        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
