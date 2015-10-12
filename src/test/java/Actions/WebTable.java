package Actions;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.MainClass;

public class WebTable extends MainClass {
	
	public static ArrayList<String> getTableData(By tableID) {
		ArrayList<String> tableData = new ArrayList<String>();
		   WebElement simpleTable = getElement(tableID);		   
		   List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
		   for (WebElement row : rows) {
		      List<WebElement> cols = row.findElements(By.tagName("td"));
		      for (WebElement col : cols) {
//		         System.out.print(col.getText() + "\t");
		         tableData.add(col.getText() + "\t");
		      }
		   System.out.println();
		   }
		   return tableData;
		}

}
