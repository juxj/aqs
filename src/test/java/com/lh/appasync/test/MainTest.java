package com.lh.appasync.test;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lh.appasync.controller.MainController;
/**
 * Created by tju on 9/22/14.
 */
public class MainTest extends BaseTestCase {

    private static Logger _logger = LoggerFactory.getLogger(MainTest.class);

    private MockMvc mockMvc ;

    @Autowired
    private MainController mainController;


    @Before
    public void initialize() {
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void doTest() throws Exception{
        this.mockMvc.perform(get("/main/test")).andExpect(status().isOk());
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


}
