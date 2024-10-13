package com.mastercard.demo.demo.async;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskScheduler {

    private static final Logger LOGGER = LogManager.getLogger(AsyncTaskScheduler.class);
    ThreadPoolTaskExecutor executor;

    @Autowired
    AsyncTaskScheduler(ThreadPoolTaskExecutor executor) throws InterruptedException
    {
        this.executor = executor;
    }

    public void performTask()
    {
        executor.execute(this::run);
    }

    public void run() {
        try {
            LOGGER.debug("Thread pool running with : " + Thread.currentThread().getName());
            Thread.sleep(2000);
        }
        catch(InterruptedException ie)
        {

        }

    }
}
