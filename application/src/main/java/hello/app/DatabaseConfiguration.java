package hello.app;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.spring.stat.BeanTypeAutoProxyCreator;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import hello.dao.user.UserPojoDao;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by hujinliang on 2018/5/18.
 */
@Configuration
public class DatabaseConfiguration {
    public static final String PRIMARY_DATASOURCE = "dataSourceOne";
    public static final String SECONDARY_DATASOURCE = "dataSourceAnother";

    @Bean(name = PRIMARY_DATASOURCE, destroyMethod = "")
    @ConfigurationProperties(prefix = "datasource.one")
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

    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSourceAnother());
    }
    @Bean
    public DataSourceTransactionManager transactionManagerOne(){
        return new DataSourceTransactionManager(dataSourceOne());
    }

//    @Bean
//    public ServletRegistrationBean exampleServletBean() {
//        ServletRegistrationBean bean = new ServletRegistrationBean(
//                new StatViewServlet(), "/druid/*");
//        bean.setLoadOnStartup(1);
//        return bean;
//    }
//    @Bean
//    public DruidStatInterceptor druidStatInterceptor(){
//        return new DruidStatInterceptor();
//    }
//    @Bean
//    public BeanTypeAutoProxyCreator beanTypeAutoProxyCreator(){
//        BeanTypeAutoProxyCreator beanTypeAutoProxyCreator= new BeanTypeAutoProxyCreator();
//        beanTypeAutoProxyCreator.setInterceptorNames("druidStatInterceptor");
//        beanTypeAutoProxyCreator.setTargetBeanType(UserPojoDao.class);
//        return beanTypeAutoProxyCreator;
//    }
}
