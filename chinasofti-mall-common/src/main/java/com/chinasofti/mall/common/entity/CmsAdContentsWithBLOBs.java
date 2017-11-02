package com.chinasofti.mall.common.entity;

public class CmsAdContentsWithBLOBs extends CmsAdContents {
    private String title;

    private String url;

    private String contens;

    private String imageurl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getContens() {
        return contens;
    }

    public void setContens(String contens) {
        this.contens = contens == null ? null : contens.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }
}