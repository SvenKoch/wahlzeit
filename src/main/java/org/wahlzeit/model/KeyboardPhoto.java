package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import com.googlecode.objectify.annotation.Subclass;

@PatternInstance (
	patternName = "Abstract Factory",
	participants = {
		"AbstractProduct",
 		"ConcreteProduct"
	}
)
 
@Subclass
public class KeyboardPhoto extends Photo {
	
	private final Keyboard content;

	public KeyboardPhoto(Keyboard content) {
		super();
		this.content = content;
	}

	public KeyboardPhoto(PhotoId myId, Keyboard content){
		super(myId);
		this.content = content;
	}

	/**
	 * @return the content
	 */
	public Keyboard getContent() {
		return content;
	}

}
