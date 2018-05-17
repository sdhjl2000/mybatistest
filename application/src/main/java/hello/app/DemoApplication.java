package hello.app;

import javax.annotation.Resource;

import hello.dao.SamplePojoDao;
import hello.domain.SamplePojo;
import hello.service.MyService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "hello")
@ImportResource({ "classpath:spring/spring-core.xml" })
@RestController
public class DemoApplication {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;
    private final MyService myService;

    public DemoApplication(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public String home() {
        sqlSessionTemplate.insert(  SamplePojoDao.class.getName()+".insert",new SamplePojo(3L,""));
        return myService.message();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
