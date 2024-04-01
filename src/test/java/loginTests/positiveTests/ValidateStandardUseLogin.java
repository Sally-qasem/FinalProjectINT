package loginTests.positiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateStandardUseLogin {
    @Test(testName = "Standard User Login Scenario")
    public void ValidateStandardUseLogin(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));

        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement pageTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String title = pageTitle.getText();
        Assert.assertEquals(title, pageTitle.getText());
    }
}