package com.northcoders.frontendrecordshop.ui.mainactivity;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.northcoders.frontendrecordshop.model.Album;
import com.northcoders.frontendrecordshop.model.AlbumRepository;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    AlbumRepository albumRepository;

    public MainActivityViewModel(@NotNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public MutableLiveData<List<Album>> getMutableLiveData(){
        return albumRepository.getMutableLiveData();
    }

}
