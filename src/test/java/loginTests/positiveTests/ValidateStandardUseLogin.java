package loginTests.positiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateStandardUseLogin {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));

        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        String currentURL = driver.getCurrentUrl();
        if (currentURL.equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("You have logged in successfuly!");
        } else {
            System.out.println("Something is wrong.. Try again!");
        }

        WebElement pageTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String title = pageTitle.getText();
        if (title.equals("Products")){
            System.out.println("The title of the page is: " + title);
        } else {
            System.out.println("The title of the page is wrong!");
        }
    }
}