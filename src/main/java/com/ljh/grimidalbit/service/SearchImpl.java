package com.ljh.grimidalbit.service;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;
import com.ljh.grimidalbit.dto.SearchItems;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.*;

@Service
@Slf4j
public class SearchImpl  implements  YoutubeApiService{

    //보고자 하는 YOU의 URL주소
    private final String GOOGLE_YOUTUBE_URL =  "https://youtube.googleapis.com/youtube/v3/playlists?";
    private final String YOUTUBE_APIKEY = "AIzaSyARnD6dcCukaq2Bqz4RYGS49XgCpF5D0tk";
    private final YouTube youtube;

    public SearchImpl(YouTube youtube) {
        this.youtube = youtube;
    }

    @Override
    public List<SearchItems> youTubeSearch(String searchQuery, long maxSearch) {





        //YoutubeAPI사용시 api와 통신하기 위해 사용 -> http_transport
        //JSON_FACTORY의 경우 youtube데이터 자체가 json형식을 지원하기에 해당 타입을 매개변수로 주입필요


        String queryTerm = searchQuery;
        log.info("Starting YouTube search... " +queryTerm);
        List<SearchItems> rvalue = new ArrayList<SearchItems>();

        try {
            if (youtube != null) {
                // Define the API request for retrieving search results.
                YouTube.Search.List search = youtube.search().list("id,snippet");

                String apiKey = YOUTUBE_APIKEY;
                search.setKey(apiKey);
                search.setQ(queryTerm);
                search.setType("video");
                search.setMaxResults(maxSearch);


                SearchListResponse searchResponse = search.execute();
                List<SearchResult> searchResultList = searchResponse.getItems();

                if (searchResultList != null) {
                    for (SearchResult rid : searchResultList) {
                        SearchItems item = new SearchItems(
                                GOOGLE_YOUTUBE_URL + rid.getId().getVideoId(),
                                rid.getSnippet().getTitle(),
                                rid.getSnippet().getChannelTitle(),
                                rid.getSnippet().getDescription(),
                                rid.getSnippet().getThumbnails().getDefault().getUrl());
                        rvalue.add(item);
                        log.info("title : " + rid.getSnippet().getTitle());
                        log.info("ChanelTitle : " + rid.getSnippet().getChannelTitle());

                    }
                }
            }

        } catch (GoogleJsonResponseException e){
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch(IOException e){
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch(Throwable t){
            t.printStackTrace();
        }

        return rvalue;
    }
}