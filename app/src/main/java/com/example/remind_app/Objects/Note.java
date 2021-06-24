package com.example.remind_app.Objects;

import android.graphics.Bitmap;

public class Note {
    Bitmap image;
    public String content;
    public String detail;

    public Note() {
    }

    public Note(Bitmap image, String content, String detail) {
        this.image = image;
        this.content = content;
        this.detail = detail;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
