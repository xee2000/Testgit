package com.ljh.grimidalbit.controller;

import com.ljh.grimidalbit.dao.UserMapper;
import com.ljh.grimidalbit.dto.UserDto;
import com.ljh.grimidalbit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    @ResponseBody
    public ResponseEntity<UserDto> UserLogin(@RequestBody UserDto dto) {
        UserDto userDto = userService.Userlogin(dto.getId(), dto.getPwd());
       log.info("확인 : [{}]", userDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
