package com.northcoders.frontendrecordshop.ui.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.northcoders.frontendrecordshop.R;
import com.northcoders.frontendrecordshop.databinding.ActivityMainBinding;
import com.northcoders.frontendrecordshop.model.Album;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Album> albums = new ArrayList<>();
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        getAllAlbums();

    }

    private void getAllAlbums(){
        mainActivityViewModel.getMutableLiveData().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsFromLiveData) {
                // albums refers to the variable name of your List of Album objects
                // albumsFromLiveData is cast to this type
                albums = (ArrayList<Album>) albumsFromLiveData;

                // This method will be created next
                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView(){
//        List<Album> albums1 = new ArrayList<>();
//        albums1.add(new Album(1L, "skfjdslkj", "slkjfdsklfj", "POP", 1805));
//        albums1.add(new Album(2L, "skfjdslkj", "slkjfdsklfj", "POP", 1805));
//        albums1.add(new Album(3L, "skfjdslkj", "slkjfdsklfj", "POP", 1805));
//        albums1.add(new Album(4L, "skfjdslkj", "slkjfdsklfj", "POP", 1805));

        recyclerView = activityMainBinding.recyclerView;
        albumAdapter  = new AlbumAdapter(albums, this);
        recyclerView.setAdapter(albumAdapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        albumAdapter.notifyDataSetChanged();
    }
}