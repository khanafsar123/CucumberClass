package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class loginSteps extends CommonMethods {





   // WebDriver driver;

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        openBrowserAndLaunchApplication();

        //because we are calling the method
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login%22");
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
    }

    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        //LoginPage login = new LoginPage();
        //   WebElement usernameField = driver.findElement(By.id("txtUsername"));
        // usernameField.sendKeys(ConfigReader.getPropertyValue("username"));
        sendText(login.usernameTextField, ConfigReader.getPropertyValue("username"));
        //  WebElement passwordField = driver.findElement(By.id("txtPassword"));
        //    passwordField.sendKeys(ConfigReader.getPropertyValue("password"));
        sendText(login.passwordTextField, ConfigReader.getPropertyValue("password"));



     /*
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        sendText(userName, ConfigReader.getPropertyValue("username"));
        //userName.sendKeys(ConfigReader.getPropertyValue("username"));
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
       sendText(password, ConfigReader.getPropertyValue("password"));
        // password.sendKeys(ConfigReader.getPropertyValue("password"));*/

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
      //  LoginPage login = new LoginPage();
        //  WebElement loginButton = driver.findElement(By.id("btnLogin"));
        click(login.loginButton);



     /*   WebElement logIn = driver.findElement(By.xpath("//input[@name = 'Submit']"));
        logIn.click();*/
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        WebElement welcomeMessage=driver.findElement(By.id("welcome"));
        if(welcomeMessage.isDisplayed()) {
            System.out.println("Test case is passed");
        }
        else {
            System.out.println("Test is failed");
        }

    }


    @When("user enters ess username and ess password")
    public void user_enters_ess_username_and_ess_password() {
                  //  LoginPage login = new LoginPage();
            // WebElement usernameField = driver.findElement(By.id("txtUsername"));
            sendText(login.usernameTextField, "asmahuma321");
            //   WebElement passwordField = driver.findElement(By.id("txtPassword"));
            sendText(login.passwordTextField, "Hum@nhrm123");




       /* WebElement usernameField = driver.findElement(By.id("txtUsername"));
        sendText(usernameField, "asmahuma321");
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        sendText(passwordField, "Hum@nhrm123");*/
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
       // LoginPage login = new LoginPage();
        // WebElement usernameField = driver.findElement(By.id("txtUsername"));
        sendText(login.usernameTextField, "admin123");
        //  WebElement passwordField = driver.findElement(By.id("txtPassword"));
        sendText(login.passwordTextField, "Hum@nhrm");



        /*WebElement usernameField = driver.findElement(By.id("txtUsername"));
        sendText(usernameField, "admin123");
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        sendText(passwordField, "Hum@nhrm");*/
    }

    @Then("error message displayed")
    public void error_message_displayed() {
        System.out.println("Error message displayed");
    }




}
