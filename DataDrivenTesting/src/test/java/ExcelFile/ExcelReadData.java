package ExcelFile;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReadData {
    public static String[][] readDataFromExcel(int num){
        int rowIndex=0;
        int cellIndex=0;
        List<List<String>> list=new ArrayList<>();
        String[][] str=null;

        try{
            File file=new File("src/test/resources/DataSet1.xlsx");
            FileInputStream fs=new FileInputStream(file);
            Workbook workbook=new XSSFWorkbook(fs);
            Sheet sheet=workbook.getSheetAt(num);
            Iterator<Row> rowIterator =sheet.rowIterator();

            while(rowIterator.hasNext()){
                Row row=rowIterator.next();
                List<String> innerList=new ArrayList<>();
                Iterator<Cell> cellIterator=row.cellIterator();
                while(cellIterator.hasNext()){
                    Cell cell=cellIterator.next();
                    if(rowIndex>0&&cellIndex>0){
                        if(cell.getCellType()== CellType.STRING){
                            innerList.add(cell.getStringCellValue());
                        }
                    }
                    cellIndex++;
                }
                rowIndex++;
                cellIndex=0;
                if(innerList.size()>0){
                    list.add(innerList);
                }
            }
            int row=list.size();
            int col=list.get(0).size();
            str=new String[row][col];

            for(int i=0;i<row;i++){
                str[i]=list.get(i).toArray(new String[0]);
            }



        }catch(IOException e){
            e.printStackTrace();
        }
        return str;
    }
}
