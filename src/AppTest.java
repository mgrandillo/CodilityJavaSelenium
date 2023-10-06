import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
 
public class AppTest extends BaseTestFinal {

    @Test //Test that the login is successful with valid credentials
    public void testValidLogin(WebDriver driver, String email, String password){
    
        WebElement emailInput = driver.findElement(By.id("email-input"));
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();

        WebElement successMessage = driver.findElement(By.className("success"));

        assert successMessage.isDisplayed() : "Valid login failed. Welcome message is not visible";
    }
     
     @Test //Test that the email and password fields exists in the page
      public void testEmailAndPasswordFieldsExist(WebDriver driver, String emailId, String passwordId) {
        
        WebElement emailInput = driver.findElement(By.id(emailId));
        WebElement passwordInput = driver.findElement(By.id(passwordId));

        assert emailInput.isDisplayed() : "Email input field is not present";
        assert passwordInput.isDisplayed() : "Password input field is not present";
    }

    @Test //Validate that the login is unsuccessful using an invalid email address
    public void testInvalidLogin(WebDriver driver, String invalidEmail, String password) {
        WebElement emailInput = driver.findElement(By.id("email-input"));
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        emailInput.sendKeys(invalidEmail);
        passwordInput.sendKeys(password);
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("error"));

        assert errorMessage.isDisplayed() : "Invalid login failed. Error message is not visible";
    }
    
    @Test //Validate that the login is unsuccessful with an invalid email format
    public void testInvalidEmailFormat(WebDriver driver, String invalidEmailFormat, String password) {
        WebElement emailInput = driver.findElement(By.id("email-input"));
        WebElement passwordInput = driver.findElement(By.id("password-input"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        emailInput.sendKeys(invalidEmailFormat);
        passwordInput.sendKeys(password);
        loginButton.click();

        WebElement validationError = driver.findElement(By.className("error"));

        assert validationError.isDisplayed() : "Invalid email format check failed. Validation error message is not visible";
        assert validationError.getText().equals("Enter a valid email") : "Invalid email format check failed. Incorrect validation message";
    }

    @Test ////Validae that the login is unsuccessful with empty credentials
    public void testEmptyCredentials(WebDriver driver) {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement emailValidationError = driver.findElement(By.id("messages"));
        WebElement passwordValidationError = driver.findElement(By.className("error"));

        assert emailValidationError.isDisplayed() && emailValidationError.getText().equals("Email is required") : "Empty email check failed. Validation error message for email is not visible or incorrect";
        assert passwordValidationError.isDisplayed() && passwordValidationError.getText().equals("Password is required") : "Empty password check failed. Validation error message for password is not visible or incorrect";
    }
}

class BaseTestFinal {
  public static void main(String[] args){
    
       // Initialize the Chrome WebDriver 
        WebDriver driver = new ChromeDriver();
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

       AppTest myApp = new AppTest();
   
       myApp.testEmailAndPasswordFieldsExist(driver, "email-input", "password-input");
       myApp.testValidLogin(driver, "login@codility.com","password");
      
       driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
       myApp.testInvalidLogin(driver, "myemail@codility.com", "password");
       
       driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
       myApp.testInvalidEmailFormat(driver, "invalid-email-format", "password");

        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        myApp.testEmptyCredentials(driver);

        driver.quit();
    }
}  