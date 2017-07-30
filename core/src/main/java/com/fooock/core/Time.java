package com.fooock.core;

import java.util.Date;

/**
 *
 */
public final class Time {

    private final Date timestamp;

    public Time(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date date() {
        return timestamp;
    }
}
