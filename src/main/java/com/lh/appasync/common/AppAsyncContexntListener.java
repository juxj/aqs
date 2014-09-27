package com.lh.appasync.common;

import com.lh.common.ApplicationContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;


/**
 * Created by tju on 9/16/14.
 */
public class AppAsyncContexntListener  extends ApplicationContextListener{

    private static Logger _logger = LoggerFactory.getLogger(AppAsyncContexntListener.class);

    @Override
    protected void initialize(ApplicationContext applicationContext) {
        _logger.debug("initialize application before system booting up.");
    }

}
