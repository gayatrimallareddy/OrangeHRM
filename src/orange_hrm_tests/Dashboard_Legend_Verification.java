package orange_hrm_tests;

import org.testng.annotations.Test;

import orange_hrm_methods.Dashboard_Page;

public class Dashboard_Legend_Verification {
	
	Dashboard_Page dashboardObj = new Dashboard_Page();
	
	@Test
	public void legendVerification() throws Exception {
		dashboardObj.Login("admin");
		dashboardObj.dashboard();
		Thread.sleep(2000);
		dashboardObj.legend();
		Thread.sleep(2000);
		dashboardObj.Logout();
		dashboardObj.CloseBrowser();
	}
}
