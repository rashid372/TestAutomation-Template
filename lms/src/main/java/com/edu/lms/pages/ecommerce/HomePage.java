package com.edu.lms.pages.ecommerce;

import com.edu.lms.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;

    @Value("${app.ecommerce.url}")
    private String url;

    public void goTo(){
        this.webDriver.get(url);
        this.webDriver.manage().window().maximize();
    }

    public void ClickSignIn(){
        this.signInLink.click();
    }

    public void close(){
        this.webDriver.quit();
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until((d) -> this.signInLink.isDisplayed());
    }
}
