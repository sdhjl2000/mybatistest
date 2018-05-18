package hello.dao.pojo;

import java.util.List;

import hello.domain.pojo.SamplePojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SamplePojoDao {

    int insert(SamplePojo pojo);

    int insertList(@Param("pojos") List< SamplePojo> pojo);

    List<SamplePojo> select(@Param("pojo") SamplePojo pojo);

    int update(@Param("pojo") SamplePojo pojo);

}
