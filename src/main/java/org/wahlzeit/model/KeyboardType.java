package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class KeyboardType {
	
	protected final String manufacturer;
	protected final String model;
	protected final int numberOfKeys;
	protected final boolean hasNumPad;
	
	protected KeyboardType superType = null;
	protected Set<KeyboardType> subTypes = new HashSet<KeyboardType>();
	
	public KeyboardType(String manufacturer, String model, int numberOfKeys, boolean hasNumPad) {
		assertNumberOfKeysNotNegative(numberOfKeys);
		this.manufacturer = manufacturer;
		this.model = model;
		this.numberOfKeys = numberOfKeys;
		this.hasNumPad = hasNumPad;
	}
	
	public boolean isSubtype(KeyboardType kt){
		KeyboardType cur = this;
		do{
			if(cur == kt){
				return true;
			}
			cur = cur.getSuperType();
		}while(cur != null);
		
		return false;
	}
	
	public KeyboardType getSuperType(){
		return superType;
	}
	
	public Iterator<KeyboardType> getSubTypeIterator(){
		return subTypes.iterator();
	}
	
	public void addSubType(KeyboardType kt){
		if(kt == null){
			throw new IllegalArgumentException("Tried to set null sub-type");
		}
		kt.setSuperType(this);
		subTypes.add(kt);
	}
	
	public boolean removeSubType(KeyboardType kt){
		return subTypes.remove(kt);
	}
	
	public void setSuperType(KeyboardType kt){
		superType = kt;
	}
	
	
	public String getManufacturer() {
		return manufacturer;
	}

	public String getModell() {
		return model;
	}

	public int getNumberOfKeys() {
		return numberOfKeys;
	}

	public boolean hasNumPad() {
		return hasNumPad;
	}
	
	private void assertNumberOfKeysNotNegative(int numberOfKeys){
		if(numberOfKeys<0){
			throw new IllegalArgumentException("numberOfKeys may not be negative!");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasNumPad ? 1231 : 1237);
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + numberOfKeys;
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
		KeyboardType other = (KeyboardType) obj;
		if (hasNumPad != other.hasNumPad)
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (numberOfKeys != other.numberOfKeys)
			return false;
		return true;
	}
}
