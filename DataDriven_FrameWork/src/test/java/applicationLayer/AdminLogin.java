package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
	@FindBy(name="txtUsername")
	WebElement ObjUser;
	@FindBy(name="txtPassword")
	WebElement Objpass;
	@FindBy(id="btnLogin")
	WebElement ObjLogin;
	public void verifyLogin(String user,String pass)
	{
		ObjUser.sendKeys(user);
		Objpass.sendKeys(pass);
		ObjLogin.click();
	}

}
