package com.wenger.collectionsandmaps;

import androidx.annotation.StringRes;

public class HeaderItem extends BaseItem {

    private @StringRes int header;

    public HeaderItem(@StringRes int header) {
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
