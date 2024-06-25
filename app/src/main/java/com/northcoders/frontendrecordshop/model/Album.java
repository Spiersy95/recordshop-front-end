package com.northcoders.frontendrecordshop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.northcoders.frontendrecordshop.BR;

public class Album extends BaseObservable {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("title")
    @Expose
    private String albumName;

    @SerializedName("artist")
    @Expose
    private String artistName;

    @SerializedName("genre")
    @Expose
    private String genre;

    @SerializedName("year")
    @Expose
    private int releaseYear;

    public Album(long id, String albumName, String artistName, String genre, int releaseYear) {
        this.id = id;
        this.albumName = albumName;
        this.artistName = artistName;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public Album(){
    }

    @Bindable
    public long getId() {
        return id;
    }


    public void setId(long id) {

        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
        notifyPropertyChanged(BR.albumName);
    }

    @Bindable
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
        notifyPropertyChanged(BR.artistName);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }
}
