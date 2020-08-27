package com.example.hlinktask;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Article {

    @SerializedName("images")
    private List<Image> Image = null;

    public List<Image> getImage() {
        return Image;
    }

    public void setImage(List<Article.Image> image) {
        Image = image;
    }

    public class Image {

        @SerializedName("url")
        @Expose
        private String url;

        @SerializedName("large_url")
        @Expose
        private String large_url;

        @SerializedName("sourceId")
        @Expose
        private String sourceId;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getLarge_url() {
            return large_url;
        }

        public void setLarge_url(String large_url) {
            this.large_url = large_url;
        }

        public String getSourceId() {
            return sourceId;
        }

        public void setSourceId(String sourceId) {
            this.sourceId = sourceId;
        }
    }

}
