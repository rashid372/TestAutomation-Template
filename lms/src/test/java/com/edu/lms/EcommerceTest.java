package com.edu.lms;

import com.edu.lms.pages.ecommerce.Address;
import com.edu.lms.pages.ecommerce.EcomSignUp;
import com.edu.lms.pages.ecommerce.HomePage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest
public class EcommerceTest {

    @Autowired
    private HomePage homePage;

    @Autowired
    private EcomSignUp ecomSignUp;

    @Autowired
    private Address address;

    @Test
    void performTest() {
        homePage.goTo();
        homePage.ClickSignIn();
        if (ecomSignUp.isLoaded()){
            ecomSignUp.registerEmail();
        }
        if (address.isLoaded()){
            Assert.assertTrue(address.saveAddress().contains("Vsoft"));
        }

        homePage.close();

    }
}
