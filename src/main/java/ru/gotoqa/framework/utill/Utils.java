package ru.gotoqa.framework.utill;

import lombok.extern.log4j.Log4j2;

/**
 * Utility class
 */
@Log4j2
public class Utils {

    private Utils() {
    }

    /**
     * Stop the thread (ms)
     * (n00b uses only)
     *
     * @param pauseValue - ms
     */
    public static void pause(int pauseValue) {
        try {
            Thread.sleep(pauseValue);
        } catch (InterruptedException ex) {
            log.warn("Thread was interrupted", ex);
            Thread.currentThread().interrupt();
        }
    }

}
