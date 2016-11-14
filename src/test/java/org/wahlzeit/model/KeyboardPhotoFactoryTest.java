package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class KeyboardPhotoFactoryTest {

	
	@Test
	public void testSingleton(){
		assertEquals(true, KeyboardPhotoFactory.getInstance() instanceof KeyboardPhotoFactory);
	}
	
	@Test
	public void testFactoryMethod(){
		assertEquals(true, KeyboardPhotoFactory.getInstance().createPhoto() instanceof KeyboardPhoto);
	}
}
