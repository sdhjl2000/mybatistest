package hello.domain;

/**
 * Created by hujinliang on 2018/5/17.
 */
public class SamplePojo {
    private Long id;
    private String name;

    public SamplePojo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
