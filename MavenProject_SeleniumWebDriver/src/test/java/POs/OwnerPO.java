package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OwnerPO extends BasePagePO{

	//locator as fields
	private By Owner_individual = By.xpath("//th[contains(text(),'Name')]");
	
	//when the individual owner is targeted
	private By EditOwner = By.xpath("//a[contains(text(),'Owner')]");
	private By AddNewPet = By.xpath("//a[contains(text(),'New Pet')]");
	private By AddVisit = By.xpath("/html/body/div/div/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a");

	private By NotFound = By.xpath("//p[contains(text(),'has not been found')]");
	public String lastname;
	
	private By Description = By.xpath("/html/body/div/div/table[2]/tbody");
	
	
	public OwnerPO(WebDriver driver, String lastName) {
		// TODO Auto-generated constructor stub
		super(driver);
		String url = "http://localhost:8080/owners?lastName=" + lastName;
		visit(url);
		lastname = lastName;
	}
	
	public BasePagePO edit() {
		click(EditOwner);
		return new EditOwnerPO(driver, lastname);
	}
	
	public BasePagePO addVisit() {
		click(AddVisit);
		return new AddVisitPO(driver, lastname);
	}

	public boolean Displayed() {
		return isIn(Owner_individual);
	}
	
	public boolean NotFound() {
		return isIn(NotFound);
	}
	
	public boolean changedDescription(String desc) {
		return find(Description).getText().contains(desc);
	}
}
