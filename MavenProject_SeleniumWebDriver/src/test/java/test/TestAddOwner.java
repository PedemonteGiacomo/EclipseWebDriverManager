package test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import POs.AddOwnerPO;
import POs.FailAddPO;
import POs.FindOwnerPagePO;
import POs.HomePO;
import POs.OwnerPO;

public class TestAddOwner extends DriverLifeCycleSetting {
	
	FindOwnerPagePO findOwner;
	AddOwnerPO addOwner; 
	AddOwnerPO notEmpty;
	AddOwnerPO notNumerical;
	OwnerPO owner;
	private HomePO home;

	@Test
	public void testFirstScenario() throws Exception {
		String firstname = "Charles";
		String lastname = "Smith";
		String address = "street 1";
		String city = "New York";
		String telephone = "123";
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		findOwner = (FindOwnerPagePO) home.find();
		assertTrue(findOwner.Displayed());
		addOwner = (AddOwnerPO) findOwner.add();
		owner = (OwnerPO) addOwner.fill(firstname, lastname, address, city, telephone);
		assertTrue(owner.Displayed());
		Thread.sleep(1500);
	}
	
	@Test
	public void testSecondScenario() throws Exception {
		String firstname = "John";
		String lastname = "Doe";
		String address = "street 1";
		String city = "";
		String telephone = "12345";
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		findOwner = (FindOwnerPagePO) home.find();
		assertTrue(findOwner.Displayed());
		addOwner = (AddOwnerPO) findOwner.add();
		notEmpty = (AddOwnerPO) addOwner.fill(firstname, lastname, address, city, telephone);
		assertTrue(notEmpty.ShouldNotBeEmpty());
		Thread.sleep(1500);
	}
	
	@Test
	public void testThirdScenario() throws Exception {
		String firstname = "John";
		String lastname = "Doe";
		String address = "street 1";
		String city = "city 1";
		String telephone = "1234574849405";
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		findOwner = (FindOwnerPagePO) home.find();
		assertTrue(findOwner.Displayed());
		addOwner = (AddOwnerPO) findOwner.add();
		Thread.sleep(1500);
		notNumerical = (AddOwnerPO) addOwner.fill(firstname, lastname, address, city, telephone);
		Thread.sleep(1500);
		assertTrue(notNumerical.NumericalValueOutOfBounds());
		Thread.sleep(1500);
	}
}

