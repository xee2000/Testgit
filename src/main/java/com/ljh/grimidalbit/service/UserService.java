package com.ljh.grimidalbit.service;

import com.ljh.grimidalbit.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    UserDto Userlogin(String id, String pwd);
}
