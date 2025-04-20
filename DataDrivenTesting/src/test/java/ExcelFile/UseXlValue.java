package ExcelFile;

public class UseXlValue {
    public static void main(String [] args){
        ExcelReadData read=new ExcelReadData();
        String[][] res=read.readDataFromExcel(0);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.println(res[i][j]);
            }
        }
    }
}
