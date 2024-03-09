package com.ljh.grimidalbit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface UploadFileService {
    int uploadfile(MultipartFile file) throws IOException;
}
