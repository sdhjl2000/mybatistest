package hello.app;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Created by hujinliang on 2018/5/18.
 */
@Configuration
@MapperScan(sqlSessionFactoryRef="oneSessionFactory",basePackages = "hello.dao.user")
public class MyBatisUserConfiguration {
    private static final String ONE_SESSION_FACTORY = "oneSessionFactory";

    @Bean(name = ONE_SESSION_FACTORY, destroyMethod = "")
    public SqlSessionFactoryBean sqlSessionFactory(final DataSource dataSourceOne) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceOne);
        Resource mybatisConfig = new ClassPathResource("mybatis/sqlMapConfig.xml");
        sqlSessionFactoryBean.setConfigLocation(mybatisConfig);
        Resource[] mappers = new PathMatchingResourcePatternResolver().getResources("mapper/user/*.xml");
        sqlSessionFactoryBean.setMapperLocations(mappers);

        sqlSessionFactoryBean.setTypeAliasesPackage("hello.domain.user.*");
        // Various other SqlSessionFactory settings
        return sqlSessionFactoryBean;
    }
//    @Bean(name = "userMapperScannerConfigurer")
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        MapperScannerConfigurer mapperScannerConfigurer= new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("hello.dao.user");
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName(ONE_SESSION_FACTORY);
//        return mapperScannerConfigurer;
//    }

}
