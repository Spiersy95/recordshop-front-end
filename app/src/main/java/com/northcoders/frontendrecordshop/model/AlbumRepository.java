package com.northcoders.frontendrecordshop.model;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.northcoders.frontendrecordshop.service.AlbumApiService;
import com.northcoders.frontendrecordshop.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class AlbumRepository {

    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application){
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData(){
        AlbumApiService albumApiService = RetrofitInstance.getService();

        Call<List<Album>> call = albumApiService.getAlbums();

        call.enqueue(new Callback<List<Album>>(){
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                mutableLiveData.setValue(response.body());


            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable throwable) {

            }
        });
        return mutableLiveData;
    }
}
