package Odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev3 {
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
      //● Bir class olusturun: IframeTest02
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        //2) sayfadaki iframe sayısını bulunuz.
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayını
        driver.get("http://demo.guru99.com/test/guru99home/");

        System.out.println(driver.findElements(By.xpath("//iframe")).size());

        WebElement x=driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(x);

        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        driver.switchTo().defaultContent();
        WebElement y=driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(y);

        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();



    }

}
