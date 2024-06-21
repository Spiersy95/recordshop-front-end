package com.northcoders.frontendrecordshop.service;

import com.northcoders.frontendrecordshop.model.Album;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AlbumApiService {

    @GET("api/v1/albums")
    Call<List<Album>> getAlbums();
}
