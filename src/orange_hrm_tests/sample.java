package orange_hrm_tests;

import org.testng.annotations.Test;

import app.utilities.Excel_Methods;
import orange_hrm_methods.Dashboard_Page;

public class sample {
	
	Excel_Methods exclObj = new Excel_Methods();
	Dashboard_Page dbObj = new Dashboard_Page();
	
	@Test
	public void sampleMethod() throws Exception {
		/*amObj.Login("admin");
		String[] subTitles = amObj.MenuBar("Leave");
		for(String subTitle : subTitles) {
			System.out.println(subTitle);
		}*/
		
		/*System.out.println("*************************************************************");
		
		Excel_Methods exlObj = new Excel_Methods();
		Sheet sheetData = exlObj.Read_Excel_Sheet("OrangeHRM.xlsx", "Menu_Bar");
		String[] dataa = exlObj.Read_Column(sheetData, "PIM");
		System.out.println("length of Array "+dataa.length);
		for(String data : dataa){
			if(data!=null){
				System.out.println(data);
			}
			else{
				continue;
			}
		}*/
		
		System.out.println("*************************************************************");
		
		dbObj.Login("admin");
		dbObj.dashboard();
		dbObj.legend();
	}

}
