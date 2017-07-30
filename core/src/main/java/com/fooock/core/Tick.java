package com.fooock.core;

/**
 * Tick of a time period
 */
public final class Tick {

    private final Time time;

    private final Number open;
    private final Number high;
    private final Number low;
    private final Number close;
    private final Number volume;

    /**
     * Create this object
     *
     * @param time   Time of the tick period
     * @param open   Open price
     * @param high   High price
     * @param low    Low price
     * @param close  Close price
     * @param volume Volume during time period
     */
    public Tick(Time time, Number open, Number high, Number low, Number close, Number volume) {
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    /**
     * Time of the tick period
     *
     * @return Time of the period
     */
    public Time time() {
        return time;
    }

    /**
     * Open price
     *
     * @return Tick open price
     */
    public Number open() {
        return open;
    }

    /**
     * High price
     *
     * @return Tick high price
     */
    public Number high() {
        return high;
    }

    /**
     * Low price
     *
     * @return Tick low price
     */
    public Number low() {
        return low;
    }

    /**
     * Close price
     *
     * @return Tick close price
     */
    public Number close() {
        return close;
    }

    /**
     * Volume during time period
     *
     * @return Tick volume during time period
     */
    public Number volume() {
        return volume;
    }
}
