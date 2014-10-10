package com.lh.appasync.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by tju on 9/22/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "/applicationContext.xml", "/applicationContext-service.xml",
        "/applicationContext-mystyle-master.xml", "/applicationContext-test-master.xml",
        "/applicationContext-async.xml", "/applicationContext-dao.xml",
        "/applicationContext-utils.xml", "/dispatcher-servlet.xml"})
@WebAppConfiguration
public abstract class BaseTestCase {
}
