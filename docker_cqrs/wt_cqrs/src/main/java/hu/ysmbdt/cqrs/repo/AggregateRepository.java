/**
 * 
 */
package hu.ysmbdt.cqrs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.ysmbdt.cqrs.entity.Aggregate;

/**
 * 
 *
 * @author kalmankostenszky
 */
public interface AggregateRepository extends JpaRepository<Aggregate, Long> {

}
