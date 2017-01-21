package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

/*
 * @PatternInstance(
 * 	patternName = "Abstract Factory"
 * 	participants = {
 * 		"AbstractFactory",
 * 		"ConcreteFactory"
 *  }
 * )
 */
public class KeyboardPhotoFactory extends PhotoFactory {

	public static void initialize() {
		getInstance();
	}

	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic KeyboardPhotoFactory").toString());
			setInstance(new KeyboardPhotoFactory());
		}

		return instance;
	}

	public KeyboardPhoto createPhoto(){
		return new KeyboardPhoto(null);
	}
	
	// step 3 in creating a new KeyboardPhoto
	public KeyboardPhoto createPhoto(PhotoId id){
		// new KeyboardPhoto is created (step 4)
		return new KeyboardPhoto(id, null);
	}

	public KeyboardPhoto createPhoto(Keyboard content) {
		return new KeyboardPhoto(content);
	}

	public KeyboardPhoto createPhoto(PhotoId id, Keyboard content) {
		return new KeyboardPhoto(id, content);
	}	

}
