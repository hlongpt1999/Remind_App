package com.example.remind_app.Objects;

public class Note {
    public String image;
    public String content;
    public String detail;

    public Note() {
    }

    public Note(String image, String content, String detail) {
        this.image = image;
        this.content = content;
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
