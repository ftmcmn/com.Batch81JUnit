package Odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Odev6 {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1(){

        driver.get("https://the-internet.herokuapp.com/windows");

        driver.findElement(By.linkText("Elemental Selenium")).click();

        Set<String> st =new HashSet<>(driver.getWindowHandles());
        System.out.println("set : "+st);

        List<String> list=new ArrayList<>(driver.getWindowHandles());

        System.out.println(list);

        driver.switchTo().window(list.get(1));
        driver.findElement(By.xpath("//*[@class='link']")).click();

        st=driver.getWindowHandles();
        System.out.println("set : "+st);
        list=new ArrayList<>(st);
        System.out.println(list);

        driver.switchTo().window(list.get(2));
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[@class='button is-rounded is-secondary']")).click();

        driver.switchTo().window(list.get(0));
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();


        list=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(3));
        System.out.println(driver.getTitle());
        System.out.println(list);
        for (String a:list
             ) {

            System.out.println("a hashkod : "+a.hashCode());
            System.out.println("a : "+a);
        }
        //String a =list.get(3);




    }
}
