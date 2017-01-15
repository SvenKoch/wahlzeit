package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class KeyboardManagerTest {

	@Test
	public void testSingleton(){
		assertTrue(KeyboardManager.getInstance() instanceof KeyboardManager);
	}
	
	@Test
	public void testKeyboardTypeCaching(){
		KeyboardManager manager = KeyboardManager.getInstance();
		String manufacturer = "Roccat";
		String model = "Ryos MK Pro";
		int numberOfKeys = 133;
		boolean hasNumPad= true;
		KeyboardType kt = manager.getKeyboardType(manufacturer, model, numberOfKeys, hasNumPad);
		KeyboardType kt2 = manager.getKeyboardType(manufacturer, model, numberOfKeys, hasNumPad);
		
		assertTrue(kt==kt2);
		assertTrue(manager.hasKeyboardType(kt));
		assertTrue(manager.hasKeyboardType(kt2));
	}
	
	@Test
	public void testKeyboardCaching(){
		KeyboardManager manager = KeyboardManager.getInstance();
		String manufacturer = "Roccat";
		String model = "Ryos MK Pro";
		int numberOfKeys = 133;
		boolean hasNumPad= true;
		String serialNumber = "1234567890";
		String owner = "John Doe";
		KeyboardType kt = manager.getKeyboardType(manufacturer, model, numberOfKeys, hasNumPad);
		Keyboard k = manager.getKeyboard(kt, serialNumber, owner);
		Keyboard k2 = manager.getKeyboard(kt, serialNumber, owner);
		
		assertTrue(k==k2);
		assertTrue(manager.hasKeyboard(k));
		assertTrue(manager.hasKeyboard(k2));

	}
}
