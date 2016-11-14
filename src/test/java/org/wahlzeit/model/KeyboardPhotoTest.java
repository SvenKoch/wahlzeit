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
		KeyboardPhoto photo = new KeyboardPhoto(manufacturer, model, numberOfKeys, hasNumPad);
		
		assertEquals(manufacturer, photo.getManufacturer());
		assertEquals(model, photo.getModell());
		assertEquals(numberOfKeys, photo.getNumberOfKeys());
		assertEquals(hasNumPad, photo.hasNumPad());
	}
	
}
