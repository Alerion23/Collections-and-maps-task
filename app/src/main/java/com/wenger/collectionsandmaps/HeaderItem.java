package com.wenger.collectionsandmaps;

public class HeaderItem extends BaseItem{
    public HeaderItem( String header) {
        super("header");
        this.header = header;
    }

  private   String header;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
