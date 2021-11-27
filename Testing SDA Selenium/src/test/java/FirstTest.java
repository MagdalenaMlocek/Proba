import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Grażyna\\Desktop\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearUp(){
        driver.quit();
    }

    @Test
    public void sdaWebPageTesting(){
        driver.get("https://sdacademy.pl");
        System.out.println(driver.findElement(By.className("heading-1")).getText());
        Assertions.assertEquals("Odważ się. Dokonaj zmiany.",driver.findElement(By.className("heading-1")).getText());


    }

    @Test
    public void sdaFromGoogleTest(){
        driver.manage().window().fullscreen();
        driver.get("https://www.google.pl");
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("software development academy");
        driver.findElement(By.name("btnK")).submit();
        driver.findElement(By.xpath("//*[@id=\"tads\"]/div[1]/div[1]/div/div[1]/a")).click();
        Assertions.assertEquals("@wp (19) Odebrane - WP Poczta",driver.getTitle());

    }

    @Test
    public void pocztaWpPl(){
        driver.get("https://profil.wp.pl");
        driver.findElement(By.id("login")).click();
        driver.findElement(By.name("login_username")).sendKeys("sdatesting");
        driver.findElement(By.name("password")).sendKeys("SDAtesting123!");
        driver.findElement(By.xpath("//*[@id=\"stgMain\"]/div/div/div[1]/form/button")).click();
        Assertions.assertEquals("@wp (19) Odebrane - WP Poczta",driver.getTitle());
    }

    @Test
    public void openSource(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).click();
        driver.findElement(By.name("txtUsername")).sendKeys("WrongUsername");
        driver.findElement(By.name("txtPassword")).sendKeys("WrongPassword");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        Assertions.assertEquals("Invalid credentials", driver.findElement(By.xpath("//*[@id=\"spanMessage\"]")).getText());
    }

}
