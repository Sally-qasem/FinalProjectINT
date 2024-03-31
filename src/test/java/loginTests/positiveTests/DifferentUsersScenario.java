package loginTests.positiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;


public class DifferentUsersScenario {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] users = {"problem_user", "performance_glitch_user", "error_user", "visual_user"};

        for (int i =0; i < users.length; i++) {
            WebElement userName = driver.findElement(By.id("user-name"));
            WebElement password = driver.findElement(By.id("password"));

            String user = users[i];
            userName.clear();
            userName.sendKeys(user);

            password.clear();
            password.sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.navigate().back();
        }
        driver.quit();
    }
    }

