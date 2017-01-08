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


	public Photo createPhoto() {
		return new KeyboardPhoto();
	}

	public Photo createPhoto(PhotoId id) {
		return new KeyboardPhoto(id);
	}

	public KeyboardPhoto createPhoto(String manufacturer, String model, int numberOfKeys, boolean hasNumPad){
		return new KeyboardPhoto(manufacturer, model, numberOfKeys, hasNumPad);
	}

	public KeyboardPhoto createPhoto(PhotoId id, String manufacturer, String model, int numberOfKeys, boolean hasNumPad){
		return new KeyboardPhoto(id, manufacturer, model, numberOfKeys, hasNumPad);
	}
	

}
