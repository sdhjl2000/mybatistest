package hello.app;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by hujinliang on 2018/5/18.
 */
@Configuration
public class DatabaseConfiguration {
    public static final String PRIMARY_DATASOURCE = "OneDS";
    public static final String SECONDARY_DATASOURCE = "AnotherDS";

    @Bean(name = PRIMARY_DATASOURCE, destroyMethod = "")
    @ConfigurationProperties(prefix = "datasource.one")
    @Primary
    public DataSource dataSourceOne() {
        // Filled up with the properties specified about thanks to Spring Boot black magic
        return new DruidDataSource();
    }

    @Bean(name = SECONDARY_DATASOURCE, destroyMethod = "")
    @ConfigurationProperties(prefix = "datasource.two")
    public DataSource dataSourceAnother() {
        // Filled up with the properties specified about thanks to Spring Boot black magic
        return new DruidDataSource();
    }
}
