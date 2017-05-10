/**
 * 
 */
package hu.ysmbdt.cqrs.entity;

/**
 *  
 *
 * @author kalmankostenszky
 */
public enum City {


	BUDAPEST("Budapest"),
	SZEGED("Szeged"),
	SOPRON("Sopron"),
	DEBRECEN("Debrecen");
	
	private String name;
	
	private City(String name){
		this.name = name;
	}
	

	public String getName(){
		return this.name();
	}
}
