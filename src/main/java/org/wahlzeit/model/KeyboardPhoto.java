package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class KeyboardPhoto extends Photo {

	private String manufacturer;
	private String model;
	private int numberOfKeys;
	private boolean hasNumPad;
	
	
	public KeyboardPhoto() {
		super();
	}

	public KeyboardPhoto(PhotoId myId) {
		super(myId);
	}

	public KeyboardPhoto(String manufacturer, String model, int numberOfKeys, boolean hasNumPad) {
		super();
		assertNumberOfKeysNotNegative(numberOfKeys);
		this.manufacturer = manufacturer;
		this.model = model;
		this.numberOfKeys = numberOfKeys;
		this.hasNumPad = hasNumPad;
	}
	
	public KeyboardPhoto(PhotoId myId, String manufacturer, String model, int numberOfKeys, boolean hasNumPad) {
		super(myId);
		if(myId == null){
			throw new IllegalArgumentException("PhotoId may not be null!");
		}
		assertNumberOfKeysNotNegative(numberOfKeys);
		this.manufacturer = manufacturer;
		this.model = model;
		this.numberOfKeys = numberOfKeys;
		this.hasNumPad = hasNumPad;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModell() {
		return model;
	}

	public void setModell(String modell) {
		this.model = modell;
	}

	public int getNumberOfKeys() {
		return numberOfKeys;
	}

	public void setNumberOfKeys(int numberOfKeys) {
		assertNumberOfKeysNotNegative(numberOfKeys);
		this.numberOfKeys = numberOfKeys;
	}

	public boolean hasNumPad() {
		return hasNumPad;
	}

	public void setHasNumPad(boolean hasNumPad) {
		this.hasNumPad = hasNumPad;
	}
	
	private void assertNumberOfKeysNotNegative(int numberOfKeys){
		if(numberOfKeys<0){
			throw new IllegalArgumentException("numberOfKeys may not be negative!");
		}
	}
	


}
