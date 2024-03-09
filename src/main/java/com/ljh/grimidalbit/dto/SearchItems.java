package com.ljh.grimidalbit.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class SearchItems {

    private String search;
    private String items;

    public SearchItems(String s, String title, String channelTitle, String description, String url) {
    }
}
