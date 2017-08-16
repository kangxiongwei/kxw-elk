package com.kxw.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kangxiongwei on 2017/8/16.
 */
public class FileLog {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileLog.class);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i< 1000; i++) {
            Thread.sleep(1000);
            LOGGER.info("this is the {} count", i);
        }
    }

}
