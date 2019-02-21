package test;
import main.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

class MenuListTest {
	
	static MenuList menuList;

	@BeforeAll
	static void setUpBeforeClass_testsConstructor() throws Exception {
		menuList = new MenuList();
		//TreeMap<String, MenuItems> menu_input = new TreeMap<>();
		String key = "drinkID";
		Drinks drink = new Drinks("nameDrink",key,1.0,"descriptionDrink","alergensDrink");
		//Snacks snack = new Snacks("nameSnack","idSnack",2.0,"descriptionSnack","alergensSnack");
		//Meals meal = new Meals("nameMeal","idMeal",3.0,"descriptionMeal","alergensMeal");
		menuList.addItem(key, drink);
		//menuList = new MenuList(menu_input);
	}


//	// I don't really understand the point/need of this method
//	@Test
//	void testGetMenuList_works() {
//		fail();
//	}


	@Test
	void testAddItem_Exception() throws InvalidItemIdentifierException {
		String key = "drinkID";
		Drinks differentDrink = new Drinks("sameDrinkReally",key,1.0,"descriptionDrink","alergensDrink");
		try {
			menuList.addItem(key, differentDrink);
			fail("key should already be in list");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Key already exists");
		}
	}

	
	@Test
	void testGetItem() throws InvalidItemIdentifierException {
		String test_key = "drinkIDtest";
		Drinks drinkTest = new Drinks("test",test_key,1.0,"test","test");
    	menuList.addItem(test_key, drinkTest);
        assertEquals(drinkTest, menuList.getItem(test_key));
	}
	
	@Test
	void testGetItem_catchThrow() {
    	try {
    		menuList.getItem("test");
    		fail("not a key should throw exception");
    	} catch (IllegalArgumentException e) {
    		assertEquals(e.getMessage(), "Key does not exist");
    	}
	}
	


	@Test
	void testRemove_throws() {
		try {
			menuList.remove("throw");
		} catch (IllegalArgumentException e) {
    		assertEquals(e.getMessage(), "Item does not exist");
    	}
	}

	@Test
	void testRemove_works() {
		try {
			menuList.remove("drinkID");
		} catch (IllegalArgumentException e) {
    		assertEquals(e.getMessage(), "Item does not exist");
    	}
		try {
			menuList.getItem("drinkID");
			fail("key shouldn't be in list");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Key does not exist");
		}
	}
	
	
	
//	@Test
//	void testPrintAll() {
//		fail("Not yet implemented");
//	}

	
	@Test
	void testWriteReport() throws InvalidItemIdentifierException {
		String key = "drinkID";
		Drinks drink = new Drinks("nameDrink",key,1.0,"descriptionDrink","alergensDrink");
		MenuList menu = new MenuList();
		menu.addItem(key, drink);		
		System.out.println(menu.writeReport());
		assertEquals(menu.writeReport(),"nameDrink/drinkID/1.0/descriptionDrink/alergensDrink");
	}

}
