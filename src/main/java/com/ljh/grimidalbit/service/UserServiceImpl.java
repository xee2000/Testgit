package com.ljh.grimidalbit.service;

import com.ljh.grimidalbit.dao.UserMapper;
import com.ljh.grimidalbit.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    private final Map<String, UserDto> store = new LinkedHashMap<>();


    @Override
    @Cacheable(key= "#id", value = "loginUser" ,cacheManager = "redisCacheManager")
    public UserDto Userlogin(String id, String pwd) {
      UserDto dto = userMapper.Userlogin(id,pwd);
      store.put(id,dto);

        return dto;
    }
}
