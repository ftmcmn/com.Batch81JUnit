package Odev;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Odev15 {

    @Test
    public void name() throws IOException {
        //   //Yeni bir test method olusturalim readExcel2()

        System.out.println(WorkbookFactory.create(new FileInputStream("src/resources/ulkeler.xlsx"))
                .getSheet("Sayfa1").getRow(0).getCell(1));
        //    //-1.satirdaki 2.hucreye gidelim v eyazdiralim
        //    //-1.satirdaki 2.hucreyi bir string degiskene atayalim veyazdiralim

        //    //-2.satir 4.cell’in afganistan’in baskenti oldugunu testedelim
        //    //-Satir sayisinibulalim
        //    //-Fiziki olarak kullanilan satir sayisinibulun
        //    //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
    }
}
