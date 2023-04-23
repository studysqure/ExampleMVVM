package com.ss.examplemvvm.model;

public class NicePlace {
    private String imageUrl;
    private String title;

    public NicePlace( String imageUrl,String title) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "NicePlace{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
