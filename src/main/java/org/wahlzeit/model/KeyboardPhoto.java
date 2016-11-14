package org.wahlzeit.model;

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
		this.manufacturer = manufacturer;
		this.model = model;
		this.numberOfKeys = numberOfKeys;
		this.hasNumPad = hasNumPad;
	}
	
	public KeyboardPhoto(PhotoId myId, String manufacturer, String model, int numberOfKeys, boolean hasNumPad) {
		super(myId);
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
		this.numberOfKeys = numberOfKeys;
	}

	public boolean hasNumPad() {
		return hasNumPad;
	}

	public void setHasNumPad(boolean hasNumPad) {
		this.hasNumPad = hasNumPad;
	}
	


}
