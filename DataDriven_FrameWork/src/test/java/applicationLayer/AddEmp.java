package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmp {
WebDriver driver;
public AddEmp(WebDriver driver)
{
	this.driver=driver;
}

	@FindBy(xpath="//b[normalize-space()='PIM']")
	WebElement Objpim;
	@FindBy(name="btnAdd")
	WebElement Objadd;
	@FindBy(name="firstName")
	WebElement Objfname;
	@FindBy(name="middleName")
	WebElement Objmname;
	@FindBy(name="lastName")
	WebElement Objlname;
	@FindBy(name="employeeId")
	WebElement ObjEid;
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement Objsave;
	@FindBy(name="personal[txtEmployeeId]")
	WebElement ObjId;
	
	public boolean verifyEmp(String Objfname,String mname ,String lname) throws Throwable
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(Objpim).click().perform();
		Thread.sleep(2000);
		ac.moveToElement(Objadd).click().perform();
		Thread.sleep(2000);
		this.Objfname.sendKeys(Objfname);
		Objmname.sendKeys(mname);
		Objlname.sendKeys(lname);
		String Exp_Data=ObjEid.getAttribute("value");
		ac.moveToElement(Objsave).click().perform();
		String Act_Data=ObjId.getAttribute("value");
		Thread.sleep(2000);
		if(Act_Data.equals(Exp_Data))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
