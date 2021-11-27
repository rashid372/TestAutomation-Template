package com.edu.lms;

import com.edu.lms.pages.google.GooglePage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.util.List;

@SpringBootTest
class LmsApplicationTests {

    @Value("${app.url}")
    private String appUrl;

    @Value("chrome,firefox,edge")
    private List<String> browsers;

    @Autowired
    private GooglePage googlePage;

    @Test
    void performTest() {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isLoaded());
        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isLoaded());
      //  Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.googlePage.close();
    }

}
