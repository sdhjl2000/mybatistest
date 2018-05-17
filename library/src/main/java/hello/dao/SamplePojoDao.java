package hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import hello.domain.*;
public interface SamplePojoDao {

    int insert(@Param("pojo") SamplePojo pojo);

    int insertList(@Param("pojos") List< SamplePojo> pojo);

    List<SamplePojo> select(@Param("pojo") SamplePojo pojo);

    int update(@Param("pojo") SamplePojo pojo);

}
