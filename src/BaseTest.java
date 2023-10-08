import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
        
   public static void main(String[] args){
    
       // Initialize the Chrome WebDriver 
       WebDriver driver = new ChromeDriver();

       AppTest myApp = new AppTest();
   
       myApp.testEmailAndPasswordFieldsExist(driver, "email-input", "password-input");
       myApp.testValidLogin(driver, "login@codility.com","password");
       myApp.testInvalidLogin(driver, "myemail@codility.com", "password");
       myApp.testInvalidEmailFormat(driver, "invalid-email-format", "password");
       myApp.testEmptyCredentials(driver);

       driver.quit();
    }
}