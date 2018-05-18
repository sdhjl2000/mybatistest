package hello.app;

import java.util.Random;
import javax.annotation.Resource;

import hello.dao.pojo.SamplePojoDao;
import hello.domain.pojo.SamplePojo;
import hello.service.MyService;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "hello",exclude= MybatisAutoConfiguration.class)
@RestController
public class DemoApplication {


    private final MyService myService;

    @Resource
    private SamplePojoDao samplePojoDao;

    public DemoApplication(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public String home() {
        samplePojoDao.insert(new SamplePojo(new Random().nextLong(),""));
        return myService.message();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
