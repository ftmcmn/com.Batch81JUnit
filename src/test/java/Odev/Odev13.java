package Odev;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Odev13 {

    @Test
    public void test() throws IOException {
        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook wB= WorkbookFactory.create(fis);

        Sheet sht=wB.getSheet("Sayfa1");

        Row rw=sht.getRow(0);
        Cell cll= rw.getCell(1);

        System.out.println(cll);

        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim

        String cl=cll+"";
        System.out.println(cl);

        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim

        Assert.assertEquals("Kabil",wB.getSheet("Sayfa1").getRow(1).getCell(3).toString());
        //- Satir sayisini bulalim
        System.out.println(WorkbookFactory.create(new FileInputStream(dosyaYolu)).getSheet("Sayfa1").getLastRowNum());
        //- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sht.getPhysicalNumberOfRows());
        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String,String>mp=new HashMap<>();

        for (int i = 0; i <sht.getLastRowNum(); i++) {

           mp.put(sht.getRow(i).getCell(0).getStringCellValue(), sht.getRow(i).getCell(1).getStringCellValue());

        }
        System.out.println(mp);






    }
}
