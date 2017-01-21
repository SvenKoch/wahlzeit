package org.wahlzeit.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.wahlzeit.services.ObjectManager;

public class KeyboardManager extends ObjectManager {
	
	protected static KeyboardManager instance = new KeyboardManager();
	
	/**
	 * In-memory cache for keyboards
	 */
	protected Map<Keyboard, Keyboard> keyboardCache = new HashMap<Keyboard, Keyboard>();
	
	/**
	 * In-memory cache for keyboardTypes
	 */
	protected Map<KeyboardType, KeyboardType> keyboardTypeCache = new HashMap<KeyboardType, KeyboardType>();

	private KeyboardManager(){
	}
	
	
	/**
	 *
	 */
	public static final KeyboardManager getInstance() {
		return instance;
	}

	/**
	 *
	 */
	public Set<Keyboard> findKeyboardsByOwner(String owner) {
		Set<Keyboard> result = new HashSet<Keyboard>();

		for (Keyboard k : keyboardCache.keySet()) {
			if(k.getOwner().equals(owner)){
				result.add(k);
			}
		}
		return result;
	}
	
	/**
	 *
	 */
	public Set<Keyboard> findKeyboardsByType(KeyboardType kt) {
		Set<Keyboard> result = new HashSet<Keyboard>();

		for (Keyboard k : keyboardCache.keySet()) {
			if(k.getType()==kt){
				result.add(k);
			}
		}
		return result;
	}
	
	
	/**
	 *
	 */
	public final boolean hasKeyboard(Keyboard keyboard) {
		return keyboardCache.containsKey(keyboard);
	}
	
	/**
	 *
	 */
	public final boolean hasKeyboardType(KeyboardType kt) {
		return keyboardTypeCache.containsKey(kt);
	}


	/**
	 *
	 */
	// step 1 in creating a new Keyboard
	public Keyboard getKeyboard(KeyboardType type, String serialNumber, String owner) {
		// new Keyboard is created (step 2)
		Keyboard keyboard = new Keyboard(type, serialNumber, owner);
		Keyboard result = keyboardCache.get(keyboard);
		if(result == null){
			synchronized (keyboardCache) {
				result = keyboardCache.get(keyboard);
				if(result == null){
					result = keyboard;
					keyboardCache.put(result, result);		
				}
			}
		}
		return result;
	}

	/**
	 *
	 */
	public KeyboardType getKeyboardType(String manufacturer, String model, int numberOfKeys, boolean hasNumPad) {
		KeyboardType kt = new KeyboardType(manufacturer, model, numberOfKeys, hasNumPad);
		KeyboardType result = keyboardTypeCache.get(kt);
		if(result == null){
			synchronized(keyboardTypeCache){
				result = keyboardTypeCache.get(kt);
				if(result == null){
					result = kt;
					keyboardTypeCache.put(result, result);
				}
			}
		}
		return result;
	}

}
