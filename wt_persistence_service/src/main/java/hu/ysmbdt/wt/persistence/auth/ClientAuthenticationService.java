/**
 * 
 */
package hu.ysmbdt.wt.persistence.auth;

/**
 *  
 *
 * @author kalmankostenszky
 */
public interface ClientAuthenticationService {

	boolean checkToken(String token);
}
