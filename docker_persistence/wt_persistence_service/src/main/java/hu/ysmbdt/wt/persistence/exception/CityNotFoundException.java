/**
 * 
 */
package hu.ysmbdt.wt.persistence.exception;

import java.util.ArrayList;
import java.util.List;

import hu.ysmbdt.wt.persistence.entity.City;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class CityNotFoundException extends NotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4832336202326138249L;
	
	public CityNotFoundException(String message, String notExists){
		
		super(message,notExists);
		initAvailableValues();
	}

	/**
	 * 
	 */
	private void initAvailableValues() {
		List<String> availableValues = new ArrayList<>();
		for (City city : City.values()) {
			availableValues.add(city.getName());
		}
		this.setAvailableValues(availableValues);
	}

	
}
