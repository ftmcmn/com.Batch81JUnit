package Yeni;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class Deneme1 extends TestBaseBeforeAfter {

    @Test
    public void testAmazon() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void testBestBuy() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void testTechproed() {
        driver.get("https://www.techproeducation.com");
    }

}
