package org.wahlzeit.model;

public class Keyboard {
	
	private final KeyboardType type;
	private final String owner;
	private final String serialNumber;
	
	public Keyboard(KeyboardType type, String serialNumber, String owner){
		this.type = type;
		this.serialNumber = serialNumber;
		this.owner = owner;
	}

	public KeyboardType getType() {
		return type;
	}

	public String getOwner() {
		return owner;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Keyboard other = (Keyboard) obj;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
}
