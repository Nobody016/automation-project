package com.testing.Utils;

import java.time.Instant;

public class Time {

    public static long getCurrentTimeInMillis() {
        Instant instant = Instant.now();
        return instant.toEpochMilli();
    }
}
