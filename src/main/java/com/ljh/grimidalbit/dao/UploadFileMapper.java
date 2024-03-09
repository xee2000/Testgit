package com.ljh.grimidalbit.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UploadFileMapper {

    void UploadFile(String filename, String filepath);
}
