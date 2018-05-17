package hello.dao;

import java.util.List;

import hello.domain.UserPojo;
import org.apache.ibatis.annotations.Param;

public interface UserPojoDao {

    int insert(@Param("pojo") UserPojo pojo);

    int insertList(@Param("pojos") List<UserPojo> pojo);

    List<UserPojo> select(@Param("pojo") UserPojo pojo);

    int update(@Param("pojo") UserPojo pojo);

}
