package sanityTests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItems {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();


        WebElement cart = driver.findElement(By.cssSelector("#shopping_cart_container > a > span"));
        String numberOfItems = cart.getText();
        if (numberOfItems.equals("2")) {
            System.out.println("You have added 2 items to the cart.");
        } else {
            System.out.println("No items added to the cart!");
        }
        cart.click();

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/cart.html";

        if (currentURL.equals(expectedURL)) {
            System.out.println("This is the pages URL: " + currentURL);
        } else {
            System.out.println("Page not found!");
        }
        WebElement pageTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String title = pageTitle.getText();
        if (title.equals("Your Cart")) {
            System.out.println("The page title is: " + title);
        } else {
            System.out.println("You are not on the right page!");
        }

        WebElement cartQuantity1 = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_list > div:nth-child(4) > div.cart_quantity"));
        WebElement cartQuantity2 = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_list > div:nth-child(3) > div.cart_quantity"));
        int quantity1 = Integer.parseInt(cartQuantity1.getText());
        int quantity2 = Integer.parseInt(cartQuantity2.getText());
        int totalQuantity = quantity1 + quantity2;
        if (totalQuantity == 2){
        System.out.println("There are 2 items in the cart!");
    } else {
        System.out.println("Check your cart again");
    }
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        String currentURL1 = driver.getCurrentUrl();
        String expectedURL1 = " https://www.saucedemo.com/checkout-step-one.html";
        if (currentURL1.equals(expectedURL1)) {
            System.out.println("This is the pages URL: " + currentURL1);
        } else {
            System.out.println("Page not found!");
        }
        WebElement pageTileinfo = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String page = pageTileinfo.getText();
        if (page.equals("Checkout: Your Information")) {
            System.out.println("You are on the right page: " + page);
        } else {
            System.out.println("Wrong page!");
        }
        Faker faker = new Faker();
        driver.findElement(By.id("first-name")).sendKeys(faker.name().username());
        driver.findElement(By.id("last-name")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("postal-code")).sendKeys(faker.address().zipCode());
        driver.findElement(By.id("continue")).click();

        String checkOUTURL = driver.getCurrentUrl();
        if (checkOUTURL.equals(" https://www.saucedemo.com/checkout-step-two.html")) {
            System.out.println("You can checkout here: " + checkOUTURL);
        } else {
            System.out.println("continue your shopping!");
        }

       WebElement CheckoutTitlePage = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        String checkOutTitle = CheckoutTitlePage.getText();
        if (checkOutTitle.equals("Checkout: Overview"))
            System.out.println("The page title is: " + checkOutTitle);
        driver.findElement(By.id("finish")).click();

        String finishOrderURL = driver.getCurrentUrl();
        if (finishOrderURL.equals("https://www.saucedemo.com/checkout-complete.html")) {
            System.out.println("You have finished your order.");
        } else {
            System.out.println("Checkout not completed");
        }

        WebElement finishOrderTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        if (finishOrderTitle.getText().equals("Checkout: Complete!")) {
            System.out.println("That's the title of the page: " + finishOrderTitle.getText());
        }

        WebElement message1 = driver.findElement(By.cssSelector("#checkout_complete_container > h2"));
        System.out.println("This is the message you should get: " + message1.getText());
        WebElement message2 = driver.findElement(By.cssSelector("#checkout_complete_container > div"));
        System.out.println("Another message you should get is: " + message2.getText());

        driver.quit();
    }
}


