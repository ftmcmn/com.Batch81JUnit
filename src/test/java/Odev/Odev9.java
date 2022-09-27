package Odev;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

import java.security.Key;

public class Odev9 extends TestBaseBeforeAfter {
        @Test
        public void test1() {
          //"https://facebook.com"  Adresine gidin
                driver.get("https://facebook.com");
          // “create new account”  butonuna basin
                driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
          // “firstName” giris kutusuna bir isim yazin

                Faker faker=new Faker();

                actions.click(driver.findElement(By.xpath("(//input[@type='text'])[2]")))
                        .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                        .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber())
                        .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                        .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("05")
                        .sendKeys(Keys.TAB).sendKeys("Oca").sendKeys(Keys.TAB).sendKeys("1975")
                        .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.LEFT)
                        .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                        .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        }
}
