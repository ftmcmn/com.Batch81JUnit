package Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Odev8 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        actions.clickAndHold(driver.findElement(By.cssSelector("#draggable"))).perform();

        actions.dragAndDrop(driver.findElement(By.cssSelector("#draggable")),driver.findElement(By.xpath("//*[@id='droppable']"))).perform();



        //“Drop here” yazisi yerine “Dropped!” oldugunu test edin

       // Assert.assertEquals("Dropped!",driver.findElement(By.xpath("Dropped!")).getText());

        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }
}
