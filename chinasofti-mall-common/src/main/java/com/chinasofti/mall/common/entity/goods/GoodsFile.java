package com.chinasofti.mall.common.entity.goods;

public class GoodsFile {
    private String ids;

    private String goodsids;

    private String filepath;

    private String filename;

    private String filetype;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public String getGoodsids() {
        return goodsids;
    }

    public void setGoodsids(String goodsids) {
        this.goodsids = goodsids == null ? null : goodsids.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }
}