package com.sapat.intro;

import java.util.concurrent.TimeUnit;

public class Helper {
    public static void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
