package loginTests.negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeLoginScenarios {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        String[] usernames = {"standard_user", "incorrect_user", "", "incorrect_user", "", "standard_user", ""};
        String[] passwords = {"incorrect_password", "secret_sauce", "incorrect_password", "secret_sauce", "", ""};

        for (int i = 0; i < usernames.length; i++) {
            for (int b = 0; b < passwords.length; b++) {
                WebElement userName = driver.findElement(By.id("user-name"));
                WebElement password = driver.findElement(By.id("password"));
                WebElement loginButton = driver.findElement(By.id("login-button"));

                userName.clear();
                password.clear();

                String username = usernames[i];
                userName.sendKeys(username);
                String pass = passwords[b];
                password.sendKeys(pass);

                loginButton.click();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.navigate().refresh();
            }
            driver.quit();
        }
    }
}

