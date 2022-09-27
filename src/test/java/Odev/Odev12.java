package Odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Odev12 extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        // Bir class oluşturun : D18_WebTables
        // 1- login( ) metodun oluşturun ve oturum açın.
        // 2- https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        //     Username : manager  ○ Password : Manager2!
        login();
        // 3- table( ) metodu oluşturun
        // 4- Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        System.out.println(driver.findElements(By.xpath("//thead//tr//th")).size());
        // 5- Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody")).getText());
        System.out.println(driver.findElement(By.xpath("//thead//tr")).getText());
        // 6- printRows( ) metodu oluşturun //tr
        // 7- table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> l=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(l.size());
        // 8- Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        l.forEach(t-> System.out.println(t.getText()));
        // 9- 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(l.get(4).getText());
        // 10- printCells( ) metodu oluşturun //td
        // 11- table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        System.out.println((l.size() * driver.findElements(By.xpath("//thead//tr//th")).size()));
        // 12- Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        for (int i = 1; i <=driver.findElements(By.xpath("//thead//tr//th")).size(); i++) {
            for (int j = 1; j <=l.size() ; j++) {

                System.out.print(driver.findElement(By.xpath("//tbody//tr[" + j + "]//td[" + i + "]")).getText());

            }
            System.out.println(" ");

        }
        List<WebElement> besinciColumnYazilari = driver.findElements(By.xpath("//tbody//td[5]"));
        besinciColumnYazilari.forEach(t-> System.out.print("bakalım : "+t.getText() + " "));
        // 13- printColumns( ) metodu oluşturun
        // 14- table body’sinde bulunan toplam sutun(column) sayısını bulun.

        // 15- Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        for (int i = 1; i <=driver.findElements(By.xpath("//thead//tr//th")).size() ; i++) {

            System.out.print(driver.findElement(By.xpath("//tbody//tr//td[" + i + "]")).getText());
            System.out.println(" ");

        }
        // 16- 5.column daki elementleri konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody//tr//td[5]")).getText());

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
