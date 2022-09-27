package Odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev4 {
    /*


    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin

     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1(){

        driver.get("https://the-internet.herokuapp.com/iframe");

        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//h3")).getText());

        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));

        driver.findElement(By.xpath("//p")).clear();
        driver.findElement(By.xpath("//p")).sendKeys("Merhaba Dunya!");

        driver.switchTo().defaultContent();

        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
        System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getText());

    }
}
