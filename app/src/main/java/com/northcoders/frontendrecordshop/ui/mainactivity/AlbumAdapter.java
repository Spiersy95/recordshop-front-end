package com.northcoders.frontendrecordshop.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.northcoders.frontendrecordshop.R;
import com.northcoders.frontendrecordshop.databinding.AlbumPresentationBinding;
import com.northcoders.frontendrecordshop.model.Album;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    private List<Album> albums;
    private Context context;

    public AlbumAdapter(List<Album> albums, Context context){
        this.albums = albums;

    }

    @NonNull
    @NotNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        AlbumPresentationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.album_presentation,
                viewGroup, false);

        return new AlbumViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AlbumViewHolder albumViewHolder, int i) {
        Album album = albums.get(i);
        albumViewHolder.albumPresentationBinding.setAlbum(album);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder{

        private AlbumPresentationBinding albumPresentationBinding;

        public AlbumViewHolder(AlbumPresentationBinding albumPresentationBinding){
            super(albumPresentationBinding.getRoot());
            this.albumPresentationBinding = albumPresentationBinding;
        }
    }
}
