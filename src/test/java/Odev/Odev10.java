package Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Odev10 extends TestBaseBeforeAfter {
    @Test
    public void name() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. code.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='text.txt']")).click();
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        Thread.sleep(5000);

        String ilk=System.getProperty("user.home");
       String son="\\Downloads\\text.txt";
       String top=ilk+son;

        Assert.assertTrue(Files.exists(Paths.get(ilk.concat(son))));



    }
}
