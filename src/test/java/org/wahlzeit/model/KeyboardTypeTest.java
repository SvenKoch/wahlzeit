package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class KeyboardTypeTest {

	@Test
	public void testConstructor(){
		String manufacturer = "Roccat";
		String model = "Ryos MK Pro";
		int numberOfKeys = 133;
		boolean hasNumPad= true;
		KeyboardType kt = new KeyboardType(manufacturer, model, numberOfKeys, hasNumPad);
		
		assertEquals(null, kt.getSuperType());
		assertFalse(kt.getSubTypeIterator().hasNext());
		assertEquals(manufacturer, kt.getManufacturer());
		assertEquals(model, kt.getModell());
		assertEquals(numberOfKeys, kt.getNumberOfKeys());
		assertEquals(hasNumPad, kt.hasNumPad);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalConstructor(){
		String manufacturer = "Roccat";
		String model = "Ryos MK Pro";
		int numberOfKeys = -2;
		boolean hasNumPad= true;
		KeyboardType kt = new KeyboardType(manufacturer, model, numberOfKeys, hasNumPad);
		
		assertEquals(null, kt.getSuperType());
		assertFalse(kt.getSubTypeIterator().hasNext());
		assertEquals(manufacturer, kt.getManufacturer());
		assertEquals(model, kt.getModell());
		assertEquals(numberOfKeys, kt.getNumberOfKeys());
		assertEquals(hasNumPad, kt.hasNumPad);
	}
	
	@Test
	public void testSubtyping(){
		String manufacturer = "Roccat";
		String model = "Ryos MK Pro";
		int numberOfKeys = 133;
		boolean hasNumPad= true;
		KeyboardType kt = new KeyboardType(manufacturer, model, numberOfKeys, hasNumPad);
		
		assertTrue(kt.isSubtype(kt));
		
		kt.setSuperType(kt);
		kt.addSubType(kt);
		
		assertEquals(kt, kt.getSuperType());
		assertTrue(kt.getSubTypeIterator().hasNext());
		assertEquals(kt, kt.getSubTypeIterator().next());
	}
}
