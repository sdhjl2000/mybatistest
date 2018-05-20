package hello.dao.user;

import java.util.List;

import hello.domain.user.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserPojoDao {

    int insert( UserPojo pojo);

    int insertList( List<UserPojo> pojo);

    List<UserPojo> select( UserPojo pojo);

    int update( UserPojo pojo);

}
