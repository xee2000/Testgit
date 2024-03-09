package com.ljh.grimidalbit.service;

import com.ljh.grimidalbit.dto.SearchItems;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface YoutubeApiService {


    List<SearchItems> youTubeSearch(String search, long max);
}
