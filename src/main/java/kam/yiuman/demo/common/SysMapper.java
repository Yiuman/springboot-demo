package kam.yiuman.demo.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SysMapper<T> extends Mapper<T>,MySqlMapper<T>{

}
