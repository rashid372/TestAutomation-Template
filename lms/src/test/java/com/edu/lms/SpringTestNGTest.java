package com.edu.lms;

import com.edu.lms.pages.google.GooglePage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


@SpringBootTest
public class SpringTestNGTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebDriver webDriver;

    @Value("${app.url}")
    private String appUrl;

    @Autowired
    private GooglePage googlePage;


    @BeforeTest
    protected void setupWebDriver(){
        webDriver.navigate().to(appUrl);
    }

    @Test
    public void testLogin() {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isLoaded());
        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isLoaded());
     //   Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.googlePage.close();
    }

    @BeforeClass(alwaysRun = true)
    @BeforeSuite(alwaysRun = true)
    @Override
    protected void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();
    }

}
