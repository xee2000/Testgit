package com.ljh.grimidalbit.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ljh.grimidalbit.dao.UploadFileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UploadFileServiceImpl implements UploadFileService{

    @Value("${UploadFile.Directory.root}")
    private String root;

    @Value("${UploadFile.Directory.path}")
    private String path;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    private final AmazonS3Client amazonS3Client;

    @Autowired
    private UploadFileMapper uploadFileMapper;

    public String fileuploadpath(String filename){
        return root+path+ "/" + filename;
    }


    @Override
    public int uploadfile(MultipartFile file) throws IOException {
        log.info(file.getOriginalFilename());
        log.info("test");

       String filepath =  fileuploadpath(Uniqfilename(file.getOriginalFilename()));
        String originalName = UUID.randomUUID() + file.getOriginalFilename();

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(file.getContentType());
        objectMetadata.setContentLength(file.getInputStream().available());

        amazonS3Client.putObject(bucketName, originalName, file.getInputStream(), objectMetadata);
        uploadFileMapper.UploadFile(originalName, filepath);
        return 1;
    }

    public String Uniqfilename(String filename){
       String uniqfile = UUID.randomUUID() + filename;

        return uniqfile;
    }
}
