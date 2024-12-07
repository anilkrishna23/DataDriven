package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogout {
@FindBy(xpath="//a[@id='welcome']")
WebElement Objwelcome;
@FindBy(xpath="//a[normalize-space()='Logout']")
WebElement Objlog;
public void verifyLogout() throws Throwable
{
	Objwelcome.click();
	Thread.sleep(2000);
	Objlog.click();
}
}
