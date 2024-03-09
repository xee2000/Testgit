package com.ljh.grimidalbit.dto;

import com.ljh.grimidalbit.service.SearchImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class UserDto {
  private String id;
  private String pwd;
  private String name;
  private String authrize;
  private String nickname;

}
