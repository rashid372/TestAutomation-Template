package com.edu.lms.pages.ecommerce;

import com.edu.lms.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EcomSignUp extends BasePage {

    @FindBy(css = "[name='email_create']")
    private WebElement email;

    @FindBy(xpath = "//button[@name=\"SubmitCreate\"]")
    private WebElement submitButton;

    public void registerEmail(){
        Double random=Math.random();
        this.email.sendKeys("automation_test"+random+"@test.com");
        submitButton.click();
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until((d) -> this.email.isDisplayed());
    }
}
