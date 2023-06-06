package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditOwnerPO extends BasePagePO{

	//locator as fields
	private By Owner_edit = By.xpath("//h2[contains(text(),'Owner')]");
	
	//Owner add form
	private By FirstName = By.xpath("//input[@id='firstName']");
	private By LastName = By.xpath("//input[@id='lastName']");
	private By Address = By.xpath("//input[@id='address']");
	private By City = By.xpath("//input[@id='city']");
	private By Telephone = By.xpath("//input[@id='telephone']");
	private By Modify = By.xpath("//button[@type='submit']");
	
	//notEmptyFields
	private By notEmptyFields = By.xpath("/html/body/div/div/form/div[1]/div[1]/div/span[2]");
	private By numericalValueOutOfBounds = By.xpath("/html/body/div/div/form/div[1]/div[5]/div/span[2]");
	
	//save lastname of the user to edit
	public String lastname;
	public String url;
	
	public EditOwnerPO(WebDriver driver, String lastName) {
		// TODO Auto-generated constructor stub
		super(driver);
		url = "http://localhost:8080/owners/1/edit";
		visit(url);
		lastname = lastName;
	}
	
	public BasePagePO modify(String identifier, String modify) throws InterruptedException {
	    if (identifier.equals("firstname")) {
	    	clearAndType(FirstName, modify);
	    } else if (identifier.equals("lastname")) {
	    	clearAndType(LastName, modify);
	        if (modify != null && !modify.isEmpty()) {
	            lastname = modify;
	        }
	    } else if (identifier.equals("address")) {
	    	clearAndType(Address, modify);
	    } else if (identifier.equals("city")) {
	    	clearAndType(City, modify);
	    } else if (identifier.equals("telephone")) {
	    	clearAndType(Telephone, modify);
	    }
	    Thread.sleep(1500);
	    click(Modify);
	    String getUrl = getUrl();
	    //if ((identifier.equals("telephone") && (modify.length() > 10 || modify.matches("[a-zA-Z]+"))) || modify == null || modify.isEmpty()) {
	    if (getUrl.equals(url))return this; // if the url remains the same for some reasons should be caused by an error
	    else return new OwnerPO(driver, lastname);
	}

	

	public boolean Displayed() {
		return isIn(Owner_edit);
	}
	
	public boolean ShouldNotBeEmpty() {
		return isIn(notEmptyFields);
	}

	public boolean NumericalValueOutOfBounds() {
		return isIn(numericalValueOutOfBounds);
	}

}
