package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOwnerPO extends BasePagePO{

	//locator as fields
	private By Owner_individual = By.xpath("//th[contains(text(),'Name')]");
	
	//Owner add form
	private By FirstName = By.xpath("//input[@id='firstName']");
	private By LastName = By.xpath("//input[@id='lastName']");
	private By Address = By.xpath("//input[@id='address']");
	private By City = By.xpath("//input[@id='city']");
	private By Telephone = By.xpath("//input[@id='telephone']");
	private By Add = By.xpath("//button[@type='submit']");
	
	//notEmptyFields
	private By notEmptyFields = By.xpath("//*[@id=\"add-owner-form\"]/div[1]/div[4]/div/span[2]");
	private By numericalValueOutOfBounds = By.xpath("//*[@id=\"add-owner-form\"]/div[1]/div[5]/div/span[2]");
	private String url;
	
	public AddOwnerPO(WebDriver driver) {
		super(driver);
		url = "http://localhost:8080/owners/new";
		visit(url);
	}
	
	public BasePagePO fill(String firstname, String lastname, String address,String city,String telephone) throws InterruptedException {
		type(FirstName, firstname);
		type(LastName, lastname);
		type(Address, address);
		type(City, city);
		type(Telephone, telephone);
		Thread.sleep(1500);
		click(Add);
		//if(((firstname == null || firstname == "") || (lastname == null || lastname == "") || (address == null || address == "") || (telephone == null || telephone == "") || (city == null || city == "")) || telephone.length() > 10){
		String getUrl = getUrl();
		if(getUrl.equals(url))return this;
		else return new OwnerPO(driver, lastname);
	}

	public boolean Displayed() {
		return isIn(Owner_individual);
	}
	
	public boolean ShouldNotBeEmpty() {
		return isIn(notEmptyFields);
	}

	public boolean NumericalValueOutOfBounds() {
		return isIn(numericalValueOutOfBounds);
	}

}
