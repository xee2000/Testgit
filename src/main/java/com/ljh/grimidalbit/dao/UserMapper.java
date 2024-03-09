package com.ljh.grimidalbit.dao;

import com.ljh.grimidalbit.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    UserDto Userlogin(Object id, Object pwd);
}
