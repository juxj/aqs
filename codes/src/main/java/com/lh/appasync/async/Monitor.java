package com.lh.appasync.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lh.appasync.dao.ICompositionDAO;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tju on 9/16/14.
 */
public abstract class Monitor implements Runnable, Consumer {

    private Queue<Object> queue = new LinkedList<Object>();
    private static Logger _logger = LoggerFactory.getLogger(Monitor.class);
    
    protected abstract void execute(Object obj);

    public Monitor() {}

    @Override
    public void put(Object obj) {
		queue.add(obj);
    }

    @Override
    public void run() {
        while(true) {
    		if (!queue.isEmpty()) {
                Object obj = queue.remove();
                this.execute(obj);
            } else {
                sleep(1);
            }
        }
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
//            _logger.debug("no tasks for executing, sleep {}", seconds);
        } catch (InterruptedException e) {

        }
    }

}
