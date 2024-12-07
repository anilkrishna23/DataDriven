package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationLayer.AddEmp;
import config.Base;
import utilities.ExcelFileUtil;

public class AppTest extends Base{
String inputpath="./FileInput/Employee.xlsx";
String outputpath="./FileOutput/DataDrivenResult.xlsx";
String TCSheet="EmpData";
ExtentReports reports;
ExtentTest logger;
@Test
public void startTest() throws Throwable
{
	reports = new ExtentReports("./target/reports/AddEmp.html");
	//create reference object for excel file util class
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	int rc = xl.rowCount(TCSheet);
	Reporter.log("No of row"+rc,true);
	for(int i=1;i<=rc;i++)
	{
		// start test
		logger = reports.startTest("Validate Add Emp");
		logger.assignAuthor("Anil");
		//read all cells from TCsheet
		String Fname=xl.getCellData(TCSheet, i,0 );
		String Mname=xl.getCellData(TCSheet, i, 1);
		String Lname=xl.getCellData(TCSheet, i, 2);
		AddEmp emp =PageFactory.initElements(driver,AddEmp.class);
		boolean res = emp.verifyEmp(Fname, Mname, Lname);
		if(res)
		{
			xl.setCellData(TCSheet,i, 3,"Pass",outputpath);
			logger.log(LogStatus.PASS,"Add Employee");
		}
		else
		{
			xl.setCellData(TCSheet, i, 3, "Fail",outputpath);
			logger.log(LogStatus.FAIL,"");
		}
			reports.endTest(logger);
			reports.flush();
	}
}
}
