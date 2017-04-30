/**
 * 
 */
package hu.ysmbdt.wt.persistence.exception;

import java.util.ArrayList;
import java.util.List;

import hu.ysmbdt.wt.persistence.entity.Sky;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class SkyNotFoundException extends NotFoundException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4968511658189266176L;

	public SkyNotFoundException(String message, String notExists){
		
		super(message,notExists);
		initAvailableValues();
	}

	/**
	 * 
	 */
	private void initAvailableValues() {
		List<String> availableValues = new ArrayList<>();
		for (Sky sky : Sky.values()) {
			availableValues.add(sky.getName());
		}
		this.setAvailableValues(availableValues);
	}

}
