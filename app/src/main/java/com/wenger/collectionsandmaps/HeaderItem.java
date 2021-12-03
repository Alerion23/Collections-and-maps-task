package com.wenger.collectionsandmaps;

public class HeaderItem extends BaseItem {

    private String header;

    public HeaderItem(String header) {
        super("header");
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
