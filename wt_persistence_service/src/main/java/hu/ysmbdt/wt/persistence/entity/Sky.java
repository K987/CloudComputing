/**
 * 
 */
package hu.ysmbdt.wt.persistence.entity;

/**
 *  
 *
 * @author kalmankostenszky
 */
public enum Sky {
	
	CLEAR("clear"),
	PARTLY_CLOUDY("partly cloudy"),
	CLOUDY("cloudy"),
	HEAVY_CLOUDS("heavy clouds"),
	FOG("fog");

	private String name;
	
	private Sky(String name){
		this.name = name;
	}
	/**
	 * @return
	 */
	public String getName() {
		return this.name;
	}
}
