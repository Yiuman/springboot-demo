package kam.yiuman.demo.mapper;

import kam.yiuman.demo.common.SysMapper;
import kam.yiuman.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper  extends SysMapper<User> {
}
