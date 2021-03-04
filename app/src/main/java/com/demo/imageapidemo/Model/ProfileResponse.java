package com.demo.imageapidemo.Model;

import com.google.gson.annotations.SerializedName;

public class ProfileResponse {
    @SerializedName("title")
    private String title;
  /*  @SerializedName("photo")
    private String photo;*/
   @SerializedName("url")
    private String url;

    public ProfileResponse(String title,String url){
        this.title = title;
       // this.photo = photo;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   /* public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }*/

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
