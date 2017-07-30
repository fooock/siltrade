package com.fooock.core;

/**
 * Tick of a time period
 */
public final class Tick {

    private final Time time;

    private final Number bid;
    private final Number high;
    private final Number low;
    private final Number ask;
    private final Number volume;

    /**
     * Create this object
     *
     * @param time   Time of the tick period
     * @param bid    Bid price
     * @param high   High price
     * @param low    Low price
     * @param ask    Ask price
     * @param volume Volume during time period
     */
    public Tick(Time time, Number bid, Number high, Number low, Number ask, Number volume) {
        this.time = time;
        this.bid = bid;
        this.high = high;
        this.low = low;
        this.ask = ask;
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
     * Bid price
     *
     * @return Tick bid price
     */
    public Number bid() {
        return bid;
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
     * Ask price
     *
     * @return Tick ask price
     */
    public Number ask() {
        return ask;
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
