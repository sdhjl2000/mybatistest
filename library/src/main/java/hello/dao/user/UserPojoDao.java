package hello.dao.user;

import java.util.List;

import hello.domain.user.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserPojoDao {

    int insert(@Param("pojo") UserPojo pojo);

    int insertList(@Param("pojos") List<UserPojo> pojo);

    List<UserPojo> select(@Param("pojo") UserPojo pojo);

    int update(@Param("pojo") UserPojo pojo);

}
