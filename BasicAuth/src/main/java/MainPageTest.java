import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.CapabilityType.PROXY;

/**
 * Created by Julia Klimova
 */

public class MainPageTest extends DriverInit {


    @Test
    public void case00() throws Exception {

        // 1. Открыть https://auth-demo.aerobatic.io/


        driver.get("https://auth-demo.aerobatic.io/");

        WebElement element = driver.findElement(By.xpath("//*[@id=\"examples\"]/div/p[2]/a[1]"));


        // 3. Пройти авторизацию (логин и пароль "aerobatic")
        File autoIt = new File("./libs/script1.exe");
        // запуск exe с передачей учетных данных в качестве параметра
        Process p = Runtime.getRuntime().exec(autoIt.getAbsolutePath());

        // 2. Нажать кнопку "Standart auth"
        element.click();

        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/p/a")).isEnabled(),
                "Case 00 is failed.");
        System.out.println("Case 00 is passed.");
    }

}
