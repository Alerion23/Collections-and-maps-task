package com.wenger.collectionsandmaps;

public class BaseItem {
    public BaseItem(String type) {
        this.type = type;
    }

    private final String type;

    public String getType() {
        return type;
    }
}
