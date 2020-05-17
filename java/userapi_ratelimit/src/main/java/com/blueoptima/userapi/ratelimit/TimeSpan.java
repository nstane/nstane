package com.blueoptima.userapi.ratelimit;

public enum TimeSpan {
    DAY(8_64_00_000), HOUR(36_00_000), MINUTE(60_000);

    long timeSpanValueInMills;

    TimeSpan(long timeSpan) {
        this.timeSpanValueInMills = timeSpan;
    }

    public long getTimeSpanValueInMills() {
        return timeSpanValueInMills;
    }
}
