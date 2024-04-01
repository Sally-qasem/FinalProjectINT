package loginTests.negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeLoginScenario {
    @Test(dataProvider = "NegativeLoginScenario")
    public void loginTest(String username, String password) {
        System.out.println(username + "- " + password);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement Password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userName.clear();
        Password.clear();

        String usernames = username;
        userName.sendKeys(username);
        String pass = password;
        Password.sendKeys(pass);

        loginButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        driver.quit();

//        WebElement errorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
//        String error = errorMessage.getText();
//        Assert.assertEquals(error, errorMessage.getText());
    }

    @DataProvider(name = "NegativeLoginScenario")
    public Object[][] getData()
    {
        Object[][] data = {{"standard_user","incorrect_pwd"},{"incorrect_user","secret_sauce"},{"incorrect_user","incorrect_pwd"},{"","secret_sauce"},{"standard_user",""},{"",""}};
        return data;
    }
}

