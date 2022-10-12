package com.example.grid_layout_manager;

import android.widget.ImageView;

public class UserModelClass {
    int images;
    String title;

    public UserModelClass(int images, String title) {
        this.images = images;
        this.title = title;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
