package test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import POs.AddVisitPO;
import POs.FindOwnerPagePO;
import POs.HomePO;
import POs.OwnerPO;
import POs.OwnersPO;

public class TestAddPetVisit extends DriverLifeCycleSetting {
	
	private FindOwnerPagePO find;
	//private OwnerPO not_found;
	private	OwnersPO list;
	private OwnerPO individual;
	private AddVisitPO pet;
	private AddVisitPO petFailed;
	private HomePO home;

	@Test
	public void testFirstScenario() throws Exception {
		String date = "today";
		String description = "the first visit";
		// start finding after fixing the strings
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		find = (FindOwnerPagePO) home.find();
		assertTrue(find.Displayed());
		Thread.sleep(1500);
		// goto list of owners
		list = (OwnersPO) find.search(null);
		assertTrue(list.Displayed());
		Thread.sleep(1500);
		// goto Franklin individual owner page
		individual = (OwnerPO) list.choose();
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
		// add pet
		pet = (AddVisitPO) individual.addVisit();
		assertTrue(pet.Displayed());
		Thread.sleep(1500);
		individual = (OwnerPO) pet.fill(date, description);
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
		// verify that the desc is changed
		assertTrue(individual.changedDescription(description));
		Thread.sleep(1500);
	}
	
	@Test
	public void testSecondScenario() throws Exception {
		String date = "today";
		String description = "";
		// start finding after fixing the strings
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		find = (FindOwnerPagePO) home.find();
		assertTrue(find.Displayed());
		Thread.sleep(1500);
		// goto list of owners
		list = (OwnersPO) find.search(null);
		assertTrue(list.Displayed());
		Thread.sleep(1500);
		// goto Franklin individual owner page
		individual = (OwnerPO) list.choose();
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
		// add pet
		pet = (AddVisitPO) individual.addVisit();
		assertTrue(pet.Displayed());
		Thread.sleep(1500);
		petFailed = (AddVisitPO) pet.fill(date, description);
		assertTrue(petFailed.ShouldNotBeEmpty()); // InvalidDate
		Thread.sleep(1500);
	}
	
	@Test
	public void testThirdScenario() throws Exception {
		String date = "194032021";
		String description = "the first visit";
		// start finding after fixing the strings
		home = new HomePO(driver);
		assertTrue(home.Displayed());
		find = (FindOwnerPagePO) home.find();
		assertTrue(find.Displayed());
		Thread.sleep(1500);
		// goto list of owners
		list = (OwnersPO) find.search(null);
		assertTrue(list.Displayed());
		Thread.sleep(1500);
		// goto Franklin individual owner page
		individual = (OwnerPO) list.choose();
		assertTrue(individual.Displayed());
		Thread.sleep(1500);
		// add pet
		pet = (AddVisitPO) individual.addVisit();
		assertTrue(pet.Displayed());
		Thread.sleep(1500);
		petFailed = (AddVisitPO) pet.fill(date, description);
		assertTrue(petFailed.InvalidDate());
		Thread.sleep(1500);
	}
}

