package Odev2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import utilities.TestBaseBeforeAfter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Odev extends TestBaseBeforeAfter {
    @Test
    public void name() {

        driver.get("https://neredekal.com");
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("(//img[@class='css-qx9cgk'])[1]")).click();//f
        driver.findElement(By.xpath("(//img[@class='css-qx9cgk'])[2]")).click();//t
        driver.findElement(By.xpath("(//img[@class='css-qx9cgk'])[3]")).click();//i
        driver.findElement(By.xpath("(//img[@class='css-qx9cgk'])[4]")).click();//y
        driver.findElement(By.xpath("(//img[@class='css-qx9cgk'])[5]")).click();//s

        List<String>list=new ArrayList<>(driver.getWindowHandles());

        //new WebDriverWait(driver, Duration.ofSeconds(20))
             //   .until(ExpectedConditions.numberOfWindowsToBe(6));


        System.out.println(list.get(1));

        driver.switchTo().window((String) driver.getWindowHandles().toArray()[2]);
        System.out.println(driver.getTitle());

        System.out.println((driver.getWindowHandles()).toArray()[2]);

        for (String a:list) {

            driver.switchTo().window(a);
            System.out.println(driver.getTitle());

        }

        for (int i = 0; i <list.size(); i++) {
            driver.switchTo().window(list.get(i));
            System.out.println(driver.getTitle());

        }
    }
}
