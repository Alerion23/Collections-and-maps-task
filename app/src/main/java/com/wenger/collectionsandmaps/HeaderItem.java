package com.wenger.collectionsandmaps;

import androidx.annotation.StringRes;

public class HeaderItem extends BaseItem {

    private @StringRes int header;

    public HeaderItem(int header) {
        super("header");
        this.header = header;
    }

    public int getHeader() {
        return header;
    }

    public void setHeader(int header) {
        this.header = header;
    }
}
