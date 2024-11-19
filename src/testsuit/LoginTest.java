package testsuit;
/**
 * Write down the following test in the ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully()
 * * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage()
 * * click on the ‘Sign In’ link
 * * Enter the invalid username
 * * Enter the invalid password
 * * Click on the ‘Sign in’ button
 * * Verify the error message ‘Invalid email
 * or password.’
 */

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseURL = "https://courses.ultimateqa.com/";

    @Before
    public void setUpBrowser() {
        openBrowser(baseURL);

    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //click on sign in link
        driver.findElement(By.linkText("Sign In")).click();

        String expectedText = "Welcome Back!";
        WebElement welcomeText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualText = welcomeText.getText();

        //Verify with assert JUnit test
        Assert.assertEquals("not verified", expectedText, actualText);

    }
    @Test
    public void verifyTheErrorMessage () {
        driver.findElement(By.linkText("Sign In")).click();

        driver.findElement(By.id("user[email]")).sendKeys("Prime.123@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("Prime123");

        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        String expectedText = "Invalid email or password.";

        WebElement inValidText = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualText = inValidText.getText();

        //Verify with assert JUnit test
        Assert.assertEquals("not error message", expectedText, actualText);

    }

}

