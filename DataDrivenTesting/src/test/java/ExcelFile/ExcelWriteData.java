package ExcelFile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class ExcelWriteData {


    public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet=workbook.createSheet("FirstSheet");

        String [][] str=new String[4][4];
        str[0][0]="SlNo";
        str[0][1]="UserName";
        str[0][2]="Password";
        str[0][3]="ConformPassword";
        for(int i=1;i<str.length;i++){
            String data=String.format("%s %s %s %s",String.valueOf(i), UUID.randomUUID().toString(),"Test@123","Test@123");
            String[] values=data.split(" ");
            for(int j=0;j<str[0].length;j++){
                String temp=values[j];
                str[i][j]=temp;
            }
        }



        //add the rows and columns
        for(int i=0;i<str.length;i++){
            Row row=sheet.createRow(i);
            for(int j=0;j<str[0].length;j++){
                Cell cell=row.createCell(j);
                cell.setCellValue(str[i][j]);
            }
        }

        for(int i=0;i<str[0].length;i++){
            sheet.autoSizeColumn(i);
        }

        //write the data to sheet
        try{
            FileOutputStream fos=new FileOutputStream("src/test/resources/DataSet1.xlsx");
            workbook.write(fos);
            workbook.close();
            System.out.println("Successfully data is created on excel sheet");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
