package DP;

import ExcelFile.ExcelReadData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPData {

    @DataProvider(name="testcase01")
    public Object[][] TestCase01(){
        return ExcelReadData.readDataFromExcel(0);
    }
}
