package loginTests.negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class NegativeLoginScenario {
    @Test(dataProvider = "NegativeLoginScenario")
    public void loginTest(String username, String password, String expectedError) {
        System.out.println(username +  "- " + password + " " +expectedError);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement Password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userName.clear();
        Password.clear();

        userName.sendKeys(username);
        Password.sendKeys(password);

        loginButton.click();
        WebElement errorMessageElement = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        String actualError = errorMessageElement.getText();
        Assert.assertEquals(actualError, expectedError);
    }
    @DataProvider(name = "NegativeLoginScenario")
    public Object[][] getData()
    {
        Object[][] data = {
                {"standard_user","incorrect_pwd", "Epic sadface: Username and password do not match any user in this service"},
                {"incorrect_user","secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"incorrect_user","incorrect_pwd", "Epic sadface: Username and password do not match any user in this service"},
                {"","secret_sauce", "Epic sadface: Username is required"},
                {"standard_user","", "Epic sadface: Password is required"},
                {"","", "Epic sadface: Username is required"}
        };
        return data;
    }
}