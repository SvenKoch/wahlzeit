package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KeyboardTest {
	
	@Test
	public void testConstructor(){
		String manufacturer = "Roccat";
		String model = "Ryos MK Pro";
		int numberOfKeys = 133;
		boolean hasNumPad= true;
		String serialNumber = "1234567890";
		String owner = "John Doe";
		KeyboardType kt = new KeyboardType(manufacturer, model, numberOfKeys, hasNumPad);
		Keyboard k = new Keyboard(kt, serialNumber, owner);
		
		assertEquals(kt, k.getType());
		assertEquals(serialNumber, k.getSerialNumber());
		assertEquals(owner, k.getOwner());
	}
}
