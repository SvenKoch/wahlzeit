package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeyboardPhotoTest {
	
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
		KeyboardPhoto photo = new KeyboardPhoto(k);
		
		assertEquals(k, photo.getContent());
	}
	
}
