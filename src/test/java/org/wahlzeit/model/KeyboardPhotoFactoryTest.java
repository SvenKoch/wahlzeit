package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class KeyboardPhotoFactoryTest {

	// note that KeyboardPhotoFactory.initialize() has to be called in order for this to work. This is done in the AllTestSuite for testing and in ModelMain for productive code.
	
	@Test
	public void testSingleton(){
		assertEquals(true, PhotoFactory.getInstance() instanceof KeyboardPhotoFactory);
	}
	
	@Test
	public void testFactoryMethod(){
		assertEquals(true, PhotoFactory.getInstance().createPhoto() instanceof KeyboardPhoto);
	}
}
