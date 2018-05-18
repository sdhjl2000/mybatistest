package hello.app;

import java.util.Random;
import javax.annotation.Resource;

import hello.dao.SamplePojoDao;
import hello.domain.SamplePojo;
import hello.service.MyService;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "hello")
@RestController
@MapperScan(basePackages="hello.dao")
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
