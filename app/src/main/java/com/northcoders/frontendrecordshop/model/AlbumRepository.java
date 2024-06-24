package com.northcoders.frontendrecordshop.model;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.northcoders.frontendrecordshop.service.AlbumApiService;
import com.northcoders.frontendrecordshop.service.RetrofitInstance;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {

    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application){
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData(){
        AlbumApiService albumApiService = RetrofitInstance.getService();

//        Call<List<Album>> call = albumApiService.getAlbums();
        Call<ResponseBody> call = albumApiService.getRawJson();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Album>>(){}.getType();
                ArrayList<Album> list = gson.fromJson(response.body().charStream(), listType);
                Log.i("album List log", response.message());
                mutableLiveData.setValue(list);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                // Handle failure case
                Log.i("album List log", throwable.getMessage());
                throwable.printStackTrace();
            }
        });
        return mutableLiveData;
    }
}
