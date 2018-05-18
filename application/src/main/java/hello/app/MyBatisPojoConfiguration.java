package hello.app;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Created by hujinliang on 2018/5/18.
 */
@Configuration
@MapperScan(sqlSessionFactoryRef="anotherSessionFactory",basePackages = "hello.dao.pojo")
public class MyBatisPojoConfiguration {

    private static final String ANOTHER_SESSION_FACTORY = "anotherSessionFactory";




    @Bean(name = ANOTHER_SESSION_FACTORY, destroyMethod = "")
    public SqlSessionFactoryBean sqlSessionFactory(final DataSource dataSourceAnother) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceAnother);
        Resource mybatisConfig = new ClassPathResource("mybatis/sqlMapConfig.xml");
        sqlSessionFactoryBean.setConfigLocation(mybatisConfig);
        Resource[] mappers = new PathMatchingResourcePatternResolver().getResources("mapper/pojo/*.xml");
        sqlSessionFactoryBean.setMapperLocations(mappers);
        sqlSessionFactoryBean.setTypeAliasesPackage("hello.domain.pojo.*");
        // Various other SqlSessionFactory settings
        return sqlSessionFactoryBean;
    }
//    @Bean(name = "pojoMapperScannerConfigurer")
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        MapperScannerConfigurer mapperScannerConfigurer= new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("hello.dao.pojo");
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName(ANOTHER_SESSION_FACTORY);
//        return mapperScannerConfigurer;
//    }

}
