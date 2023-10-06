import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
        
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
    }
}