package com.ljh.grimidalbit.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljh.grimidalbit.dto.SearchItems;
import com.ljh.grimidalbit.service.SearchImpl;
import com.ljh.grimidalbit.service.UploadFileService;
import com.ljh.grimidalbit.service.YoutubeApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
public class DataController {

    @Autowired
    private YoutubeApiService youTubeApiService;
    @Autowired
    private UploadFileService uploadFileService;

    @RequestMapping(value={"/search"}, method= RequestMethod.GET)
    public @ResponseBody
    String searchYouTube(
            @RequestParam(value="word", required=true) String search,
            @RequestParam(value="items", required=false, defaultValue="5") String items) throws JsonProcessingException {

        long max = (long) Integer.parseInt(items);
        List<SearchItems> item = youTubeApiService.youTubeSearch(search, max);

        // JSON으로 변환
        String result = new ObjectMapper().writeValueAsString(item);
        System.out.println(result);
        return result;
    }

    @PostMapping(value = {"/file/upload"})
    @ResponseBody
    public ResponseEntity FileUpload(@RequestParam(value = "file")MultipartFile file) throws IOException {
        log.info("데이터 확인 : " + file.getOriginalFilename());
        int result = uploadFileService.uploadfile(file);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
