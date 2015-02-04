import java.io.File;
import java.io.IOException;
import java.awt.Desktop;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;

import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelReader  
{
    Cell cell;
    Number number;
    public void readFile() throws BiffException, IOException, WriteException
    {
        Workbook workbook = Workbook.getWorkbook(new File("Cards.xls"));
        Sheet sheet0 = workbook.getSheet(0);
      
        for(int i=1;i<sheet0.getRows();i++)
        {
            cell = sheet0.getCell(0, i);
            ToolCard.TOOL_CARDS.add(cell.getContents().toString());
        }
        Sheet sheet1 = workbook.getSheet(1);
      
        for(int i=1;i<sheet1.getRows();i++)
        {
            cell = sheet1.getCell(0, i);
            ImpedimentCard.IMPEDIMENT_CARDS.add(cell.getContents().toString());
        }
        Sheet sheet2 = workbook.getSheet(2);
      
        for(int i=1;i<sheet2.getRows();i++)
        {
            cell = sheet2.getCell(0, i);
            OpportunityCard.OPPORTUNITY_CARDS.add(cell.getContents().toString());
        }
        
        System.out.println("Tools : " + ToolCard.TOOL_CARDS.size() + ", Impediment : " + ImpedimentCard.IMPEDIMENT_CARDS.size() + ", Opportunity : " + OpportunityCard.OPPORTUNITY_CARDS.size());
        workbook.close();
    }
   
   public void writeToFile() throws BiffException, IOException, WriteException {
       /* System.out.println("Inside Write to excel File.");
        Workbook wb = Workbook.getWorkbook(new File("abc.xls"));
        WritableWorkbook copy = Workbook.createWorkbook(new File("Graph.xls"),wb);
        WritableSheet sheet = copy.getSheet(0);     

        for(int j = 0; j < 11; j++){
            number = new Number(j, 5, ScrumWorld.graph_Values.get(j));
        }
        
        sheet.addCell(number);
        copy.write();
        copy.close();
        
        //Display Graph from excel file.
        Desktop dt = Desktop.getDesktop();
        dt.open(new File("Graph.xls"));*/
        
    }
}
