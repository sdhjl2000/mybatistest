package hello.app;

import java.time.Instant;
import java.util.Random;
import javax.annotation.Resource;

import hello.dao.pojo.SamplePojoDao;
import hello.dao.user.UserPojoDao;
import hello.domain.pojo.SamplePojo;
import hello.domain.user.UserPojo;
import hello.service.MyService;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "hello",exclude= MybatisAutoConfiguration.class)
@RestController
@EnableTransactionManagement
public class DemoApplication {


    private final MyService myService;

    @Resource
    private SamplePojoDao samplePojoDao;

    @Resource
    private UserPojoDao userPojoDao;

    public DemoApplication(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    @Transactional()
    public String home() {
        samplePojoDao.insert(new SamplePojo(Instant.now().getEpochSecond(),""));
       userPojoDao.insert(new UserPojo(Instant.now().getEpochSecond(),""));
        //samplePojoDao.insert(new SamplePojo(Long.MAX_VALUE+1,""));
        return myService.message();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
