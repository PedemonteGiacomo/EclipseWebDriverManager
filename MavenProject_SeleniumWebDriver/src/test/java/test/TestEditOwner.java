package test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import POs.AddOwnerPO;
import POs.EditOwnerPO;
import POs.FailAddPO;
import POs.FindOwnerPagePO;
import POs.HomePO;
import POs.OwnerPO;
import POs.OwnersPO;

public class TestEditOwner extends DriverLifeCycleSetting {
	
	// to obtain the findOwner page
	private FindOwnerPagePO findOwner;
	// for lists and individuals
	private OwnerPO individual;
	private OwnersPO list;
	// to edit
	private EditOwnerPO edit;
	private EditOwnerPO individualEditedWrongly;
	private HomePO home;

	@Test
	public void testFirstScenario() throws Exception {
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		findOwner = (FindOwnerPagePO) home.find();
		assertTrue(findOwner.Displayed());
		Thread.sleep(1500);
		// goto list of owners
		list = (OwnersPO) findOwner.search(null);
		assertTrue(list.Displayed());
		Thread.sleep(1500);
		// goto Franklin individual owner page
		individual = (OwnerPO) list.choose();
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
		// go to the edit page and edit the city
		edit = (EditOwnerPO) individual.edit();
		assertTrue(edit.Displayed());
		Thread.sleep(1500);
		// verify the edit
		individual = (OwnerPO) edit.modify("city", "New York");
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
	}
	
	@Test
	public void testSecondScenario() throws Exception {
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		findOwner = (FindOwnerPagePO) home.find();
		assertTrue(findOwner.Displayed());
		Thread.sleep(1500);
		// goto list of owners
		list = (OwnersPO) findOwner.search(null);
		assertTrue(list.Displayed());
		Thread.sleep(1500);
		// goto Franklin individual owner page
		individual = (OwnerPO) list.choose();
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
		// go to the edit page and edit the city
		edit = (EditOwnerPO) individual.edit();
		assertTrue(edit.Displayed());
		Thread.sleep(1500);
		// verify the edit
		individualEditedWrongly = (EditOwnerPO) edit.modify("firstname", "");
		assertTrue(individualEditedWrongly.ShouldNotBeEmpty());
		Thread.sleep(1500);
	}
	
	@Test
	public void testThirdScenario() throws Exception {
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		findOwner = (FindOwnerPagePO) home.find();
		assertTrue(findOwner.Displayed());
		Thread.sleep(1500);
		// goto list of owners
		list = (OwnersPO) findOwner.search(null);
		assertTrue(list.Displayed());
		Thread.sleep(1500);
		// goto Franklin individual owner page
		individual = (OwnerPO) list.choose();
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
		// go to the edit page and edit the city
		edit = (EditOwnerPO) individual.edit();
		assertTrue(edit.Displayed());
		Thread.sleep(1500);
		// verify the edit
		individualEditedWrongly = (EditOwnerPO) edit.modify("telephone", "xyz");
		assertTrue(individualEditedWrongly.NumericalValueOutOfBounds());
		Thread.sleep(1500);
	}
}

