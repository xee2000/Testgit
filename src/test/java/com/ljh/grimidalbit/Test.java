package com.ljh.grimidalbit;

import com.ljh.grimidalbit.dto.UserDto;
import com.ljh.grimidalbit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootTest
@Transactional
@SpringJUnitConfig
@Slf4j
public class Test {

    @Autowired
    private UserService userService;


    @org.junit.jupiter.api.Test
    @DisplayName("캐시적용 Redis")
    void Userlogin(){
        UserDto dto = new UserDto();
        dto.setId("123");
        dto.setPwd("123");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        UserDto userDto = userService.Userlogin(dto.getId(), dto.getPwd());
        stopWatch.stop();
        System.out.println("Execution Time: " + stopWatch.getTotalTimeMillis() + " ms");
        Assertions.assertEquals(dto.getId(), userDto.getId());
    }

}
