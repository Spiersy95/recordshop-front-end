package com.northcoders.frontendrecordshop.service;

import com.northcoders.frontendrecordshop.model.Album;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AlbumApiService {

//    @GET("albums")
//    Call<List<Album>> getAlbums();

    @GET("albums")
    Call<ResponseBody> getRawJson();
}
