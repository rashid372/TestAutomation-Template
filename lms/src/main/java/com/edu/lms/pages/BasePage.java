package com.edu.lms.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class BasePage {

    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected WebDriverWait wait;

    @PostConstruct
    public void InitPage() {
        PageFactory.initElements(webDriver, this);
    }

    public abstract boolean isLoaded();
}
