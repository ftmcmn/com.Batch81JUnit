package Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.List;

public class Odev7 extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        System.out.println(driver.getWindowHandle());
        //Cizili alan bölümün uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        List<String> list=new ArrayList<>(driver.getWindowHandles());
        System.out.println(list);

        driver.switchTo().window(list.get(1));
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());
    }

}
