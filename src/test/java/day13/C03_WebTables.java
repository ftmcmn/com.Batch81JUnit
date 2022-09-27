package day13;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_WebTables extends TestBaseBeforeAfter {
    //Bir önceki class'daki adrese gidelim
    //Login() methodunu kullanarak sayfaya giriş yapalım
    //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım

    int satir = 3;
    int sutun = 4;

    @Test
    public void name() {

       login();

        System.out.println(driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]")).getText());
    }
    public void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }




}
