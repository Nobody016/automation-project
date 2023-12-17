package com.testing.Utils;

import com.testing.Pages.WebPage;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Retry {
    private static final Logger log = LoggerFactory.getLogger(WebPage.class);


    public interface CallToRetry {
        void process() throws Exception;
    }

    @SneakyThrows
    public static boolean retryOnException(int retryDurrationInSecconds, long waitTimeBeweenRetys, String thrownErrorMessage, CallToRetry call) {
        long startTime = Time.getCurrentTimeInMillis();
        long executionStartTime = 0;
        long executionEndTime;
        long executionDuration;
        int counter = 0;

        if (retryDurrationInSecconds <= 0) {
            throw new IllegalArgumentException("The process duration must be a positive value");
        }
        if (waitTimeBeweenRetys <= 0) {
            throw new IllegalArgumentException("Initial wait must be at least 1 millisecond");
        }
        Exception thrown;
        do {
            try {
                executionStartTime = Time.getCurrentTimeInMillis();
                call.process();
                return true;
            } catch (Exception e) {
                executionEndTime = Time.getCurrentTimeInMillis();
                thrown = e;
                log.debug("Failed. Issue caused by '{}'. Using retry every {} milliseconds. Retry attempt: {}. Maximum execution duration: {} seconds", e.getMessage().split("Build info:")[0], waitTimeBeweenRetys, (counter + 1), retryDurrationInSecconds);
                counter++;
            }
            try {
                executionDuration = executionEndTime - executionStartTime;
                if (executionDuration < waitTimeBeweenRetys) {
                    Thread.sleep(waitTimeBeweenRetys - executionDuration);
                }
            } catch (InterruptedException wakeAndAbort) {
                break;
            }
        } while (Time.getCurrentTimeInMillis() < startTime + retryDurrationInSecconds * 1000L);
        log.debug("Failed. Issue caused by '{}'. Using retry every {} milliseconds. Retry attempt: {}. Maximum execution duration: {} seconds", thrown.getMessage(), waitTimeBeweenRetys, (counter + 1), retryDurrationInSecconds);
        throw new RuntimeException(thrownErrorMessage, thrown);
    }
}
