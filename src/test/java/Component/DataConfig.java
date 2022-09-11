package Component;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.Properties;

public class DataConfig {

    public static String LOGIN_ADDRESS;

    public static  String dataConfigXlsx[][];

    public void properties() throws IOException {

        Properties p = new Properties();

        InputStream inputStream = new FileInputStream("dataConfig.properties");
        p.load(inputStream);

        LOGIN_ADDRESS = p.getProperty("LOGIN_ADDRESS");


    }
    public String[][] propertiesExcel(String sheetXlsx) throws IOException {



        FileInputStream fileInputStream = new FileInputStream(sheetXlsx);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int totalRows = sheet.getLastRowNum();
        Row row = sheet.getRow(0);
        int totalsCols = row.getLastCellNum();



        DataFormatter formatter = new DataFormatter();
        dataConfigXlsx=new String[totalRows][totalsCols];

        for (int i=0; i<totalRows; i++){
            for(int j=0; j<totalsCols; j++){
                dataConfigXlsx[i][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));

            }
        }
    return dataConfigXlsx;

    }
}
