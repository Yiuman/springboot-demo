package kam.yiuman.bigeyes.mapper;

import kam.yiuman.bigeyes.common.SysMapper;
import kam.yiuman.bigeyes.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends SysMapper<User> {
}
