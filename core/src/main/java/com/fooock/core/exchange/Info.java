package com.fooock.core.exchange;

/**
 *
 */
public final class Info {

    private final String name;
    private final String description;
    private final String web;

    public Info(String name, String description, String web) {
        this.name = name;
        this.description = description;
        this.web = web;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public String web() {
        return web;
    }
}
