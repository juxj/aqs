package com.lh.common;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * Created by tju on 9/16/14.
 */
public abstract class ApplicationContextListener extends ContextLoaderListener {

    protected abstract void initialize(ApplicationContext applicationContext);
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        super.contextInitialized(event);
        ApplicationContext applicationContext = this.getCurrentWebApplicationContext();
        this.initialize(applicationContext);
    }
}
