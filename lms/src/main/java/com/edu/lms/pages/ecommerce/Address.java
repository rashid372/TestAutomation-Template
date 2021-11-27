package com.edu.lms.pages.ecommerce;

import com.edu.lms.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class Address extends BasePage {

    @FindBy(xpath = "//input[@id=\"id_gender1\"]")
    private WebElement genderRadio;

    @FindBy(id = "firstname")
    private WebElement firstname;

    @FindBy(id = "lastname")
    private WebElement lastname;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(name = "id_state")
    private WebElement statedropdown;

    @FindBy(name = "postcode")
    private WebElement postcode;

    @FindBy(id = "phone_mobile")
    private WebElement phone_mobile;

    @FindBy(xpath = "//input[@name=\"alias\"]")
    private WebElement phone_name;

    @FindBy(xpath = "//input[@name=\"alias\"]")
    private WebElement phone_lname;

    @FindBy(name = "submitAccount")
    private WebElement submitAccount;

    @FindBy(name = "customer_firstname")
    private WebElement custFirstName;

    @FindBy(name = "customer_lastname")
    private WebElement custLastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement finalText;



    public String saveAddress(){
        //Select Title
        this.genderRadio.click();
        this.custFirstName.sendKeys("Test User");
        this.custLastName.sendKeys("Vsoft");
        this.password.sendKeys("PKR@PKR");
        this.firstname.sendKeys("Test User");
        this.lastname.sendKeys("Vsoft");
        this.company.sendKeys("Vsoft");
        this.address1.sendKeys("Test 81/1,2nd cross");
        this.city.sendKeys("XYZ");
        Select oSelect=new Select(this.statedropdown);
        oSelect.selectByValue("4");
        this.postcode.sendKeys("51838");
        this.phone_mobile.sendKeys("234567890");
        this.phone_name.click();
        this.phone_name.sendKeys("Office");
        this.submitAccount.click();

        return finalText.getText();

    }
    public boolean isLoaded() {
        return this.wait.until((d) -> this.genderRadio.isDisplayed());
    }
}
