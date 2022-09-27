package Odev;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Odev11 extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {

    //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com");
    //2."Login Portal" a  kadar asagi inin
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();
    //4.Diger window'a gecin
        List<String> list=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(1));
    //5."username" ve  "password" kutularina deger yazdirin
        Faker faker=new Faker();
        actions.click(driver.findElement(By.cssSelector("#text")))
                .sendKeys(faker.name().username()).sendKeys(Keys.TAB).sendKeys(faker.internet().password()).perform();
        Thread.sleep(5000);
    //6."login" butonuna basin
        driver.findElement(By.cssSelector("#login-button")).click();
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        Assert.assertEquals("validation failed",driver.switchTo().alert().getText());
    //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
    //Ilk sayfaya geri donun
        driver.switchTo().window(list.get(0));
    //Ilk sayfaya donuldugunu test edin
        Assert.assertEquals("http://webdriveruniversity.com/",driver.getCurrentUrl());


    }
}
