package com.setur.test;

import com.setur.base.BaseTest;
import com.setur.page.HomePage;
import org.junit.Test;

import java.io.IOException;


public class HomeTest extends BaseTest {
    @Test
    public void SeturHomepage() throws InterruptedException, IOException {
        new HomePage(driver).SeturHomepage();
    }
}

