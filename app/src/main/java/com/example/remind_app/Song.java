package com.example.remind_app;

import java.io.Serializable;

public class Song implements Serializable {
    private String name;
    private int resoure;

    public Song(String name, int resoure) {
        this.name = name;
        this.resoure = resoure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResoure() {
        return resoure;
    }

    public void setResoure(int resoure) {
        this.resoure = resoure;
    }
}
