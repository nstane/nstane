package com.blueoptima.userapi.ratelimit.store;

public class ValueStore {
    public int currentLimit;

    public long initTimeInMillis;

    public ValueStore(final int currentLimit, final long initTimeInMillis) {
        this.currentLimit = currentLimit;
        this.initTimeInMillis = initTimeInMillis;
    }

    public int getCurrentLimit() {
        return currentLimit;
    }

    public long getInitTimeInMillis() {
        return initTimeInMillis;
    }

    public void increaseRateLimit() {
        currentLimit++;
    }
}
