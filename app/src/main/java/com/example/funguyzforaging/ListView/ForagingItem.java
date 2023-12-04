package com.example.funguyzforaging.ListView;

public class ForagingItem {
    private String name;
    private String description;

    public ForagingItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public ForagingItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ForagingItem setDescription(String description) {
        this.description = description;
        return this;
    }
}
